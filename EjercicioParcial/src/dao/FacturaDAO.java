package dao;

import hbt.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import entities.Factura;
import entities.Mozo;

public class FacturaDAO extends HibernateUtil {
	public static Factura getFactura(int nroFactura) {
		return getEntity(Factura.class, nroFactura);
	}

	public static List<Factura> getList() {
		return getAll(Factura.class);
	}

	@SuppressWarnings("unchecked")
	public static List<Object[]> getPlatosXMozo(Mozo m) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			List<Object[]> list = getSessionFactory().getCurrentSession().createQuery("SELECT r.descripcion,max(p.descripcion),max(p.precio) FROM Factura f JOIN f.platos p JOIN p.rubro r WHERE f.mozo.idMozo = (:idMozo) GROUP BY r.descripcion").setParameter("idMozo", m.getIdMozo()).list();
			return list;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static List<Factura> getByMozo(Mozo m) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			List<Factura> list = getSessionFactory().getCurrentSession().createQuery("from Factura WHERE mozo.idMozo = (:idMozo)").setParameter("idMozo", m.getIdMozo()).list();
			return list;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static List<Mozo> getMozosMayorFacturacion() {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			List<Object[]> list = getSessionFactory().getCurrentSession().createQuery("SELECT m.idMozo,sum(f.total) as totalFac FROM Factura f JOIN f.mozo m GROUP BY m.idMozo HAVING sum(f.total) >= ALL (SELECT sum(f.total) FROM Factura f GROUP BY f.mozo.idMozo)").list();
			if (list.isEmpty()) {
				return null;
			}
			List<Integer> mozos = new ArrayList<>();
			for (Object[] tupla : list) {
				mozos.add(Integer.parseInt(tupla[0].toString()));
			}
			List<Mozo> tuplas = getSessionFactory().getCurrentSession().createQuery("FROM Mozo m WHERE m.idMozo IN (:idMozo)").setParameterList("idMozo", mozos).list();
			tx.commit();
			return tuplas;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static List<Integer> getMozoSinPostre() {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			List<Integer> list = getSessionFactory().getCurrentSession().createQuery("SELECT DISTINCT f.mozo.idMozo FROM Factura f WHERE f.mozo.idMozo <> ALL (SELECT f.mozo.idMozo FROM Factura f JOIN f.platos p JOIN p.rubro r WHERE r.descripcion = 'Postres')").list();
			tx.commit();
			return list;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static List<Object[]> getPlatosFactMasCaros() {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			List<Object[]> list = getSessionFactory().getCurrentSession().createQuery("SELECT p.idPlato,f.nroFactura FROM Factura f JOIN f.platos p WHERE p.idPlato IN (SELECT idPlato FROM Plato WHERE precio = (SELECT max(precio) FROM Plato)) ORDER BY p.idPlato,f.nroFactura").list();
			tx.commit();
			return list;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return null;
	}
}