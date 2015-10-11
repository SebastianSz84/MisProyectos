package dao;

import hbt.HibernateUtil;
import entities.Rubro;

public class RubroDAO extends HibernateUtil {

	public static Rubro getRubro(int id) {
		return getEntity(Rubro.class, id);
	}	
}