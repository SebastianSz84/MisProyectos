package beans;

import java.sql.Date;



public class MovimientoCuentaBean {
	
	private int idMovimiento;
	private Date fecha;
	private float monto;
	private CuentaCorrienteBean cuenta;
	
	public MovimientoCuentaBean(Date fecha, float monto, CuentaCorrienteBean cuenta) {
		super();
		this.fecha = fecha;
		this.monto = monto;
		this.cuenta = cuenta;
	}
	
	public MovimientoCuentaBean(){}
	
	

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}



	public CuentaCorrienteBean getCuenta() {
		return cuenta;
	}

	public void setCuenta(CuentaCorrienteBean cuenta) {
		this.cuenta = cuenta;
	}


	public Date getFecha() {
		return fecha;
	}
	public float getMonto() {
		return monto;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	
	

}
