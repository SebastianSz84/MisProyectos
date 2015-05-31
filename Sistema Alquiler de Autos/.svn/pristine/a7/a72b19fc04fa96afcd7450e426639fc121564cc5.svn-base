package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import modelo.ClienteDTO;
import controlador.SistemaAlquilerAutos;

public class vInicioSesion extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SistemaAlquilerAutos sistema;

	private JPanel panel;
	private JLabel lblUser;
	private JTextField txtUser;
	private JLabel lblPass;
	private JPasswordField txtPass;
	private JButton btnAceptar;
	private JButton btnCancelar;

	public vInicioSesion(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGUI();
	}

	private void initGUI() {
		try {
			setSize(300, 150);
			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(0, 0, 300, 150);

			lblUser = new JLabel();
			lblUser.setText("Nombre de usuario:");
			lblUser.setBounds(25, 15, 140, 25);
			txtUser = new JTextField();
			txtUser.setBounds(175, 15, 100, 25);

			lblPass = new JLabel();
			lblPass.setText("Contraseña:");
			lblPass.setBounds(25, 40, 140, 25);
			txtPass = new JPasswordField();
			txtPass.setBounds(175, 40, 100, 25);

			btnAceptar = new JButton();
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(50, 80, 90, 25);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (camposCompletos()) {
						ClienteDTO cli = sistema.iniciarSesion(
								txtUser.getText(),
								new String(txtPass.getPassword()));
						if (cli != null && cli.isActivo()) {
							vInterfazWeb vistaMenuWeb = new vInterfazWeb(
									sistema, cli);
							vistaMenuWeb.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null,
									"Usuario y/o contraseña incorrectos",
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});

			btnCancelar = new JButton();
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(160, 80, 90, 25);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			panel.add(lblUser);
			panel.add(txtUser);
			panel.add(lblPass);
			panel.add(txtPass);
			panel.add(btnAceptar);
			panel.add(btnCancelar);
			setContentPane(panel);

			setTitle("Iniciar Sesión");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private boolean camposCompletos() {
		if (txtUser.getText().isEmpty() || txtPass.getPassword().length == 0) {
			JOptionPane.showMessageDialog(null, "Debe completar los campos",
					"Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}