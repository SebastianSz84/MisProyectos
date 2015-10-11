package controlador;

import java.util.ArrayList;
import java.util.List;

import dao.FacturaDAO;
import dao.MozoDAO;
import dao.PlatoDAO;
import dao.RubroDAO;
import entities.Factura;
import entities.Mozo;
import entities.Plato;
import entities.Rubro;

public class Sistema {

	public static void main(String[] args) {
		// Ejercicio 1
		ejercicioUno();

		System.out.println();

		// Ejercicio 2
		ejercicioDos();

		System.out.println();

		// Ejercicio 3
		ejercicioTres();

		System.out.println();

		// Ejercicio 4
		ejercicioCuatro();

		System.out.println();
	}

	private static void ejercicioUno() {
		List<Plato> platos = PlatoDAO.getList();
		List<Rubro> rubros = RubroDAO.getList();

		System.out.println("Ejercicio 1: Indicar la cantidad.de platos que pertenecen  a cada rubro");
		for (Rubro r : rubros) {
			int cantPlatos = 0;
			for (Plato p : platos) {
				if (p.getRubro().getIdRubro() == r.getIdRubro()) {
					cantPlatos++;
				}
			}
			System.out.println("Rubro: " + r.getDescripcion() + ". Cantidad de Platos: " + Integer.toString(cantPlatos));
		}
	}

	private static void ejercicioDos() {
		System.out.println("Ejercicio 2: Identificar al mozo que facturó el mayor importe entre todas sus facturas");
		List<Mozo> mozos = MozoDAO.getList();
		List<Factura> facturas = FacturaDAO.getList();
		float mayorFacturacion = 0;
		Mozo mozoMayorFacturacion = null;

		for (Mozo m : mozos) {
			float totalMozo = 0;
			for (Factura f : facturas) {
				if (f.getMozo().getIdMozo() == m.getIdMozo()) {
					totalMozo = totalMozo + f.getTotal();
				}
			}
			if (totalMozo > mayorFacturacion) {
				mayorFacturacion = totalMozo;
				mozoMayorFacturacion = m;
			}
		}
		if (mozoMayorFacturacion == null) {
			System.out.println("No se ha encontrado el mozo con mayor facturación.");
		} else {
			System.out.println("Mozo: " + mozoMayorFacturacion.getApellido() + ", " + mozoMayorFacturacion.getNombre() + ".");
		}
	}

	private static void ejercicioTres() {
		System.out.println("Ejercicio 3: Identificar al mozo que no facturó ningún postre");
		Rubro postre = RubroDAO.getByDesc("Postre");
		List<Plato> platos = PlatoDAO.getByRubro(postre);
		List<Factura> facturas = FacturaDAO.getList();

		for (Factura f : facturas) {
			boolean tienePostre = false;
			for (Plato p : platos) {
				if (f.tenesPlato(p)) {
					tienePostre = true;
				}
			}
			if (!tienePostre) {
				System.out.println(f.getMozo().getApellido() + ", " + f.getMozo().getNombre());
			}
		}
	}

	private static void ejercicioCuatro() {
		System.out.println("Ejercicio 4: Indicar los platos de mayor precio que se facturaron y la factura correspondiente");
		List<Factura> facturas = FacturaDAO.getList();
		List<Plato> platos = new ArrayList<>();
		for (Factura f : facturas) {
			for (Plato p : f.getPlatos()) {
				platos.add(p);
			}
		}

		if (platos.size() == 0) {
			System.out.println("No se ha encontrado el plato facturado más caro.");
			return;
		}

		Plato platoMasCaro = null;
		float precioMasCaro = 0;

		for (Plato p : platos) {
			if (precioMasCaro < p.getPrecio()) {
				platoMasCaro = p;
				precioMasCaro = p.getPrecio();
			}
		}

		for (Plato p : platos) {
			if (p.getPrecio() == precioMasCaro) {
				System.out.println("Plato: " + p.getDescripcion() + ". Precio: " + p.getPrecio());
				for (Factura f : facturas) {
					if (f.tenesPlato(platoMasCaro)) {
						;
					}
				}
			}
		}
	}
}