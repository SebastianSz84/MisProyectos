package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import modelo.Factura;
import modelo.ItemFactura;

public class MapperFactura {
	private static MapperFactura instancia;

	private MapperFactura() {

	}

	public static MapperFactura getInstancia() {
		if (instancia == null) {
			instancia = new MapperFactura();
		}
		return instancia;
	}

	public Vector<Factura> selectPorMesAño(int mes, int año) {
		try {
			Vector<Factura> facturas = new Vector<>();
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;databaseName=Supermercado;",
							"sa", "sa");
			PreparedStatement s = c
					.prepareStatement("select [numero] from Facturas WHERE mes = ? AND anio = ?");

			s.setInt(1, mes);
			s.setInt(2, año);

			ResultSet r = s.executeQuery();

			while (r.next()) {
				int nroFact = r.getInt(1);
				Factura fact = new Factura(nroFact, mes, año);
				Vector<ItemFactura> items = new Vector<>();

				s = c.prepareStatement("select [cantidad],[codProd] from ItemsFactura WHERE numFact = ?");
				s.setInt(1, nroFact);

				ResultSet rItem = s.executeQuery();

				while (rItem.next()) {
					items.add(new ItemFactura(rItem.getInt(2), MapperProducto
							.getInstancia().select(rItem.getInt(3))));
				}

				fact.setItems(items);

				facturas.add(fact);
			}
			c.close();
			return facturas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
