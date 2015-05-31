package vista;

import java.awt.BorderLayout;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import modelo.ProductoView;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
@SuppressWarnings("serial")
public class ListadoProductos extends JFrame {
	private Vector<ProductoView> productos;
	private JTable tblProductos;

	public ListadoProductos(Vector<ProductoView> productos) {
		super();
		this.productos = productos;
		initGUI();
	}

	private void initGUI() {
		{
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setSize(440, 240);
			BorderLayout thisLayout = new BorderLayout();
			getContentPane().setLayout(thisLayout);
			this.setLocationRelativeTo(null);
			{
				DefaultTableModel tblProductosModel = new DefaultTableModel();

				tblProductosModel.addColumn("Código");
				tblProductosModel.addColumn("Descripción");

				// for (int i = 0; i < productos.size(); i++) {
				// Object[] linea = new Object[2];
				//
				// linea[1] = String.valueOf(productos.elementAt(i)
				// .getCodigo());
				// linea[2] = productos.elementAt(i).getDescripcion();
				// tblProductosModel.addRow(linea);
				// }

				for (int i = 0; i < 3; i++) {
					Object[] linea = new Object[2];

					linea[0] = "Línea " + Integer.valueOf(i) + ", Columna 1";
					linea[1] = "Línea " + Integer.valueOf(i) + ", Columna 2";
					tblProductosModel.addRow(linea);
				}

				tblProductos = new JTable();
				getContentPane().add(tblProductos, BorderLayout.CENTER);
				tblProductos.setBounds(0, 0, 424, 202);
				tblProductos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				tblProductos.setModel(tblProductosModel);
			}
		}
	}
}