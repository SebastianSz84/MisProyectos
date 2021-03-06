package modelo;

import java.util.Date;
import java.util.Vector;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Sistema de Alquiler de Autos
//  @ File Name : Factura.java
//  @ Date : 09/05/2013
//  @ Author : Grupo 5
//
//

public class Factura {
	private static int proxNroFactura;
	int nroFactura;
	private Vector<ItemFactura> items;
	private Date fecha;
	private float impTotal;
	private String tipo;
	private int nroTran;
	private Cliente cliente;

	public Factura(int nroTran, String tipo, Cliente cliente) {
		items = new Vector<ItemFactura>();
		nroFactura = getProxNroFactura();
		this.tipo = tipo;
		fecha = new Date();
		this.nroTran = nroTran;
		this.cliente = cliente;
	}

	private static int getProxNroFactura() {
		return ++proxNroFactura;
	}

	public void calcularFactura() {
		for (int i = 0; i < items.size(); i++) {
			impTotal = impTotal + items.elementAt(i).getMonto();
		}
	}

	public void agregarItem(String descr, float mont) {
		ItemFactura item = new ItemFactura(descr, mont);
		items.add(item);
	}

	public FacturaDTO crearFacturaDTO() {
		FacturaDTO fac = new FacturaDTO(nroFactura, fecha, impTotal, tipo,
				nroTran, cliente.getDni(), cliente.getNombre(),
				cliente.getApellido());

		for (int i = 0; i < items.size(); i++) {
			fac.agregarItem(items.elementAt(i).getDescripcion(), items
					.elementAt(i).getMonto());
		}
		return fac;
	}

	public boolean sosFactura(int nroFactura){
		return nroFactura==this.nroFactura;
	}
	
	public float getImpTotal() {
		return impTotal;
	}

	public void setImpTotal(float total) {
		impTotal = total;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getNroTran() {
		return nroTran;
	}

	public void setNroTran(int nroTran) {
		this.nroTran = nroTran;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getNroFactura() {
		return nroFactura;
	}
}