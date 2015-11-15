package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EmpleadosId
{
	private String tipoDocumento;
	@Column(name = "numeroDocumento")
	private int numero;
	
	public String getTipoDocumento()
	{
		return tipoDocumento;
	}
	
	public void setTipoDocumento(String tipoDocumento)
	{
		this.tipoDocumento = tipoDocumento;
	}
	
	public int getNumero()
	{
		return numero;
	}
	
	public void setNumero(int numero)
	{
		this.numero = numero;
	}
}