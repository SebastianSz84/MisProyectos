package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "proyecto_tarea")
public class ItemTarea
{
	@EmbeddedId
	private ItemTareaId clave;
	
	@ManyToMany
	@JoinColumns(
	{
		@JoinColumn(name = "tipoDocumento"),
		@JoinColumn(name = "numeroDocumento")
	})
	private Operario operario;
	
	@ManyToOne
	@JoinColumn(name = "codigoTarea", insertable = false, updatable = false)
	private Tareas tarea;
	
	private int cantidadHoras;
	private float valorHora;
	
	public Operario getOperario()
	{
		return operario;
	}
	
	public void setOperario(Operario operario)
	{
		this.operario = operario;
	}
	
	public int getCantidadHoras()
	{
		return cantidadHoras;
	}
	
	public void setCantidadHoras(int cantidadHoras)
	{
		this.cantidadHoras = cantidadHoras;
	}
	
	public float getValorHora()
	{
		return valorHora;
	}
	
	public void setValorHora(float valorHora)
	{
		this.valorHora = valorHora;
	}
}