package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Clientes")
public class Cliente
{
	@Id
	private int dni;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "domicilio", nullable = false)
	private String domicilio;
	
	public int getDni()
	{
		return dni;
	}
	
	public void setDni(int dni)
	{
		this.dni = dni;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getDomicilio()
	{
		return domicilio;
	}
	
	public void setDomicilio(String domicilio)
	{
		this.domicilio = domicilio;
	}
	
	public Cliente()
	{
	}
}