package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.AlquilerDTO;
import controlador.SistemaAlquilerAutos;

public class vRegistrarDevolucion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla

	private String mensaje;
	private SistemaAlquilerAutos sistema;

	private JLabel lblNroAlquiler;
	private JTextField txtNroAlquiler;
	private JButton btnBuscarAlquiler;

	private JLabel lblCliente;
	private JTextField txtCliente;

	private JLabel lblTipo;
	private JComboBox txtTipo;

	private JLabel lblFechaInicio;
	private JTextField txtFechaInicio;
	private JLabel lblFechaFin;
	private JTextField txtFechaFin;
	private JLabel lblObservCliente;
	private JTextField txtObservCliente;
	private JLabel lblFechaDevolucion;
	private JTextField txtFechaDevolucion;
	private JLabel lblObservDevolucion;
	private JTextField txtObservDevolucion;
	private JButton btnRegistrarDevolucion;
	private JLabel lblKilometraje;
	private JTextField txtKilometraje;
	private JLabel lblCombustible;
	private JTextField txtCombustible;
	private JLabel lblDescuento;
	private JTextField txtDescuento;
	private JLabel lblRecargo;
	private JTextField txtRecargo;

	private JPanel panel;
	private JPanel panelSuperior;
	private JPanel panelCentral;
	private JPanel panelInferior;

	// constructor
	public vRegistrarDevolucion(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(515, 560);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(getBounds());
			setContentPane(panel);

			panelSuperior = new JPanel();
			panelSuperior.setLayout(null);
			panelSuperior.setBounds(0, 0, getWidth(), 40);
			panel.add(panelSuperior);

			panelCentral = new JPanel();
			panelCentral.setLayout(null);
			panelCentral.setBounds(0, 40, getWidth(), 200);
			panel.add(panelCentral);

			panelInferior = new JPanel();
			panelInferior.setLayout(null);
			panelInferior.setBounds(0, 240, getWidth(), 280);
			panel.add(panelInferior);

			lblNroAlquiler = new JLabel();
			lblNroAlquiler.setBounds(20, 15, 160, 25);
			txtNroAlquiler = new JTextField();
			txtNroAlquiler.setBounds(190, 15, 200, 25);

			btnBuscarAlquiler = new JButton();
			btnBuscarAlquiler.setBounds(410, 15, 80, 25);

			lblNroAlquiler.setText("Número de Alquiler:");
			btnBuscarAlquiler.setText("Buscar");

			btnBuscarAlquiler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtNroAlquiler.setText(txtNroAlquiler.getText().trim());

					if (txtNroAlquiler.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar el Número de Alquiler", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						if (sonSoloNumeros(txtNroAlquiler.getText())) {
							AlquilerDTO alq = sistema.mostrarAlquiler(Integer
									.parseInt(txtNroAlquiler.getText()));
							if (alq != null) {
								cargarDatos(alq);
								ocultarCampos(false);
							} else {
								ocultarCampos(true);
								borrarCampos();
								txtNroAlquiler.setText(txtNroAlquiler.getText()
										+ " <--- Alquiler inexistente");
								txtNroAlquiler.selectAll();
								btnBuscarAlquiler.transferFocusBackward();
							}
						} else {
							JOptionPane
									.showMessageDialog(
											null,
											"El Número de Alquiler puede contener sólo números",
											"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});

			panelSuperior.add(lblNroAlquiler);
			panelSuperior.add(txtNroAlquiler);
			panelSuperior.add(btnBuscarAlquiler);

			lblCliente = new JLabel();
			lblCliente.setBounds(20, 15, 160, 25);
			txtCliente = new JTextField();
			txtCliente.setBounds(190, 15, 200, 25);
			txtCliente.setEnabled(false);
			lblTipo = new JLabel();
			lblTipo.setBounds(20, 55, 160, 25);
			String[] listaTipos = { "(Seleccione)", "Económico", "Compacto",
					"Premium", "Minivan", "Camionetas" };
			txtTipo = new JComboBox(listaTipos);
			txtTipo.setBounds(190, 55, 200, 25);
			txtTipo.setEnabled(false);
			lblFechaInicio = new JLabel();
			lblFechaInicio.setBounds(20, 95, 160, 25);
			txtFechaInicio = new JTextField();
			txtFechaInicio.setBounds(190, 95, 200, 25);
			txtFechaInicio.setEnabled(false);
			lblFechaFin = new JLabel();
			lblFechaFin.setBounds(20, 135, 160, 25);
			txtFechaFin = new JTextField();
			txtFechaFin.setBounds(190, 135, 200, 25);
			txtFechaFin.setEnabled(false);
			lblObservCliente = new JLabel();
			lblObservCliente.setBounds(20, 175, 160, 25);
			txtObservCliente = new JTextField();
			txtObservCliente.setBounds(190, 175, 200, 25);
			txtObservCliente.setEnabled(false);

			lblCliente.setText("Cliente:");
			lblTipo.setText("Tipo:");
			lblFechaInicio.setText("Fecha de Inicio:");
			lblFechaFin.setText("Fecha de Fin:");
			lblObservCliente.setText("Observaciones del Cliente:");

			panelCentral.add(lblCliente);
			panelCentral.add(txtCliente);
			panelCentral.add(lblTipo);
			panelCentral.add(txtTipo);
			panelCentral.add(lblFechaInicio);
			panelCentral.add(txtFechaInicio);
			panelCentral.add(lblFechaFin);
			panelCentral.add(txtFechaFin);
			panelCentral.add(lblObservCliente);
			panelCentral.add(txtObservCliente);

			lblFechaDevolucion = new JLabel();
			lblFechaDevolucion.setBounds(20, 15, 160, 25);
			txtFechaDevolucion = new JTextField();
			txtFechaDevolucion.setBounds(190, 15, 200, 25);
			lblObservDevolucion = new JLabel();
			lblObservDevolucion.setBounds(20, 55, 160, 25);
			txtObservDevolucion = new JTextField();
			txtObservDevolucion.setBounds(190, 55, 200, 25);
			lblKilometraje = new JLabel();
			lblKilometraje.setBounds(20, 95, 160, 25);
			txtKilometraje = new JTextField();
			txtKilometraje.setBounds(190, 95, 200, 25);
			lblCombustible = new JLabel();
			lblCombustible.setBounds(20, 135, 160, 25);
			txtCombustible = new JTextField();
			txtCombustible.setBounds(190, 135, 200, 25);
			lblDescuento = new JLabel();
			lblDescuento.setBounds(20, 175, 160, 25);
			txtDescuento = new JTextField();
			txtDescuento.setBounds(190, 175, 200, 25);
			lblRecargo = new JLabel();
			lblRecargo.setBounds(20, 215, 160, 25);
			txtRecargo = new JTextField();
			txtRecargo.setBounds(190, 215, 200, 25);

			btnRegistrarDevolucion = new JButton();
			btnRegistrarDevolucion.setBounds(167, 255, 181, 25);

			panelInferior.add(lblFechaDevolucion);
			panelInferior.add(txtFechaDevolucion);
			panelInferior.add(lblObservDevolucion);
			panelInferior.add(txtObservDevolucion);
			panelInferior.add(lblKilometraje);
			panelInferior.add(txtKilometraje);
			panelInferior.add(lblCombustible);
			panelInferior.add(txtCombustible);
			panelInferior.add(lblDescuento);
			panelInferior.add(txtDescuento);
			panelInferior.add(lblRecargo);
			panelInferior.add(txtRecargo);

			lblFechaDevolucion.setText("Fecha de Devolución:");
			lblObservDevolucion.setText("Revisión de Devolución:");
			lblKilometraje.setText("Kilometraje:");
			lblCombustible.setText("Nivel de Combustible:");
			lblDescuento.setText("Descuento:");
			lblRecargo.setText("Recargo:");

			panelInferior.add(btnRegistrarDevolucion);
			btnRegistrarDevolucion.setText("Registrar Devolución");
			btnRegistrarDevolucion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (validarCampos()) {
						AlquilerDTO alq = sistema.registrarDevolucion(
								Integer.parseInt(txtNroAlquiler.getText()),
								convertirFecha(txtFechaDevolucion.getText()),
								txtObservDevolucion.getText(),
								Float.parseFloat(txtKilometraje.getText()),
								Float.parseFloat(txtCombustible.getText()),
								Float.parseFloat(txtDescuento.getText()),
								Float.parseFloat(txtRecargo.getText()));
						if (alq != null) {
							JOptionPane.showMessageDialog(null,
									"Se ha registrado la devolución", "Éxito",
									JOptionPane.INFORMATION_MESSAGE);
							borrarCampos();
						} else {
							JOptionPane.showMessageDialog(null,
									"No se ha registrado la devolución",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane
								.showMessageDialog(null,
										"Hay conflictos en uno o más campos:"
												+ mensaje, "Error",
										JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnRegistrarDevolucion.setEnabled(false);

			borrarCampos();
			ocultarCampos(true);
			setTitle("Registrar Devolución");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cargarDatos(AlquilerDTO alq) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

		txtCliente.setText(Integer.toString(alq.getDniCliente()) + " - "
				+ alq.getNombreCliente() + " " + alq.getApellidoCliente());
		txtTipo.setSelectedItem(alq.getTipo());
		txtFechaInicio.setText(formatoFecha.format(alq.getFechaInicio()));
		txtFechaFin.setText(formatoFecha.format(alq.getFechaFin()));
		txtObservCliente.setText(alq.getObservacionesCliente());
	}

	private void borrarCampos() {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

		for (Component c : panelInferior.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setText("");
		}
		txtTipo.setSelectedIndex(0);
		txtFechaDevolucion.setText(formatoFecha.format(new Date()));
	}

	private void ocultarCampos(boolean ocultar) {
		btnRegistrarDevolucion.setEnabled(!ocultar);
		for (Component c : panelInferior.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setEnabled(!ocultar);
		}
	}

	private boolean validarCampos() {
		mensaje = "";

		if (txtTipo.getSelectedIndex() == 0) {
			mensaje = mensaje + "\n" + "Debe seleccionar el Tipo";
		}
		if (txtNroAlquiler.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Número de Alquiler está vacío";
		}
		if (txtFechaInicio.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Fecha de Inicio está vacío";
		} else {
			if (convertirFecha(txtFechaInicio.getText()) == null) {
				mensaje = mensaje
						+ "\n"
						+ "La Fecha de Inicio no está bien ingresada (dd-mm-aaaa, ej: 23-12-1980).";
			}
		}
		if (txtFechaFin.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Fecha de Inicio está vacío";
		} else {
			if (convertirFecha(txtFechaFin.getText()) == null) {
				mensaje = mensaje
						+ "\n"
						+ "La Fecha de Inicio no está bien ingresada (dd-mm-aaaa, ej: 23-12-1980).";
			}
		}
		if (txtObservDevolucion.getText().isEmpty()) {
			mensaje = mensaje + "\n"
					+ "El campo Observaciones de Devolucion está vacío";
		}

		if (mensaje.isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean sonSoloNumeros(String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			if (!Character.isDigit(c))
				if (c != '.' || c != ',')
					return false;
		}
		return true;
	}

	private Date convertirFecha(String fec) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha;
		try {
			fecha = formatoFecha.parse(fec);
		} catch (ParseException e) {
			return null;
		}
		return fecha;
	}
}