package modelo;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Rubros")
public class Rubro {
	
	@Id
	@Column(name = "IdRubro")
	private int idRubro;
	
	@Column
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdRubro() {
		return idRubro;
	}
}
