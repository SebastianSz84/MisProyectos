package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tareas")
public class Tareas
{
	@Id
	@Column(name = "codigoTarea")
	private int codigo;
	private String descripcion;
	
	public int getCodigo()
	{
		return codigo;
	}
	
	public void setCodigo(int codigo)
	{
		this.codigo = codigo;
	}
	
	public String getDescripcion()
	{
		return descripcion;
	}
	
	public void setDescripcion(String descripcion)
	{
		this.descripcion = descripcion;
	}
}