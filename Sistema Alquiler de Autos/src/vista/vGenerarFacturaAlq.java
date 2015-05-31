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

import modelo.AlquilerDTO;
import modelo.FacturaDTO;
import controlador.SistemaAlquilerAutos;

public class vGenerarFacturaAlq extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SistemaAlquilerAutos sistema;
	private String mensaje;

	private JPanel panel;
	private JPanel panelBuscarAlquiler;
	private JPanel panelCentral;
	private JPanel panelInferior;

	private JLabel lblNroAlquiler;
	private JTextField txtNroAlquiler;
	private JButton btnBuscarAlquiler;

	private JLabel lblDNICliente;
	private JTextField txtDNICliente;
	private JLabel lblNombreCliente;
	private JTextField txtNombreCliente;
	private JLabel lblApellidoCliente;
	private JTextField txtApellidoCliente;
	private JLabel lblFechaInicio;
	private JTextField txtFechaInicio;
	private JLabel lblFechaFin;
	private JTextField txtFechaFin;
	private JLabel lblFechaDevolucion;
	private JTextField txtFechaDevolucion;
	private JLabel lblObservCliente;
	private JTextField txtObservCliente;
	private JLabel lblObservDevolucion;
	private JTextField txtObservDevolucion;
	private JLabel lblTipoFactura;
	private JTextField txtTipoFactura;

	private JButton btnGenerarFactura;

	public vGenerarFacturaAlq(SistemaAlquilerAutos sist) {
		super();
		sistema = sist;
		initGUI();
	}

	private void initGUI() {
		try {
			setSize(540, 480);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(getBounds());
			setContentPane(panel);

			panelBuscarAlquiler = new JPanel();
			panelBuscarAlquiler.setLayout(null);
			panelBuscarAlquiler.setBounds(0, 0, getWidth(), 40);

			panelCentral = new JPanel();
			panelCentral.setLayout(null);
			panelCentral.setBounds(0, 40, getWidth(), 320);

			panelInferior = new JPanel();
			panelInferior.setLayout(null);
			panelInferior.setBounds(0, 360, getWidth(), 80);

			lblNroAlquiler = new JLabel();
			lblNroAlquiler.setBounds(20, 15, 220, 25);
			txtNroAlquiler = new JTextField();
			txtNroAlquiler.setBounds(240, 15, 180, 25);
			btnBuscarAlquiler = new JButton();
			btnBuscarAlquiler.setBounds(435, 15, 80, 25);

			btnBuscarAlquiler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtNroAlquiler.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null,
								"Debe ingresar el Número de Alquiler", "Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						AlquilerDTO alq = sistema.mostrarAlquiler(Integer
								.parseInt(txtNroAlquiler.getText()));
						if (alq != null) {
							if (alq.getFechaDevolucion() != null) {
								cargarDatos(alq);
								btnGenerarFactura.setEnabled(true);
								txtTipoFactura.setEnabled(true);
							} else {
								JOptionPane
										.showMessageDialog(
												null,
												"El Alquiler ingresado no registra fecha de devolución",
												"Error",
												JOptionPane.ERROR_MESSAGE);
							}
						} else {
							txtNroAlquiler.setText(txtNroAlquiler.getText()
									+ " <--- Alquiler inexistente");
							txtNroAlquiler.selectAll();
							btnBuscarAlquiler.transferFocusBackward();
							btnGenerarFactura.setEnabled(false);
							txtTipoFactura.setEnabled(false);
						}
					}
				}
			});

			lblNroAlquiler.setText("Número de Alquiler:");
			btnBuscarAlquiler.setText("Buscar");

			panelBuscarAlquiler.add(lblNroAlquiler);
			panelBuscarAlquiler.add(txtNroAlquiler);
			panelBuscarAlquiler.add(btnBuscarAlquiler);

			panel.add(panelBuscarAlquiler);

			lblDNICliente = new JLabel();
			lblDNICliente.setBounds(20, 15, 220, 25);
			txtDNICliente = new JTextField();
			txtDNICliente.setBounds(240, 15, 180, 25);
			lblNombreCliente = new JLabel();
			lblNombreCliente.setBounds(20, 55, 220, 25);
			txtNombreCliente = new JTextField();
			txtNombreCliente.setBounds(240, 55, 180, 25);
			lblApellidoCliente = new JLabel();
			lblApellidoCliente.setBounds(20, 95, 220, 25);
			txtApellidoCliente = new JTextField();
			txtApellidoCliente.setBounds(240, 95, 180, 25);
			lblFechaInicio = new JLabel();
			lblFechaInicio.setBounds(20, 135, 220, 25);
			txtFechaInicio = new JTextField();
			txtFechaInicio.setBounds(240, 135, 180, 25);
			lblFechaFin = new JLabel();
			lblFechaFin.setBounds(20, 175, 220, 25);
			txtFechaFin = new JTextField();
			txtFechaFin.setBounds(240, 175, 180, 25);
			lblFechaDevolucion = new JLabel();
			lblFechaDevolucion.setBounds(20, 215, 220, 25);
			txtFechaDevolucion = new JTextField();
			txtFechaDevolucion.setBounds(240, 215, 180, 25);
			lblObservCliente = new JLabel();
			lblObservCliente.setBounds(20, 255, 220, 25);
			txtObservCliente = new JTextField();
			txtObservCliente.setBounds(240, 255, 180, 25);
			lblObservDevolucion = new JLabel();
			lblObservDevolucion.setBounds(20, 295, 220, 25);
			txtObservDevolucion = new JTextField();
			txtObservDevolucion.setBounds(240, 295, 180, 25);

			lblDNICliente.setText("DNI:");
			lblNombreCliente.setText("Nombre:");
			lblApellidoCliente.setText("Apellido:");
			lblFechaInicio.setText("Fecha de inicio (dd-mm-aaaa):");
			lblFechaFin.setText("Fecha de fin (dd-mm-aaaa):");
			lblFechaDevolucion.setText("Fecha de devolución (dd-mm-aaaa):");
			lblObservCliente.setText("Observaciones del Cliente:");
			lblObservDevolucion.setText("Observaciones de Devolución:");

			panelCentral.add(lblDNICliente);
			panelCentral.add(txtDNICliente);
			panelCentral.add(lblNombreCliente);
			panelCentral.add(txtNombreCliente);
			panelCentral.add(lblApellidoCliente);
			panelCentral.add(txtApellidoCliente);
			panelCentral.add(lblFechaInicio);
			panelCentral.add(txtFechaInicio);
			panelCentral.add(lblFechaFin);
			panelCentral.add(txtFechaFin);
			panelCentral.add(lblFechaDevolucion);
			panelCentral.add(txtFechaDevolucion);
			panelCentral.add(lblObservCliente);
			panelCentral.add(txtObservCliente);
			panelCentral.add(lblObservDevolucion);
			panelCentral.add(txtObservDevolucion);

			panel.add(panelCentral);

			lblTipoFactura = new JLabel();
			lblTipoFactura.setBounds(20, 15, 220, 25);
			txtTipoFactura = new JTextField(1);
			txtTipoFactura.setBounds(240, 15, 180, 25);
			btnGenerarFactura = new JButton();
			btnGenerarFactura.setBounds(180, 55, 180, 25);

			btnGenerarFactura.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (validarDatos()) {
						FacturaDTO fact = sistema.generarFactura(
								Integer.parseInt(txtNroAlquiler.getText()),
								txtTipoFactura.getText());
						if (fact != null) {
							JOptionPane.showMessageDialog(
									null,
									"Se ha generado la factura "
											+ fact.getNroFactura(), "Éxito",
									JOptionPane.INFORMATION_MESSAGE);
							borrarCampos();
							ocultarCampos(true);
						} else {
							JOptionPane.showMessageDialog(null,
									"Error al generar la factura", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Errores en los datos:" + mensaje, "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			btnGenerarFactura.setText("Generar Factura");
			lblTipoFactura.setText("Tipo de Factura:");

			panelInferior.add(lblTipoFactura);
			panelInferior.add(txtTipoFactura);
			panelInferior.add(btnGenerarFactura);

			panel.add(panelInferior);

			borrarCampos();
			ocultarCampos(true);
			setTitle("Facturar Alquiler");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean validarDatos() {
		mensaje = "";
		if (txtTipoFactura.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Tipo de Factura está vacío";
		}
		if (mensaje.isEmpty()) {
			return true;
		}
		return false;
	}

	private void cargarDatos(AlquilerDTO alq) {
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

		txtDNICliente.setText(Integer.toString(alq.getDniCliente()));
		txtNombreCliente.setText(alq.getNombreCliente());
		txtApellidoCliente.setText(alq.getApellidoCliente());
		txtFechaInicio.setText(formatoFecha.format(alq.getFechaInicio()));
		txtFechaFin.setText(formatoFecha.format(alq.getFechaFin()));
		txtFechaDevolucion
				.setText(formatoFecha.format(alq.getFechaDevolucion()));
		txtObservCliente.setText(alq.getObservacionesCliente());
		txtObservDevolucion.setText(alq.getObservacionesDevolucion());
	}

	private void ocultarCampos(boolean ocultar) {
		for (Component c : panelCentral.getComponents()) {
			if (c instanceof JTextField) {
				c.setEnabled(!ocultar);
			}
		}
		txtTipoFactura.setEnabled(!ocultar);
		btnGenerarFactura.setEnabled(!ocultar);
	}

	private void borrarCampos() {
		for (Component c : panelCentral.getComponents()) {
			if (c instanceof JTextField) {
				((JTextField) c).setText("");
			}
		}
		txtTipoFactura.setText("");
	}
}