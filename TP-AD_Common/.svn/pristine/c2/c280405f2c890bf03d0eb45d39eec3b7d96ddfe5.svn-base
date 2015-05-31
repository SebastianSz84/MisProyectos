package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import beans.ClienteBean;
import beans.MercaderiaBean;
import beans.ParticularBean;
import beans.PedidoBean;
import beans.SucursalBean;


public interface InterfazEnvios extends Remote
{
	public void agregarEmpresaDireccionValida( String direccion, String tel, String cuit) throws RemoteException;
	public void altaCuentaCorriente(int cbu,float saldoActual, float minimoPermitidoSinAuth, String cuit) throws RemoteException;
	public void altaMovimientoCuenta(Date fecha, float monto, int cbu) throws RemoteException;
	public ParticularBean altaParticular(String direccion, String telefono, String nombre, String apellido, String dni) throws RemoteException;
	public void altaProducto(String tipo, String descripcion, String cuit) throws RemoteException;
	public void altaEmpresa(String direccion, String telefono, String razonSoial, String cuit, String regularidad) throws RemoteException;
	public ClienteBean getCliente(String tipo,String nro) throws RemoteException;
	public void altaSucursal(String nombre, String dir, String gerente, String encDespacho, String encRecepcion) throws RemoteException;
	public void altaDeposito(float cantidadMax, String encargado, String sucursal) throws RemoteException;
	public int altaPedido(String manifiesto, String dirDestino, Date fechaEnregaMaxima,Date fechaEntregaEstimada, String condEspeciales,Time horarioDeEntregaDesde, Time horarioDeEntregahasta,	String dirDeRetiroSoloEmpresa, int prioridad, String estado,String sucursal, String cliente, String tipoC) throws RemoteException;
	public List<PedidoBean> getPedidosPorEstado(String estado) throws RemoteException;
	public PedidoBean getPedido(int numeroPedido) throws RemoteException;
	public List<PedidoBean> getPedidos() throws RemoteException;
	public MercaderiaBean getMercaderia(int idMercaderia) throws RemoteException;
	public int altaPedidoBean(PedidoBean pb) throws RemoteException;
	public SucursalBean getSucursal(String nombre) throws RemoteException;
	public void actualizarPedido(PedidoBean pb) throws RemoteException;
	public ArrayList<String> getListaNombresSucursales() throws RemoteException;
	public String cerrarPedido (PedidoBean pedB) throws RemoteException;
	public List<PedidoBean> getPedidosCliente(int idCliente) throws RemoteException;
	public String validarPedidosPorVencerDeSucursal(String sucursal)throws RemoteException;

}
