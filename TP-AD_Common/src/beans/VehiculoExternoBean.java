package beans;



public class VehiculoExternoBean {
	
	private int idVehiculoExterno;
	private String tipo;
	private String identificacion;
	private float capacidadCarga;
	private ConsideracionEspecialBean consideracionEspecial;
	public VehiculoExternoBean(String tipo, String identificacion,
			float capacidadCarga, ConsideracionEspecialBean consideracionEspecial) {
		super();
		this.tipo = tipo;
		this.identificacion = identificacion;
		this.capacidadCarga = capacidadCarga;
		this.consideracionEspecial=consideracionEspecial;
	}

	public VehiculoExternoBean(){}

	public int getIdVehiculoExterno() {
		return idVehiculoExterno;
	}


	public void setIdVehiculoExterno(int idVehiculoExterno) {
		this.idVehiculoExterno = idVehiculoExterno;
	}


	public ConsideracionEspecialBean getConsideracionEspecial() {
		return consideracionEspecial;
	}


	public void setConsideracionEspecial(
			ConsideracionEspecialBean consideracionEspecial) {
		this.consideracionEspecial = consideracionEspecial;
	}


	public String getTipo() {
		return tipo;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public float getCapacidadCarga() {
		return capacidadCarga;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	public void setCapacidadCarga(float capacidadCarga) {
		this.capacidadCarga = capacidadCarga;
	}
	
	

}
