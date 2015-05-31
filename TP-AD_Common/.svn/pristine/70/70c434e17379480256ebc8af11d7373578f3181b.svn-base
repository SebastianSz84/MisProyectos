package beans;

import java.io.Serializable;




public class ParticularBean extends ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private String apellido;


	public ParticularBean(String direccion, String telefono, String nombre,	String apellido, String dni) {
		super(direccion, telefono);
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public ParticularBean() {
		super();
	}
		
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}

	public String getDni() {
		return dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String getIdentificacion() {
		// TODO Auto-generated method stub
		return this.dni;
	}

	public String getTipoCliente()
	{
		return "DNI";
	}


}
