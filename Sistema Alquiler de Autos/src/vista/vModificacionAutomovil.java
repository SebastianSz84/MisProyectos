package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.AutomovilDTO;
import controlador.SistemaAlquilerAutos;

public class vModificacionAutomovil extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla

	private JLabel lblPatente;
	private JTextField txtPatente;
	private JButton btnBuscarAuto;

	private JLabel lblAnio;
	private JTextField txtAnio;
	private JLabel lblCombustible;
	private JTextField txtCombustible;
	private JLabel lblKilometraje;
	private JTextField txtKilometraje;
	private JLabel lblCbActivo;
	private JCheckBox cbActivo;

	private JButton btnModAutomovil;

	private JPanel panel;
	private JPanel panelBuscarAuto;
	private JPanel panelPrincipal;

	private String mensaje;

	private SistemaAlquilerAutos sistema;

	// constructor
	public vModificacionAutomovil(SistemaAlquilerAutos sist) {
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

			panelBuscarAuto = new JPanel();
			panelBuscarAuto.setLayout(null);
			panelBuscarAuto.setBounds(0, 0, getWidth(), 40);

			panelPrincipal = new JPanel();
			panelPrincipal.setLayout(null);
			panelPrincipal.setBounds(0, 40, getWidth(), 200);

			lblPatente = new JLabel();
			lblPatente.setBounds(20, 15, 140, 25);
			txtPatente = new JTextField();
			txtPatente.setBounds(170, 15, 160, 25);
			btnBuscarAuto = new JButton();
			btnBuscarAuto.setBounds(350, 15, 80, 25);
			btnBuscarAuto.setText("Buscar");

			btnBuscarAuto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					txtPatente.setText(txtPatente.getText().trim());
					if (!txtPatente.getText().isEmpty()) {
						AutomovilDTO auto = sistema.mostrarAutomovil(txtPatente
								.getText());
						if (auto != null) {
							txtAnio.setText(auto.getAnio());
							txtCombustible.setText(Float.toString(auto
									.getCombustible()));
							txtKilometraje.setText(Float.toString(auto
									.getKilometraje()));
							cbActivo.setSelected(auto.isActivo());
							ocultarCampos(false);
						} else {
							txtPatente.setText(txtPatente.getText()
									+ " <--- Automóvil inexistente");
							btnModAutomovil.setEnabled(false);
							txtPatente.selectAll();
							btnBuscarAuto.transferFocusBackward();
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar la Patente", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			panelBuscarAuto.add(lblPatente);
			panelBuscarAuto.add(txtPatente);
			panelBuscarAuto.add(btnBuscarAuto);

			lblAnio = new JLabel();
			lblAnio.setBounds(20, 15, 140, 25);
			txtAnio = new JTextField();
			txtAnio.setBounds(170, 15, 160, 25);
			lblCombustible = new JLabel();
			lblCombustible.setBounds(20, 55, 140, 25);
			txtCombustible = new JTextField();
			txtCombustible.setBounds(170, 55, 160, 25);
			lblKilometraje = new JLabel();
			lblKilometraje.setBounds(20, 95, 140, 25);
			txtKilometraje = new JTextField();
			txtKilometraje.setBounds(170, 95, 160, 25);
			lblCbActivo = new JLabel();
			lblCbActivo.setBounds(20, 135, 140, 25);
			cbActivo = new JCheckBox();
			cbActivo.setBounds(170, 135, 140, 25);
			cbActivo.setEnabled(false);

			btnModAutomovil = new JButton();
			btnModAutomovil.setBounds(157, 175, 141, 25);

			btnModAutomovil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (validarCampos()) {
						AutomovilDTO auto = sistema.modificarAutomovil(
								txtPatente.getText(), txtAnio.getText(),
								Float.parseFloat(txtCombustible.getText()),
								Float.parseFloat(txtKilometraje.getText()),
								cbActivo.isSelected());
						if (auto != null) {
							JOptionPane
									.showMessageDialog(
											null,
											"El Automóvil ha sido modificado correctamente",
											"Éxito",
											JOptionPane.INFORMATION_MESSAGE);
							borrarCampos();
						} else {
							JOptionPane.showMessageDialog(null,
									"No se ha podido modificar el Automóvil",
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

			lblAnio.setText("Año:");
			lblPatente.setText("Patente:");
			lblCombustible.setText("Nivel del Combustible:");
			lblKilometraje.setText("Kilometraje:");
			lblCbActivo.setText("Activo:");
			btnModAutomovil.setText("Cambiar datos");

			panelPrincipal.add(lblAnio);
			panelPrincipal.add(txtAnio);
			panelPrincipal.add(lblCombustible);
			panelPrincipal.add(txtCombustible);
			panelPrincipal.add(lblKilometraje);
			panelPrincipal.add(txtKilometraje);
			panelPrincipal.add(lblCbActivo);
			panelPrincipal.add(cbActivo);
			panelPrincipal.add(btnModAutomovil);

			panel.add(panelBuscarAuto);
			panel.add(panelPrincipal);

			ocultarCampos(true);
			setTitle("Modificar Automóvil");
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
		btnModAutomovil.setEnabled(!ocultar);
		for (Component c : panelPrincipal.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setEnabled(!ocultar);
		}
	}

	private boolean validarCampos() {
		mensaje = "";

		if (txtAnio.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Año está vacío";
		} else {
			if (!sonSoloNumeros(txtAnio.getText())) {
				mensaje = mensaje + "\n"
						+ "El Año está mal ingresado. Son sólo números.";
			}
		}
		if (txtPatente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Patente está vacío";
		} else {
			if (sonSoloNumeros(txtPatente.getText())
					|| sonSoloLetras(txtPatente.getText())) {
				mensaje = mensaje + "\n"
						+ "El campo Patente debe contener letras y números";
			}
		}
		if (txtCombustible.getText().isEmpty()) {
			mensaje = mensaje + "\n"
					+ "El campo Nivel de Combustible está vacío";
		} else {
			if (!sonSoloNumeros(txtCombustible.getText())) {
				mensaje = mensaje
						+ "\n"
						+ "El campo Combustible es un numero (puede llevar decimales)";
			}
		}
		if (txtKilometraje.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Kilometraje está vacío";
		} else {
			if (!sonSoloNumeros(txtKilometraje.getText())) {
				mensaje = mensaje
						+ "\n"
						+ "El campo Kilometraje es un numero (puede llevar decimales)";
			}
		}

		if (mensaje.isEmpty()) {
			return true;
		}
		return false;
	}

	private boolean sonSoloNumeros(String cadena) {
		try {
			float numero = Float.parseFloat(cadena);
		} catch (Exception e) {
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