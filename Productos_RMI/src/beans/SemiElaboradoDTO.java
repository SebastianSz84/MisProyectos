package beans;

import java.util.List;

public class SemiElaboradoDTO extends ProductoDTO {
	private List<MateriaPrimaDTO> meteriales;
	private float costoProduccion;
	private UnidadDTO unidadAlmacenamiento;

	public List<MateriaPrimaDTO> getMeteriales() {
		return meteriales;
	}

	public void setMeteriales(List<MateriaPrimaDTO> meteriales) {
		this.meteriales = meteriales;
	}

	public float getCostoProduccion() {
		return costoProduccion;
	}

	public void setCostoProduccion(float costoProduccion) {
		this.costoProduccion = costoProduccion;
	}

	public UnidadDTO getUnidadAlmacenamiento() {
		return unidadAlmacenamiento;
	}

	public void setUnidadAlmacenamiento(UnidadDTO unidadAlmacenamiento) {
		this.unidadAlmacenamiento = unidadAlmacenamiento;
	}

}