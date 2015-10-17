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

	public static List<Plato> getByRubro(Rubro r) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			List<Plato> list = getSessionFactory().getCurrentSession().createQuery("from Plato where idRubro = (:idRubro)").setParameter("idRubro", r.getIdRubro()).list();
			tx.commit();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static List<Object[]> getCantXRubro() {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			List<Object[]> list = getSessionFactory().getCurrentSession().createQuery("SELECT r.descripcion,count(p.idPlato) FROM Plato p JOIN p.rubro r GROUP BY r.descripcion").list();
			tx.commit();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
			tx.rollback();
		}
		return null;
	}
}