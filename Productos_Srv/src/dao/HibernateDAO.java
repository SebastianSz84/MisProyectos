package dao;

import hbt.HibernateUtil;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.MateriaPrima;
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

	public List<Unidad> listarUNs() {
		Session s = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Unidad> lista = s.createQuery("from Unidad").list();
		s.close();
		return lista;
	}
}