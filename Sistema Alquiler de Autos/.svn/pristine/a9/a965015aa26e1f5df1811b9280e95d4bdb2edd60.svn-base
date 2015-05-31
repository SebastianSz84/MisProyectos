package vista;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.ClienteDTO;
import controlador.SistemaAlquilerAutos;

public class vModificacionClienteWeb extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla

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
	private JLabel lblUsername;
	private JTextField txtUsername;
	private JLabel lblPassword;
	private JPasswordField txtPassword;

	private JButton btnModCliente;

	private JPanel panel;
	private JPanel panelCentral;
	private JPanel panelInferior;

	private String mensaje;
	private ClienteDTO cliente;

	private SistemaAlquilerAutos sistema;
	private vInterfazWeb interfazWeb;

	// constructor
//	public vModificacionClienteWeb(SistemaAlquilerAutos sistema,
//			ClienteDTO cliente) {
		public vModificacionClienteWeb(vInterfazWeb interfazWeb) {
		super();
		this.interfazWeb = interfazWeb;
		cliente = interfazWeb.getCliente();
		sistema = interfazWeb.getSistema();
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(405, 445);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(0, 0, 405, 445);
			setContentPane(panel);
			panelCentral = new JPanel();
			panelCentral.setLayout(null);
			panelCentral.setBounds(0, 0, 405, 375);
			panelInferior = new JPanel();
			panelInferior.setLayout(null);
			panelInferior.setBounds(0, 375, 405, 55);

			panel.add(panelCentral);
			panel.add(panelInferior);

			lblFechaNCliente = new JLabel();
			lblFechaNCliente.setBounds(20, 15, 220, 25);
			txtFechaNCliente = new JTextField();
			txtFechaNCliente.setBounds(240, 15, 140, 25);
			lblNombreCliente = new JLabel();
			lblNombreCliente.setBounds(20, 55, 220, 25);
			txtNombreCliente = new JTextField();
			txtNombreCliente.setBounds(240, 55, 140, 25);
			lblApellidoCliente = new JLabel();
			lblApellidoCliente.setBounds(20, 95, 220, 25);
			txtApellidoCliente = new JTextField();
			txtApellidoCliente.setBounds(240, 95, 140, 25);
			lblTelefonoCliente = new JLabel();
			lblTelefonoCliente.setBounds(20, 135, 220, 25);
			txtTelefonoCliente = new JTextField();
			txtTelefonoCliente.setBounds(240, 135, 140, 25);
			lblDomicilioCliente = new JLabel();
			lblDomicilioCliente.setBounds(20, 175, 220, 25);
			txtDomicilioCliente = new JTextField();
			txtDomicilioCliente.setBounds(240, 175, 140, 25);
			lblSexoCliente = new JLabel();
			lblSexoCliente.setBounds(20, 215, 220, 25);
			String[] listaSexo = { "(Seleccione)", "Masculino", "Femenino" };
			txtSexoCliente = new JComboBox(listaSexo);
			txtSexoCliente.setBounds(240, 215, 140, 25);
			txtSexoCliente.setSelectedIndex(0);
			lblNacionalidadCliente = new JLabel();
			lblNacionalidadCliente.setBounds(20, 255, 220, 25);
			txtNacionalidadCliente = new JTextField();
			txtNacionalidadCliente.setBounds(240, 255, 140, 25);
			lblUsername = new JLabel();
			lblUsername.setBounds(20, 295, 220, 25);
			txtUsername = new JTextField();
			txtUsername.setBounds(240, 295, 140, 25);
			txtUsername.setEnabled(false);
			lblPassword = new JLabel();
			lblPassword.setBounds(20, 335, 140, 25);
			txtPassword = new JPasswordField();
			txtPassword.setBounds(240, 335, 140, 25);

			btnModCliente = new JButton();
			btnModCliente.setBounds(127, 0, 151, 25);

			panelCentral.add(lblFechaNCliente);
			panelCentral.add(txtFechaNCliente);
			panelCentral.add(lblNombreCliente);
			panelCentral.add(txtNombreCliente);
			panelCentral.add(lblApellidoCliente);
			panelCentral.add(txtApellidoCliente);
			panelCentral.add(lblTelefonoCliente);
			panelCentral.add(txtTelefonoCliente);
			panelCentral.add(lblDomicilioCliente);
			panelCentral.add(txtDomicilioCliente);
			panelCentral.add(lblSexoCliente);
			panelCentral.add(txtSexoCliente);
			panelCentral.add(lblNacionalidadCliente);
			panelCentral.add(txtNacionalidadCliente);
			panelCentral.add(lblUsername);
			panelCentral.add(txtUsername);
			panelCentral.add(lblPassword);
			panelCentral.add(txtPassword);
			panelInferior.add(btnModCliente);

			lblFechaNCliente.setText("Fecha de Nacimiento (dd-mm-aaaa):");
			lblNombreCliente.setText("Nombre:");
			lblApellidoCliente.setText("Apellido:");
			lblTelefonoCliente.setText("Telefono:");
			lblDomicilioCliente.setText("Domicilio:");
			lblSexoCliente.setText("Sexo:");
			lblNacionalidadCliente.setText("Nacionalidad:");
			lblUsername.setText("Nombre de usuario:");
			lblPassword.setText("Contraseña:");

			btnModCliente.setText("Cambiar datos");

			btnModCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					mensaje = "";
					validarCampos();

					if (mensaje.isEmpty()) {
						int dni = cliente.getDni();
						String nom = txtNombreCliente.getText();
						String apellido = txtApellidoCliente.getText();
						Date fechaNac = convertirFecha(txtFechaNCliente
								.getText());
						String domicilio = txtDomicilioCliente.getText();
						String nacionalidad = txtNacionalidadCliente.getText();
						String tel = txtTelefonoCliente.getText();
						String sex;
						String pass = new String(txtPassword.getPassword());

						if (txtSexoCliente.getSelectedIndex() == 1) {
							sex = "M";
						} else {
							sex = "F";
						}

						sistema.modificacionCliente(dni, nom, apellido,
								fechaNac, domicilio, sex, nacionalidad, pass,
								tel);
						JOptionPane.showMessageDialog(null,
								"El cliente se ha modificado correctamente",
								"Éxito", JOptionPane.INFORMATION_MESSAGE);
						actualizarClienteWeb();
						dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"Errores en los datos:" + mensaje, "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			});

			recuperarDatos();
			setTitle("Modificar Cliente");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void validarCampos() {
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
			if (sonSoloLetras(txtDomicilioCliente.getText())) {
				mensaje = mensaje
						+ "\n"
						+ "El campo Domicilio debe contener solo letras y numeros";
			}
		}
		if ((String) txtSexoCliente.getSelectedItem() == "(Seleccione)") {
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
		String pwd = new String(txtPassword.getPassword());
		if (pwd.isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Contraseña está vacío";
		} else {
			if (sonSoloNumeros(pwd)) {
				mensaje = mensaje
						+ "\n"
						+ "El campo Contraseña debe contener letras, y puede contener números";
			}
		}
	}

	private void recuperarDatos() {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

		txtNombreCliente.setText(cliente.getNombre());
		txtApellidoCliente.setText(cliente.getApellido());
		txtFechaNCliente.setText(formatoFecha.format(cliente.getFechaNac()));
		txtDomicilioCliente.setText(cliente.getDomicilio());

		if (cliente.getSexo().equals("M")) {
			txtSexoCliente.setSelectedIndex(1);
		} else {
			txtSexoCliente.setSelectedIndex(2);
		}

		txtNacionalidadCliente.setText(cliente.getNacionalidad());
		txtTelefonoCliente.setText(cliente.getTelefono());
		txtUsername.setText(cliente.getUsername());
		txtPassword.setText(cliente.getPassword());
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

	private void actualizarClienteWeb() {
		int dni = cliente.getDni();
		interfazWeb.setCliente(sistema.mostrarCliente(dni));
	}
}