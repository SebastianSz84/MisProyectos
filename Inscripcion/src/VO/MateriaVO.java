package VO;

public class MateriaVO
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
	
	public MateriaVO()
	{
	}
	
	public String toString()
	{
		return this.numero + " - " + this.nombre;
	}
	
	public boolean equals(Object o)
	{
		if (o == null || (o instanceof MateriaVO))
		{
			return false;
		}
		
		MateriaVO m = (MateriaVO) o;
		
		if (this.numero.equals(m.getNumero()))
		{
			return true;
		}
		return false;
	}
}