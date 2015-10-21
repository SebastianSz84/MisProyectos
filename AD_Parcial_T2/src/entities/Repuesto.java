package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PR")
public class Repuesto extends Material
{
	private float precio;
	
	public float getPrecio()
	{
		return precio;
	}
	
	public void setPrecio(float precio)
	{
		this.precio = precio;
	}
	
	public Repuesto()
	{
		super();
	}
	
	@Override
	public float getValor()
	{
		return this.precio;
	}
}