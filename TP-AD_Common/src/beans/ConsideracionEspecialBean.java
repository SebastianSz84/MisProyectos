package beans;

import java.util.ArrayList;
import java.util.List;


public class ConsideracionEspecialBean {
	
	private int idConsideracionEspecial;
	private boolean entregaInmediata;
	private boolean requiereAvioneta;
	private boolean autorizacionAvioneta;
	private boolean requiereCamionExterno;
	private float costoExtra;
	private List<CarrierBean> carriers;
	private List<VehiculoExternoBean> vExternos;
	private PedidoBean pedido;
	
	public ConsideracionEspecialBean(boolean entregaInmediata,
			boolean requiereAvioneta, boolean autorizacionAvioneta,
			boolean requiereCamionExterno, float costoExtra, PedidoBean pedido) {
		super();
		this.entregaInmediata = entregaInmediata;
		this.requiereAvioneta = requiereAvioneta;
		this.autorizacionAvioneta = autorizacionAvioneta;
		this.requiereCamionExterno = requiereCamionExterno;
		this.costoExtra = costoExtra;
		this.carriers = new ArrayList<CarrierBean>();
		this.vExternos = new ArrayList<VehiculoExternoBean>();
		this.pedido=pedido;
	}

	public ConsideracionEspecialBean(){}
	
	public int getIdConsideracionEspecial() {
		return idConsideracionEspecial;
	}

	public void setIdConsideracionEspecial(int idConsideracionEspecial) {
		this.idConsideracionEspecial = idConsideracionEspecial;
	}


	public PedidoBean getPedido() {
		return pedido;
	}




	public void setPedido(PedidoBean pedido) {
		this.pedido = pedido;
	}




	public boolean isEntregaInmediata() {
		return entregaInmediata;
	}


	public boolean isRequiereAvioneta() {
		return requiereAvioneta;
	}


	public boolean isAutorizacionAvioneta() {
		return autorizacionAvioneta;
	}


	public boolean isRequiereCamionExterno() {
		return requiereCamionExterno;
	}


	public float getCostoExtra() {
		return costoExtra;
	}


	public List<CarrierBean> getCarriers() {
		return carriers;
	}


	public void setCarriers(List<CarrierBean> carriers) {
		this.carriers = carriers;
	}


	public List<VehiculoExternoBean> getvExternos() {
		return vExternos;
	}


	public void setvExternos(List<VehiculoExternoBean> vExternos) {
		this.vExternos = vExternos;
	}
	public void setEntregaInmediata(boolean entregaInmediata) {
		this.entregaInmediata = entregaInmediata;
	}


	public void setRequiereAvioneta(boolean requiereAvioneta) {
		this.requiereAvioneta = requiereAvioneta;
	}


	public void setAutorizacionAvioneta(boolean autorizacionAvioneta) {
		this.autorizacionAvioneta = autorizacionAvioneta;
	}


	public void setRequiereCamionExterno(boolean requiereCamionExterno) {
		this.requiereCamionExterno = requiereCamionExterno;
	}


	public void setCostoExtra(float costoExtra) {
		this.costoExtra = costoExtra;
	}


	public void addCarrier(CarrierBean carrier) {
		this.carriers.add(carrier);
	}


	public void addvExterno(VehiculoExternoBean vehiculo) {
		this.vExternos.add(vehiculo);
	}
	
	
	

}
