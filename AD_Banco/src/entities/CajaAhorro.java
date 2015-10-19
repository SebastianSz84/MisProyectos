package entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CajasAhorro")
@PrimaryKeyJoinColumn
public class CajaAhorro extends Cuenta
{
	
	public CajaAhorro()
	{
		super();
	}
}