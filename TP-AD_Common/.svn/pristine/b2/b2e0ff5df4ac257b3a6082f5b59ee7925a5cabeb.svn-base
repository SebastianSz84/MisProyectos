package beans;

import java.util.ArrayList;
import java.util.List;

public class DepositoBean {
	private int idDeposito;
	private float cantidadMax;
	private String encargado;
	private List<AreaBean> areas;
	private List<MercaderiaBean> mercaderias;
	private SucursalBean suc;
	

	public DepositoBean(float cantidadMax, String encargado, SucursalBean sucursal) {
		this.cantidadMax = cantidadMax;
		this.encargado = encargado;
		this.areas = new ArrayList<AreaBean>();
		this.mercaderias = new ArrayList<MercaderiaBean>();
		this.suc=sucursal;
	}

	public DepositoBean(){}
	

	public int getIdDeposito() {
		return idDeposito;
	}


	public void setIdDeposito(int idDeposito) {
		this.idDeposito = idDeposito;
	}

	public List<AreaBean> getAreas() {
		return areas;
	}

	public void setAreas(ArrayList<AreaBean> areas) {
		this.areas = areas;
	}


	public List<MercaderiaBean> getMercaderias() {
		return mercaderias;
	}

	public void setMercaderias(ArrayList<MercaderiaBean> mercaderias) {
		this.mercaderias = mercaderias;
	}



	public float getCantidadMax() {
		return cantidadMax;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setCantidadMax(float cantidadMax) {
		this.cantidadMax = cantidadMax;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public void addAreas(AreaBean area) {
		this.areas.add(area);
	}

	public void addMercaderia(MercaderiaBean mercaderia) {
		this.mercaderias.add(mercaderia);
	}


	public SucursalBean getSuc() {
		return suc;
	}

	public void setSuc(SucursalBean suc) {
		this.suc = suc;
	}

	public void setAreas(List<AreaBean> areas) {
		this.areas = areas;
	}

	public void setMercaderias(List<MercaderiaBean> mercaderias) {
		this.mercaderias = mercaderias;
	}
	
	

}
