package beans;

import java.io.Serializable;

public class UnidadDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int codigo;
	private String descripcion;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}