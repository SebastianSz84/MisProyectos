package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Producto;

public class MapperProducto {

	private static MapperProducto instancia;

	private MapperProducto() {

	}

	public static MapperProducto getInstancia() {
		if (instancia == null) {
			instancia = new MapperProducto();
		}
		return instancia;
	}

	public Producto select(int codigo) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c = DriverManager
					.getConnection(
							"jdbc:sqlserver://localhost:1433;databaseName=Supermercado",
							"sa", "sa");
			PreparedStatement s = c
					.prepareStatement("select [precio],[descripcion] from Productos WHERE codigo = ?");

			s.setInt(1, codigo);

			ResultSet r = s.executeQuery();
			c.close();

			if (r.next()) {
				float precio = r.getFloat(2);
				String descripcion = r.getString(3);
				return new Producto(codigo, precio, descripcion);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
