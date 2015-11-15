package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Directivo;
import entities.Empleados;
import entities.Estado;
import entities.ItemTarea;
import entities.Operario;
import entities.Proyecto;
import entities.Tareas;

public class HibernateUtil
{
	private static final SessionFactory sessionFactory;
	static
	{
		try
		{
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Empleados.class);
			config.addAnnotatedClass(Directivo.class);
			config.addAnnotatedClass(Operario.class);
			config.addAnnotatedClass(Proyecto.class);
			config.addAnnotatedClass(ItemTarea.class);
			config.addAnnotatedClass(Tareas.class);
			config.addAnnotatedClass(Estado.class);
			sessionFactory = config.buildSessionFactory();
		}
		catch (Throwable ex)
		{
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
}
