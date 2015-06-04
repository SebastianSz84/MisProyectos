package vista;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.Sistema;

public class AltaEmpCon extends JFrame {
	private Sistema sistema;

	private JPanel panel;

	private JLabel lblLegajo;
	private JTextField txtLegajo;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JLabel lblDomicilio;
	private JTextField txtDomicilio;

	private JButton btnAceptar;
	private JButton btnCancelar;

	public AltaEmpCon(Sistema sist) {
		super();
		sistema = sist;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(260, 160);
		setLayout(null);

		panel = new JPanel();
		setContentPane(panel);

		lblLegajo = new JLabel();
		lblLegajo.setBounds(20, 20, 110, 25);
		txtLegajo = new JTextField();
		txtLegajo.setBounds(130, 20, 110, 25);
		lblNombre = new JLabel();
		lblNombre.setBounds(20, 60, 110, 25);
		txtNombre = new JTextField();
		txtNombre.setBounds(130, 60, 110, 25);
		lblDomicilio = new JLabel();
		lblDomicilio.setBounds(20, 100, 110, 25);
		txtDomicilio = new JTextField();
		txtDomicilio.setBounds(130, 100, 110, 25);

		btnAceptar = new JButton();
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(50, 120, 70, 25);

		btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(50, 120, 70, 25);

		panel.add(btnAceptar);
		panel.add(btnCancelar);
		panel.add(lblDomicilio);
		panel.add(txtDomicilio);
		panel.add(lblLegajo);
		panel.add(txtLegajo);
		panel.add(lblNombre);
		panel.add(txtNombre);

		setLocationRelativeTo(null);
	}
}