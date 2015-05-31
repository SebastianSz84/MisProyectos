package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.AlquilerDTO;
import modelo.ReservaDTO;
import controlador.SistemaAlquilerAutos;

public class vGenerarAlquilerReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla
	private SistemaAlquilerAutos sistema;

	private JLabel lblNroReserva;
	private JTextField txtNroReserva;
	private JButton btnBuscarReserva;

	private JLabel lblTipo;
	private JComboBox txtTipo;
	private JLabel lblFechaInicio;
	private JTextField txtFechaInicio;
	private JLabel lblFechaFin;
	private JTextField txtFechaFin;
	private JLabel lblObservCliente;
	private JTextField txtObservCliente;
	private JButton btnAltaAlquilerReserva;

	private JPanel panel;
	private JPanel panelBuscarReserva;
	private JPanel panelPrincipal;
	private JPanel panelInferior;

	// constructor
	public vGenerarAlquilerReserva(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(490, 280);
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
			panelInferior.setBounds(0, 160, getWidth(), 80);

			lblNroReserva = new JLabel();
			lblNroReserva.setBounds(20, 15, 180, 25);
			txtNroReserva = new JTextField();
			txtNroReserva.setBounds(210, 15, 160, 25);
			btnBuscarReserva = new JButton();
			btnBuscarReserva.setBounds(385, 15, 80, 25);

			btnBuscarReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					txtNroReserva.setText(txtNroReserva.getText().trim());

					if (!txtNroReserva.getText().isEmpty()) {
						ReservaDTO res = sistema.mostrarReserva(Integer
								.parseInt(txtNroReserva.getText()));
						if (res != null) {
							if (res.getEstado().equals("Activo")) {
								actualizarDatos(res);
								txtObservCliente.setEnabled(true);
								btnAltaAlquilerReserva.setEnabled(true);
							} else {
								txtNroReserva.setText(txtNroReserva.getText()
										+ " <--- Reserva inactiva");
								btnAltaAlquilerReserva.setEnabled(false);
								txtObservCliente.setEnabled(false);
								txtNroReserva.selectAll();
								btnBuscarReserva.transferFocusBackward();
							}
						} else {
							txtNroReserva.setText(txtNroReserva.getText()
									+ " <--- Reserva inexistente");
							btnAltaAlquilerReserva.setEnabled(false);
							txtObservCliente.setEnabled(false);
							txtNroReserva.selectAll();
							btnBuscarReserva.transferFocusBackward();
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar el Número de Reserva", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			lblNroReserva.setText("Número de reserva:");
			txtNroReserva.setText("");
			btnBuscarReserva.setText("Buscar");

			panelBuscarReserva.add(lblNroReserva);
			panelBuscarReserva.add(txtNroReserva);
			panelBuscarReserva.add(btnBuscarReserva);

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

			panelPrincipal.add(lblTipo);
			panelPrincipal.add(txtTipo);
			panelPrincipal.add(lblFechaInicio);
			panelPrincipal.add(txtFechaInicio);
			panelPrincipal.add(lblFechaFin);
			panelPrincipal.add(txtFechaFin);

			lblTipo.setText("Tipo:");
			lblFechaInicio.setText("Fecha de inicio (dd-mm-aaaa):");
			txtFechaInicio.setText("");
			lblFechaFin.setText("Fecha de fin (dd-mm-aaaa):");
			txtFechaFin.setText("");

			btnAltaAlquilerReserva = new JButton();
			btnAltaAlquilerReserva.setBounds(185, 55, 141, 25);
			lblObservCliente = new JLabel();
			lblObservCliente.setBounds(20, 15, 180, 25);
			lblObservCliente.setText("Observaciones del Cliente:");
			txtObservCliente = new JTextField();
			txtObservCliente.setBounds(210, 15, 160, 25);

			btnAltaAlquilerReserva.setText("Generar Alquiler");

			btnAltaAlquilerReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					AlquilerDTO alq = sistema.generarAlquilerPorReserva(
							Integer.parseInt(txtNroReserva.getText()),
							txtObservCliente.getText());

					if (alq != null) {
						JOptionPane
								.showMessageDialog(
										null,
										"Se ha creado el alquiler "
												+ Integer.toString(alq
														.getNroAlquiler()),
										"Éxito",
										JOptionPane.INFORMATION_MESSAGE);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"No se ha creado el alquiler", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			panelInferior.add(lblObservCliente);
			panelInferior.add(txtObservCliente);
			panelInferior.add(btnAltaAlquilerReserva);

			panel.add(panelBuscarReserva);
			panel.add(panelPrincipal);
			panel.add(panelInferior);

			ocultarCampos(true);
			setTitle("Generar Reserva");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void actualizarDatos(ReservaDTO res) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

		txtFechaInicio.setText(formatoFecha.format(res.getFechaInicio()));
		txtFechaFin.setText(formatoFecha.format(res.getFechaFin()));
		txtTipo.setSelectedItem(res.getTipo());
	}

	private void ocultarCampos(boolean ocultar) {
		for (Component c : panelPrincipal.getComponents()) {
			if (c instanceof JTextField || c instanceof JComboBox) {
				c.setEnabled(!ocultar);
			}
		}
		btnAltaAlquilerReserva.setEnabled(!ocultar);
		txtObservCliente.setEnabled(!ocultar);
	}
}