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

import controlador.SistemaAlquilerAutos;

public class vAltaClienteLocal extends JFrame {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;

	private JLabel lblDNICliente;
	private JTextField txtDNICliente;
	private JLabel lblFechaNCliente;
	private JTextField txtFechaNCliente;
	private JLabel lblNombreCliente;
	private JTextField txtNombreCliente;
	private JLabel lblApellidoCliente;
	private JTextField txtApellidoCliente;
	private JLabel lblTelefonoCliente;
	private JTextField txtTelefonoCliente;
	private JLabel lblDomicilioCliente;
	private JTextField txtDomicilioCliente;
	private JLabel lblSexoCliente;
	private JComboBox txtSexoCliente;
	private JLabel lblNacionalidadCliente;
	private JTextField txtNacionalidadCliente;
	private JButton btnAltaCliente;

	private JPanel panel;

	private String mensaje;

	private SistemaAlquilerAutos sistema;

	// constructor
	public vAltaClienteLocal(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(400, 400);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(getBounds());
			setContentPane(panel);

			lblDNICliente = new JLabel();
			lblDNICliente.setBounds(20, 15, 220, 25);
			txtDNICliente = new JTextField();
			txtDNICliente.setBounds(240, 15, 140, 25);
			txtDNICliente.setText("");
			lblFechaNCliente = new JLabel();
			lblFechaNCliente.setBounds(20, 55, 220, 25);
			txtFechaNCliente = new JTextField();
			txtFechaNCliente.setBounds(240, 55, 140, 25);
			txtFechaNCliente.setText("");
			lblNombreCliente = new JLabel();
			lblNombreCliente.setBounds(20, 95, 220, 25);
			txtNombreCliente = new JTextField();
			txtNombreCliente.setBounds(240, 95, 140, 25);
			txtNombreCliente.setText("");
			lblApellidoCliente = new JLabel();
			lblApellidoCliente.setBounds(20, 135, 220, 25);
			txtApellidoCliente = new JTextField();
			txtApellidoCliente.setBounds(240, 135, 140, 25);
			txtApellidoCliente.setText("");
			lblTelefonoCliente = new JLabel();
			lblTelefonoCliente.setBounds(20, 175, 220, 25);
			txtTelefonoCliente = new JTextField();
			txtTelefonoCliente.setBounds(240, 175, 140, 25);
			txtTelefonoCliente.setText("");
			lblDomicilioCliente = new JLabel();
			lblDomicilioCliente.setBounds(20, 215, 220, 25);
			txtDomicilioCliente = new JTextField();
			txtDomicilioCliente.setBounds(240, 215, 140, 25);
			txtDomicilioCliente.setText("");
			lblSexoCliente = new JLabel();
			lblSexoCliente.setBounds(20, 255, 220, 25);
			String[] listaSexo = { "(Seleccione)", "Masculino", "Femenino" };
			txtSexoCliente = new JComboBox(listaSexo);
			txtSexoCliente.setBounds(240, 255, 140, 25);
			txtSexoCliente.setSelectedIndex(0);
			lblNacionalidadCliente = new JLabel();
			lblNacionalidadCliente.setBounds(20, 295, 220, 25);
			txtNacionalidadCliente = new JTextField();
			txtNacionalidadCliente.setBounds(240, 295, 140, 25);
			txtNacionalidadCliente.setText("");

			btnAltaCliente = new JButton();
			btnAltaCliente.setBounds(145, 335, 110, 25);

			panel.add(lblDNICliente);
			panel.add(txtDNICliente);
			panel.add(lblFechaNCliente);
			panel.add(txtFechaNCliente);
			panel.add(lblNombreCliente);
			panel.add(txtNombreCliente);
			panel.add(lblApellidoCliente);
			panel.add(txtApellidoCliente);
			panel.add(lblTelefonoCliente);
			panel.add(txtTelefonoCliente);
			panel.add(lblDomicilioCliente);
			panel.add(txtDomicilioCliente);
			panel.add(lblSexoCliente);
			panel.add(txtSexoCliente);
			panel.add(lblNacionalidadCliente);
			panel.add(txtNacionalidadCliente);
			panel.add(btnAltaCliente);

			lblDNICliente.setText("DNI:");
			lblFechaNCliente.setText("Fecha de Nacimiento (dd-mm-aaaa):");
			lblNombreCliente.setText("Nombre:");
			lblApellidoCliente.setText("Apellido:");
			lblTelefonoCliente.setText("Telefono:");
			lblDomicilioCliente.setText("Domicilio:");
			lblSexoCliente.setText("Sexo:");
			lblNacionalidadCliente.setText("Nacionalidad:");

			btnAltaCliente.setText("Dar de Alta");

			btnAltaCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					mensaje = "";

					validarDatos();
					if (mensaje.isEmpty()) {
						if (sistema.mostrarCliente(Integer
								.parseInt(txtDNICliente.getText())) == null) {
							enviarDatosCliente();
						} else {
							JOptionPane.showMessageDialog(null,
									"El DNI ingresado ya existe", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Errores en los datos:" + mensaje, "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			borrarCampos();
			setTitle("Alta de Cliente");
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

	private void enviarDatosCliente() {
		String dni = txtDNICliente.getText();
		String nom = txtNombreCliente.getText();
		String apellido = txtApellidoCliente.getText();
		Date fechaNac = convertirFecha(txtFechaNCliente.getText());
		String domicilio = txtDomicilioCliente.getText();
		String nacionalidad = txtNacionalidadCliente.getText();
		String tel = txtTelefonoCliente.getText();
		String sex;
		if (txtSexoCliente.getSelectedIndex() == 1) {
			sex = "M";
		} else {
			sex = "F";
		}

		sistema.registrarCliente(Integer.parseInt(dni), nom, apellido,
				fechaNac, domicilio, sex, nacionalidad, tel, null, null);

		JOptionPane.showMessageDialog(null,
				"El cliente se ha dado de alta correctamente", "Éxito",
				JOptionPane.INFORMATION_MESSAGE);
		borrarCampos();
	}

	private void validarDatos() {
		if (txtDNICliente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo DNI esta vacío";
		} else {
			if (!sonSoloNumeros(txtDNICliente.getText())) {
				mensaje = mensaje + "\n" + "El dni esta mal ingresado.";
			}
		}
		if (txtFechaNCliente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Fecha Nacimiento esta vacío";
		} else {
			if (convertirFecha(txtFechaNCliente.getText()) == null) {
				mensaje = mensaje
						+ "\n"
						+ "La fecha no esta bien ingresada dd-mm-aaaa ej: 23-12-1980.";
			}
		}
		if (txtNombreCliente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Nombre esta vacío";
		} else {
			if (!sonSoloLetras(txtNombreCliente.getText())) {
				mensaje = mensaje + "\n"
						+ "El campo nombre no puede contener numeros";
			}
		}
		if (txtApellidoCliente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Apellido esta vacío";
		} else {
			if (!sonSoloLetras(txtApellidoCliente.getText())) {
				mensaje = mensaje + "\n"
						+ "El campo apellido no puede contener numeros";
			}
		}
		if (txtTelefonoCliente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Telefono esta vacío";
		} else {
			if (!sonSoloNumeros(txtTelefonoCliente.getText())) {
				mensaje = mensaje + "\n"
						+ "El campo telefono no puede contener letras";
			}
		}
		if (txtDomicilioCliente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Domicilio esta vacío";
		} else {
			if (sonSoloLetras(txtDomicilioCliente.getText())
					|| sonSoloNumeros(txtDomicilioCliente.getText())) {
				mensaje = mensaje
						+ "\n"
						+ "El campo Domicilio debe contener solo letras y numeros";
			}
		}
		if (txtSexoCliente.getSelectedIndex() == 0) {
			mensaje = mensaje + "\n" + "Seleccione sexo Masculino o Femenino";
		}
		if (txtNacionalidadCliente.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Nacionalidad esta vacío";
		} else {
			if (!sonSoloLetras(txtNacionalidadCliente.getText())) {
				mensaje = mensaje + "\n"
						+ "El campo Nacionalidad no puede contener números";
			}
		}
	}

	private boolean sonSoloNumeros(String cadena) {
		for (int i = 0; i < cadena.length(); i++) {
			char c = cadena.charAt(i);
			if (!Character.isDigit(c))
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