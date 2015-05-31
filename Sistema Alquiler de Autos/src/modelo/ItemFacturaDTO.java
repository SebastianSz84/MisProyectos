package modelo;

public class ItemFacturaDTO {
	private String descripcion;
	private float monto;

	public ItemFacturaDTO(String desc, float monto) {
		descripcion = desc;
		this.monto = monto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
}