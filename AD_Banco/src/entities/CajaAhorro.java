package entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CajasAhorro")
public class CajaAhorro extends Cuenta
{
	public CajaAhorro()
	{
		super();
	}
}