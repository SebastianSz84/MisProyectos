package beans;

import java.io.Serializable;
import java.util.List;

public class ElaboradoDTO extends ProductoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SemiElaboradoDTO> componentes;
	private float precioVenta;
	private int porcentajeGanancia;
	private UnidadDTO unidad;

	public List<SemiElaboradoDTO> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<SemiElaboradoDTO> componentes) {
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

	public UnidadDTO getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadDTO unidad) {
		this.unidad = unidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}