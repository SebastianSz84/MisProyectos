package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import controlador.SistemaAlquilerAutos;

public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SistemaAlquilerAutos sist;

	private JMenuBar mbMenuPrincipal;
	private JMenu jmabmClientes;
	private JMenuItem jmiAltaclientes;
	private JMenuItem jmiBajaClientes;
	private JMenuItem jmiModificacionClientes;
	private JMenu jmabmModelos;
	private JMenuItem jmiAltaModelo;
	private JMenuItem jmiBajaModelo;
	private JMenuItem jmiModificacionModelo;
	private JMenu jmabmAutomoviles;
	private JMenuItem jmiAltaAutomovil;
	private JMenuItem jmiBajaAutomovil;
	private JMenuItem jmiModificacionAutomovil;
	private JMenu jmgestionReservas;
	private JMenuItem jmiBajaReserva;
	private JMenu jmgestionAlquilers;
	private JMenuItem jmiAltaAlquierReserva;
	private JMenuItem jmiAltaAlquilerLocal;
	private JMenuItem jmiRegistrarDevolucion;
	private JMenu jmInterfazWeb;
	private JMenuItem jmiUsuarioNuevo;
	private JMenuItem jmiIniciarSesion;
	private JMenu jmFacturas;
	private JMenuItem jmiGenFactxAlquiler;
	private JMenuItem jmiMostrarFact;
	private JMenu jmSistema;
	private JMenuItem jmiSalir;

	public static void main(String[] args) {
		MenuPrincipal inst = new MenuPrincipal();
		inst.setVisible(true);
	}

	public MenuPrincipal() {
		super();
		sist = new SistemaAlquilerAutos();

		//Casos de prueba
		// sist.registrarCliente(1, "nomCliente1", "apeCliente1", new Date(),
		// "Balcarce 50", "M", "Namibio", "123456789", "cli1", "cli1");
		// sist.registrarCliente(2, "nomCliente2", "apeCliente2", new Date(),
		// "Balcarce 50", "M", "Namibio", "123456789", "", "");
		// sist.registrarModelo("TT13", "Audi", "TT Roadster", "3.0 Ti",
		// "4WD, Airbag", "Premium", Float.parseFloat("500"),
		// Float.parseFloat("25"));
		// sist.registrarModelo("CARRERA911", "Porsche", "Boxster", "3.6 Flat",
		// "4WD, Airbag, Jaula antivuelco", "Premium",
		// Float.parseFloat("800"), Float.parseFloat("40"));
		// sist.registrarAutomovil("TT13", "2013", "QWE123",
		// Float.parseFloat("100"), Float.parseFloat("50"), "Activo");
		// sist.registrarAutomovil("CARRERA911", "2013", "ASD123",
		// Float.parseFloat("75"), Float.parseFloat("40"), "Activo");

		Date fechaInicio, fechaFin;
		Calendar cal = Calendar.getInstance();
		cal.set(2013, Calendar.AUGUST, 1);
		fechaInicio = cal.getTime();
		sist.generarReserva(2, "Premium", fechaInicio, fechaInicio);

		cal.set(2013, Calendar.AUGUST, 8);
		fechaFin = cal.getTime();
		sist.generarReserva(1, "Premium", fechaInicio, fechaFin);

		initGUI();
	}

	private void initGUI() {
		try {
			setDefaultCloseOperation(EXIT_ON_CLOSE);

			mbMenuPrincipal = new JMenuBar();
			setJMenuBar(mbMenuPrincipal);

			mbMenuPrincipal.setPreferredSize(new java.awt.Dimension(650, 21));

			jmabmClientes = new JMenu();
			mbMenuPrincipal.add(jmabmClientes);
			jmabmClientes.setText("Clientes");
			jmabmClientes.setPreferredSize(new java.awt.Dimension(64, 21));

			jmiAltaclientes = new JMenuItem();
			jmabmClientes.add(jmiAltaclientes);
			jmiAltaclientes.setText("Alta");
			jmiAltaclientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vAltaClienteLocal vista = new vAltaClienteLocal(sist);
					vista.setVisible(true);
				}
			});

			jmiBajaClientes = new JMenuItem();
			jmabmClientes.add(jmiBajaClientes);
			jmiBajaClientes.setText("Baja");
			jmiBajaClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vBajaCliente vista = new vBajaCliente(sist);
					vista.setVisible(true);
				}
			});

			jmiModificacionClientes = new JMenuItem();
			jmabmClientes.add(jmiModificacionClientes);
			jmiModificacionClientes.setText("Modificación");
			jmiModificacionClientes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vModificacionCliente vista = new vModificacionCliente(sist);
					vista.setVisible(true);
				}
			});

			jmabmModelos = new JMenu();
			mbMenuPrincipal.add(jmabmModelos);
			jmabmModelos.setText("Modelos");
			jmabmModelos.setPreferredSize(new java.awt.Dimension(64, 21));

			jmiAltaModelo = new JMenuItem();
			jmabmModelos.add(jmiAltaModelo);
			jmiAltaModelo.setText("Alta");
			jmiAltaModelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vAltaModelo vista = new vAltaModelo(sist);
					vista.setVisible(true);
				}
			});

			jmiBajaModelo = new JMenuItem();
			jmabmModelos.add(jmiBajaModelo);
			jmiBajaModelo.setText("Baja");
			jmiBajaModelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vBajaModelo vista = new vBajaModelo(sist);
					vista.setVisible(true);
				}
			});

			jmiModificacionModelo = new JMenuItem();
			jmabmModelos.add(jmiModificacionModelo);
			jmiModificacionModelo.setText("Modificación");
			jmiModificacionModelo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vModificacionModelo vista = new vModificacionModelo(sist);
					vista.setVisible(true);
				}
			});

			jmabmAutomoviles = new JMenu();
			mbMenuPrincipal.add(jmabmAutomoviles);
			jmabmAutomoviles.setText("Automoviles");
			jmabmAutomoviles.setPreferredSize(new java.awt.Dimension(85, 21));

			jmiAltaAutomovil = new JMenuItem();
			jmabmAutomoviles.add(jmiAltaAutomovil);
			jmiAltaAutomovil.setText("Alta");
			jmiAltaAutomovil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vAltaAutomovil vista = new vAltaAutomovil(sist);
					vista.setVisible(true);
				}
			});

			jmiBajaAutomovil = new JMenuItem();
			jmabmAutomoviles.add(jmiBajaAutomovil);
			jmiBajaAutomovil.setText("Baja");
			jmiBajaAutomovil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vBajaAutomovil vista = new vBajaAutomovil(sist);
					vista.setVisible(true);
				}
			});

			jmiModificacionAutomovil = new JMenuItem();
			jmabmAutomoviles.add(jmiModificacionAutomovil);
			jmiModificacionAutomovil.setText("Modificación");
			jmiModificacionAutomovil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vModificacionAutomovil vista = new vModificacionAutomovil(
							sist);
					vista.setVisible(true);
				}
			});

			jmgestionReservas = new JMenu();
			mbMenuPrincipal.add(jmgestionReservas);
			jmgestionReservas.setText("Reservas");
			jmgestionReservas.setPreferredSize(new java.awt.Dimension(68, 21));

			jmiBajaReserva = new JMenuItem();
			jmgestionReservas.add(jmiBajaReserva);
			jmiBajaReserva.setText("Cancelar");
			jmiBajaReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vBajaReserva vista = new vBajaReserva(sist);
					vista.setVisible(true);
				}
			});

			jmgestionAlquilers = new JMenu();
			mbMenuPrincipal.add(jmgestionAlquilers);
			jmgestionAlquilers.setText("Alquileres");
			jmgestionAlquilers.setPreferredSize(new java.awt.Dimension(70, 21));

			jmiAltaAlquierReserva = new JMenuItem();
			jmgestionAlquilers.add(jmiAltaAlquierReserva);
			jmiAltaAlquierReserva.setText("Generar alquiler por reserva");
			jmiAltaAlquierReserva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vGenerarAlquilerReserva vista = new vGenerarAlquilerReserva(
							sist);
					vista.setVisible(true);
				}
			});

			jmiAltaAlquilerLocal = new JMenuItem();
			jmgestionAlquilers.add(jmiAltaAlquilerLocal);
			jmiAltaAlquilerLocal.setText("Generar alquiler en local");
			jmiAltaAlquilerLocal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vGenerarAlquilerLocal vista = new vGenerarAlquilerLocal(
							sist);
					vista.setVisible(true);
				}
			});

			jmiRegistrarDevolucion = new JMenuItem();
			jmgestionAlquilers.add(jmiRegistrarDevolucion);
			jmiRegistrarDevolucion.setText("Registrar devolución");
			jmiRegistrarDevolucion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vRegistrarDevolucion vista = new vRegistrarDevolucion(sist);
					vista.setVisible(true);
				}
			});

			jmFacturas = new JMenu();
			mbMenuPrincipal.add(jmFacturas);
			jmFacturas.setText("Facturas");
			jmFacturas.setPreferredSize(new java.awt.Dimension(70, 21));

			jmiGenFactxAlquiler = new JMenuItem();
			jmFacturas.add(jmiGenFactxAlquiler);
			jmiGenFactxAlquiler.setText("Facturar Alquiler");
			jmiGenFactxAlquiler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vGenerarFacturaAlq vistaFacturar = new vGenerarFacturaAlq(
							sist);
					vistaFacturar.setVisible(true);
				}
			});

			jmiMostrarFact = new JMenuItem();
			jmFacturas.add(jmiMostrarFact);
			jmiMostrarFact.setText("Mostrar Factura");
			jmiMostrarFact.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vMostrarFactura vistaFactura = new vMostrarFactura(sist);
					vistaFactura.setVisible(true);
				}
			});

			jmInterfazWeb = new JMenu();
			mbMenuPrincipal.add(jmInterfazWeb);
			jmInterfazWeb.setText("Interfaz Web");
			jmInterfazWeb.setPreferredSize(new java.awt.Dimension(85, 21));

			jmiUsuarioNuevo = new JMenuItem();
			jmInterfazWeb.add(jmiUsuarioNuevo);
			jmiUsuarioNuevo.setText("Usuario nuevo");
			jmiUsuarioNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vAltaClienteWeb vistaAlta = new vAltaClienteWeb(sist);
					vistaAlta.setVisible(true);
				}
			});

			jmiIniciarSesion = new JMenuItem();
			jmInterfazWeb.add(jmiIniciarSesion);
			jmiIniciarSesion.setText("Iniciar sesión");
			jmiIniciarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					vInicioSesion vistaInicio = new vInicioSesion(sist);
					vistaInicio.setVisible(true);
				}
			});

			jmSistema = new JMenu();
			mbMenuPrincipal.add(jmSistema);
			jmSistema.setText("Sistema");
			jmSistema.setPreferredSize(new java.awt.Dimension(60, 21));

			jmiSalir = new JMenuItem();
			jmSistema.add(jmiSalir);
			jmiSalir.setText("Salir");

			jmiSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					if (JOptionPane.showConfirmDialog(null,
							"¿Está seguro que desea salir?", "Salir",
							JOptionPane.YES_NO_OPTION) == 0) {
						System.exit(0);
					}
				}
			});

			setResizable(false);
			setTitle("Sistema de Alquiler de Autos");
			setSize(700, 450);
			setLocationRelativeTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}