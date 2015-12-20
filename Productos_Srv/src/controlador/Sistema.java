package controlador;

import java.util.List;

import dao.HibernateDAO;
import entities.MateriaPrima;
import entities.Unidad;

public class Sistema {
	private static Sistema instancia;

	public static Sistema getInstancia() {
		if (instancia == null) {
			instancia = new Sistema();
		}
		return instancia;
	}

	public static void setInstancia(Sistema instancia) {
		Sistema.instancia = instancia;
	}

	public List<MateriaPrima> listarMPs() {
		return HibernateDAO.getInstancia().listarMPs();
	}

	public List<Unidad> listarUNs() {
		return HibernateDAO.getInstancia().listarUNs();
	}
}