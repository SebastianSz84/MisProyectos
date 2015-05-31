package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class EmpresaBean extends ClienteBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private String cuit;
	private String razonSoial;
	private String regularidad;
	private List<EmpresaDirValidasBean> direccionesValidas;
	private List<ProductoBean> productosValidos;
	private List<CuentaCorrienteBean> cuentasCorrientes;

	public EmpresaBean(String direccion, String telefono, String razonSoial, String cuit, String regularidad) {
		super(direccion, telefono);
		this.razonSoial = razonSoial;
		this.cuit = cuit;
		this.regularidad = regularidad;
		this.direccionesValidas = new ArrayList<EmpresaDirValidasBean>();
		this.productosValidos = new ArrayList<ProductoBean>();
		this.cuentasCorrientes =  new ArrayList<CuentaCorrienteBean>();
	}

	public EmpresaBean() {
		super();
	}

	public String getRazonSoial() {
		return razonSoial;
	}

	public String getCuit() {
		return cuit;
	}


	public String getRegularidad() {
		return regularidad;
	}


	public List<EmpresaDirValidasBean> getDireccionesValidas() {
		return direccionesValidas;
	}


	public List<ProductoBean> getProductosValidos() {
		return productosValidos;
	}

	public List<CuentaCorrienteBean> getCuentasCorrientes() {
		return cuentasCorrientes;
	}


	public void setRazonSoial(String razonSoial) {
		this.razonSoial = razonSoial;
	}


	public void setCuit(String cuit) {
		this.cuit = cuit;
	}


	public void setRegularidad(String regularidad) {
		this.regularidad = regularidad;
	}


	public void addDireccionValida(EmpresaDirValidasBean direccionValida) {
		this.direccionesValidas.add(direccionValida);
	}


	public void addProductoValido(ProductoBean productosValido) {
		this.productosValidos.add(productosValido);
	}


	public void setCuentasCorrientes(List<CuentaCorrienteBean> cuentasCorrientes) {
		this.cuentasCorrientes = cuentasCorrientes;
	}



	public void setProductosValidos(List<ProductoBean> productosValidos) {
		this.productosValidos = productosValidos;
	}

	public void setDireccionesValidas(List<EmpresaDirValidasBean> direccionesValidas) {
		this.direccionesValidas = direccionesValidas;
	}


	public void addCuentaCorriente(CuentaCorrienteBean cuentaCorriente) {
		this.cuentasCorrientes.add(cuentaCorriente);
	}

	@Override
	public String getIdentificacion() {
		// TODO Auto-generated method stub
		return this.cuit;
	}

	public String getTipoCliente()
	{
		return "CUIT";
	}




}
