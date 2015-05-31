package modelo;

import java.util.Vector;

public class ProveedorView {
	private String cuit;
	private String nombre;
	private Vector<ProductoView> productos;

	public ProveedorView(String cuit, String nom) {
		this.cuit = cuit;
		this.nombre = nom;
	}

	public void setProductos(Vector<ProductoView> productos) {
		this.productos = productos;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Vector<ProductoView> getProductos() {
		return productos;
	}
}
