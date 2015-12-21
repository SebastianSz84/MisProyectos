package controlador;

import interfaz.InterfazProductos;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import rmi.RecursosRMI;

public class Server {
	private InterfazProductos objetoRemoto;

	public static void main(String[] args) {
		new Server();
	}

	public Server() {
		iniciar();
	}

	private void iniciar() {
		try {
			LocateRegistry.createRegistry(1099);
			objetoRemoto = new RecursosRMI();
			Naming.rebind(InterfazProductos.url, objetoRemoto);
			System.out.println("Escuchando en " + InterfazProductos.url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}