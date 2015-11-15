package entities;

import javax.persistence.Embeddable;

@Embeddable
public class ItemTareaId
{
	private Proyecto proyecto;
	private Tareas tarea;
	
	public Proyecto getProyecto()
	{
		return proyecto;
	}
	
	public void setProyecto(Proyecto proyecto)
	{
		this.proyecto = proyecto;
	}
	
	public Tareas getTarea()
	{
		return tarea;
	}
	
	public void setTarea(Tareas tarea)
	{
		this.tarea = tarea;
	}
}