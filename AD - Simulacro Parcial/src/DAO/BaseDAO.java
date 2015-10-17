package DAO;

import modelo.Domicilio;
import modelo.Factura;
import modelo.Localidad;
import modelo.Mozo;
import modelo.Plato;
import modelo.Rubro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class BaseDAO {
	
	private static Session _session;
	
	public static Session getSession()
	{
		if (_session == null)
		{
			// Create session
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.addAnnotatedClass(Localidad.class);
			cfg.addAnnotatedClass(Domicilio.class);
			cfg.addAnnotatedClass(Mozo.class);
			cfg.addAnnotatedClass(Factura.class);
			cfg.addAnnotatedClass(Rubro.class);
			cfg.addAnnotatedClass(Plato.class);
			
			SessionFactory factory = cfg.buildSessionFactory();
			_session = factory.openSession();
		}
		return _session;
	}
}
