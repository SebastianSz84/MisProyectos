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
	@Column(name="IdCodpos")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="IdCodpos")
	private int codpos;
	private String nombre;

	public int getCodpos() {
		return codpos;
	}
	public void setCodpos(int codpos) {
		this.codpos = codpos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}