package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "materiales")
public class MateriaPrima {
	@Id
	@Column(name = "codMaterial", length = 50)
	private String codigo;

	@Column(length = 50)
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "uniCompra")
	private Unidad unidadCompra;

	@ManyToOne
	@JoinColumn(name = "uniUso")
	private Unidad unidadUso;

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

	public Unidad getUnidadCompra() {
		return unidadCompra;
	}

	public void setUnidadCompra(Unidad unidadCompra) {
		this.unidadCompra = unidadCompra;
	}

	public Unidad getUnidadUso() {
		return unidadUso;
	}

	public void setUnidadUso(Unidad unidadUso) {
		this.unidadUso = unidadUso;
	}
}