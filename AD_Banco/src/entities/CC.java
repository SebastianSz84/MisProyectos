package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CuentasCorriente")
public class CC extends Cuenta
{
	@Column(nullable = false)
	private Float descubierto;
	
	public Float getDescubierto()
	{
		return descubierto;
	}
	
	public void setDescubierto(Float descubierto)
	{
		this.descubierto = descubierto;
	}
	
	public CC()
	{
		super();
	}
}