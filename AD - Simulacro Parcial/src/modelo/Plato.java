package modelo;

import javax.persistence.*;

@Entity
@Table(name = "Platos")
public class Plato {

	@Id
	@Column(name = "IdPlato")
	private int idPlato;
	
	@Column
	private String descripcion;

	@Column
	private float precio;
	
	@ManyToOne
	@JoinColumn(name = "IdRubro")
	private Rubro rubro;

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

	public int getIdPlato() {
		return idPlato;
	} 
}
