package controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import dao.TallerDAO;
import entities.ItemReparacion;
import entities.Reparacion;

public class Sistema
{
	private static TallerDAO dao = TallerDAO.getInstancia();
	
	public static void main(String[] args)
	{
		ejercicioUno();
		System.out.println();
		
		ejercicioDos();
		System.out.println();
		
		ejercicioTres();
		System.out.println();
		//
		// ejercicioUno();
		System.out.println();
	}
	
	private static void ejercicioUno()
	{
		// ¿Cuál es el importe en dinero de una reparación pasado como parámetro? Devolver el nombre del cliente, el vehículo y el importe.
		System.out.print("Ejercicio 1\nIngrese el número de reparación: ");
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String nroRep = br.readLine();
			Reparacion r = dao.getReparacion(Integer.parseInt(nroRep));
			System.out.println("\nCliente: " + r.getCliente().getNombre() + ".\nVehículo: " + r.getVehiculo().getMarca() + " " + r.getVehiculo().getModelo() + " " + r.getVehiculo().getMatricula() + ".\nImporte: " + Float.toString(r.getTotal()));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static void ejercicioDos()
	{
		// ¿Qué materiales y técnico se requirieron en cada reparación?
		System.out.println("Ejercicio 2");
		List<Reparacion> reps = dao.getReparaciones();
		
		for (Reparacion r : reps)
		{
			System.out.println("Reparación: " + r.getNumero());
			for (ItemReparacion itRep : r.getItems())
			{
				System.out.println("Técnico: " + itRep.getTecnico().getNombre());
				System.out.println(itRep.getClave().getMaterial().getClass().toString() + ": " + itRep.getClave().getMaterial().getDescripcion());
			}
		}
	}
	
	private static void ejercicioTres()
	{
		// Determinar las reparaciones desarrolladas por un técnico entre un par de fechas pasadas como parámetro.
		System.out.println("Ejercicio 3");
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Ingrese el tipo de Documento del técnico: ");
			String tDoc = br.readLine();
			System.out.print("Ingrese el número de Documento del técnico: ");
			String nDoc = br.readLine();
			System.out.print("Ingrese la fecha de inicio (DD/MM/AAAA): ");
			String fechaIni = br.readLine();
			System.out.print("Ingrese la fecha de fin (DD/MM/AAAA): ");
			String fechaFin = br.readLine();
			
			List<Object[]> tuplas = dao.getRepsXTecnicoYFecha(tDoc, Integer.parseInt(nDoc), parsearFecha(fechaIni), parsearFecha(fechaFin));
			if (tuplas.isEmpty())
			{
				System.out.println("No se han encontrado reparaciones");
			}
			else
			{
				for (Object[] tupla : tuplas)
				{
					if (tuplas.indexOf(tupla) == 0)
					{
						System.out.println("El técnico " + tupla[1].toString() + " ha realizado las siguientes reparaciones:");
					}
					System.out.println(tupla[0].toString());
				}
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private static Date parsearFecha(String fecha)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		
		try
		{
			Date d = sdf.parse(fecha);
			return d;
		}
		catch (ParseException e)
		{
			return Calendar.getInstance().getTime();
		}
	}
}