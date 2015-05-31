package vista;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import modelo.FacturaDTO;
import controlador.SistemaAlquilerAutos;

public class vMostrarFactura extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SistemaAlquilerAutos sistema;
	private FacturaDTO factura;

	private JPanel panel;
	private JPanel panelBuscarFactura;
	private JPanel panelCentral;

	private JLabel lblNroFactura;
	private JTextField txtNroFactura;
	private JButton btnBuscarFactura;

	private JLabel lblFecha;
	private JTextField txtFecha;
	private JLabel lblTipoFactura;
	private JTextField txtTipoFactura;
	private JLabel lblNroTran;
	private JTextField txtNroTran;
	private JLabel lblDNICliente;
	private JTextField txtDNICliente;
	private JLabel lblNombreCliente;
	private JTextField txtNombreCliente;
	private JLabel lblApellidoCliente;
	private JTextField txtApellidoCliente;
	private JLabel lblImporteTotal;
	private JTextField txtImporteTotal;
	private JButton btnVerDetalle;

	public vMostrarFactura(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGUI();
	}

	private void initGUI() {
		try {
			setSize(540, 445);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(getBounds());
			setContentPane(panel);

			panelBuscarFactura = new JPanel();
			panelBuscarFactura.setLayout(null);
			panelBuscarFactura.setBounds(0, 0, getWidth(), 40);

			lblNroFactura = new JLabel();
			lblNroFactura.setBounds(20, 15, 220, 25);
			txtNroFactura = new JTextField();
			txtNroFactura.setBounds(240, 15, 180, 25);
			btnBuscarFactura = new JButton();
			btnBuscarFactura.setBounds(435, 15, 80, 25);

			btnBuscarFactura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					txtNroFactura.setText(txtNroFactura.getText().trim());
					if (!txtNroFactura.getText().isEmpty()) {
						factura = sistema.mostrarFactura(Integer
								.parseInt(txtNroFactura.getText()));
						if (factura != null) {
							cargarDatos(factura);
							btnVerDetalle.setEnabled(true);
						} else {
							txtNroFactura.setText(txtNroFactura.getText()
									+ " <--- Factura inexistente");
							txtNroFactura.selectAll();
							btnBuscarFactura.transferFocusBackward();
							btnVerDetalle.setEnabled(false);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar el Número de Factura", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			lblNroFactura.setText("Número de Factura:");
			btnBuscarFactura.setText("Buscar");

			panelBuscarFactura.add(lblNroFactura);
			panelBuscarFactura.add(txtNroFactura);
			panelBuscarFactura.add(btnBuscarFactura);

			panel.add(panelBuscarFactura);

			panelCentral = new JPanel();
			panelCentral.setLayout(null);
			panelCentral.setBounds(0, 40, getWidth(), 320);

			lblFecha = new JLabel();
			lblFecha.setBounds(20, 15, 220, 25);
			txtFecha = new JTextField();
			txtFecha.setBounds(240, 15, 180, 25);
			lblTipoFactura = new JLabel();
			lblTipoFactura.setBounds(20, 55, 220, 25);
			txtTipoFactura = new JTextField();
			txtTipoFactura.setBounds(240, 55, 180, 25);
			lblNroTran = new JLabel();
			lblNroTran.setBounds(20, 95, 220, 25);
			txtNroTran = new JTextField();
			txtNroTran.setBounds(240, 95, 180, 25);
			lblDNICliente = new JLabel();
			lblDNICliente.setBounds(20, 135, 220, 25);
			txtDNICliente = new JTextField();
			txtDNICliente.setBounds(240, 135, 180, 25);
			lblNombreCliente = new JLabel();
			lblNombreCliente.setBounds(20, 175, 220, 25);
			txtNombreCliente = new JTextField();
			txtNombreCliente.setBounds(240, 175, 180, 25);
			lblApellidoCliente = new JLabel();
			lblApellidoCliente.setBounds(20, 215, 220, 25);
			txtApellidoCliente = new JTextField();
			txtApellidoCliente.setBounds(240, 215, 180, 25);
			lblImporteTotal = new JLabel();
			lblImporteTotal.setBounds(20, 255, 220, 25);
			txtImporteTotal = new JTextField();
			txtImporteTotal.setBounds(240, 255, 180, 25);
			btnVerDetalle = new JButton();
			btnVerDetalle.setBounds(210, 295, 120, 25);

			lblFecha.setText("Fecha:");
			lblTipoFactura.setText("Tipo de Factura:");
			lblNroTran.setText("Número de Alquiler:");
			lblDNICliente.setText("DNI del Cliente:");
			lblNombreCliente.setText("Nombre del Cliente:");
			lblApellidoCliente.setText("Apellido del Cliente:");
			lblImporteTotal.setText("Importe Total:");
			btnVerDetalle.setText("Ver Detalle");

			btnVerDetalle.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vDetalleFactura vista = new vDetalleFactura(factura
							.getItems());
					vista.setVisible(true);
				}
			});

			panelCentral.add(lblFecha);
			panelCentral.add(txtFecha);
			panelCentral.add(lblTipoFactura);
			panelCentral.add(txtTipoFactura);
			panelCentral.add(lblNroTran);
			panelCentral.add(txtNroTran);
			panelCentral.add(lblDNICliente);
			panelCentral.add(txtDNICliente);
			panelCentral.add(lblNombreCliente);
			panelCentral.add(txtNombreCliente);
			panelCentral.add(lblApellidoCliente);
			panelCentral.add(txtApellidoCliente);
			panelCentral.add(lblImporteTotal);
			panelCentral.add(txtImporteTotal);
			panelCentral.add(btnVerDetalle);

			panel.add(panelCentral);

			ocultarCampos(true);
			setTitle("Mostrar Factura");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void cargarDatos(FacturaDTO fact) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

		txtFecha.setText(formatoFecha.format(fact.getFecha()));
		txtTipoFactura.setText(fact.getTipo());
		txtNroTran.setText(Integer.toString(fact.getNroTran()));
		txtDNICliente.setText(Integer.toString(fact.getDni()));
		txtNombreCliente.setText(fact.getNombre());
		txtApellidoCliente.setText(fact.getApellido());
		txtImporteTotal.setText(Float.toString(fact.getImpTotal()));
	}

	private void ocultarCampos(boolean ocultar) {
		for (Component c : panelCentral.getComponents()) {
			if (c instanceof JTextField) {
				c.setEnabled(!ocultar);
			}
		}
		btnVerDetalle.setEnabled(!ocultar);
	}
}