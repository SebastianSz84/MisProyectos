package VO;

import java.util.Vector;

public class ProfesorVO
{
	private int numeroLegajo;
	private String nombre;
	private DireccionVO direccion;
	private Vector<MateriaVO> materias;
	
	public int getNumeroLegajo()
	{
		return numeroLegajo;
	}
	
	public void setNumeroLegajo(int numeroLegajo)
	{
		this.numeroLegajo = numeroLegajo;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public DireccionVO getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(DireccionVO direccion)
	{
		this.direccion = direccion;
	}
	
	public Vector<MateriaVO> getMaterias()
	{
		return materias;
	}
	
	public void setMaterias(Vector<MateriaVO> materias)
	{
		this.materias = materias;
	}
	
	public ProfesorVO()
	{
	}
	
	public String toString()
	{
		return "Curso " + Integer.toString(this.numeroLegajo);
	}
	
	public boolean equals(Object o)
	{
		if (o == null || !(o instanceof ProfesorVO))
		{
			return false;
		}
		
		ProfesorVO p = (ProfesorVO) o;
		
		if (this.numeroLegajo == p.getNumeroLegajo())
		{
			return true;
		}
		return false;
	}
}