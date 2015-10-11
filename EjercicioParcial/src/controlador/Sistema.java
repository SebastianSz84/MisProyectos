package controlador;

import java.util.List;

import dao.PlatoDAO;
import entities.Plato;

public class Sistema {

	public static void main(String[] args) {
		List<Plato> platos = PlatoDAO.getList();
	}
}