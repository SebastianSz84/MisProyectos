package dao;

import hbt.HibernateUtil;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import entities.Reparacion;
import entities.Tecnico;

public class TallerDAO
{
	private static SessionFactory sf;
	private static TallerDAO instancia;
	
	public static SessionFactory getSf()
	{
		return sf;
	}
	
	public static void setSf(SessionFactory sf)
	{
		TallerDAO.sf = sf;
	}
	
	public static TallerDAO getInstancia()
	{
		if (instancia == null)
		{
			instancia = new TallerDAO();
		}
		return instancia;
	}
	
	public static void setInstancia(TallerDAO instancia)
	{
		TallerDAO.instancia = instancia;
	}
	
	public TallerDAO()
	{
		super();
		sf = HibernateUtil.getSessionFactory();
	}
	
	@SuppressWarnings("unchecked")
	public List<Tecnico> getTecnicos()
	{
		Session s = sf.openSession();
		List<Tecnico> tecnicos = s.createQuery("from Tecnico").list();
		s.close();
		return tecnicos;
	}
	
	public Reparacion getReparacion(int nroRep)
	{
		Session s = sf.openSession();
		Reparacion r = (Reparacion) s.createQuery("from Reparacion where codigoReparacion = :nroRep").setParameter("nroRep", nroRep).list().get(0);
		s.close();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	public List<Reparacion> getReparaciones()
	{
		Session s = sf.openSession();
		List<Reparacion> reps = s.createQuery("from Reparacion").list();
		s.close();
		return reps;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> getRepsXTecnicoYFecha(String tDoc, int nDoc, Date fIni, Date fFin)
	{
		Session s = sf.openSession();
		Query q = s.createQuery("select r.numero,t.nombre from Reparacion r join r.items it join it.tecnico t where t.clave.tipoDocumento = :tDoc and t.clave.numeroDocumento = :nDoc and r.fecha between :fIni and :fFin");
		q.setParameter("tDoc", tDoc);
		q.setParameter("nDoc", nDoc);
		q.setDate("fIni", fIni);
		q.setDate("fFin", fFin);
		List<Object[]> tuplas = q.list();
		s.close();
		return tuplas;
	}
	
	public float getImpRepXFechas(Date fIni, Date fFin)
	{
		Session s = sf.openSession();
		Query q = s.createQuery("select sum(m.precio*it.cantidad) from Reparacion r join r.items it join it.clave.material m where r.fecha between :fIni and :fFin and m.class = Repuesto");
		q.setDate("fIni", fIni);
		q.setDate("fFin", fFin);
		float importe = Float.parseFloat(q.list().get(0).toString());
		s.close();
		return importe;
	}
}