package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import modelo.Producto;
import modelo.Proveedor;

public class MapperProveedor {
	private static MapperProveedor instancia;

	private MapperProveedor() {

	}

	public static MapperProveedor getInstancia() {
		if (instancia == null) {
			instancia = new MapperProveedor();
		}
		return instancia;
	}

	public Vector<Producto> selectProdXProv(String cuit) {
		try {
			Vector<Producto> productos = new Vector<>();

			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=Proveedores";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c = DriverManager.getConnection(connectionUrl, "sa",
					"sa");

			PreparedStatement s = c
					.prepareStatement("select [codigo] from ProvProd WHERE cuit = ?");

			s.setString(1, cuit);

			ResultSet r = s.executeQuery();
			c.close();

			while (r.next()) {
				int codigo = r.getInt(1);
				productos.add(MapperProducto.getInstancia().selectByCodigo(
						codigo));
			}
			return productos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Proveedor selectByCUIT(String cuit) {
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=Proveedores";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c = DriverManager.getConnection(connectionUrl, "sa",
					"sa");

			PreparedStatement s = c
					.prepareStatement("select [cuit],[nombre] from Proveedores WHERE cuit = ?");

			s.setString(1, cuit);

			ResultSet r = s.executeQuery();
			c.close();

			if (r.next()) {
				return new Proveedor(r.getString(1), r.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Proveedor p) {
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=Proveedores";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c = DriverManager.getConnection(connectionUrl, "sa",
					"sa");

			PreparedStatement s = c
					.prepareStatement("insert [cuit],[nombre] into Proveedores "
							+ "VALUES (?,?)");

			s.setString(1, p.getCuit());
			s.setString(2, p.getNombre());

			s.execute();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}