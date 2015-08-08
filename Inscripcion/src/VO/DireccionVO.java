package VO;

public class DireccionVO
{
	private String calle;
	private int numero;
	private String cp;
	private String localidad;
	private int piso;
	private String depto;
	
	public String getCalle()
	{
		return calle;
	}
	
	public void setCalle(String calle)
	{
		this.calle = calle;
	}
	
	public int getNumero()
	{
		return numero;
	}
	
	public void setNumero(int numero)
	{
		this.numero = numero;
	}
	
	public String getCp()
	{
		return cp;
	}
	
	public void setCp(String cp)
	{
		this.cp = cp;
	}
	
	public String getLocalidad()
	{
		return localidad;
	}
	
	public void setLocalidad(String localidad)
	{
		this.localidad = localidad;
	}
	
	public int getPiso()
	{
		return piso;
	}
	
	public void setPiso(int piso)
	{
		this.piso = piso;
	}
	
	public String getDepto()
	{
		return depto;
	}
	
	public void setDepto(String depto)
	{
		this.depto = depto;
	}
	
	public DireccionVO()
	{
	}
	
	public String toString()
	{
		return this.calle + " " + Integer.toString(this.numero) + " " + Integer.toString(this.piso) + " " + this.depto;
	}
	
	public boolean equals(Object o)
	{
		if (o == null || !(o instanceof DireccionVO))
		{
			return false;
		}
		
		DireccionVO d = (DireccionVO) o;
		
		if (this.calle.equals(d.getCalle()) && this.numero == d.getNumero() && this.cp.equals(d.getCp()) && this.localidad.equals(d.getLocalidad()) && this.piso == d.getPiso() && this.depto.equals(d.getDepto()))
		{
			return true;
		}
		return false;
	}
}
