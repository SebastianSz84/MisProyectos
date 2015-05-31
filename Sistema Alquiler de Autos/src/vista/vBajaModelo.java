package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.ModeloDTO;
import controlador.SistemaAlquilerAutos;

public class vBajaModelo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla
	private SistemaAlquilerAutos sistema;

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
	private JButton btnBajaModelo;
	private JButton btnBuscarModelo;

	private JPanel panelPrincipal;
	private JPanel panelBuscarModelo;
	private JPanel panel;
	private JPanel panelInferior;

	// constructor
	public vBajaModelo(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(465, 400);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			panel = new JPanel();
			setContentPane(panel);
			panel.setLayout(null);
			panel.setBounds(0, 0, getWidth(), getHeight());

			panelBuscarModelo = new JPanel();
			panelBuscarModelo.setLayout(null);
			panelBuscarModelo.setBounds(0, 0, 465, 40);

			panelPrincipal = new JPanel();
			panelPrincipal.setLayout(null);
			panelPrincipal.setBounds(0, 40, 465, 280);

			panelInferior = new JPanel();
			panelInferior.setLayout(null);
			panelInferior.setBounds(0, 320, 465, 55);

			lblCodigoModelo = new JLabel();
			lblCodigoModelo.setBounds(20, 15, 140, 25);
			txtCodigoModelo = new JTextField();
			txtCodigoModelo.setBounds(180, 15, 160, 25);
			btnBuscarModelo = new JButton();
			btnBuscarModelo.setBounds(360, 15, 80, 25);

			lblMarca = new JLabel();
			lblMarca.setBounds(20, 15, 140, 25);
			txtMarca = new JTextField();
			txtMarca.setBounds(180, 15, 160, 25);
			lblModelo = new JLabel();
			lblModelo.setBounds(20, 55, 140, 25);
			txtModelo = new JTextField();
			txtModelo.setBounds(180, 55, 160, 25);
			lblDatosMotor = new JLabel();
			lblDatosMotor.setBounds(20, 95, 140, 25);
			txtDatosMotor = new JTextField();
			txtDatosMotor.setBounds(180, 95, 160, 25);
			lblDatosSeguridad = new JLabel();
			lblDatosSeguridad.setBounds(20, 135, 140, 25);
			txtDatosSeguridad = new JTextField();
			txtDatosSeguridad.setBounds(180, 135, 160, 25);
			lblTipo = new JLabel();
			lblTipo.setBounds(20, 175, 140, 25);
			String[] listaTipos = { "(Seleccione)", "Económico", "Compacto",
					"Premium", "Minivan", "Camionetas" };
			txtTipo = new JComboBox(listaTipos);
			txtTipo.setBounds(180, 175, 160, 25);
			lblCostoDiario = new JLabel();
			lblCostoDiario.setBounds(20, 215, 140, 25);
			txtCostoDiario = new JTextField();
			txtCostoDiario.setBounds(180, 215, 160, 25);
			lblCostoExcedente = new JLabel();
			lblCostoExcedente.setBounds(20, 255, 140, 25);
			txtCostoExcedente = new JTextField();
			txtCostoExcedente.setBounds(180, 255, 160, 25);

			btnBajaModelo = new JButton();
			btnBajaModelo.setBounds(172, 15, 121, 25);

			panelBuscarModelo.add(lblCodigoModelo);
			panelBuscarModelo.add(txtCodigoModelo);
			panelBuscarModelo.add(btnBuscarModelo);

			panelPrincipal.add(lblMarca);
			panelPrincipal.add(txtMarca);
			panelPrincipal.add(lblModelo);
			panelPrincipal.add(txtModelo);
			panelPrincipal.add(lblDatosMotor);
			panelPrincipal.add(txtDatosMotor);
			panelPrincipal.add(lblDatosSeguridad);
			panelPrincipal.add(txtDatosSeguridad);
			panelPrincipal.add(lblTipo);
			panelPrincipal.add(txtTipo);
			panelPrincipal.add(lblCostoDiario);
			panelPrincipal.add(txtCostoDiario);
			panelPrincipal.add(lblCostoExcedente);
			panelPrincipal.add(txtCostoExcedente);

			panelInferior.add(btnBajaModelo);

			panel.add(panelBuscarModelo);
			panel.add(panelPrincipal);
			panel.add(panelInferior);

			lblCodigoModelo.setText("Código de Modelo:");
			lblMarca.setText("Marca:");
			lblModelo.setText("Modelo:");
			lblDatosMotor.setText("Datos del motor:");
			lblDatosSeguridad.setText("Datos de seguridad:");
			lblTipo.setText("Tipo:");
			lblCostoDiario.setText("Costo Diario:");
			lblCostoExcedente.setText("Costo Excedente:");

			btnBajaModelo.setText("Dar de Baja");
			btnBuscarModelo.setText("Buscar");

			btnBajaModelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (sistema.eliminarModelo(txtCodigoModelo.getText())) {
						JOptionPane.showMessageDialog(null,
								"Se ha dado de baja el modelo", "Éxito",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null,
								"No se pudo dar de baja el modelo" + "\n"
										+ "porque tiene Automóviles ocupados",
								"Error", JOptionPane.ERROR_MESSAGE);
					}
					borrarCampos();
					btnBajaModelo.setEnabled(false);
				}

			});

			btnBuscarModelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					String codigoModelo = txtCodigoModelo.getText();
					ModeloDTO mod = sistema.mostrarModelo(codigoModelo);
					if (mod != null) {
						ocultarCampos(true);
						cargarDatos(mod);

						btnBajaModelo.setEnabled(true);
					} else {
						txtCodigoModelo.setText(txtCodigoModelo.getText()
								+ " <--- Modelo inexistente");
						txtCodigoModelo.selectAll();
						btnBuscarModelo.transferFocusBackward();
						ocultarCampos(true);
					}
				}
			});

			ocultarCampos(true);
			setTitle("Baja de Modelo");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cargarDatos(ModeloDTO mod) {
		txtModelo.setText(mod.getModelo());
		txtDatosMotor.setText(mod.getDatosMotor());
		txtMarca.setText(mod.getMarca());
		txtTipo.setSelectedItem(mod.getTipo());
		txtCostoDiario.setText(Float.toString(mod.getCostoDiario()));
		txtCostoExcedente.setText(Float.toString(mod.getCostoExcedente()));
		txtDatosSeguridad.setText(mod.getDatosSeguridad());
	}

	private void ocultarCampos(boolean ocultar) {
		for (Component c : panelPrincipal.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setEnabled(!ocultar);
		}
		txtTipo.setEnabled(!ocultar);
		btnBajaModelo.setEnabled(!ocultar);
	}

	private void borrarCampos() {
		for (Component c : panel.getComponents()) {
			if (c instanceof JTextField)
				((JTextField) c).setText("");
		}
		txtTipo.setSelectedIndex(0);
	}
}