package VO;

import java.util.Vector;

public class CursoVO
{
	private int numeroCurso;
	private MateriaVO materia;
	private ProfesorVO profesor;
	private Vector<AlumnoVO> alumnos;
	private int cantidadMaxima;
	
	public int getNumeroCurso()
	{
		return numeroCurso;
	}
	
	public void setNumeroCurso(int numeroCurso)
	{
		this.numeroCurso = numeroCurso;
	}
	
	public MateriaVO getMateria()
	{
		return materia;
	}
	
	public void setMateria(MateriaVO materia)
	{
		this.materia = materia;
	}
	
	public ProfesorVO getProfesor()
	{
		return profesor;
	}
	
	public void setProfesor(ProfesorVO profesor)
	{
		this.profesor = profesor;
	}
	
	public Vector<AlumnoVO> getAlumnos()
	{
		return alumnos;
	}
	
	public void setAlumnos(Vector<AlumnoVO> alumnos)
	{
		this.alumnos = alumnos;
	}
	
	public int getCantidadMaxima()
	{
		return cantidadMaxima;
	}
	
	public void setCantidadMaxima(int cantidadMaxima)
	{
		this.cantidadMaxima = cantidadMaxima;
	}
	
	public CursoVO()
	{
	}
	
	public String toString()
	{
		return "Curso " + Integer.toString(this.numeroCurso);
	}
	
	public boolean equals(Object o)
	{
		if (o == null || !(o instanceof CursoVO))
		{
			return false;
		}
		
		CursoVO c = (CursoVO) o;
		
		if (this.numeroCurso == c.getNumeroCurso())
		{
			return true;
		}
		return false;
	}
}