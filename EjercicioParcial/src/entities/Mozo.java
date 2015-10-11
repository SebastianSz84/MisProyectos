package entities;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Mozos")
public class Mozo {
	@Id
	private int idMozo;
	private String nombre;
	private String apellido;
	@Embedded
	private Domicilio domicilio;

	public int getIdMozo() {
		return idMozo;
	}

	public void setIdMozo(int idMozo) {
		this.idMozo = idMozo;
	}

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
}