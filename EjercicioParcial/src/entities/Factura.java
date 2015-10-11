package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Facturas")
public class Factura {
	@Id
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

	public int getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(int nroFactura) {
		this.nroFactura = nroFactura;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
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
}