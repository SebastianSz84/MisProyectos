package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Sistema;

public class AltaEmpDep extends JFrame {
	private Sistema sistema;

	private JPanel panel;

	private JLabel lblLegajo;
	private JTextField txtLegajo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDomicilio;
	private JTextField txtDomicilio;
	private JLabel lblSueldo;
	private JTextField txtSueldo;

	private JButton btnAceptar;
	private JButton btnCancelar;

	private String mensaje;

	public AltaEmpDep(Sistema sist) {
		super();
		sistema = sist;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(320, 280);

		panel = new JPanel();
		setContentPane(panel);
		panel.setLayout(null);

		lblLegajo = new JLabel();
		lblLegajo.setBounds(20, 20, 110, 25);
		lblLegajo.setText("Legajo");
		txtLegajo = new JTextField();
		txtLegajo.setBounds(130, 20, 150, 25);
		lblNombre = new JLabel();
		lblNombre.setBounds(20, 60, 110, 25);
		lblNombre.setText("Nombre");
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 60, 150, 25);
		lblDomicilio = new JLabel();
		lblDomicilio.setBounds(20, 100, 110, 25);
		lblDomicilio.setText("Domicilio");
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(130, 100, 150, 25);
		lblSueldo = new JLabel();
		lblSueldo.setBounds(20, 140, 110, 25);
		lblSueldo.setText("Sueldo");
		txtSueldo = new JTextField();
		txtSueldo.setBounds(130, 140, 150, 25);

		btnAceptar = new JButton();
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(50, 180, 100, 25);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (camposValidos()) {
					if (sistema.agregarEmpleadoEnDependencia(
							txtNombre.getText(), txtDomicilio.getText(),
							Integer.parseInt(txtLegajo.getText()),
							Float.parseFloat(txtSueldo.getText()))) {
						JOptionPane.showMessageDialog(null,
								"Empleado agregado correctamente", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null,
								"El legajo ya existe", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"Hay conflictos en los campos:" + mensaje, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(160, 180, 100, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		panel.add(btnAceptar);
		panel.add(btnCancelar);
		panel.add(lblDomicilio);
		panel.add(txtDomicilio);
		panel.add(lblLegajo);
		panel.add(txtLegajo);
		panel.add(lblNombre);
		panel.add(txtNombre);
		panel.add(lblSueldo);
		panel.add(txtSueldo);

		setLocationRelativeTo(null);
	}

	private boolean camposValidos() {
		mensaje = "";

		if (txtLegajo.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Legajo está vacío";
		} else {
			try {
				int auxInt = Integer.parseInt(txtLegajo.getText());
			} catch (Exception e) {
				mensaje = mensaje + "\n"
						+ "El campo Legajo debe contener únicamente numeros";
			}
		}

		if (txtNombre.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Nombre está vacío";
		}

		if (txtDomicilio.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Domicilio está vacío";
		}

		if (txtSueldo.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Sueldo está vacío";
		} else {
			try {
				float auxFloat = Float.parseFloat(txtSueldo.getText());
			} catch (Exception e) {
				mensaje = mensaje
						+ "\n"
						+ "El campo Sueldo debe ser numérico (puede contener separador de miles '.')";
			}
		}

		if (mensaje.isEmpty()) {
			return true;
		}
		return false;
	}
}