package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Cuentas")
public abstract class Cuenta
{
	@Id
	private Integer numero;
	@Column(nullable = false)
	private Float saldo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dniCliente")
	private Cliente cliente;
	
	public Integer getNumero()
	{
		return numero;
	}
	
	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}
	
	public Float getSaldo()
	{
		return saldo;
	}
	
	public void setSaldo(Float saldo)
	{
		this.saldo = saldo;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
}