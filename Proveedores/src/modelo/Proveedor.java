package modelo;

import java.util.Vector;

public class Proveedor {
	private String cuit;
	private String nombre;
	private Vector<Producto> productos;

	public Proveedor(String cuit, String nombre) {
		this.cuit = cuit;
		this.nombre = nombre;
	}

	public void creadProd(int cod, String nom) {
	}

	public void setProductos(Vector<Producto> productos) {
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

	public Vector<Producto> getProductos() {
		return productos;
	}

	public Vector<ProductoView> listarProds() {
		Vector<ProductoView> vistaProds = new Vector<>();

		for (int i = 0; i < productos.size(); i++) {
			vistaProds.add(productos.elementAt(i).getView());
		}

		return null;
	}
}