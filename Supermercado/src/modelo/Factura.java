package modelo;

import java.util.Vector;

public class Factura {
	private int mes;
	private int año;
	private int numero;
	private Vector<ItemFactura> items;

	public Factura(int nroFact, int mes, int año) {
		this.numero = nroFact;
		this.mes = mes;
		this.año = año;
	}

	public float getTotal() {
		float total = 0;
		for (int i = 0; i < items.size(); i++) {
			total = total + items.elementAt(i).getSubtotal();
		}
		return total;
	}

	public void setItems(Vector<ItemFactura> items) {
		this.items = items;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Vector<ItemFactura> getItems() {
		return items;
	}
}