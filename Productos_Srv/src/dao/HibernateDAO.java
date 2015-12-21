package dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entities.MateriaPrima;
import entities.SemiElaborado;
import entities.Unidad;

public class HibernateDAO {
	private static HibernateDAO instancia;
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public static HibernateDAO getInstancia() {
		if (instancia == null) {
			instancia = new HibernateDAO();
		}
		return instancia;
	}

	public static void setInstancia(HibernateDAO instancia) {
		HibernateDAO.instancia = instancia;
	}

	public static SessionFactory getSf() {
		return sf;
	}

	public static void setSf(SessionFactory sf) {
		HibernateDAO.sf = sf;
	}

	@SuppressWarnings("unchecked")
	public List<MateriaPrima> listarMPs() {
		Session s = sf.openSession();
		List<MateriaPrima> lista = s.createQuery("from MateriaPrima").list();
		s.close();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Unidad> listarUNs() {
		Session s = sf.openSession();
		List<Unidad> lista = s.createQuery("from Unidad").list();
		s.close();
		return lista;
	}

	public Unidad leerUN(int codUn) {
		Session s = sf.openSession();
		Unidad d = (Unidad) s.createQuery("from Unidad where codUnidad = :codUn ").setParameter("codUn", codUn).uniqueResult();
		s.close();
		return d;
	}

	public MateriaPrima leerMP(String codMP) {
		Session s = sf.openSession();
		MateriaPrima mp = (MateriaPrima) s.createQuery("from MateriaPrima where codMaterial = :codMP ").setParameter("codMP", codMP).uniqueResult();
		s.close();
		return mp;
	}

	@SuppressWarnings("unchecked")
	public List<SemiElaborado> listarSE() {
		Session s = sf.openSession();
		List<SemiElaborado> lista = s.createQuery("from SemiElaborado").list();
		s.close();
		return lista;
	}

	public SemiElaborado grabarSE(SemiElaborado se) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		s.saveOrUpdate(se);
		tx.commit();
		return se;
	}

	public SemiElaborado leerSE(int codSE) {
		Session s = sf.openSession();
		SemiElaborado se = (SemiElaborado) s.createQuery("from SemiElaborado where codProducto = :cod").setParameter("cod", codSE).uniqueResult();
		s.close();
		return se;
	}
}