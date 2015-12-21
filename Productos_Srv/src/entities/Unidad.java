package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import beans.UnidadDTO;

@Entity
@Table(name = "unidades")
public class Unidad {
	@Id
	@Column(name = "codUnidad")
	private int codigo;

	@Column(length = 50)
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

	public UnidadDTO getDTO() {
		UnidadDTO unDTO = new UnidadDTO();
		unDTO.setCodigo(codigo);
		unDTO.setDescripcion(descripcion);
		return unDTO;
	}
}