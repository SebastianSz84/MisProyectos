package beans;

import java.io.Serializable;




public class AreaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idArea;
	private String descripcion;
	private float capacidadMaxima;
	private DepositoBean deposito;
	public AreaBean(String descripcion, float capacidadMaxima, DepositoBean deposito) {
		this.deposito=deposito;
		this.descripcion = descripcion;
		this.capacidadMaxima = capacidadMaxima;
	}
	
	public AreaBean(){}
	
	public int getIdArea() {
		return idArea;
	}



	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public DepositoBean getDeposito() {
		return deposito;
	}



	public void setDeposito(DepositoBean deposito) {
		this.deposito = deposito;
	}



	public String getDescripcion() {
		return descripcion;
	}
	public float getCapacidadMaxima() {
		return capacidadMaxima;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCapacidadMaxima(float capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}
	
	
	
	

}
