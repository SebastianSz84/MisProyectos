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
import modelo.ClienteDTO;
import controlador.SistemaAlquilerAutos;

public class vGenerarAlquilerLocal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla

	private JLabel lblTipo;
	private JComboBox txtTipo;
	private JLabel lblDni;
	private JTextField txtDni;
	private JButton btnBuscarDni;
	private JLabel lblFechaInicio;
	private JTextField txtFechaInicio;
	private JLabel lblFechaFin;
	private JTextField txtFechaFin;
	private JLabel lblObservCliente;
	private JTextField txtObservCliente;
	private JButton btnGenerarAlquiler;

	private JPanel panel;
	private JPanel panelSuperior;
	private JPanel panelInferior;

	private String mensaje;

	private SistemaAlquilerAutos sistema;

	// constructor
	public vGenerarAlquilerLocal(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(400, 280);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			panel = new JPanel();
			panel.setBounds(0, 0, 400, 280);
			panel.setLayout(null);
			panelSuperior = new JPanel();
			panelSuperior.setLayout(null);
			panelSuperior.setBounds(0, 0, 400, 40);
			panel.add(panelSuperior);
			panelInferior = new JPanel();
			panelInferior.setLayout(null);
			panelInferior.setBounds(0, 40, 400, 255);
			panel.add(panelInferior);
			setContentPane(panel);

			lblDni = new JLabel();
			lblDni.setBounds(20, 15, 110, 25);
			txtDni = new JTextField();
			txtDni.setBounds(140, 15, 140, 25);

			btnBuscarDni = new JButton();
			btnBuscarDni.setBounds(295, 15, 80, 25);

			lblDni.setText("DNI:");
			btnBuscarDni.setText("Buscar");

			btnBuscarDni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (txtDni.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Ingrese el DNI",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						if (sonSoloNumeros(txtDni.getText())) {
							ClienteDTO cli = sistema.mostrarCliente(Integer
									.parseInt(txtDni.getText()));
							if (cli != null) {
								txtDni.setText(Integer.toString(cli.getDni()));
								ocultarCampos(false);
							} else {
								ocultarCampos(true);
								txtDni.setText(txtDni.getText()
										+ " <--- DNI inexistente");
								txtDni.selectAll();
								btnBuscarDni.transferFocusBackward();
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"El DNI puede contener sólo números",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});

			panelSuperior.add(lblDni);
			panelSuperior.add(txtDni);
			panelSuperior.add(btnBuscarDni);

			lblTipo = new JLabel();
			lblTipo.setBounds(20, 15, 110, 25);
			String[] listaTipos = { "(Seleccione)", "Económico", "Compacto",
					"Premium", "Minivan", "Camionetas" };
			txtTipo = new JComboBox(listaTipos);
			txtTipo.setBounds(140, 15, 140, 25);
			lblFechaInicio = new JLabel();
			lblFechaInicio.setBounds(20, 55, 110, 25);
			txtFechaInicio = new JTextField();
			txtFechaInicio.setBounds(140, 55, 140, 25);
			lblFechaFin = new JLabel();
			lblFechaFin.setBounds(20, 95, 110, 25);
			txtFechaFin = new JTextField();
			txtFechaFin.setBounds(140, 95, 140, 25);
			lblObservCliente = new JLabel();
			lblObservCliente.setBounds(20, 135, 110, 25);
			txtObservCliente = new JTextField();
			txtObservCliente.setBounds(140, 135, 140, 25);
			btnGenerarAlquiler = new JButton();
			btnGenerarAlquiler.setBounds(125, 175, 150, 25);

			panelInferior.add(lblTipo);
			panelInferior.add(txtTipo);
			panelInferior.add(lblFechaInicio);
			panelInferior.add(txtFechaInicio);
			panelInferior.add(lblFechaFin);
			panelInferior.add(txtFechaFin);
			panelInferior.add(lblObservCliente);
			panelInferior.add(txtObservCliente);

			lblTipo.setText("Tipo:");
			lblFechaInicio.setText("Fecha de Inicio:");
			lblFechaFin.setText("Fecha de Fin:");
			lblObservCliente.setText("Observaciones:");

			panelInferior.add(btnGenerarAlquiler);
			btnGenerarAlquiler.setText("Generar Alquiler");
			btnGenerarAlquiler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (validarCampos()) {
						AlquilerDTO alq = sistema.generarAlquilerEnLocal(
								Integer.parseInt(txtDni.getText()),
								convertirFecha(txtFechaInicio.getText()),
								convertirFecha(txtFechaFin.getText()), txtTipo
										.getSelectedItem().toString(),
								txtObservCliente.getText());
						if (alq != null) {
							JOptionPane.showMessageDialog(
									null,
									"Se ha generado el alquiler "
											+ Integer.toString(alq
													.getNroAlquiler()),
									"Éxito", JOptionPane.INFORMATION_MESSAGE);
							borrarCampos();
						} else {
							JOptionPane.showMessageDialog(null,
									"No se ha generado el alquiler", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Hay conflictos en uno o más campos:", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnGenerarAlquiler.setEnabled(false);

			ocultarCampos(true);
			setTitle("Generar Alquiler en Local");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void borrarCampos() {
		for (Component c : panelInferior.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setText("");
		}
	}

	private void ocultarCampos(boolean ocultar) {
		btnGenerarAlquiler.setEnabled(!ocultar);
		txtTipo.setEnabled(!ocultar);
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
		if (txtDni.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo DNI está vacío";
		} else {
			if (!sonSoloNumeros(txtDni.getText())) {
				mensaje = mensaje + "\n" + "El dni está mal ingresado.";
			}
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
		if (txtObservCliente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Observaciones está vacío";
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