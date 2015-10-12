package dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;

import entities.Mozo;

public class MozoDAO extends HibernateUtil {

	public static Mozo getMozo(int id) {
		return getEntity(Mozo.class, id);
	}

	public static List<Mozo> getList() {
		return getAll(Mozo.class);
	}

	public static List<Mozo> getListXLocalidad(String l) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			List<Mozo> list = getSessionFactory().getCurrentSession().createQuery("from Mozo where domicilio.localidad.localida LIKE (:loc)").setParameter("loc", l).list();
			return list;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return null;
	}

	public static Mozo getByNombreCompleto(String a, String n) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			Query q = getSessionFactory().getCurrentSession().createQuery("from Mozo where apellido = (:ape) and nombre = (:nom)");
			q.setParameter("ape", a);
			q.setParameter("nom", n);
			Mozo m = (Mozo) q.list().get(0);
			return m;
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return null;
	}
}