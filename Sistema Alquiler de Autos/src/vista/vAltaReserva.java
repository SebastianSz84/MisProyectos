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

import modelo.ClienteDTO;
import modelo.ReservaDTO;
import controlador.SistemaAlquilerAutos;

public class vAltaReserva extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// defino los atributos de la pantalla
	private SistemaAlquilerAutos sistema;
	private ClienteDTO cliente;

	private JLabel lblTipo;
	private JComboBox txtTipo;
	private JLabel lblFechaInicio;
	private JTextField txtFechaInicio;
	private JLabel lblFechaFin;
	private JTextField txtFechaFin;
	private JButton btnAltaReserva;

	private JPanel panel;

	private String mensaje;

	// constructor
	public vAltaReserva(SistemaAlquilerAutos sist, ClienteDTO cli) {
		super();
		sistema = sist;
		cliente = cli;
		initGui();
	}

	// dibuja la pantalla
	private void initGui() {
		try {
			// define tamaño de la pantalla
			setSize(395, 200);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

			panel = new JPanel();
			panel.setLayout(null);
			panel.setBounds(getBounds());
			setContentPane(panel);

			lblTipo = new JLabel();
			lblTipo.setBounds(20, 15, 180, 25);
			String[] listaTipos = { "(Seleccione)", "Económico", "Compacto",
					"Premium", "Minivan", "Camionetas" };
			txtTipo = new JComboBox(listaTipos);
			txtTipo.setBounds(210, 15, 160, 25);
			lblFechaInicio = new JLabel();
			lblFechaInicio.setBounds(20, 55, 180, 25);
			txtFechaInicio = new JTextField();
			txtFechaInicio.setBounds(210, 55, 160, 25);
			lblFechaFin = new JLabel();
			lblFechaFin.setBounds(20, 95, 180, 25);
			txtFechaFin = new JTextField();
			txtFechaFin.setBounds(210, 95, 160, 25);

			btnAltaReserva = new JButton();
			btnAltaReserva.setBounds(142, 135, 111, 25);

			panel.add(lblTipo);
			panel.add(txtTipo);
			panel.add(lblFechaInicio);
			panel.add(txtFechaInicio);
			panel.add(lblFechaFin);
			panel.add(txtFechaFin);
			panel.add(btnAltaReserva);

			lblTipo.setText("Tipo:");
			lblFechaInicio.setText("Fecha de inicio (dd-mm-aaaa):");
			txtFechaInicio.setText("");
			lblFechaFin.setText("Fecha de fin (dd-mm-aaaa):");
			txtFechaFin.setText("");

			btnAltaReserva.setText("Generar");

			btnAltaReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					int dni = cliente.getDni();
					String tipo = txtTipo.getSelectedItem().toString();
					String fechaInicio = txtFechaInicio.getText();
					String fechaFin = txtFechaFin.getText();

					if (camposCorrectos()) {
						ReservaDTO res = sistema.generarReserva(dni, tipo,
								convertirFecha(fechaInicio),
								convertirFecha(fechaFin));
						if (res != null) {
							JOptionPane.showMessageDialog(
									null,
									"Se ha creado la reserva "
											+ Integer.toString(res
													.getNroReserva()), "Éxito",
									JOptionPane.INFORMATION_MESSAGE);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null,
									"No se ha creado la reserva", "Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Errores en los datos:" + mensaje, "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});

			setTitle("Generar Reserva");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean camposCorrectos() {
		mensaje = "";
		Date fechaInicio = null, fechaFin = null;

		if (txtTipo.getSelectedIndex() == 0) {
			mensaje = mensaje + "\n" + "El campo DNI de Cliente está vacío";
		}
		if (txtFechaInicio.getText().isEmpty()) {
			mensaje = mensaje + "\n" + "El campo Fecha de Inicio está vacío";
		} else {
			fechaInicio = convertirFecha(txtFechaInicio.getText());
			if (fechaInicio == null) {
				mensaje = mensaje + "\n"
						+ "El campo Fecha de Inicio tiene un error de formato";
			}
		}
		if (txtFechaFin.getText().isEmpty()) {
			mensaje = mensaje + "\nEl campo Fecha de Fin está vacío";
		} else {
			fechaFin = convertirFecha(txtFechaFin.getText());
			if (fechaFin == null) {
				mensaje = mensaje + "\n"
						+ "El campo Fecha de Fin tiene un error de formato";
			}
		}
		if (fechaInicio != null && fechaFin != null
				&& fechaFin.before(fechaInicio)) {
			mensaje = mensaje
					+ "\n"
					+ "La Fecha de Fin debe ser igual o posterior a la Fecha de Inicio";
		}
		if (mensaje.isEmpty()) {
			return true;
		}
		return false;
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