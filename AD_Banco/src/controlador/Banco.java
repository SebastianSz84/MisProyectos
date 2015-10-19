package controlador;

import java.util.List;

import dao.BancoDAO;
import entities.Cuenta;

public class Banco
{
	public static void main(String[] args)
	{
		mostrarSaldos();
	}
	
	private static void mostrarSaldos()
	{
		List<Cuenta> cuentas = BancoDAO.getInstancia().getSaldos();
		for (Cuenta c : cuentas)
		{
			System.out.println("Número: " + c.getNumero().toString() + ". Saldo: " + c.getSaldo());
		}
	}
}