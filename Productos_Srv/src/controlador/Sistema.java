package controlador;

import java.util.ArrayList;
import java.util.List;

import beans.MateriaPrimaDTO;
import beans.SemiElaboradoDTO;
import beans.UnidadDTO;
import dao.HibernateDAO;
import entities.MateriaPrima;
import entities.SemiElaborado;
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

	public List<MateriaPrimaDTO> listarMPs() {
		List<MateriaPrimaDTO> listaMPDTO = new ArrayList<MateriaPrimaDTO>();
		for (MateriaPrima mp : HibernateDAO.getInstancia().listarMPs()) {
			listaMPDTO.add(mp.getDTO());
		}
		return listaMPDTO;
	}

	public List<UnidadDTO> listarUNs() {
		List<UnidadDTO> lista = new ArrayList<>();
		for (Unidad u : HibernateDAO.getInstancia().listarUNs()) {
			lista.add(u.getDTO());
		}
		return lista;
	}

	public List<SemiElaboradoDTO> listarSE() {
		List<SemiElaboradoDTO> lista = new ArrayList<>();
		for (SemiElaborado se : HibernateDAO.getInstancia().listarSE()) {
			lista.add(se.getDTO());
		}
		return lista;
	}

	public SemiElaborado listarMPporSE(int codSE) {
		return HibernateDAO.getInstancia().leerSE(codSE);
	}

	public SemiElaboradoDTO grabarSE(SemiElaboradoDTO seDTO) {
		SemiElaborado se = HibernateDAO.getInstancia().leerSE(seDTO.getNumero());
		return HibernateDAO.getInstancia().grabarSE(se).getDTO();
	}
}