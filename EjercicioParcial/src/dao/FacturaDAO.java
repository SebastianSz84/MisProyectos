package dao;

import hbt.HibernateUtil;
import entities.Factura;

public class FacturaDAO extends HibernateUtil {
	public static Factura getFactura(int nroFactura) {
		return getEntity(Factura.class, nroFactura);
	}
}
