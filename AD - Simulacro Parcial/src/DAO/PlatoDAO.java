package DAO;

import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import DTO.PlatoDTO;
import DTO.RubroDTO;

public class PlatoDAO extends BaseDAO {
	
	public static List<PlatoDTO> listPlatosMasCarosPorRubroPorMozo(int idMozo) {
		
		String hql = 
				"select p.idPlato, p.descripcion, p.precio, r.descripcion " + 
				"from Factura f " +
				"inner join f.platos p " +
				"inner join p.rubro r " +
				"where p.precio = (" +
				"	select max(p.precio) " +
				"	from Factura f " +
				"	inner join f.platos p " +
				"	inner join p.rubro ru " +
				"	where f.mozo = :idMozo " +
				"	and ru.idRubro = r.idRubro " +
				"	) " +
				"and f.mozo = :idMozo " +
				"order by r.idRubro, p.precio";
		
		List<Object> hqlResult = getSession().createQuery(hql).setInteger("idMozo", idMozo).list();
		
		List<PlatoDTO> listPlatos = new Vector<PlatoDTO>();
		
		for (Object plato : hqlResult) {
			
			PlatoDTO platoDTO = new PlatoDTO();
			
			platoDTO.idPlato = (Integer)(((Object[])plato)[0]);
			platoDTO.descripcion = (String)(((Object[])plato)[1]);
			platoDTO.precio = (float)(((Object[])plato)[2]);
			platoDTO.rubroDescripcion = (String)(((Object[])plato)[3]);
			
			listPlatos.add(platoDTO);
		}
		return listPlatos;
	}
}
