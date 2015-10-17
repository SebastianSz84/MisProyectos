package modelo;

import javax.persistence.*;

@Entity
@Table(name = "Localidades")
public class Localidad {

	@Id
	@Column(name = "IdCodPos")
	public int codPos;
	
	@Column(name = "localida")
	public String nombre;

}
