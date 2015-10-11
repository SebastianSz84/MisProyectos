package dao;

import hbt.HibernateUtil;

import java.util.List;

import entities.Rubro;

public class RubroDAO extends HibernateUtil {

	public static Rubro getRubro(int id) {
		return getEntity(Rubro.class, id);
	}

	public static List<Rubro> getList() {
		return getAll(Rubro.class, "Rubros");
	}
}