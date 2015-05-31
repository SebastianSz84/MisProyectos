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

import modelo.ClienteDTO;
import controlador.SistemaAlquilerAutos;

public class vBajaCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla

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
	private JButton btnBajaCliente;
	private JButton btnBuscarCliente;

	private JPanel panel;
	private JPanel panelBuscarDNI;
	private JPanel panelCentral;
	private JPanel panelInferior;

	private SistemaAlquilerAutos sistema;

	// constructor
	public vBajaCliente(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(500, 400);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(0, 0, 500, 400);
			setContentPane(panel);
			panelBuscarDNI = new JPanel();
			panelBuscarDNI.setLayout(null);
			panelBuscarDNI.setBounds(0, 0, 500, 40);
			panelCentral = new JPanel();
			panelCentral.setLayout(null);
			panelCentral.setBounds(0, 40, 500, 280);
			panelInferior = new JPanel();
			panelInferior.setLayout(null);
			panelInferior.setBounds(0, 335, 500, 55);

			panel.add(panelBuscarDNI);
			panel.add(panelCentral);
			panel.add(panelInferior);

			lblDNICliente = new JLabel();
			lblDNICliente.setBounds(20, 15, 220, 25);
			txtDNICliente = new JTextField();
			txtDNICliente.setBounds(240, 15, 140, 25);
			btnBuscarCliente = new JButton();
			btnBuscarCliente.setBounds(395, 15, 80, 25);
			btnBuscarCliente.setText("Buscar");

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

			btnBajaCliente = new JButton();
			btnBajaCliente.setBounds(195, 0, 110, 25);

			panelBuscarDNI.add(lblDNICliente);
			panelBuscarDNI.add(txtDNICliente);
			panelBuscarDNI.add(btnBuscarCliente);

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
			panelInferior.add(btnBajaCliente);

			lblDNICliente.setText("DNI:");
			lblFechaNCliente.setText("Fecha de Nacimiento (dd-mm-aaaa):");
			lblNombreCliente.setText("Nombre:");
			lblApellidoCliente.setText("Apellido:");
			lblTelefonoCliente.setText("Telefono:");
			lblDomicilioCliente.setText("Domicilio:");
			lblSexoCliente.setText("Sexo:");
			lblNacionalidadCliente.setText("Nacionalidad:");

			btnBajaCliente.setText("Dar de Baja");
			btnBajaCliente.setEnabled(false);
			btnBuscarCliente.setText("Buscar");

			btnBajaCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					String dni = txtDNICliente.getText();
					if (sistema.eliminarCliente(Integer.parseInt(dni))) {
						JOptionPane.showMessageDialog(null,
								"El cliente se ha dado de baja correctamente",
								"Éxito", JOptionPane.INFORMATION_MESSAGE);
						borrarCampos();
						btnBajaCliente.setEnabled(false);
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"No puede eliminar el cliente porque\naún tiene reservas o alquileres activos",
										"Error", JOptionPane.ERROR_MESSAGE);
					}
				}

			});

			btnBuscarCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					String dni = txtDNICliente.getText();
					if (dni.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Ingrese el DNI",
								"Error", JOptionPane.ERROR_MESSAGE);
					} else {
						if (sonSoloNumeros(dni)) {
							ClienteDTO cli = sistema.mostrarCliente(Integer
									.parseInt(dni));
							if (cli != null) {
								SimpleDateFormat formatoFecha = new SimpleDateFormat(
										"dd-MM-yyyy");
								txtNombreCliente.setText(cli.getNombre());
								txtApellidoCliente.setText(cli.getApellido());
								txtFechaNCliente.setText(formatoFecha
										.format(cli.getFechaNac()));
								txtDomicilioCliente.setText(cli.getDomicilio());
								if (cli.getSexo().equals("M")) {
									txtSexoCliente.setSelectedIndex(1);
								} else {
									txtSexoCliente.setSelectedIndex(2);
								}
								txtNacionalidadCliente.setText(cli
										.getNacionalidad());
								txtTelefonoCliente.setText(cli.getTelefono());
								btnBajaCliente.setEnabled(true);
							} else {
								txtDNICliente.setText(txtDNICliente.getText()
										+ " <--- El cliente no existe");
								btnBajaCliente.setEnabled(false);
								txtDNICliente.selectAll();
								btnBuscarCliente.transferFocusBackward();
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"El DNI está mal ingresado", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});

			borrarCampos();
			ocultarCampos(true);
			setTitle("Baja de Cliente");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void borrarCampos() {
		for (Component c : panelCentral.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setText("");
		}
		for (Component c : panelBuscarDNI.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setText("");
		}
	}

	private void ocultarCampos(boolean ocultar) {

		for (Component c : panelCentral.getComponents()) {
			if (c instanceof JTextField || c instanceof JComboBox
					|| c instanceof JButton) {
				c.setEnabled(!ocultar);
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
}