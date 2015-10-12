package dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Transaction;

import entities.Rubro;

public class RubroDAO extends HibernateUtil {

	public static Rubro getRubro(int id) {
		return getEntity(Rubro.class, id);
	}

	public static List<Rubro> getList() {
		return getAll(Rubro.class);
	}

	public static Rubro getByDesc(String desc) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			List<Rubro> list = getSessionFactory().getCurrentSession().createQuery("from Rubro where descripcion = (:desc)").setParameter("desc", desc).list();
			return list.get(0);
		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}
		return null;
	}
}