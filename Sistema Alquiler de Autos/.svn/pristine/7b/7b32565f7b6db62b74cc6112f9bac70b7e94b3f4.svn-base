package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.FacturaDTO;
import modelo.ReservaDTO;
import controlador.SistemaAlquilerAutos;

public class vBajaReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla

	private JLabel lblNroReserva;
	private JTextField txtNroReserva;
	private JButton btnBuscarReserva;

	private JLabel lblTipo;
	private JComboBox txtTipo;
	private JLabel lblFechaInicio;
	private JTextField txtFechaInicio;
	private JLabel lblFechaFin;
	private JTextField txtFechaFin;

	private JButton btnBajaReserva;

	private JPanel panel;
	private JPanel panelBuscarReserva;
	private JPanel panelPrincipal;
	private JPanel panelInferior;

	private SistemaAlquilerAutos sistema;

	// constructor
	public vBajaReserva(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(490, 240);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(getBounds());
			setContentPane(panel);

			panelBuscarReserva = new JPanel();
			panelBuscarReserva.setLayout(null);
			panelBuscarReserva.setBounds(0, 0, getWidth(), 40);

			panelPrincipal = new JPanel();
			panelPrincipal.setLayout(null);
			panelPrincipal.setBounds(0, 40, getWidth(), 120);

			panelInferior = new JPanel();
			panelInferior.setLayout(null);
			panelInferior.setBounds(0, 160, getWidth(), 40);

			lblNroReserva = new JLabel();
			lblNroReserva.setBounds(20, 15, 180, 25);
			txtNroReserva = new JTextField();
			txtNroReserva.setBounds(210, 15, 160, 25);
			btnBuscarReserva = new JButton();
			btnBuscarReserva.setBounds(385, 15, 80, 25);

			lblTipo = new JLabel();
			lblTipo.setBounds(20, 15, 180, 25);
			String[] listaTipos = { "(Seleccione)", "Económico", "Compacto",
					"Premium", "Minivan", "Camionetas" };
			txtTipo = new JComboBox(listaTipos);
			txtTipo.setBounds(210, 15, 160, 25);
			lblFechaInicio = new JLabel();
			lblFechaInicio.setBounds(20, 55, 180, 25);
			txtFechaInicio = new JTextField();
			txtFechaInicio.setBounds(210, 55, 160, 25);
			lblFechaFin = new JLabel();
			lblFechaFin.setBounds(20, 95, 180, 25);
			txtFechaFin = new JTextField();
			txtFechaFin.setBounds(210, 95, 160, 25);

			btnBajaReserva = new JButton();
			btnBajaReserva.setBounds(190, 15, 110, 25);

			btnBuscarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					String nroReserva = txtNroReserva.getText();
					ReservaDTO res = sistema.mostrarReserva(Integer
							.parseInt(nroReserva));
					if (res != null) {
						Calendar fecha = Calendar.getInstance();
						fecha.setTime(res.getFechaInicio());
						txtFechaInicio.setText(String.format(
								"%1$te-%1$tm-%1$tY", fecha));
						fecha.setTime(res.getFechaFin());
						txtFechaFin.setText(String.format("%1$te-%1$tm-%1$tY",
								fecha));
						txtTipo.setSelectedItem(res.getTipo());
						btnBajaReserva.setEnabled(true);
					} else {
						txtNroReserva.setText(txtNroReserva.getText()
								+ " <--- Reserva inexistente");
						btnBajaReserva.setEnabled(false);
						txtNroReserva.selectAll();
						btnBuscarReserva.transferFocusBackward();
					}
				}
			});

			panelBuscarReserva.add(lblNroReserva);
			panelBuscarReserva.add(txtNroReserva);
			panelBuscarReserva.add(btnBuscarReserva);

			panelPrincipal.add(lblTipo);
			panelPrincipal.add(txtTipo);
			panelPrincipal.add(lblFechaInicio);
			panelPrincipal.add(txtFechaInicio);
			panelPrincipal.add(lblFechaFin);
			panelPrincipal.add(txtFechaFin);

			panelInferior.add(btnBajaReserva);

			panel.add(panelBuscarReserva);
			panel.add(panelPrincipal);
			panel.add(panelInferior);

			lblNroReserva.setText("Número de reserva:");
			txtNroReserva.setText("");
			btnBuscarReserva.setText("Buscar");

			lblTipo.setText("Tipo:");
			txtTipo.setSelectedIndex(0);
			lblFechaInicio.setText("Fecha de inicio (dd-mm-aaaa):");
			txtFechaInicio.setText("");
			lblFechaFin.setText("Fecha de fin (dd-mm-aaaa):");
			txtFechaFin.setText("");

			btnBajaReserva.setText("Cancelar");

			btnBajaReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					FacturaDTO fact = sistema.cancelarReserva(Integer
							.parseInt(txtNroReserva.getText()));

					if (fact != null) {
						JOptionPane
								.showMessageDialog(
										null,
										"Se ha cancelado la reserva "
												+ txtNroReserva.getText()
												+ "\nSe ha creado la factura "
												+ Integer.toString(fact
														.getNroFactura()),
										"Éxito",
										JOptionPane.INFORMATION_MESSAGE);
						borrarCampos();
					} else {
						JOptionPane.showMessageDialog(null,
								"No se ha cancelado la reserva", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			ocultarCampos(true);
			setTitle("Cancelar Reserva");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void borrarCampos() {
		for (Component c : panel.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setText("");
		}
	}

	private void ocultarCampos(boolean ocultar) {
		for (Component c : panelPrincipal.getComponents()) {
			if (c instanceof JTextField || c instanceof JComboBox) {
				c.setEnabled(!ocultar);
			}
		}
		btnBajaReserva.setEnabled(!ocultar);
	}
}