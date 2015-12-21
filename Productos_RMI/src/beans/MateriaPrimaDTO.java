package beans;

public class MateriaPrimaDTO {
	private String codigo;
	private String descripcion;
	private UnidadDTO unidadCompra;
	private UnidadDTO unidadUso;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public UnidadDTO getUnidadCompra() {
		return unidadCompra;
	}

	public void setUnidadCompra(UnidadDTO unidadCompra) {
		this.unidadCompra = unidadCompra;
	}

	public UnidadDTO getUnidadUso() {
		return unidadUso;
	}

	public void setUnidadUso(UnidadDTO unidadUso) {
		this.unidadUso = unidadUso;
	}

}