package dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Cuenta;

public class BancoDAO
{
	private static SessionFactory sf;
	private static BancoDAO instancia;
	
	public static SessionFactory getSf()
	{
		return sf;
	}
	
	public static void setSf(SessionFactory sf)
	{
		BancoDAO.sf = sf;
	}
	
	public static BancoDAO getInstancia()
	{
		if (instancia == null)
		{
			instancia = new BancoDAO();
		}
		return instancia;
	}
	
	private BancoDAO()
	{
		sf = HibernateUtil.getSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	public List<Cuenta> getSaldos()
	{
		Session s = sf.openSession();
		List<Cuenta> cuentas = s.createQuery("from CajaAhorro").list();
		cuentas.addAll(s.createQuery("from CC").list());
		s.close();
		return cuentas;
	}
}