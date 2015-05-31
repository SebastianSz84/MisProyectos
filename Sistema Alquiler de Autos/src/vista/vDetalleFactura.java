package vista;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import modelo.ItemFacturaDTO;

public class vDetalleFactura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Vector<ItemFacturaDTO> items;

	private JTable tabla;
	private JScrollPane scrollPane;

	public vDetalleFactura(Vector<ItemFacturaDTO> items) {
		super();
		this.items = items;
		initGUI();
	}

	private void initGUI() {
		try {
			setSize(400, 400);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			tabla = new JTable(new DefaultTableModel(new Object[] {
					"Descripción", "Monto" }, 0));

			llenarTablaCuentas();
			tabla.setEnabled(false);
			tabla.setBounds(getBounds());
			tabla.getColumnModel().getColumn(0).setPreferredWidth(280);
			DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
			rightRenderer
					.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
			tabla.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
			tabla.getColumnModel().getColumn(1).setPreferredWidth(120);

			scrollPane = new JScrollPane(tabla);
			scrollPane.setBounds(getBounds());
			setContentPane(scrollPane);

			setTitle("Detalles de Factura");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void llenarTablaCuentas() {
		DefaultTableModel modeloVista = (DefaultTableModel) tabla.getModel();

		for (int i = 0; i < items.size(); i++) {
			modeloVista.addRow(new Object[] {
					items.elementAt(i).getDescripcion(),
					Float.toString(items.elementAt(i).getMonto()) });
		}
	}
}