package modelo;

import javax.persistence.*;

@Entity
@Table(name = "Mozos")
public class Mozo {
	
	@Id
	@Column(name = "IdMozo")
	private int idMozo;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;
		
	@Embedded
	private Domicilio domicilio;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public int getIdMozo() {
		return idMozo;
	}

}
