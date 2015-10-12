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

		// Ejercicio 5
		ejercicioCinco();

		System.out.println();

		// Ejercicio 6
		ejercicioSeis();

		System.out.println();

	}

	private static void ejercicioUno() {
		System.out.println("Ejercicio 1: Indicar la cantidad de platos que pertenecen a cada rubro");

		List<Object[]> tuplas = PlatoDAO.getCantXRubro();

		for (Object[] tupla : tuplas) {
			for (int i = 0; i < tupla.length; i++) {
				System.out.print("\t " + tupla[i]);
			}
			System.out.println();
		}
	}

	private static void ejercicioDos() {
		System.out.println("Ejercicio 2: Identificar al mozo que facturó el mayor importe entre todas sus facturas");

		List<Mozo> tuplas = FacturaDAO.getMozosMayorFacturacion();

		for (Mozo m : tuplas) {
			System.out.println(m.getApellido() + ", " + m.getNombre());
		}
	}

	private static void ejercicioTres() {
		System.out.println("Ejercicio 3: Identificar al mozo que no facturó ningún postre");
		Rubro postre = RubroDAO.getByDesc("Postres");
		List<Plato> platos = PlatoDAO.getByRubro(postre);
		List<Factura> facturas = FacturaDAO.getList();
		List<Mozo> mozos = new ArrayList<>();

		for (Factura f : facturas) {
			boolean tienePostre = false;
			for (Plato p : platos) {
				if (f.tenesPlato(p)) {
					tienePostre = true;
				}
			}
			if (!tienePostre) {
				if (!mozos.contains(f.getMozo())) {
					mozos.add(f.getMozo());
				}
			}
		}
		if (mozos.isEmpty()) {
			System.out.println("No hay mozos que no hayan facturado postres.");
		} else {
			for (Mozo m : mozos) {
				System.out.println(m.getApellido() + ", " + m.getNombre());
			}
		}
	}

	private static void ejercicioCuatro() {
		System.out.println("Ejercicio 4: Indicar los platos de mayor precio que se facturaron y la factura correspondiente");
		List<Factura> facturas = FacturaDAO.getList();
		List<Plato> platos = new ArrayList<>();
		for (Factura f : facturas) {
			for (Plato p : f.getPlatos()) {
				if (!platos.contains(p)) {
					platos.add(p);
				}
			}
		}

		if (platos.size() == 0) {
			System.out.println("No se ha encontrado el plato facturado más caro.");
			return;
		}

		float precioMasCaro = 0;

		for (Plato p : platos) {
			if (precioMasCaro < p.getPrecio()) {
				precioMasCaro = p.getPrecio();
			}
		}

		for (Plato p : platos) {
			if (p.getPrecio() == precioMasCaro) {
				System.out.println("Plato: " + p.getDescripcion() + ". Precio: " + p.getPrecio() + ". Números de Factura:");
				for (Factura f : facturas) {
					if (f.tenesPlato(p)) {
						System.out.println(Integer.toString(f.getNroFactura()));
					}
				}
				System.out.println();
			}
		}
	}

	private static void ejercicioCinco() {
		System.out.println("Ejercicio 5: Indicar a los mozos que pertenezcan a las localidades que correspondan al siguiente patrón de caracteres:");
		System.out.println("Comienza con 'M' y contiene una 'e'");
		List<Mozo> mozos = MozoDAO.getListXLocalidad("M%e%");

		if (mozos.isEmpty()) {
			System.out.println("No se han encontrado mozos en localidades con el criterio ingresado.");
		} else {
			for (Mozo m : mozos) {
				System.out.println(m.getApellido() + ", " + m.getNombre());
			}
		}
	}

	private static void ejercicioSeis() {
		System.out.println("Ejercicio 6: Indicar al plato más caro de cada rubro facturado por el mozo: Andrade, Pablo");

		Mozo m = MozoDAO.getByNombreCompleto("Andrade", "Pablo");
		if (m == null) {
			System.out.println("No se ha encontrado el mozo elegido.");
			return;
		}

		List<Object[]> tuplas = FacturaDAO.getPlatosXMozo(m);

		if (tuplas == null) {
			System.out.println("No se han encontrado platos màs caros facturados por el mozo elegido.");
			return;
		}

		for (Object[] tupla : tuplas) {
			for (int i = 0; i < tupla.length; i++) {
				System.out.print("\t" + tupla[i]);
			}
			System.out.println();
		}
	}
}