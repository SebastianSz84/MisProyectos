package modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Automovil {
	private static int proxIdAuto;
	private int idAuto;
	private String anio;
	private String patente;
	private float kilometraje;
	private float combustible;
	private boolean activo;
	private int[] fechasOcupado;

	public Automovil(String anio, String patente, float kilometraje,
			float combustible, String estado) {
		idAuto = generarIdAuto();
		this.anio = anio;
		this.patente = patente;
		this.kilometraje = kilometraje;
		this.combustible = combustible;
		this.activo = true;
		fechasOcupado = new int[366];
	}

	public static int generarIdAuto() {
		return ++proxIdAuto;
	}

	public AutomovilDTO crearAutomovilDTO() {
		AutomovilDTO auto = new AutomovilDTO(idAuto, anio, patente,
				kilometraje, combustible, activo);
		return auto;
	}

	public boolean agregarFechaOcupado(Date inicio, Date fin) {
		int cantDias = diasEntreDosFechas(inicio, fin);
		Calendar calIni = new GregorianCalendar();
		Calendar calFin = new GregorianCalendar();

		calIni.setTime(inicio);
		int posInicial = calIni.get(Calendar.DAY_OF_YEAR);
		;

		calFin.setTime(fin);
		int posFinal = calFin.get(Calendar.DAY_OF_YEAR);

		int posActual = posInicial, i = 1;

		while (fechasOcupado[posActual] == 0 && i < cantDias) {
			i++;
			posActual++;
			if (posActual == 367) {
				posActual = 1;
			}
		}

		if (fechasOcupado[posActual] == 0 && i == cantDias) {
			for (posActual = posInicial; posActual <= posFinal; posActual++) {
				if (posActual == 367) {
					posActual = 1;
				} else if (posActual == 60) {
					if (calIni.get(Calendar.YEAR) == calFin.get(Calendar.YEAR)) {
						if (!esBisiesto(calIni.get(Calendar.YEAR))) {
							posActual++;
						}
					} else {
						if (posInicial <= 60) {
							if (esBisiesto(calIni.get(Calendar.YEAR))) {
								posActual++;
							}
						} else {
							if (esBisiesto(calFin.get(Calendar.YEAR))) {
								posActual++;
							}
						}
					}
				}
				if (cantDias == 1) {
					fechasOcupado[posActual] = 3;
				} else {
					if (posActual == posInicial || posActual == posFinal) {
						fechasOcupado[posActual] = 2;
					} else {
						fechasOcupado[posActual] = 1;
					}
				}
			}
			return true;
		}
		return false;
	}

	public void quitarFechaOcupado(Date inicio, Date fin) {
		Calendar cal = new GregorianCalendar();

		cal.setTime(inicio);
		int posInicial = cal.get(Calendar.DAY_OF_YEAR);

		cal.setTime(fin);
		int posFinal = cal.get(Calendar.DAY_OF_YEAR);

		for (int posActual = posInicial; posActual <= posFinal; posActual++) {
			if (posActual == 367) {
				posActual = 1;
			}
			fechasOcupado[posActual] = 0;
		}
	}

	private int diasEntreDosFechas(Date d1, Date d2) {
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24) + 1);
	}

	private boolean esBisiesto(int anio) {
		if ((anio % 400 == 0) || ((anio % 4 == 0) && (anio % 100 != 0)))
			return true;
		return false;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getAnio() {
		return anio;
	}

	public void setCombustible(float combustible) {
		this.combustible = combustible;
	}

	public float getCombustible() {
		return combustible;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setKilometraje(float kilometraje) {
		this.kilometraje = kilometraje;
	}

	public float getKilometraje() {
		return kilometraje;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public String getPatente() {
		return patente;
	}

	public int getIdAuto() {
		return idAuto;
	}

	public static void setProxIdAuto(int proxIdAuto) {
		Automovil.proxIdAuto = proxIdAuto;
	}

	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}

	public int[] getFechasOcupado() {
		return fechasOcupado;
	}

	public boolean estoyLibre() {
		for (int i = 0; i < fechasOcupado.length; i++) {
			if (fechasOcupado[i] != 0) {
				return false;
			}
		}
		return true;
	}

	public boolean estasReservadoEnFecha(Date inicio, Date fin) {
		int cantDias = diasEntreDosFechas(inicio, fin);
		Calendar calIni = new GregorianCalendar();
		Calendar calFin = new GregorianCalendar();

		calIni.setTime(inicio);
		int posInicial = calIni.get(Calendar.DAY_OF_YEAR);

		calFin.setTime(fin);
		int posFinal = calFin.get(Calendar.DAY_OF_YEAR);

		if (calIni.get(Calendar.YEAR) < calFin.get(Calendar.YEAR)) {
			posFinal = posFinal + 365;
			if ((posInicial <= 60 && esBisiesto(calIni.get(Calendar.YEAR)))
					|| (posFinal <= 60 && esBisiesto(calFin.get(Calendar.YEAR)))) {
				posFinal++;
			}
		}

		if (cantDias == 1) {
			if (fechasOcupado[posInicial] == 3)
				return true;
		} else {
			if (fechasOcupado[posInicial] == 2 && fechasOcupado[posFinal] == 2) {
				int posActual = posInicial;
				for (int i = cantDias - 1; i <= cantDias; i++) {
					posActual++;
					if (posActual == 367) {
						posActual = 1;
					}
					if (fechasOcupado[posActual] != 1) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}

	public boolean autoEliminate() {
		if (estoyLibre()) {
			activo = false;
			return true;
		}
		return false;
	}

	public void modificarDatos(String anio, float comb, float kilom,
			boolean activo) {
		this.anio = anio;
		this.combustible = comb;
		this.kilometraje = kilom;
		this.activo = activo;
	}

	public boolean sosElAutomovil(String patente) {
		return this.patente.equals(patente);
	}
}