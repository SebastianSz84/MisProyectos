package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Empleados
{
	@EmbeddedId
	private EmpleadosId clave;
	private String nombre;
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public EmpleadosId getClave()
	{
		return clave;
	}
	
	public void setClave(EmpleadosId clave)
	{
		this.clave = clave;
	}
}
