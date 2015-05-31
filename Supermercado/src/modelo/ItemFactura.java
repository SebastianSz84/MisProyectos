package modelo;

public class ItemFactura {
	private int nroItem;
	private int cantidad;
	private Producto producto;

	public ItemFactura(int nroItem, int cantidad, Producto prod) {
		this.nroItem = nroItem;
		this.cantidad = cantidad;
		this.producto = prod;
	}

	public ItemFactura(int cant, Producto prod) {
		this.cantidad = cant;
		this.producto = prod;
	}

	public float getSubtotal() {
		return this.cantidad * this.producto.getPrecio();
	}

	public int getNroItem() {
		return nroItem;
	}

	public void setNroItem(int nroItem) {
		this.nroItem = nroItem;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
