package vista;

import java.awt.Component;
import java.awt.Container;
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
import controlador.SistemaAlquilerAutos;

public class vBajaAutomovil extends JFrame {

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
	private JButton btnBajaAutomovil;

	private Container panelPrincipal;
	private Container panel;
	private Container panelInferior;
	private Container panelBuscarAuto;

	private SistemaAlquilerAutos sistema;

	// constructor
	public vBajaAutomovil(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(455, 240);
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
			panelPrincipal.setBounds(0, 40, getWidth(), 120);

			panelInferior = new JPanel();
			panelInferior.setLayout(null);
			panelInferior.setBounds(0, 160, getWidth(), 40);

			lblPatente = new JLabel();
			lblPatente.setBounds(20, 15, 140, 25);
			txtPatente = new JTextField();
			txtPatente.setBounds(170, 15, 160, 25);
			btnBuscarAuto = new JButton();
			btnBuscarAuto.setBounds(350, 15, 80, 25);

			lblPatente.setText("Patente:");
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
							btnBajaAutomovil.setEnabled(true);
						} else {
							txtPatente.setText(txtPatente.getText()
									+ " <--- Automóvil inexistente");
							btnBajaAutomovil.setEnabled(false);
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

			lblAnio.setText("Año:");
			lblCombustible.setText("Nivel del Combustible:");
			lblKilometraje.setText("Kilometraje:");

			panelPrincipal.add(lblAnio);
			panelPrincipal.add(txtAnio);
			panelPrincipal.add(lblCombustible);
			panelPrincipal.add(txtCombustible);
			panelPrincipal.add(lblKilometraje);
			panelPrincipal.add(txtKilometraje);

			btnBajaAutomovil = new JButton();
			btnBajaAutomovil.setBounds(157, 15, 141, 25);

			btnBajaAutomovil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (sistema.eliminarAutomovil(txtPatente.getText())) {
						JOptionPane
								.showMessageDialog(
										null,
										"El Automóvil se ha dado de baja correctamente",
										"Error",
										JOptionPane.INFORMATION_MESSAGE);
						borrarCampos();
					} else {
						JOptionPane
								.showMessageDialog(
										null,
										"No se puede dar de baja el automóvil,"
												+ "\n"
												+ "aún tiene reservas y/o alquileres activos.",
										"Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			btnBajaAutomovil.setText("Dar de Baja");

			panelInferior.add(btnBajaAutomovil);

			panel.add(panelBuscarAuto);
			panel.add(panelPrincipal);
			panel.add(panelInferior);

			ocultarCampos(true);
			setTitle("Baja de Automóvil");
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
		btnBajaAutomovil.setEnabled(!ocultar);
		for (Component c : panelPrincipal.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setEnabled(!ocultar);
		}
	}
}