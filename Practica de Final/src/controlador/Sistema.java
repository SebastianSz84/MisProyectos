package controlador;

import java.util.Vector;

import modelo.Contratado;
import modelo.Empleado;
import modelo.EnDependencia;
import modelo.Sueldo;
import modelo.SueldoView;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Practica Final
//  @ File Name : Sistema.java
//  @ Date : 14/07/2013
//  @ Author : Sebastian Szarfsztejn
//
//

public class Sistema {
	private Vector<Empleado> empleados;
	private Vector<Sueldo> sueldos;

	public boolean agregarEmpleadoEnDependencia(String nom, String dom,
			int legajo, float sueldo) {
		Empleado emp = buscarEmpleadoXLegajo(legajo);

		if (emp == null) {
			emp = new EnDependencia(nom, dom, legajo, sueldo);
			empleados.add(emp);
			return true;
		}

		return false;
	}

	public boolean agregarEmpleadoContratado(String nom, String dom,
			int legajo, float valorHora, int horas) {
		Empleado emp = buscarEmpleadoXLegajo(legajo);

		if (emp == null) {
			emp = new Contratado(nom, dom, legajo, valorHora, horas);
			empleados.add(emp);
			return true;
		}

		return false;
	}

	public Vector<SueldoView> calcularSueldo(String mes) {
		Vector<SueldoView> vistaSueldos = new Vector<SueldoView>();

		for (int i = 0; i < empleados.size(); i++) {
			Sueldo s = new Sueldo(mes, empleados.elementAt(i));
			sueldos.add(s);
			vistaSueldos.add(s.getView());
		}

		return vistaSueldos;
	}

	public SueldoView mostrarSueldo(String mes, int legajo) {
		Sueldo s = buscarSueldo(legajo, mes);

		if (s != null) {
			return s.getView();
		}

		return null;
	}

	private Empleado buscarEmpleadoXLegajo(int legajo) {
		for (int i = 0; i < empleados.size(); i++) {
			if (empleados.elementAt(i).sosElEmpleado(legajo)) {
				return empleados.elementAt(i);
			}
		}
		return null;
	}

	private Sueldo buscarSueldo(int legajo, String mes) {
		for (int i = 0; i < sueldos.size(); i++) {
			if (sueldos.elementAt(i).sosElSueldo(legajo, mes)) {
				return sueldos.elementAt(i);
			}
		}
		return null;
	}

	public Sistema() {
		empleados = new Vector<Empleado>();
		sueldos = new Vector<Sueldo>();
	}
}