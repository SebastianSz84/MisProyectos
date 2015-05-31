package vista;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import modelo.ClienteDTO;
import controlador.SistemaAlquilerAutos;

public class vInterfazWeb extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SistemaAlquilerAutos sistema;
	private ClienteDTO cliente;

	private JMenuBar mbMenuIW;
	private JMenu jmCliente;
	private JMenuItem jmiModificar;
	private JMenu jmReserva;
	private JMenuItem jmiGenerar;
	private JMenuItem jmiCancelar;
	private JMenu jmInterfazWeb;
	private JMenuItem jmiSalirIW;

	public vInterfazWeb(SistemaAlquilerAutos sist, ClienteDTO cli) {
		super();
		sistema = sist;
		cliente = cli;
		initGUI();
	}

	private void initGUI() {
		try {
			setSize(400, 400);

			mbMenuIW = new JMenuBar();
			setJMenuBar(mbMenuIW);

			mbMenuIW.setPreferredSize(new Dimension(400, 21));

			jmCliente = new JMenu();
			jmCliente.setPreferredSize(new Dimension(60, 21));
			jmCliente.setText("Cliente");

			jmiModificar = new JMenuItem();
			jmiModificar.setText("Modificar");
			jmiModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// vModificacionClienteWeb vista = new
					// vModificacionClienteWeb(sistema, cliente);
					vModificacionClienteWeb vista = new vModificacionClienteWeb(
							getInterfazWeb());
					vista.setVisible(true);
				}
			});
			jmCliente.add(jmiModificar);

			mbMenuIW.add(jmCliente);

			jmReserva = new JMenu();
			jmReserva.setPreferredSize(new Dimension(60, 21));
			jmReserva.setText("Reserva");

			jmiGenerar = new JMenuItem();
			jmiGenerar.setText("Generar");
			jmiGenerar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vAltaReserva vista = new vAltaReserva(sistema, cliente);
					vista.setVisible(true);
				}
			});
			jmReserva.add(jmiGenerar);

			jmiCancelar = new JMenuItem();
			jmiCancelar.setText("Cancelar");
			jmiCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vBajaReserva vista = new vBajaReserva(sistema);
					vista.setVisible(true);
				}
			});
			jmReserva.add(jmiCancelar);

			mbMenuIW.add(jmReserva);

			jmInterfazWeb = new JMenu();
			jmInterfazWeb.setPreferredSize(new Dimension(85, 21));
			jmInterfazWeb.setText("Interfaz Web");

			jmiSalirIW = new JMenuItem();
			jmiSalirIW.setText("Salir");
			jmiSalirIW.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (JOptionPane.showConfirmDialog(null,
							"¿Está seguro que desea salir?", "Salir",
							JOptionPane.YES_NO_OPTION) == 0) {
						dispose();
					}
				}
			});

			jmInterfazWeb.add(jmiSalirIW);

			mbMenuIW.add(jmInterfazWeb);

			setTitle("Interfaz Web");
			setResizable(false);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public vInterfazWeb getInterfazWeb() {
		return this;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public SistemaAlquilerAutos getSistema() {
		return sistema;
	}
}