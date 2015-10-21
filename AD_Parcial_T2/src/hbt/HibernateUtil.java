package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.Cliente;
import entities.ItemReparacion;
import entities.ManoDeObra;
import entities.Material;
import entities.Persona;
import entities.Reparacion;
import entities.Repuesto;
import entities.Tecnico;
import entities.Vehiculo;

public class HibernateUtil
{
	private static final SessionFactory sessionFactory;
	static
	{
		try
		{
			AnnotationConfiguration config = new AnnotationConfiguration();
			config.addAnnotatedClass(Tecnico.class);
			config.addAnnotatedClass(Persona.class);
			config.addAnnotatedClass(Cliente.class);
			config.addAnnotatedClass(Reparacion.class);
			config.addAnnotatedClass(ItemReparacion.class);
			config.addAnnotatedClass(Material.class);
			config.addAnnotatedClass(Repuesto.class);
			config.addAnnotatedClass(ManoDeObra.class);
			config.addAnnotatedClass(Vehiculo.class);
			
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
