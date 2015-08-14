package negocio;

import VO.MateriaVO;

public class Materia
{
	private String numero;
	private String nombre;
	
	public String getNumero()
	{
		return numero;
	}
	
	public void setNumero(String numero)
	{
		this.numero = numero;
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public Materia()
	{
	}
	
	public String toString()
	{
		return this.numero + " - " + this.nombre;
	}
	
	public boolean equals(Object o)
	{
		if (o == null)
		{
			return false;
		}
		else if (o instanceof Materia)
		{
			Materia m = (Materia) o;
			return this.numero.equals(m.getNumero());
		}
		else if (o instanceof MateriaVO)
		{
			MateriaVO m = (MateriaVO) o;
			return this.numero.equals(m.getNumero());
		}
		else
		{
			return false;
		}
	}
	
	public MateriaVO getVO()
	{
		MateriaVO vo = new MateriaVO();
		vo.setNombre(nombre);
		vo.setNumero(numero);
		return vo;
	}
}
