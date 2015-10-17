package test;

import java.util.List;
import DAO.*;
import DTO.*;

public class HQLTest {

	public static void main(String[] args) {
		//1.	Indicar la cantidad.de platos que pertenecen  a cada rubro
		List<RubroDTO> res = RubroDAO.listPlatos();
		
		//2.	Identificar al mozo que factur� el mayor importe entre todas sus facturas.
		MozoDTO mozoMayorFact = MozoDAO.listMozoConMayorFacturacion();
		
		//3.	Identificar al mozo que no factur� ning�n postre.
		List<MozoDTO> mozosSinPostres = MozoDAO.listMozosSinPostre();
		
		//4.	Indicar los platos de mayor precio que se facturaron y la factura correspondiente.
		List<FacturaDTO> facturasConPlatosMasCaros = FacturasDAO.listFacturasConPlatosMasCaros();
		
		//5.	Indicar los mozos que pertenezcan a las localidades que correspondan al siguiente patr�n de caracteres: ...
		List<MozoDTO> mozosPorLocalidad = MozoDAO.listMozosPorLocalidad("arti");
		
		//6.	Indicar el plato m�s caro de cada rubro facturado por el mozo: ...
		List<PlatoDTO> platoMasCaroPorRubroPorMozo = PlatoDAO.listPlatosMasCarosPorRubroPorMozo(3);
	}

}
