package negocio;

import java.util.Vector;

import VO.AlumnoVO;
import VO.CursoVO;

public class Curso
{
	private int numeroCurso;
	private Materia materia;
	private Profesor profesor;
	private Vector<Alumno> alumnos;
	private int cantidadMaxima;
	
	public int getNumeroCurso()
	{
		return numeroCurso;
	}
	
	public void setNumeroCurso(int numeroCurso)
	{
		this.numeroCurso = numeroCurso;
	}
	
	public Materia getMateria()
	{
		return materia;
	}
	
	public void setMateria(Materia materia)
	{
		this.materia = materia;
	}
	
	public Profesor getProfesor()
	{
		return profesor;
	}
	
	public void setProfesor(Profesor profesor)
	{
		this.profesor = profesor;
	}
	
	public Vector<Alumno> getAlumnos()
	{
		return alumnos;
	}
	
	public void setAlumnos(Vector<Alumno> alumnos)
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
	
	public Curso()
	{
	}
	
	public String toString()
	{
		String s = "Curso " + Integer.toString(this.numeroCurso);
		if (this.materia != null)
		{
			s = s + " - " + this.materia.toString();
		}
		return s;
	}
	
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		else if (o instanceof Curso)
		{
			Curso c = (Curso) o;
			return this.numeroCurso == c.getNumeroCurso();
		}
		else if (o instanceof CursoVO)
		{
			CursoVO c = (CursoVO) o;
			return this.numeroCurso == c.getNumeroCurso();
		}
		else
		{
			return false;
		}
	}
	
	public CursoVO getVO()
	{
		CursoVO vo = new CursoVO();
		Vector<AlumnoVO> aVO = new Vector<>();
		for (Alumno a : alumnos)
		{
			aVO.add(a.getVO());
		}
		vo.setAlumnos(aVO);
		vo.setMateria(materia.getVO());
		vo.setNumeroCurso(numeroCurso);
		vo.setProfesor(profesor.getVO());
		return vo;
	}
	
	public void asignarAlumno(Alumno a)
	{
		alumnos.add(a);
	}
	
	public void eliminarAlumno(Alumno a)
	{
		alumnos.removeElement(a);
	}
}