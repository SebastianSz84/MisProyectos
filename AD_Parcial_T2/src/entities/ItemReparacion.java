package entities;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reparacion_material")
public class ItemReparacion
{
	@EmbeddedId
	private ClaveItemRep clave;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumns(
	{
		@JoinColumn(name = "tipoDocumento"),
		@JoinColumn(name = "numeroDocumento")
	})
	private Tecnico tecnico;
	
	private int cantidad;
	
	public int getCantidad()
	{
		return cantidad;
	}
	
	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}
	
	public Tecnico getTecnico()
	{
		return tecnico;
	}
	
	public void setTecnico(Tecnico tecnico)
	{
		this.tecnico = tecnico;
	}
	
	public float getSubtotal()
	{
		return this.cantidad * this.clave.getMaterial().getValor();
	}
	
	public ClaveItemRep getClave()
	{
		return clave;
	}
	
	public void setClave(ClaveItemRep clave)
	{
		this.clave = clave;
	}
}