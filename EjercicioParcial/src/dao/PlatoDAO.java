package dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Transaction;

import entities.Plato;
import entities.Rubro;

public class PlatoDAO extends HibernateUtil {

	public static Plato getPlato(int id) {
		return getEntity(Plato.class, id);
	}

	public static List<Plato> getList() {
		return getAll(Plato.class);
	}

	public static List<Plato> getByRubro(Rubro postre) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			List<Plato> list = getSessionFactory().getCurrentSession().createQuery("").list();
			tx.commit();
			return list;
		} catch (Exception ex) {
			tx.rollback();
		}
		return null;
	}
}