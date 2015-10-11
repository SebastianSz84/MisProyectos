package dao;

import hbt.HibernateUtil;

import java.util.List;

import entities.Mozo;

public class MozoDAO extends HibernateUtil {

	public static Mozo getMozo(int id) {
		return getEntity(Mozo.class, id);
	}

	public static List<Mozo> getList() {
		return getAll(Mozo.class, "Mozos");
	}
}