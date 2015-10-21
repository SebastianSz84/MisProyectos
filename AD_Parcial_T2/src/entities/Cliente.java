package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Persona
{
	@Column(length = 50)
	private String cuentaCorriente;
	
	public String getCuentaCorriente()
	{
		return cuentaCorriente;
	}
	
	public void setCuentaCorriente(String cuentaCorriente)
	{
		this.cuentaCorriente = cuentaCorriente;
	}
	
	public Cliente()
	{
		super();
	}
}