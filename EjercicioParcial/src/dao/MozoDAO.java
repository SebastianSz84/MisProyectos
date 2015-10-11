package dao;

import entities.Mozo;
import hbt.HibernateUtil;

public class MozoDAO extends HibernateUtil {

	public static Mozo getMozo(int id) {
		return getEntity(Mozo.class, id);
	}	
}