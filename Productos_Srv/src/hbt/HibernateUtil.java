package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entities.Elaborado;
import entities.MateriaPrima;
import entities.Producto;
import entities.SemiElaborado;
import entities.Unidad;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration config = new Configuration();

			config.addAnnotatedClass(Elaborado.class);
			config.addAnnotatedClass(MateriaPrima.class);
			config.addAnnotatedClass(SemiElaborado.class);
			config.addAnnotatedClass(Producto.class);
			config.addAnnotatedClass(Unidad.class);

			sessionFactory = config.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}