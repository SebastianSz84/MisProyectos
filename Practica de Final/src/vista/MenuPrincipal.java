package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import modelo.SueldoView;
import controlador.Sistema;

public class MenuPrincipal extends JFrame {
	private Sistema sistema;

	private JMenuBar barraMenues;

	private JMenu menuEmpleado;
	private JMenuItem agregarEmpDep;
	private JMenuItem agregarEmpCon;

	private JMenu menuSueldo;
	private JMenuItem liquidarSueldos;
	private JMenuItem mostrarSueldo;

	public MenuPrincipal() {
		super();
		sistema = new Sistema();
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setLayout(null);

		barraMenues = new JMenuBar();
		barraMenues.setSize(new Dimension(800, 25));

		menuEmpleado = new JMenu();
		menuEmpleado.setText("Empleado");

		agregarEmpDep = new JMenuItem();
		agregarEmpDep.setText("Agregar En Relación de Dependencia");
		agregarEmpDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AltaEmpDep altaEmpDep = new AltaEmpDep(sistema);
				altaEmpDep.setVisible(true);
			}
		});
		menuEmpleado.add(agregarEmpDep);

		agregarEmpCon = new JMenuItem();
		agregarEmpCon.setText("Agregar Contratado");
		agregarEmpCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				AltaEmpCon altaEmpCon = new AltaEmpCon(sistema);
				altaEmpCon.setVisible(true);
			}
		});
		menuEmpleado.add(agregarEmpCon);

		barraMenues.add(menuEmpleado);

		menuSueldo = new JMenu();
		menuSueldo.setText("Sueldo");

		liquidarSueldos = new JMenuItem();
		liquidarSueldos.setText("Liquidar Sueldos");
		liquidarSueldos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mes = JOptionPane
						.showInputDialog("Ingrese el mes a liquidar:");
				if (!mes.isEmpty()) {
					Vector<SueldoView> sueldos = sistema.calcularSueldo(mes);
					if (sueldos.size() == 0) {
						JOptionPane.showMessageDialog(null,
								"No se han liquidado sueldos.", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						TablaLiquidacion vistaTabla = new TablaLiquidacion(sueldos);
						vistaTabla.setVisible(true);
					}
				}
			}
		});
		menuSueldo.add(liquidarSueldos);

		mostrarSueldo = new JMenuItem();
		mostrarSueldo.setText("Mostrar Sueldo");
		mostrarSueldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String mes = JOptionPane
						.showInputDialog("Ingrese el mes a liquidar:");
				if (!mes.isEmpty()) {
					String legajo = JOptionPane
							.showInputDialog("Ingrese el legajo:");
					if (!legajo.isEmpty()) {
						SueldoView sueldo = sistema.mostrarSueldo(mes,
								Integer.parseInt(legajo));
						if (sueldo != null) {
							JOptionPane.showMessageDialog(
									null,
									"Sueldo liquidado: "
											+ Float.toString(sueldo
													.getSueldoAPagar()),
									"Sueldo liquidado",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,
									"Sueldo no liquidado", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		});
		menuSueldo.add(mostrarSueldo);
		barraMenues.add(menuSueldo);

		add(barraMenues);

		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		MenuPrincipal menuPpal = new MenuPrincipal();
		menuPpal.setVisible(true);
	}
}