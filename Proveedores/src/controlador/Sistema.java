package controlador;

import java.util.Vector;

import persistencia.MapperProveedor;
import modelo.ProductoView;
import modelo.Proveedor;

public class Sistema {
	private Vector<Proveedor> proveedores;
	private static Sistema instancia;

	private Sistema() {
		this.proveedores = new Vector<>();
	}

	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}

	public void crearProv(String cuit, String nom) {
		if (buscarProv(cuit) == null) {
			Proveedor prov = new Proveedor(cuit, nom);
			proveedores.add(prov);
			MapperProveedor.getInstancia().insert(prov);
		}
	}

	private Proveedor buscarProv(String cuit) {
		for (int i = 0; i < proveedores.size(); i++) {
			if (proveedores.elementAt(i).getCuit().equals(cuit)) {
				return proveedores.elementAt(i);
			}
		}
		return MapperProveedor.getInstancia().selectByCUIT(cuit);
	}

	public void agregarProd(String cuit, int cod, String des) {

	}

	public Vector<ProductoView> mostrarProd(String cuit) {
		Proveedor prov = buscarProv(cuit);

		if (prov != null) {
			return prov.listarProds();
		}

		return null;
	}
}