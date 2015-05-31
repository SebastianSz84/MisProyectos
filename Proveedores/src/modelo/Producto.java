package modelo;

public class Producto {
	private int codigo;
	private String descripcion;

	public Producto(int cod, String des) {
		this.codigo = cod;
		this.descripcion = des;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ProductoView getView() {
		return new ProductoView(this.codigo, this.descripcion);
	}
}