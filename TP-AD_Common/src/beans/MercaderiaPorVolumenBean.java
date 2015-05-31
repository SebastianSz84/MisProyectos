package beans;




public class MercaderiaPorVolumenBean extends MercaderiaBean{
	
	private float volumen;

	public MercaderiaPorVolumenBean(float alto, float ancho, float profundidad, String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,	String coordenadasDestino, float volumen, RemitoBean remito, PedidoBean pedido, DepositoBean deposito) 
	{
		super(alto, ancho, profundidad, fragilidad, aplicable, cantApilable,
				condDeViaje, indicacionesManpulacion, coordenadasDestino, remito, pedido, deposito);
		this.volumen = volumen;
	}

	public MercaderiaPorVolumenBean()
	{ 
		super();
	}
	
	public float getVolumen() {
		return volumen;
	}

	public void setVolumen(float volumen) {
		this.volumen = volumen;
	}

	
	
}
