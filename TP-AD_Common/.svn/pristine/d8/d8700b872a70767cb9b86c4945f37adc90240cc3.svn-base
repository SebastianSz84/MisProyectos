package beans;

import java.io.Serializable;


public class PlanDeMantenimientoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPlan;
	private float cantKilometros;
	private String tipo;
	private String controlEspecial;
	private VehiculoBean vehiculo;
	public PlanDeMantenimientoBean(float cantKilometros, String tipo, String controlEspecial, VehiculoBean vehiculo) {
		this.cantKilometros = cantKilometros;
		this.tipo = tipo;
		this.controlEspecial = controlEspecial;
		this.vehiculo=vehiculo;
	}

	public PlanDeMantenimientoBean(){}


	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}



	public VehiculoBean getVehiculo() {
		return vehiculo;
	}



	public void setVehiculo(VehiculoBean vehiculo) {
		this.vehiculo = vehiculo;
	}



	public float getCantKilometros() {
		return cantKilometros;
	}
	public String getTipo() {
		return tipo;
	}
	public String getControlEspecial() {
		return controlEspecial;
	}
	public void setCantKilometros(float cantKilometros) {
		this.cantKilometros = cantKilometros;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setControlEspecial(String controlEspecial) {
		this.controlEspecial = controlEspecial;
	}



}
