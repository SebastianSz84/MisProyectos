package VO;

public class AlumnoVO
{
	private int legajo;
	private String nombre;
	private String estado;
	
	public int getLegajo()
	{
		return legajo;
	}
	
	public void setLegajo(int legajo)
	{
		this.legajo = legajo;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public String getEstado()
	{
		return estado;
	}
	
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
	
	public AlumnoVO()
	{
	}
	
	public String toString()
	{
		return Integer.toString(this.legajo) + this.nombre;
	}
	
	public boolean equals(Object o)
	{
		if (o == null || (o instanceof AlumnoVO))
		{
			return false;
		}
		
		AlumnoVO a = (AlumnoVO) o;
		
		if (this.legajo == a.getLegajo())
		{
			return true;
		}
		return false;
	}
}