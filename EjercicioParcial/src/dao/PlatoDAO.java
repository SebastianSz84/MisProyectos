package dao;

import java.util.List;

import hbt.HibernateUtil;
import entities.Plato;

public class PlatoDAO extends HibernateUtil {

	public static Plato getPlato(int id) {
		return getEntity(Plato.class, id);
	}

	public static List<Plato> getList() {
		return getAll(Plato.class,"Platos");
	}	
}