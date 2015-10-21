package entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reparaciones")
public class Reparacion
{
	@Id
	@Column(name = "codigoReparacion")
	private int numero;
	private Date fecha;
	private String estado;
	
	@ManyToOne
	@JoinColumns(
	{
		@JoinColumn(name = "tipoDocumento"),
		@JoinColumn(name = "numeroDocumento")
	})
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "matricula")
	private Vehiculo vehiculo;
	
	@OneToMany
	// (fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoReparacion")
	private List<ItemReparacion> items;
	
	public int getNumero()
	{
		return numero;
	}
	
	public void setNumero(int numero)
	{
		this.numero = numero;
	}
	
	public Date getFecha()
	{
		return fecha;
	}
	
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}
	
	public String getEstado()
	{
		return estado;
	}
	
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
	
	public Reparacion()
	{
		super();
	}
	
	public float getTotal()
	{
		float total = 0;
		for (ItemReparacion itRep : items)
		{
			total = total + itRep.getSubtotal();
		}
		return total;
	}
	
	public Cliente getCliente()
	{
		return cliente;
	}
	
	public void setCliente(Cliente cliente)
	{
		this.cliente = cliente;
	}
	
	public List<ItemReparacion> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemReparacion> items)
	{
		this.items = items;
	}
	
	public Vehiculo getVehiculo()
	{
		return vehiculo;
	}
	
	public void setVehiculo(Vehiculo vehiculo)
	{
		this.vehiculo = vehiculo;
	}
}