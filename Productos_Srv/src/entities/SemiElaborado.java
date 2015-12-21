package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import beans.MateriaPrimaDTO;
import beans.SemiElaboradoDTO;

@Entity
@Table(name = "semiElaborados")
public class SemiElaborado extends Producto {
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "materialSemi", joinColumns = { @JoinColumn(name = "codProducto") }, inverseJoinColumns = @JoinColumn(name = "codMaterial"))
	private List<MateriaPrima> meteriales;

	@Column(name = "costo")
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

	public SemiElaboradoDTO getDTO() {
		SemiElaboradoDTO seDTO = new SemiElaboradoDTO();
		seDTO.setCostoProduccion(costoProduccion);
		seDTO.setDescripcion(this.getDescripcion());
		seDTO.setNumero(this.getNumero());
		List<MateriaPrimaDTO> lista = new ArrayList<>();
		for (MateriaPrima mp : this.meteriales) {
			lista.add(mp.getDTO());
		}
		seDTO.setMeteriales(lista);
		return seDTO;
	}
}