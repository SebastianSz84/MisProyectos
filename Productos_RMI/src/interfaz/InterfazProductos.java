package interfaz;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import beans.MateriaPrimaDTO;
import beans.SemiElaboradoDTO;
import beans.UnidadDTO;

public interface InterfazProductos extends Remote {
	public static final String url = "localhost/RecursosRMI";

	public List<MateriaPrimaDTO> listarMPs() throws RemoteException;

	public SemiElaboradoDTO listarMPporSE(int codSE) throws RemoteException;

	public List<UnidadDTO> listarUNs() throws RemoteException;

	public List<SemiElaboradoDTO> listarSE() throws RemoteException;
}