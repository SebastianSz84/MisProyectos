package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "elaborados")
public class Elaborado extends Producto {
	@ManyToMany
	@JoinTable(name = "compuestoDe", joinColumns = { @JoinColumn(name = "codProductoE") }, inverseJoinColumns = { @JoinColumn(name = "codProductoSM") })
	private List<SemiElaborado> componentes;

	private float precioVenta;
	private int porcentajeGanancia;
	@ManyToOne
	@JoinColumn(name = "unidad")
	private Unidad unidad;

	public List<SemiElaborado> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<SemiElaborado> componentes) {
		this.componentes = componentes;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public int getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(int porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public Unidad getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidad unidad) {
		this.unidad = unidad;
	}
}