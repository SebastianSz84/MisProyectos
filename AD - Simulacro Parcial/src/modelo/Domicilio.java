package modelo;

import javax.persistence.*;

@Embeddable
public class Domicilio {
	
	@Column
	private String calle;
	
	@Column
	private int numero;
	
	@Column
	private int piso;
	
	@Column
	private int depto;
	
	@ManyToOne
	@JoinColumn(name = "IdCodPos")
	private Localidad localidad;

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public int getDepto() {
		return depto;
	}

	public void setDepto(int depto) {
		this.depto = depto;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

}
