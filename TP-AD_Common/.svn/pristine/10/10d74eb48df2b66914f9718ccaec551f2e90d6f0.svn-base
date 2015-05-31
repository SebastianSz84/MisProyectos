package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class FacturaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idFactura;
	private Date fecha;
	private float total;
	private ClienteBean cliente;
	private List<ItemFacturaBean> items;
	public FacturaBean(Date fecha, float total, ClienteBean cliente) {
		this.fecha = fecha;
		this.total = total;
		this.cliente = cliente;
		this.items = new ArrayList<ItemFacturaBean>();
	}
	
	public FacturaBean(){}
	

	public int getIdFactura()
	{
		return this.idFactura;
	}
	public void setIdFactura(int idFactura)
	{
		this.idFactura=idFactura;
	}
	
	public Date getFecha() 
	{
		return fecha;
	}
	public float getTotal() {
		return total;
	}

	public ClienteBean getCliente() {
		return cliente;
	}
	

	public List<ItemFacturaBean> getItems() {
		return items;
	}
	
	public void setItems(List<ItemFacturaBean> items)
	{
		this.items= items;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void setCliente(ClienteBean cliente) {
		this.cliente = cliente;
	}
	public void addItem(ItemFacturaBean item) {
		this.items.add(item);
	}
	
	

}
