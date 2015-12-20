package entities;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class Producto {
	@Id
	@Column(name = "codProducto")
	private int numero;

	@Column(length = 50)
	private String descripcion;
}