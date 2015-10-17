package DAO;

import java.util.*;

import DTO.*;

public class FacturasDAO extends BaseDAO {
	
	
	
	public static List<FacturaDTO> listFacturasConPlatosMasCaros() {
		
		String hql = 
				"select distinct " +
				"f.nroFactura, f.total, " +
				"f.fechaApertura, f.fechaCierre " + 
				"from Factura f " +
				"inner join f.platos p " +
				"where p.precio = (select Max(p.precio) from Plato p)";
		
		List<Object> hqlResult = getSession().createQuery(hql).list();
		
		List<FacturaDTO> listFact = new Vector<FacturaDTO>();
		
		for (Object mozo : hqlResult) {
			
			FacturaDTO factDTO = new FacturaDTO();
			
			factDTO.idFactura = (Integer)(((Object[])mozo)[0]);
			factDTO.total = (float)(((Object[])mozo)[1]);
			factDTO.fechaApertura = (Date)(((Object[])mozo)[2]);
			factDTO.fechaCierre= (Date)(((Object[])mozo)[3]);
			
			listFact.add(factDTO);
		}
		return listFact;
	}
}
