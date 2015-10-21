package entities;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ClaveItemRep implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "codigoReparacion")
	private Reparacion reparacion;
	
	@ManyToOne
	@JoinColumn(name = "codigoMaterial")
	private Material material;
	
	public Material getMaterial()
	{
		return material;
	}
	
	public void setMaterial(Material material)
	{
		this.material = material;
	}
	
	public Reparacion getReparacion()
	{
		return reparacion;
	}
	
	public void setReparacion(Reparacion reparacion)
	{
		this.reparacion = reparacion;
	}
}