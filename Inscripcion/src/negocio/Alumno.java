package negocio;

import VO.AlumnoVO;

public class Alumno
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
	
	public Alumno()
	{
	}
	
	public String toString()
	{
		return Integer.toString(this.legajo) + this.nombre;
	}
	
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		else if (o instanceof Alumno)
		{
			Alumno a = (Alumno) o;
			return this.legajo == a.getLegajo();
		}
		else if (o instanceof AlumnoVO)
		{
			AlumnoVO a = (AlumnoVO) o;
			return this.legajo == a.getLegajo();
		}
		else
		{
			return false;
		}
	}
	
	public AlumnoVO getVO()
	{
		AlumnoVO vo = new AlumnoVO();
		vo.setEstado(estado);
		vo.setLegajo(legajo);
		vo.setNombre(nombre);
		return vo;
	}
}