package dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.Proyecto;

public class ProyectoDAO
{
	private SessionFactory sessionFactory;
	private static ProyectoDAO instancia;
	
	public static ProyectoDAO getInstancia()
	{
		if (instancia == null)
		{
			instancia = new ProyectoDAO();
		}
		return instancia;
	}
	
	public static void setInstancia(ProyectoDAO instancia)
	{
		ProyectoDAO.instancia = instancia;
	}
	
	private ProyectoDAO()
	{
		sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	public SessionFactory getSessionFactory()
	{
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
	
	public void pregunta_I(int codigo)
	{
		try
		{
			Session s = sessionFactory.openSession();
			Proyecto p = (Proyecto) s.createQuery("from Proyecto where codigoProyecto = :codigo").setParameter("codigo", codigo).list().get(0);
			s.close();
			if (p == null)
			{
				System.out.println("\nNo se ha encontrado el proyecto: " + Integer.toString(codigo));
			}
			else
			{
				System.out.println("Proyecto: " + p.toString() + ". Importe: " + Float.toString(p.getImporte()));
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void pregunta_II()
	{
		Session s = sessionFactory.openSession();
		List<Object[]> lista = s.createQuery("select p.codigoProyecto, count(pt.codigoTarea), count(pt.tipoDocumento").list();
		s.close();
		if (lista == null)
		{
			System.out.println("\nNo se han encontrado datos.");
		}
		else
		{
			System.out.println("\nProyecto\tCant. Tareas\tCant. Empleados");
			for (Object[] elem : lista)
			{
				System.out.println("\n" + elem[0].toString() + "\t" + elem[1].toString() + "\t" + elem[2].toString() + "\t");
			}
		}
	}
}