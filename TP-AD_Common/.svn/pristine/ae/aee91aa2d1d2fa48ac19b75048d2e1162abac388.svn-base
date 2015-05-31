package beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;




public class PedidoBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPedido;
	private String manifiesto;
	private String dirDestino;
	private Date fechaEnregaMaxima;
	private Date fechaEntregaEstimada;
	private String condEspeciales;
	private Time horarioDeEntregaDesde;
	private Time horarioDeEntregahasta;
	private String estado;
	private String dirDeRetiroSoloEmpresa;
	private int prioridad;
	private ClienteBean cliente;
	private SucursalBean sucursal;
	private List<MercaderiaBean> mercaderias;
	private List<DestinatarioBean> destinatarios;
	private List<ConsideracionEspecialBean> consideraciones;

	public PedidoBean(String manifiesto, String dirDestino, Date fechaEnregaMaxima,
			Date fechaEntregaEstimada, String condEspeciales,
			Time horarioDeEntregaDesde, Time horarioDeEntregahasta,
			String dirDeRetiroSoloEmpresa, int prioridad,String estado,  SucursalBean sucursal,ClienteBean cliente) 
	{
		this.manifiesto = manifiesto;
		this.dirDestino = dirDestino;
		this.fechaEnregaMaxima = fechaEnregaMaxima;
		this.fechaEntregaEstimada = fechaEntregaEstimada;
		this.condEspeciales = condEspeciales;
		this.horarioDeEntregaDesde = horarioDeEntregaDesde;
		this.horarioDeEntregahasta = horarioDeEntregahasta;
		this.dirDeRetiroSoloEmpresa = dirDeRetiroSoloEmpresa;
		this.prioridad = prioridad;
		this.sucursal=sucursal;
		this.estado=estado;
		this.mercaderias = new ArrayList<MercaderiaBean>();
		this.cliente=cliente;
		this.destinatarios = new ArrayList<DestinatarioBean>();
		this.consideraciones = new ArrayList<ConsideracionEspecialBean>();
	}

	public PedidoBean(){
		this.mercaderias = new ArrayList<MercaderiaBean>();
		this.destinatarios = new ArrayList<DestinatarioBean>();
		this.consideraciones = new ArrayList<ConsideracionEspecialBean>();



	}
	

	public int getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}



	public String getManifiesto() {
		return manifiesto;
	}

	public String getDirDestino() {
		return dirDestino;
	}

	public Date getFechaEnregaMaxima() {
		return fechaEnregaMaxima;
	}

	public Date getFechaEntregaEstimada() {
		return fechaEntregaEstimada;
	}

	public String getCondEspeciales() {
		return condEspeciales;
	}

	public Time getHorarioDeEntregaDesde() {
		return horarioDeEntregaDesde;
	}

	public Time getHorarioDeEntregahasta() {
		return horarioDeEntregahasta;
	}

	public String getDirDeRetiroSoloEmpresa() {
		return dirDeRetiroSoloEmpresa;
	}

	public int getPrioridad() {
		return prioridad;
	}


	public List<MercaderiaBean> getMercaderias() {
		return mercaderias;
	}

	public void setMercaderias(List<MercaderiaBean> mercaderias) {
		this.mercaderias = mercaderias;
	}


	public List<ConsideracionEspecialBean> getConsideraciones() {
		return consideraciones;
	}
	public void setConsideraciones(
			List<ConsideracionEspecialBean> consideraciones) {
		this.consideraciones = consideraciones;
	}

	


	public List<DestinatarioBean> getDestinatarios() {
		return destinatarios;
	}
	public void setDestinatarios(List<DestinatarioBean> destinatarios) {
		this.destinatarios = destinatarios;
	}



	public void setManifiesto(String manifiesto) {
		this.manifiesto = manifiesto;
	}

	public void setDirDestino(String dirDestino) {
		this.dirDestino = dirDestino;
	}

	public void setFechaEnregaMaxima(Date fechaEnregaMaxima) {
		this.fechaEnregaMaxima = fechaEnregaMaxima;
	}

	public void setFechaEntregaEstimada(Date fechaEntregaEstimada) {
		this.fechaEntregaEstimada = fechaEntregaEstimada;
	}

	public void setCondEspeciales(String condEspeciales) {
		this.condEspeciales = condEspeciales;
	}

	public void setHorarioDeEntregaDesde(Time horarioDeEntregaDesde) {
		this.horarioDeEntregaDesde = horarioDeEntregaDesde;
	}

	public void setHorarioDeEntregahasta(Time horarioDeEntregahasta) {
		this.horarioDeEntregahasta = horarioDeEntregahasta;
	}

	public void setDirDeRetiroSoloEmpresa(String dirDeRetiroSoloEmpresa) {
		this.dirDeRetiroSoloEmpresa = dirDeRetiroSoloEmpresa;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public void addMercaderia(MercaderiaBean mercaderia) {
		this.mercaderias.add(mercaderia);
	}

	public void addDestinatario(DestinatarioBean destinatario) {
		this.destinatarios.add(destinatario);
	}

	public void addConsideraciones(ConsideracionEspecialBean consideracionEs) {
		this.consideraciones.add(consideracionEs);
	}



	public SucursalBean getSucursal() {
		return sucursal;
	}


	public void setSucursal(SucursalBean sucursal) {
		this.sucursal = sucursal;
	}


	public ClienteBean getCliente() {
		return cliente;
	}


	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

	
}
