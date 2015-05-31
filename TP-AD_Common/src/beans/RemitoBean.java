package beans;

import java.util.ArrayList;
import java.util.List;



public class RemitoBean {
	
	private int nroRemito;
	private String estado;
	private List<MercaderiaBean> mercaderias;
	private VehiculoBean vehiculo;
	
	public RemitoBean(int nroRemito, String estado, VehiculoBean vehiculo) {
		super();
		this.nroRemito = nroRemito;
		this.estado = estado;
		this.mercaderias = new ArrayList<MercaderiaBean>();
		this.vehiculo=vehiculo;
	}

	public RemitoBean(){}
	

	public int getNroRemito() {
		return nroRemito;
	}

	public String getEstado() {
		return estado;
	}

	public List<MercaderiaBean> getMercaderias() {
		return mercaderias;
	}
	public void setMercaderias(ArrayList<MercaderiaBean> mercaderias) {
		this.mercaderias = mercaderias;
	}


	public VehiculoBean getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoBean vehiculo) {
		this.vehiculo = vehiculo;
	}

	
	public void setNroRemito(int nroRemito) {
		this.nroRemito = nroRemito;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void addMercaderia(MercaderiaBean mercaderia) {
		this.mercaderias.add(mercaderia);
	}
	
	

}
