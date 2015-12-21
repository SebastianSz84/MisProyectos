package rmi;

import interfaz.InterfazProductos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import beans.MateriaPrimaDTO;
import beans.SemiElaboradoDTO;
import beans.UnidadDTO;
import controlador.Sistema;
import entities.MateriaPrima;
import entities.SemiElaborado;
import entities.Unidad;

public class RecursosRMI extends UnicastRemoteObject implements InterfazProductos {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected RecursosRMI() throws RemoteException {
		super();
	}

	@Override
	public List<MateriaPrimaDTO> listarMPs() throws RemoteException {
		List<MateriaPrimaDTO> listaMPDTO = new ArrayList<MateriaPrimaDTO>();
		for (MateriaPrima mp : Sistema.getInstancia().listarMPs()) {
			listaMPDTO.add(mp.getDTO());
		}
		return listaMPDTO;
	}

	@Override
	public SemiElaboradoDTO listarMPporSE(int codSE) throws RemoteException {
		return Sistema.getInstancia().listarMPporSE(codSE).getDTO();
	}

	@Override
	public List<UnidadDTO> listarUNs() throws RemoteException {
		List<UnidadDTO> lista = new ArrayList<>();
		for (Unidad u : Sistema.getInstancia().listarUNs()) {
			lista.add(u.getDTO());
		}
		return lista;
	}

	@Override
	public List<SemiElaboradoDTO> listarSE() throws RemoteException {
		List<SemiElaboradoDTO> lista = new ArrayList<>();
		for (SemiElaborado se : Sistema.getInstancia().listarSE()) {
			lista.add(se.getDTO());
		}
		return lista;
	}
}