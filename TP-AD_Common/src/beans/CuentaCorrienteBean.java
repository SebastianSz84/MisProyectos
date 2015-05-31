package beans;

import java.util.ArrayList;
import java.util.List;




public class CuentaCorrienteBean {
	private int cbu;
	private float saldoActual;
	private float minimoPermitidoSinAuth;
	private boolean estado;
	private EmpresaBean empresa;
	private List<MovimientoCuentaBean> movimientos;
	
	public CuentaCorrienteBean(int cbu,float saldoActual, float minimoPermitidoSinAuth,
			boolean estado, EmpresaBean emp) {
		super();
		this.cbu = cbu;
		this.saldoActual = saldoActual;
		this.minimoPermitidoSinAuth = minimoPermitidoSinAuth;
		this.estado = estado;
		this.movimientos = new ArrayList<MovimientoCuentaBean>();
		this.empresa = emp;
	}

	public CuentaCorrienteBean(){}

	public int getCbu() {
		return cbu;
	}

	public void setCbu(int cbu) {
		this.cbu = cbu;
	}

	public void setMovimientos(List<MovimientoCuentaBean> movimientos) {
		this.movimientos = movimientos;
	}
	
	
	public float getSaldoActual() {
		return saldoActual;
	}

	public float getMinimoPermitidoSinAuth() {
		return minimoPermitidoSinAuth;
	}

	public boolean isEstado() {
		return estado;
	}


	public List<MovimientoCuentaBean> getMovimientos() {
		return movimientos;
	}

	public void setSaldoActual(float saldoActual) {
		this.saldoActual = saldoActual;
	}

	public void setMinimoPermitidoSinAuth(float minimoPermitidoSinAuth) {
		this.minimoPermitidoSinAuth = minimoPermitidoSinAuth;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	
	public void addMovimiento(MovimientoCuentaBean movimiento) {
		this.saldoActual=this.saldoActual+movimiento.getMonto();
		this.movimientos.add(movimiento);
	}
	
	
	
	public EmpresaBean getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaBean empresa) {
		this.empresa = empresa;
	}

}
