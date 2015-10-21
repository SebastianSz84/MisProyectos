package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("MO")
public class ManoDeObra extends Material
{
	private float valorHora;
	
	public float getValorHora()
	{
		return valorHora;
	}
	
	public void setValorHora(float valorHora)
	{
		this.valorHora = valorHora;
	}
	
	public ManoDeObra()
	{
		super();
	}
	
	@Override
	public float getValor()
	{
		return this.valorHora;
	}
}