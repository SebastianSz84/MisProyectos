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

	public Producto selectByCodigo(int cod) {
		try {
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=Proveedores";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c = DriverManager.getConnection(connectionUrl, "sa",
					"sa");

			PreparedStatement s = c
					.prepareStatement("select [codigo],[descripcion] from Productos WHERE codigo = ?");

			s.setInt(1, cod);

			ResultSet r = s.executeQuery();
			c.close();

			if (r.next()) {
				return new Producto(r.getInt(1), r.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
