package DAO;

import java.util.List;
import java.util.Vector;

import org.hibernate.Query;

import DTO.MozoDTO;
import DTO.RubroDTO;

public class MozoDAO extends BaseDAO {
	
	public static List<MozoDTO> listMozosPorLocalidad(String localidadPattern) {
		String hql = 
				"select m.idMozo, m.nombre, m.apellido " +
				"from Mozo m " +
				"inner join m.domicilio d " +
				"inner join d.localidad l " +
				"where l.nombre like :localidadPattern";
		
		List<Object> hqlResult = getSession().createQuery(hql).setString("localidadPattern", "%" + localidadPattern + "%").list();
		
		List<MozoDTO> listMozo = new Vector<MozoDTO>();
		
		for (Object mozo : hqlResult) {
			
			MozoDTO mozoDTO = new MozoDTO();
			
			mozoDTO.idMozo = (Integer)(((Object[])mozo)[0]);
			mozoDTO.nombre = (String)(((Object[])mozo)[1]);
			mozoDTO.apellido = (String)(((Object[])mozo)[2]);
			
			listMozo.add(mozoDTO);
		}

		return listMozo;
	}
	
	public static MozoDTO listMozoConMayorFacturacion() {
		
		String hql = 
				"select m.idMozo, m.nombre, m.apellido, sum(f.total) " +
				"from Factura f " +
				"inner join f.mozo m " +
				"group by m.idMozo, m.nombre, m.apellido " +
				"order by sum(f.total) desc ";
		
		Object hqlResult = getSession().createQuery(hql).setMaxResults(1).uniqueResult();
		
		MozoDTO mozo = new MozoDTO();
		
		mozo.idMozo = (Integer)(((Object[])hqlResult)[0]);
		mozo.nombre = (String)(((Object[])hqlResult)[1]);
		mozo.apellido = (String)(((Object[])hqlResult)[2]);
		mozo.facturacion = (Double)(((Object[])hqlResult)[3]);
				
		return mozo;
		
	}
	
	public static List<MozoDTO> listMozosSinPostre() {
		
		String hql = 
				"select m.idMozo, m.nombre, m.apellido " +
				"from Mozo m " +
				"where m.idMozo not in " +
				"(select f.mozo.idMozo " +
				"from Factura f " +
				"inner join f.platos p " +
				"inner join p.rubro r " +
				"where r.descripcion = 'Postres')";
		
		List<Object> hqlResult = getSession().createQuery(hql).list();
		
		List<MozoDTO> listMozo = new Vector<MozoDTO>();
		
		for (Object mozo : hqlResult) {
			
			MozoDTO mozoDTO = new MozoDTO();
			
			mozoDTO.idMozo = (Integer)(((Object[])mozo)[0]);
			mozoDTO.nombre = (String)(((Object[])mozo)[1]);
			mozoDTO.apellido = (String)(((Object[])mozo)[2]);
			
			listMozo.add(mozoDTO);
		}
		
		return listMozo;
		
	}
}
