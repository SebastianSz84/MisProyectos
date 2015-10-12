package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Platos")
public class Plato {
	@Id
	private Integer idPlato;
	private String descripcion;
	private Float precio;
	@ManyToOne
	@JoinColumn(name = "IdRubro")
	private Rubro rubro;

	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Rubro getRubro() {
		return rubro;
	}

	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}

}