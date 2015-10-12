package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Localidades")
public class Localidad {

	@Id
	@Column(name = "IdCodpos")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "IdCodpos")
	private Integer codpos;
	private String localida;

	public Integer getCodpos() {
		return codpos;
	}

	public void setCodpos(Integer codpos) {
		this.codpos = codpos;
	}

	public String getLocalida() {
		return localida;
	}

	public void setLocalida(String localida) {
		this.localida = localida;
	}
}