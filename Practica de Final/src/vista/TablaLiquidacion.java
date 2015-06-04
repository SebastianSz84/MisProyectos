package vista;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.SueldoView;

public class TablaLiquidacion extends JFrame {
	private Vector<SueldoView> sueldos;

	private JScrollPane scrollPane;
	private JTable tabla;

	public TablaLiquidacion(Vector<SueldoView> sueldos) {
		super();
		this.sueldos = sueldos;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(300, 400);

		scrollPane = new JScrollPane(tabla);
		scrollPane.setLayout(null);
		scrollPane.setBounds(getBounds());

		tabla = new JTable(new DefaultTableModel(new Object[] { "Legajo",
				"Sueldo" }, 0));
		llenarTabla();

		tabla.setEnabled(false);
		// tabla.setBounds(getBounds());
		tabla.setBounds(20, 20, 200, 200);
		scrollPane.add(tabla);

		setContentPane(scrollPane);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void llenarTabla() {
		DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

		for (int i = 0; i < sueldos.size(); i++) {
			modelo.addRow(new String[] {
					Integer.toString(sueldos.elementAt(i).getEmpleado()
							.getLegajo()),
					Float.toString(sueldos.elementAt(i).getSueldoAPagar()) });
		}
	}
}