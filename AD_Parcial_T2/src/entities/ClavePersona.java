package entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ClavePersona implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoDocumento;
	private int numeroDocumento;
	
	public int getNumeroDocumento()
	{
		return numeroDocumento;
	}
	
	public void setNumeroDocumento(int numeroDocumento)
	{
		this.numeroDocumento = numeroDocumento;
	}
	
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
	public String getTipoDocumento()
	{
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento)
	{
		this.tipoDocumento = tipoDocumento;
	}
}