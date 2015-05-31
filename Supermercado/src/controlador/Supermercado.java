package controlador;

import java.util.Vector;

import persistencia.MapperFactura;
import modelo.Factura;

public class Supermercado {
	private Vector<Factura> facturas;
	private static Supermercado instancia;

	public float obtenerTotalMes(int mes, int a�o) {
		float totalMes = 0;
		Vector<Factura> factMesA�o = MapperFactura.getInstancia()
				.selectPorMesA�o(mes, a�o);

		for (int i = 0; i < factMesA�o.size(); i++) {
			totalMes = totalMes + factMesA�o.elementAt(i).getTotal();
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