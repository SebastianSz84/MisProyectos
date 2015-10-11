package dao;

import hbt.HibernateUtil;
import entities.Localidad;

public class LocalidadDAO extends HibernateUtil {
	public static Localidad getLocalidad(int codpos) {
		return getEntity(Localidad.class, codpos);
	}
}