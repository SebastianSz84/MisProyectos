package vista;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.ModeloDTO;
import controlador.SistemaAlquilerAutos;

public class vAltaModelo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla

	private JLabel lblCodigoModelo;
	private JTextField txtCodigoModelo;
	private JLabel lblMarca;
	private JTextField txtMarca;
	private JLabel lblModelo;
	private JTextField txtModelo;
	private JLabel lblDatosMotor;
	private JTextField txtDatosMotor;
	private JLabel lblDatosSeguridad;
	private JTextField txtDatosSeguridad;
	private JLabel lblTipo;
	private JComboBox txtTipo;
	private JLabel lblCostoDiario;
	private JTextField txtCostoDiario;
	private JLabel lblCostoExcedente;
	private JTextField txtCostoExcedente;
	private JButton btnAltaModelo;

	private String mensaje;

	private JPanel panel;

	private SistemaAlquilerAutos sistema;

	// constructor
	public vAltaModelo(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(365, 400);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			panel = new JPanel();
			setContentPane(panel);
			panel.setLayout(null);

			lblCodigoModelo = new JLabel();
			lblCodigoModelo.setBounds(20, 15, 140, 25);
			txtCodigoModelo = new JTextField();
			txtCodigoModelo.setBounds(180, 15, 160, 25);
			lblMarca = new JLabel();
			lblMarca.setBounds(20, 55, 140, 25);
			txtMarca = new JTextField();
			txtMarca.setBounds(180, 55, 160, 25);
			lblModelo = new JLabel();
			lblModelo.setBounds(20, 95, 140, 25);
			txtModelo = new JTextField();
			txtModelo.setBounds(180, 95, 160, 25);
			lblDatosMotor = new JLabel();
			lblDatosMotor.setBounds(20, 135, 140, 25);
			txtDatosMotor = new JTextField();
			txtDatosMotor.setBounds(180, 135, 160, 25);
			lblDatosSeguridad = new JLabel();
			lblDatosSeguridad.setBounds(20, 175, 140, 25);
			txtDatosSeguridad = new JTextField();
			txtDatosSeguridad.setBounds(180, 175, 160, 25);
			lblTipo = new JLabel();
			lblTipo.setBounds(20, 215, 140, 25);
			String[] listaTipos = { "(Seleccione)", "Económico", "Compacto",
					"Premium", "Minivan", "Camionetas" };
			txtTipo = new JComboBox(listaTipos);
			txtTipo.setBounds(180, 215, 160, 25);
			lblCostoDiario = new JLabel();
			lblCostoDiario.setBounds(20, 255, 140, 25);
			txtCostoDiario = new JTextField();
			txtCostoDiario.setBounds(180, 255, 160, 25);
			lblCostoExcedente = new JLabel();
			lblCostoExcedente.setBounds(20, 295, 140, 25);
			txtCostoExcedente = new JTextField();
			txtCostoExcedente.setBounds(180, 295, 160, 25);
			btnAltaModelo = new JButton();
			btnAltaModelo.setBounds(135, 335, 110, 25);

			panel.add(lblCodigoModelo);
			panel.add(txtCodigoModelo);
			panel.add(lblMarca);
			panel.add(txtMarca);
			panel.add(lblModelo);
			panel.add(txtModelo);
			panel.add(lblDatosMotor);
			panel.add(txtDatosMotor);
			panel.add(lblDatosSeguridad);
			panel.add(txtDatosSeguridad);
			panel.add(lblTipo);
			panel.add(txtTipo);
			panel.add(lblCostoDiario);
			panel.add(txtCostoDiario);
			panel.add(lblCostoExcedente);
			panel.add(txtCostoExcedente);
			panel.add(btnAltaModelo);

			lblCodigoModelo.setText("Código de Modelo:");
			lblMarca.setText("Marca:");
			lblModelo.setText("Modelo:");
			lblDatosMotor.setText("Datos del motor:");
			lblDatosSeguridad.setText("Datos de seguridad:");
			lblTipo.setText("Tipo:");
			lblCostoDiario.setText("Costo Diario:");
			lblCostoExcedente.setText("Costo Excedente:");

			btnAltaModelo.setText("Dar de Alta");

			btnAltaModelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					String codigoModelo = txtCodigoModelo.getText();
					String modelo = txtModelo.getText();
					String datosMotor = txtDatosMotor.getText();
					String marca = txtMarca.getText();
					String tipo = txtTipo.getSelectedItem().toString();
					String costoDiario = txtCostoDiario.getText();
					String costoExcedente = txtCostoExcedente.getText();
					String datosSeguridad = txtDatosSeguridad.getText();

					if (camposCorrectos()) {
						ModeloDTO mod = sistema.registrarModelo(codigoModelo,
								marca, modelo, datosMotor, datosSeguridad,
								tipo, Float.parseFloat(costoDiario),
								Float.parseFloat(costoExcedente));
						if (mod != null) {
							JOptionPane.showMessageDialog(null,
									"El Modelo se ha agregado correctamente",
									"Éxito", JOptionPane.INFORMATION_MESSAGE);
							borrarCampos();
						} else {
							JOptionPane.showMessageDialog(null,
									"El Modelo ya existe en el sistema",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Errores en los datos:" + mensaje, "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			borrarCampos();
			setTitle("Alta de Modelo");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void borrarCampos() {
		txtTipo.setSelectedIndex(0);
		for (Component c : panel.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setText("");
		}
	}

	private boolean camposCorrectos() {
		mensaje = "";

		if (txtCodigoModelo.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Código de Modelo está vacío";
		}
		if (txtMarca.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Marca está vacío";
		} else {
		}
		if (txtModelo.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Modelo está vacío";
		} else {
		}
		if (txtDatosMotor.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Dato de Motor está vacío";
		} else {
		}
		if (txtDatosSeguridad.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Dato de Seguridad está vacío";
		} else {
		}
		if (txtTipo.getSelectedIndex() == 0) {
			mensaje = mensaje + "\n" + "Debe seleccionar el Tipo";
		} else {
		}
		if (txtCostoDiario.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Costo Diario está vacío";
		} else {
			if (!sonSoloNumeros(txtCostoDiario.getText())) {
				mensaje = mensaje
						+ "\n"
						+ "el campo Costo Diario es numérico (puede llevar decimales)";
			}
		}
		if (txtCostoExcedente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Costo Excedente está vacío";
		} else {
			if (!sonSoloNumeros(txtCostoExcedente.getText())) {
				mensaje = mensaje
						+ "\n"
						+ "El campo Costo Excedente es numérico (puede llevar decimales)";
			}
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
}