package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tecnicos")
public class Tecnico extends Persona
{
	private float salarioBase;
	
	public float getSalarioBase()
	{
		return salarioBase;
	}
	
	public void setSalarioBase(float salarioBase)
	{
		this.salarioBase = salarioBase;
	}
	
	public Tecnico()
	{
		super();
	}
}