package controlador;

import java.util.Vector;

import persistencia.MapperFactura;
import modelo.Factura;

public class Supermercado {
	private Vector<Factura> facturas;
	private static Supermercado instancia;

	public float obtenerTotalMes(int mes, int año) {
		float totalMes = 0;
		Vector<Factura> factMesAño = MapperFactura.getInstancia()
				.selectPorMesAño(mes, año);

		for (int i = 0; i < factMesAño.size(); i++) {
			totalMes = totalMes + factMesAño.elementAt(i).getTotal();
		}

		return totalMes;
	}

	public static Supermercado getInstancia() {
		if (instancia == null) {
			instancia = new Supermercado();
		}
		return instancia;
	}

	public Vector<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Vector<Factura> facturas) {
		this.facturas = facturas;
	}

	public static void setInstancia(Supermercado instancia) {
		Supermercado.instancia = instancia;
	}
}