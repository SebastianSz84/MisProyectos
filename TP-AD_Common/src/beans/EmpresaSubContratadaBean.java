package beans;

import java.util.ArrayList;

public class EmpresaSubContratadaBean {
	
	private String razonSocial;
	private ArrayList<VehiculoExternoBean> vehiculosEsternos;
	private ArrayList<CarrierBean> carriers;

	public EmpresaSubContratadaBean(String razonSocial) {
		super();
		this.razonSocial = razonSocial;
		this.vehiculosEsternos = new ArrayList<VehiculoExternoBean>();
		this.carriers = new ArrayList<CarrierBean>();
		
	}

	public EmpresaSubContratadaBean(){}
	
	public String getRazonSocial() {
		return razonSocial;
	}

	public ArrayList<VehiculoExternoBean> getVehiculosEsternos() {
		return vehiculosEsternos;
	}

	public ArrayList<CarrierBean> getCarriers() {
		return carriers;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void addVehiculoEsterno(VehiculoExternoBean vehiculosEsterno) {
		this.vehiculosEsternos.add(vehiculosEsterno);
	}

	public void addCarrier(CarrierBean carrier) {
		this.carriers.add(carrier);
	}
	
	
	

}
