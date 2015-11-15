package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proyectos")
public class Proyecto
{
	@Id
	@Column(name = "codigoProyecto")
	private int numero;
	
	@Column(name = "descripcion")
	private String nombre;
	
	@ManyToOne
	@JoinColumns(
	{
		@JoinColumn(name = "tipoDocumento"),
		@JoinColumn(name = "numeroDocumento")
	})
	private Directivo director;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "codigoProyecto")
	private List<ItemTarea> items;
	
	public int getNumero()
	{
		return numero;
	}
	
	public void setNumero(int numero)
	{
		this.numero = numero;
	}
	
	public Directivo getDirector()
	{
		return director;
	}
	
	public void setDirector(Directivo director)
	{
		this.director = director;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public Estado getEstado()
	{
		return estado;
	}
	
	public void setEstado(Estado estado)
	{
		this.estado = estado;
	}
	
	public List<ItemTarea> getItems()
	{
		return items;
	}
	
	public void setItems(List<ItemTarea> items)
	{
		this.items = items;
	}
	
	public float getImporte()
	{
		float importe = 0;
		for (ItemTarea it : items)
		{
			importe = importe + it.getCantidadHoras() * it.getValorHora();
		}
		return 0;
	}
	
	public String toString()
	{
		return Integer.toString(this.numero) + " " + this.nombre;
	}
}