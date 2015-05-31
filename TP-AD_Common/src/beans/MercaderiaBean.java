package beans;

import java.util.ArrayList;
import java.util.List;



public abstract class MercaderiaBean {
	
	protected int idMercaderia;
	protected float alto;
	protected float ancho;
	protected float profundidad;
	protected String fragilidad;
	protected boolean aplicable;
	protected int cantApilable;
	protected String condDeViaje;
	protected String indicacionesManpulacion;
	protected String coordenadasDestino;
	protected RemitoBean remito;
	protected List<MovimientoBean> movimientos;
	protected PedidoBean pedido;
	protected DepositoBean deposito;
	
	public MercaderiaBean(float alto, float ancho, float profundidad,String fragilidad, boolean aplicable, int cantApilable,
			String condDeViaje, String indicacionesManpulacion,	String coordenadasDestino, RemitoBean remito, PedidoBean pedido, DepositoBean deposito) {
		this.alto = alto;
		this.ancho = ancho;
		this.profundidad = profundidad;
		this.fragilidad = fragilidad;
		this.aplicable = aplicable;
		this.cantApilable = cantApilable;
		this.condDeViaje = condDeViaje;
		this.indicacionesManpulacion = indicacionesManpulacion;
		this.coordenadasDestino = coordenadasDestino;
		this.movimientos = new ArrayList<MovimientoBean>();
		this.remito=remito;
		this.pedido=pedido;
		this.deposito=deposito;
	}

	public MercaderiaBean()
	{
	}
	

	public int getIdMercaderia() {
		return idMercaderia;
	}
	public void setIdMercaderia(int idMercaderia) {
		this.idMercaderia = idMercaderia;
	}



	public RemitoBean getRemito() {
		return remito;
	}



	public void setRemito(RemitoBean remito) {
		this.remito = remito;
	}



	public List<MovimientoBean> getMovimientos() {
		return movimientos;
	}

	public void setMovimientos(ArrayList<MovimientoBean> movimientos) {
		this.movimientos = movimientos;
	}



	public float getAlto() {
		return alto;
	}

	public float getAncho() {
		return ancho;
	}

	public float getProfundidad() {
		return profundidad;
	}

	public String getFragilidad() {
		return fragilidad;
	}

	public boolean isAplicable() {
		return aplicable;
	}

	public int getCantApilable() {
		return cantApilable;
	}

	public String getCondDeViaje() {
		return condDeViaje;
	}

	public String getIndicacionesManpulacion() {
		return indicacionesManpulacion;
	}

	public String getCoordenadasDestino() {
		return coordenadasDestino;
	}

	public void setAlto(float alto) {
		this.alto = alto;
	}

	public void setAncho(float ancho) {
		this.ancho = ancho;
	}

	public void setProfundidad(float profundidad) {
		this.profundidad = profundidad;
	}

	public void setFragilidad(String fragilidad) {
		this.fragilidad = fragilidad;
	}

	public void setAplicable(boolean aplicable) {
		this.aplicable = aplicable;
	}

	public void setCantApilable(int cantApilable) {
		this.cantApilable = cantApilable;
	}

	public void setCondDeViaje(String condDeViaje) {
		this.condDeViaje = condDeViaje;
	}

	public void setIndicacionesManpulacion(String indicacionesManpulacion) {
		this.indicacionesManpulacion = indicacionesManpulacion;
	}

	public void setCoordenadasDestino(String coordenadasDestino) {
		this.coordenadasDestino = coordenadasDestino;
	}

	public void addMovimiento (MovimientoBean movimiento) {
		this.movimientos.add(movimiento);
	}


	public PedidoBean getPedido() {
		return pedido;
	}


	public void setPedido(PedidoBean pedido) {
		this.pedido = pedido;
	}


	public void setMovimientos(List<MovimientoBean> movimientos) {
		this.movimientos = movimientos;
	}


	public DepositoBean getDeposito() {
		return deposito;
	}


	public void setDeposito(DepositoBean deposito) {
		this.deposito = deposito;
	}

	
}
