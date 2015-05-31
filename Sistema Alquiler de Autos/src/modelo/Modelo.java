package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

public class Modelo {

	private Vector<Automovil> automoviles;
	private String codigoModelo;
	private String marca;
	private String modelo;
	private String datosMotor;
	private String datosSeguridad;
	private String tipo;
	private float costoDiario;
	private float costoExcedente;
	private boolean activo;

	public Modelo(String codigoModelo, String marca, String modelo,
			String datosMotor, String datosSeguridad, String tipo,
			float costoDiario, float costoExcedente) {
		this.codigoModelo = codigoModelo;
		this.marca = marca;
		this.modelo = modelo;
		this.datosMotor = datosMotor;
		this.datosSeguridad = datosSeguridad;
		this.tipo = tipo;
		this.costoDiario = costoDiario;
		this.costoExcedente = costoExcedente;
		automoviles = new Vector<Automovil>();
	}

	public ModeloDTO crearModeloDTO() {
		ModeloDTO mod = new ModeloDTO(codigoModelo, marca, modelo, datosMotor,
				datosSeguridad, tipo, costoDiario, costoExcedente, activo);
		return mod;
	}

	public void setAutomoviles(Vector<Automovil> automoviles) {
		this.automoviles = automoviles;
	}

	public Vector<Automovil> getAutomoviles() {
		return automoviles;
	}

	public void setCodigoModelo(String codigoModelo) {
		this.codigoModelo = codigoModelo;
	}

	public String getCodigoModelo() {
		return codigoModelo;
	}

	public void setCostoDiario(float costoDiario) {
		this.costoDiario = costoDiario;
	}

	public float getCostoDiario() {
		return costoDiario;
	}

	public void setCostoExcedente(float costoExcedente) {
		this.costoExcedente = costoExcedente;
	}

	public float getCostoExcedente() {
		return costoExcedente;
	}

	public void setDatosMotor(String datosMotor) {
		this.datosMotor = datosMotor;
	}

	public String getDatosMotor() {
		return datosMotor;
	}

	public void setDatosSeguridad(String datosSeguridad) {
		this.datosSeguridad = datosSeguridad;
	}

	public String getDatosSeguridad() {
		return datosSeguridad;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setActivo(boolean estado) {
		activo = estado;
	}

	public boolean isActivo() {
		return activo;
	}

	// busca un auto libre y si lo esta, lo reserva y lo devuelve
	public Automovil hayDisponible(Date inicio, Date fin) {
		Automovil auto = buscarAutoDisponible(inicio, fin);
		if (auto != null && auto.agregarFechaOcupado(inicio, fin)) {
			return auto;
		}
		return null;
	}

	// busca un auto libre para reservar, si lo enceuntra lo devuelve
	private Automovil buscarAutoDisponible(Date inicio, Date fin) {
		for (int i = 0; i < automoviles.size(); i++) {
			if (!automoviles.elementAt(i).estasReservadoEnFecha(inicio, fin))
				return automoviles.elementAt(i);
		}
		return null;
	}

	public Automovil entregarReservado(Date inicio, Date fin) {
		for (int i = 0; i < automoviles.size(); i++) {
			if (automoviles.elementAt(i).estasReservadoEnFecha(inicio, fin))
				return automoviles.elementAt(i);
		}
		return null;
	}

	public void deshacerReserva(Date inicio, Date fin) {
		Automovil auto = entregarReservado(inicio, fin);
		if (auto != null) {
			auto.quitarFechaOcupado(inicio, fin);
		}
	}

	public Automovil agregarAutomovil(String anio, String patente,
			float kilometraje, float combustible, String estado) {
		Automovil auto = new Automovil(anio, patente, kilometraje, combustible,
				estado);
		automoviles.add(auto);
		return auto;
	}

	// ver el tema del id
	public boolean eliminarAutomovil(int idAuto) {
		Automovil auto = buscarAutoxId(idAuto);
		if (auto.isActivo() && auto.estoyLibre()) {
			auto.setActivo(false);
			return true;
		}
		return false;
	}

	// ver el tema del id
	private Automovil buscarAutoxId(int idAuto) {
		for (int i = 0; i < automoviles.size(); i++) {
			if (automoviles.elementAt(i).getIdAuto() == idAuto) {
				return automoviles.elementAt(i);
			}
		}
		return null;
	}

	public float calcularCosto(Date fechaInicio, Date fechaFin, Date fechaDevo) {
		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();

		cal1.setTime(fechaInicio);
		cal2.setTime(fechaFin);

		int difDias = diasEntreDosFechas(cal1.getTime(), cal2.getTime()), difDiasEx = 0;

		if (fechaDevo != null) {
			Calendar cal3 = new GregorianCalendar();
			cal3.setTime(fechaDevo);
			difDiasEx = diasEntreDosFechas(cal2.getTime(), cal3.getTime());
		}

		return (difDias * costoDiario + difDiasEx * costoExcedente);
	}

	private int diasEntreDosFechas(Date d1, Date d2) {
		Calendar anterior = Calendar.getInstance();
		anterior.setTime(d1);

		Calendar actual = Calendar.getInstance();
		actual.setTime(d2);

		int diffDias = 0;
		while (anterior.before(actual)) {
			anterior.add(Calendar.DAY_OF_MONTH, 1);
			diffDias++;
		}
		return diffDias;
	}

	public Automovil buscarAutoxPatente(String patente) {
		for (int i = 0; i < automoviles.size(); i++) {
			if (automoviles.elementAt(i).sosElAutomovil(patente)) {
				return automoviles.elementAt(i);
			}
		}
		return null;
	}

	public boolean hayAutoOcupado() {
		for (int i = 0; i < automoviles.size(); i++) {
			if (!automoviles.elementAt(i).estoyLibre()) {
				return false;
			}
		}
		return true;
	}

	public boolean eliminarAutoxPatente(String patente) {
		Automovil auto = buscarAutoxPatente(patente);
		if (auto != null && auto.autoEliminate()) {
			return true;
		}
		return false;
	}

	public AutomovilDTO modificarAuto(String patente, String anio, float comb,
			float kilom, boolean activo) {
		Automovil auto = buscarAutoxPatente(patente);

		if (auto != null) {
			auto.modificarDatos(anio, comb, kilom, activo);
			return auto.crearAutomovilDTO();
		}
		return null;
	}

	public boolean sosModelo(String nromodelo) {
		return nromodelo == this.codigoModelo;
	}
}