package beans;



public class MercaderiaPorPesoBean extends MercaderiaBean{

	private float peso;

	public MercaderiaPorPesoBean(float alto, float ancho, float profundidad, String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,	String coordenadasDestino, float peso, RemitoBean remito, PedidoBean pedido, DepositoBean deposito) {
		super(alto, ancho, profundidad, fragilidad, aplicable, cantApilable,condDeViaje, indicacionesManpulacion, coordenadasDestino, remito, pedido, deposito);
		this.peso = peso;
	}

	public MercaderiaPorPesoBean()
	{
		super();
	}
	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
	
	
	
}
