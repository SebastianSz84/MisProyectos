package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.AutomovilDTO;
import modelo.ModeloDTO;
import controlador.SistemaAlquilerAutos;

public class vAltaAutomovil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla

	private JLabel lblCodigoModelo;
	private JTextField txtCodigoModelo;
	private JButton btnBuscarModelo;
	private JLabel lblAnio;
	private JTextField txtAnio;
	private JLabel lblCombustible;
	private JTextField txtCombustible;
	private JLabel lblKilometraje;
	private JTextField txtKilometraje;
	private JLabel lblPatente;
	private JTextField txtPatente;
	private JButton btnAltaAutomovil;

	private JPanel panel;
	private JPanel panelBuscarModelo;
	private JPanel panelPrincipal;
	private JPanel panelInferior;

	private String mensaje;

	private SistemaAlquilerAutos sistema;

	// constructor
	public vAltaAutomovil(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(455, 280);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(getBounds());
			setContentPane(panel);

			panelBuscarModelo = new JPanel();
			panelBuscarModelo.setLayout(null);
			panelBuscarModelo.setBounds(0, 0, getWidth(), 40);
			panelPrincipal = new JPanel();
			panelPrincipal.setLayout(null);
			panelPrincipal.setBounds(0, 40, getWidth(), 160);
			panelInferior = new JPanel();
			panelInferior.setLayout(null);
			panelInferior.setBounds(0, 200, getWidth(), 40);

			lblCodigoModelo = new JLabel();
			lblCodigoModelo.setBounds(20, 15, 140, 25);
			txtCodigoModelo = new JTextField();
			txtCodigoModelo.setBounds(170, 15, 160, 25);
			btnBuscarModelo = new JButton();
			btnBuscarModelo.setBounds(350, 15, 80, 25);

			lblCodigoModelo.setText("Código de Modelo:");
			btnBuscarModelo.setText("Buscar");

			btnBuscarModelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ModeloDTO mod = sistema.mostrarModelo(txtCodigoModelo
							.getText());
					if (mod != null) {
						ocultarCampos(false);
						txtCodigoModelo.setText(mod.getCodigoModelo());
						btnAltaAutomovil.setEnabled(true);
					} else {
						txtCodigoModelo.setText(txtCodigoModelo.getText()
								+ " <--- Modelo inexistente");
						btnAltaAutomovil.setEnabled(false);
						txtCodigoModelo.selectAll();
						btnBuscarModelo.transferFocusBackward();
						ocultarCampos(true);
					}
				}
			});

			panelBuscarModelo.add(lblCodigoModelo);
			panelBuscarModelo.add(txtCodigoModelo);
			panelBuscarModelo.add(btnBuscarModelo);

			lblPatente = new JLabel();
			lblPatente.setBounds(20, 15, 140, 25);
			txtPatente = new JTextField();
			txtPatente.setBounds(170, 15, 160, 25);
			lblAnio = new JLabel();
			lblAnio.setBounds(20, 55, 140, 25);
			txtAnio = new JTextField();
			txtAnio.setBounds(170, 55, 160, 25);
			lblCombustible = new JLabel();
			lblCombustible.setBounds(20, 95, 140, 25);
			txtCombustible = new JTextField();
			txtCombustible.setBounds(170, 95, 160, 25);
			lblKilometraje = new JLabel();
			lblKilometraje.setBounds(20, 135, 140, 25);
			txtKilometraje = new JTextField();
			txtKilometraje.setBounds(170, 135, 160, 25);

			lblAnio.setText("Año:");
			lblPatente.setText("Patente:");
			lblCombustible.setText("Nivel del Combustible:");
			lblKilometraje.setText("Kilometraje:");

			panelPrincipal.add(lblAnio);
			panelPrincipal.add(txtAnio);
			panelPrincipal.add(lblPatente);
			panelPrincipal.add(txtPatente);
			panelPrincipal.add(lblCombustible);
			panelPrincipal.add(txtCombustible);
			panelPrincipal.add(lblKilometraje);
			panelPrincipal.add(txtKilometraje);

			btnAltaAutomovil = new JButton();
			btnAltaAutomovil.setBounds(172, 15, 111, 25);

			btnAltaAutomovil.setText("Dar de Alta");

			btnAltaAutomovil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					mensaje = "";
					validarCampos();
					if (mensaje.isEmpty()) {
						AutomovilDTO auto = sistema.registrarAutomovil(
								txtCodigoModelo.getText(), txtAnio.getText(),
								txtPatente.getText(),
								Float.parseFloat(txtKilometraje.getText()),
								Float.parseFloat(txtCombustible.getText()),
								"Disponible");
						if (auto != null) {
							JOptionPane
									.showMessageDialog(
											null,
											"El Automóvil se ha dado de alta correctamente.",
											"Éxito",
											JOptionPane.INFORMATION_MESSAGE);
							borrarCampos();
						} else {
							JOptionPane.showMessageDialog(null,
									"Error al dar de alta el Automóvil.",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Hay conflictos en uno o más campos:", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			panelInferior.add(btnAltaAutomovil);

			panel.add(panelBuscarModelo);
			panel.add(panelPrincipal);
			panel.add(panelInferior);

			ocultarCampos(true);
			setTitle("Alta de Automóvil");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void borrarCampos() {
		for (Component c : panelPrincipal.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setText("");
		}
	}

	private void ocultarCampos(boolean ocultar) {
		btnAltaAutomovil.setEnabled(!ocultar);
		for (Component c : panelPrincipal.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setEnabled(!ocultar);
		}
	}

	private void validarCampos() {
		if (txtAnio.getText().isEmpty()) {
			mensaje = mensaje + "\nEl campo Año está vacío";
		} else {
			if (!sonSoloNumeros(txtAnio.getText())) {
				mensaje = mensaje
						+ "\nEl Año esta mal ingresado. Son solo numeros.";
			}
		}
		if (txtPatente.getText().isEmpty()) {
			mensaje = mensaje + "\nEl campo Patente está vacío";
		} else {
			if (sonSoloNumeros(txtPatente.getText())
					|| sonSoloLetras(txtPatente.getText())) {
				mensaje = mensaje
						+ "\nEl campo Patente debe contener letras y números";
			}
		}
		if (txtCombustible.getText().isEmpty()) {
			mensaje = mensaje + "\nEl campo Nivel de Combustible está vacío";
		} else {
			if (!sonSoloNumeros(txtCombustible.getText())) {
				mensaje = mensaje
						+ "\nEl campo Combustible es un numero (puede llevar decimales)";
			}
		}
		if (txtKilometraje.getText().isEmpty()) {
			mensaje = mensaje + "\nEl campo Kilometraje está vacío";
		} else {
			if (!sonSoloNumeros(txtKilometraje.getText())) {
				mensaje = mensaje
						+ "\nEl campo Kilometraje es un numero (puede llevar decimales)";
			}
		}
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

	private boolean sonSoloLetras(String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			if (Character.isDigit(c))
				return false;
		}
		return true;
	}
}