package hbt;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Domicilio;
import entities.Factura;
import entities.Localidad;
import entities.Mozo;
import entities.Plato;
import entities.Rubro;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Domicilio.class);
			config.addAnnotatedClass(Localidad.class);
			config.addAnnotatedClass(Mozo.class);
			config.addAnnotatedClass(Factura.class);
			config.addAnnotatedClass(Plato.class);
			config.addAnnotatedClass(Rubro.class);

			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static <T> T getEntity(Class<T> cls, int id) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			T entity = (T) getSessionFactory().getCurrentSession().get(cls, id);
			tx.commit();
			return entity;
		} catch (Exception ex) {
			tx.rollback();
		}
		return null;
	}

	public static <T> List<T> getAll(Class<T> cls) {
		Transaction tx = getSessionFactory().getCurrentSession().beginTransaction();
		try {
			@SuppressWarnings("unchecked")
			List<T> list = getSessionFactory().getCurrentSession().createQuery("from " + cls.getName()).list();
			return list;
		} catch (Exception ex) {
			tx.rollback();
		}
		return null;
	}
}