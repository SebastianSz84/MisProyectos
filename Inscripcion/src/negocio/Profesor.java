package negocio;

import java.util.Vector;

import VO.MateriaVO;
import VO.ProfesorVO;

public class Profesor
{
	private int numeroLegajo;
	private String nombre;
	private Direccion direccion;
	private Vector<Materia> materias;
	
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
	
	public Direccion getDireccion()
	{
		return direccion;
	}
	
	public void setDireccion(Direccion direccion)
	{
		this.direccion = direccion;
	}
	
	public Vector<Materia> getMaterias()
	{
		return materias;
	}
	
	public void setMaterias(Vector<Materia> materias)
	{
		this.materias = materias;
	}
	
	public Profesor()
	{
	}
	
	public String toString()
	{
		return Integer.toString(this.numeroLegajo) + " " + this.nombre;
	}
	
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		else if (o instanceof Profesor)
		{
			Profesor p = (Profesor) o;
			return this.numeroLegajo == p.getNumeroLegajo();
		}
		else if (o instanceof ProfesorVO)
		{
			ProfesorVO p = (ProfesorVO) o;
			return this.numeroLegajo == p.getNumeroLegajo();
		}
		else
		{
			return false;
		}
	}
	
	public ProfesorVO getVO()
	{
		ProfesorVO vo = new ProfesorVO();
		vo.setDireccion(this.direccion.getVO());
		Vector<MateriaVO> mVO = new Vector<>();
		for (Materia m : materias)
		{
			mVO.add(m.getVO());
		}
		vo.setMaterias(mVO);
		vo.setNombre(nombre);
		vo.setNumeroLegajo(numeroLegajo);
		return vo;
	}
	
	public void asignarMateria(Materia m)
	{
		materias.add(m);
	}
}
