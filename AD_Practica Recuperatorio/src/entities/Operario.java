package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "operarios")
public class Operario extends Empleados
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
}