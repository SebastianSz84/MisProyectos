package DAO;

import java.util.List;
import java.util.Vector;

import org.hibernate.Query;
import org.hibernate.Session;

import DTO.RubroDTO;

public class RubroDAO extends BaseDAO {
	
	public static List<RubroDTO> listPlatos() {
		String hql = "select r.descripcion, count(p.idPlato) from Plato p inner join p.rubro r group by r.descripcion";
		
		Query query = getSession().createQuery(hql);
		
		List<Object> queryResult = query.list();
		List<RubroDTO> dtoResult = new Vector<RubroDTO>();
		
		for (Object rubro: queryResult) {
			RubroDTO dto = new RubroDTO();
			
			dto.rubro = (String)(((Object[])rubro)[0]);
			dto.cantPlatos = (Long)(((Object[])rubro)[1]);
			
			dtoResult.add(dto);
		}
		return dtoResult;
	}
}
