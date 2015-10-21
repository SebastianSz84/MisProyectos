package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo
{
	@Id
	@Column(length = 8, nullable = false)
	private String matricula;
	@Column(length = 50)
	private String marca;
	@Column(length = 50)
	private String modelo;
	private int anio;
	@ManyToOne
	@JoinColumns(
	{
		@JoinColumn(name = "tipoDocumento"),
		@JoinColumn(name = "numeroDocumento")
	})
	private Cliente duenio;
	
	public String getMatricula()
	{
		return matricula;
	}
	
	public void setMatricula(String matricula)
	{
		this.matricula = matricula;
	}
	
	public String getMarca()
	{
		return marca;
	}
	
	public void setMarca(String marca)
	{
		this.marca = marca;
	}
	
	public String getModelo()
	{
		return modelo;
	}
	
	public void setModelo(String modelo)
	{
		this.modelo = modelo;
	}
	
	public int getAnio()
	{
		return anio;
	}
	
	public void setAnio(int anio)
	{
		this.anio = anio;
	}
	
	public Cliente getDuenio()
	{
		return duenio;
	}
	
	public void setDuenio(Cliente duenio)
	{
		this.duenio = duenio;
	}
	
	public Vehiculo()
	{
		super();
	}
}