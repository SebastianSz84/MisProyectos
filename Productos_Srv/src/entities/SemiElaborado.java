package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "semiElaborados")
public class SemiElaborado extends Producto {
	@ManyToMany
	@JoinTable(name = "materialSemi", joinColumns = { @JoinColumn(name = "codProducto") }, inverseJoinColumns = @JoinColumn(name = "codMaterial"))
	private List<MateriaPrima> meteriales;
	private float costoProduccion;
	@ManyToOne
	@JoinColumn(name = "almacenadoComo")
	private Unidad unidadAlmacenamiento;

	public List<MateriaPrima> getMeteriales() {
		return meteriales;
	}

	public void setMeteriales(List<MateriaPrima> meteriales) {
		this.meteriales = meteriales;
	}

	public float getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public Unidad getUnidadAlmacenamiento() {
		return unidadAlmacenamiento;
	}

	public void setUnidadAlmacenamiento(Unidad unidadAlmacenamiento) {
		this.unidadAlmacenamiento = unidadAlmacenamiento;
	}
}