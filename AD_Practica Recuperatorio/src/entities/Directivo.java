package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "directivos")
public class Directivo extends Empleados
{
	private float salario;
	
	public float getSalario()
	{
		return salario;
	}
	
	public void setSalario(float salario)
	{
		this.salario = salario;
	}
}