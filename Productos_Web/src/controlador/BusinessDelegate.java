package controlador;

import interfaz.InterfazProductos;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import beans.MateriaPrimaDTO;
import beans.SemiElaboradoDTO;
import beans.UnidadDTO;

public class BusinessDelegate {
	private InterfazProductos objetoRemoto;
	private static BusinessDelegate instancia;

	public static BusinessDelegate getInstancia() {
		if (instancia == null) {
			instancia = new BusinessDelegate();
		}
		return instancia;
	}

	public static void setInstancia(BusinessDelegate instancia) {
		BusinessDelegate.instancia = instancia;
	}

	private BusinessDelegate() {
		try {
			objetoRemoto = (InterfazProductos) Naming.lookup(InterfazProductos.url);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}
	}

	public void grabarSE(SemiElaboradoDTO se) {
		try {
			objetoRemoto.grabarSE(se);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public SemiElaboradoDTO listarMPporSE(int codSE) {
		try {
			return objetoRemoto.listarMPporSE(codSE);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MateriaPrimaDTO> listarMPs() {
		try {
			return objetoRemoto.listarMPs();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<UnidadDTO> listarUNs() {
		try {
			return objetoRemoto.listarUNs();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<SemiElaboradoDTO> listarSE() {
		try {
			return objetoRemoto.listarSE();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}
}