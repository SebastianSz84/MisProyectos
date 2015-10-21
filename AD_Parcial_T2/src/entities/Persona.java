package entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persona
{
	@EmbeddedId
	private ClavePersona clave;
	@Column(length = 150, nullable = true)
	private String nombre;
	
	public Persona()
	{
		super();
	}
	
	public ClavePersona getClave()
	{
		return clave;
	}
	
	public void setClave(ClavePersona clave)
	{
		this.clave = clave;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
}