package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;





public class SucursalBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numeroSucursal;
	private String nombre;
	private String dir;
	private String gerente;
	private String encDespacho;
	private String encRecepcion;
	private List<DepositoBean> depositos;
	private List<PedidoBean> pedidos;
	private List<VehiculoBean> vehiculos;
	private List<MapaDeRutaBean> rutas;
	public SucursalBean(String nombre, String dir, String gerente,
			String encDespacho, String encRecepcion) {
		this.nombre = nombre;
		this.dir = dir;
		this.gerente = gerente;
		this.encDespacho = encDespacho;
		this.encRecepcion = encRecepcion;
		this.depositos = new ArrayList<DepositoBean>();
		this.pedidos = new ArrayList<PedidoBean>();
		this.vehiculos = new ArrayList<VehiculoBean>();
		this.rutas = new ArrayList<MapaDeRutaBean>();
	}
	public SucursalBean(){}
	

	public int getNumeroSucursal() {
		return numeroSucursal;
	}
	public void setNumeroSucursal(int numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}
	public String getNombre() {
		return nombre;
	}
	public String getDir() {
		return dir;
	}
	public String getGerente() {
		return gerente;
	}
	public String getEncDespacho() {
		return encDespacho;
	}
	public String getEncRecepcion() {
		return encRecepcion;
	}
	

	public List<DepositoBean> getDepositos() {
		return depositos;
	}

	public void setDepositos(ArrayList<DepositoBean> depositos) {
		this.depositos = depositos;
	}
	

	public List<PedidoBean> getPedidos() {
		return pedidos;
	}
	public void setPedidos(ArrayList<PedidoBean> pedidos) {
		this.pedidos = pedidos;
	}
	

	public List<VehiculoBean> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(ArrayList<VehiculoBean> vehiculos) {
		this.vehiculos = vehiculos;
	}
	

	public List<MapaDeRutaBean> getRutas() {
		return rutas;
	}
	
	public void setRutas(ArrayList<MapaDeRutaBean> rutas) {
		this.rutas = rutas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public void setGerente(String gerente) {
		this.gerente = gerente;
	}
	public void setEncDespacho(String encDespacho) {
		this.encDespacho = encDespacho;
	}
	public void setEncRecepcion(String encRecepcion) {
		this.encRecepcion = encRecepcion;
	}
	public void addDeposito(DepositoBean deposito) {
		this.depositos.add(deposito);
	}
	public void addPedido(PedidoBean pedido) {
		this.pedidos.add(pedido);
	}
	public void addVehiculo(VehiculoBean vehiculo) {
		this.vehiculos.add(vehiculo);
	}
	public void addRuta(MapaDeRutaBean ruta) {
		this.rutas.add(ruta);
	}
	public void setDepositos(List<DepositoBean> depositos) {
		this.depositos = depositos;
	}
	public void setPedidos(List<PedidoBean> pedidos) {
		this.pedidos = pedidos;
	}
	public void setVehiculos(List<VehiculoBean> vehiculos) {
		this.vehiculos = vehiculos;
	}
	public void setRutas(List<MapaDeRutaBean> rutas) {
		this.rutas = rutas;
	}
	
}
