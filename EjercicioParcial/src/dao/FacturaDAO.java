package dao;

import hbt.HibernateUtil;

import java.util.List;

import entities.Factura;

public class FacturaDAO extends HibernateUtil {
	public static Factura getFactura(int nroFactura) {
		return getEntity(Factura.class, nroFactura);
	}

	public static List<Factura> getList() {
		return getAll(Factura.class);
	}
}
