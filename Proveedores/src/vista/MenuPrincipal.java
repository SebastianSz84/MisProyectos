package vista;

import javax.swing.JFrame;

import controlador.Sistema;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.WindowConstants;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
@SuppressWarnings("serial")
public class MenuPrincipal extends JFrame {
	@SuppressWarnings("unused")
	private Sistema sistema;

	public MenuPrincipal() {
		super();
		this.sistema = Sistema.getInstancia();
		initGUI();
	}

	private void initGUI() {
		setSize(new Dimension(640, 480));
		setResizable(false);
		getContentPane().setLayout(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(0, 0));
		menuBar.setSize(new Dimension(480, 0));
		menuBar.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuBar.setBounds(0, 0, 634, 21);
		getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("Proveedores");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAltaProveedor = new JMenuItem("Alta");
		mnNewMenu.add(mntmAltaProveedor);

		JMenuItem mntmListarProductos = new JMenuItem("Listar Productos");
		mntmListarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				PedirProveedor vista = new PedirProveedor(evento);
				vista.setVisible(true);
			}
		});
		mnNewMenu.add(mntmListarProductos);

		JMenuItem mntmCantidadDeProductos = new JMenuItem(
				"Cantidad de Productos");
		mntmCantidadDeProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
				PedirProveedor vista = new PedirProveedor(evento);
				vista.setVisible(true);
			}
		});
		mnNewMenu.add(mntmCantidadDeProductos);
		this.setLocationRelativeTo(null);
		this.setTitle("Sistema de proveedores");
	}

	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
		menu.setVisible(true);
	}
}