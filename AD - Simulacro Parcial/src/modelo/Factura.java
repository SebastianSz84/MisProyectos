package modelo;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "Facturas")
public class Factura {

	@Id
	@Column(name = "NroFactura")
	private int nroFactura;
	
	@ManyToOne
	@JoinColumn(name = "IdMozo")
	private Mozo mozo;
	
	@ManyToMany
	@JoinTable(name = "ItemsFactura", joinColumns = @JoinColumn(name = "nroFactura"), inverseJoinColumns = @JoinColumn(name = "idPlato"))
	private List<Plato> platos;
	
	private Date fechaApertura;
	
	private Date fechaCierre;
	
	private float total;

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public List<Plato> getPlato() {
		return platos;
	}

	public void setPlato(List<Plato> platos) {
		this.platos = platos;
	}

	public Date getFechaApertura() {
		return fechaApertura;
	}

	public void setFechaApertura(Date fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getNroFactura() {
		return nroFactura;
	}
}
