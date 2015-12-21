package rmi;

import interfaz.InterfazProductos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import beans.MateriaPrimaDTO;
import beans.SemiElaboradoDTO;
import beans.UnidadDTO;
import controlador.Sistema;

public class RecursosRMI extends UnicastRemoteObject implements InterfazProductos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecursosRMI() throws RemoteException {
		super();
	}

	@Override
	public List<MateriaPrimaDTO> listarMPs() throws RemoteException {
		return Sistema.getInstancia().listarMPs();
	}

	@Override
	public SemiElaboradoDTO listarMPporSE(int codSE) throws RemoteException {
		return Sistema.getInstancia().listarMPporSE(codSE).getDTO();
	}

	@Override
	public List<UnidadDTO> listarUNs() throws RemoteException {
		return Sistema.getInstancia().listarUNs();
	}

	@Override
	public List<SemiElaboradoDTO> listarSE() throws RemoteException {
		return Sistema.getInstancia().listarSE();
	}

	@Override
	public SemiElaboradoDTO grabarSE(SemiElaboradoDTO se) {
		return Sistema.getInstancia().grabarSE(se);
	}
}