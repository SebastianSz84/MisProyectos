package modelo;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Sistema de Alquiler de Autos
//  @ File Name : ModeloDTO.java
//  @ Date : 09/05/2013
//  @ Author : Grupo 5
//
//

public class ModeloDTO {
	private String codigoModelo;
	private String marca;
	private String modelo;
	private String datosMotor;
	private String datosSeguridad;
	private String tipo;
	private float costoDiario;
	private float costoExcedente;
	private boolean activo;

	public ModeloDTO(String cod, String marca, String modelo,
			String datosMotor, String datosSeg, String tipo, float costoDia,
			float costoEx, boolean activo) {
		codigoModelo = cod;
		this.marca = marca;
		this.modelo = modelo;
		this.datosMotor = datosMotor;
		this.datosSeguridad = datosSeg;
		this.tipo = tipo;
		this.costoDiario = costoDia;
		this.costoExcedente = costoEx;
		this.activo = activo;
	}

	public String getCodigoModelo() {
		return codigoModelo;
	}

	public void setCodigoModelo(String codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDatosMotor() {
		return datosMotor;
	}

	public void setDatosMotor(String datosMotor) {
		this.datosMotor = datosMotor;
	}

	public String getDatosSeguridad() {
		return datosSeguridad;
	}

	public void setDatosSeguridad(String datosSeguridad) {
		this.datosSeguridad = datosSeguridad;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getCostoDiario() {
		return costoDiario;
	}

	public void setCostoDiario(float costoDiario) {
		this.costoDiario = costoDiario;
	}

	public float getCostoExcedente() {
		return costoExcedente;
	}

	public void setCostoExcedente(float costoExcedente) {
		this.costoExcedente = costoExcedente;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
