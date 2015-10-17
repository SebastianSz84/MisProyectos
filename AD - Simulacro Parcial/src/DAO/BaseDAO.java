package DAO;

import modelo.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDAO {
	
	private static Session _session;
	
	public static Session getSession()
	{
		if (_session == null)
		{
			// Create session
			Configuration cfg = new Configuration();
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
