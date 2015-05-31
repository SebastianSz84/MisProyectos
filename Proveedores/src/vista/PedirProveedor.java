package vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import modelo.ProductoView;
import controlador.Sistema;

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
public class PedirProveedor extends JFrame {
	private JButton btnAceptar;
	private JLabel lblCUIT;
	private JTextField txtCUIT;
	private JButton btnCancelar;
	private ActionEvent evento;

	public PedirProveedor(ActionEvent evento) {
		super();
		this.evento = evento;
		initGUI();
	}

	private void initGUI() {
		{
			getContentPane().setLayout(null);
			this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		}
		{
			btnAceptar = new JButton();
			getContentPane().add(btnAceptar, "Center");
			btnAceptar.setText("Aceptar");
			btnAceptar.setBounds(70, 100, 80, 23);
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					ListadoProductos vista = new ListadoProductos(null);
					vista.setVisible(true);
					dispose();

					Vector<ProductoView> productos = Sistema.getInstancia()
							.mostrarProd(txtCUIT.getText());

					if (productos != null) {
						if (evento.getActionCommand()
								.equals("Listar Productos")) {
							vista = new ListadoProductos(null);
							vista.setVisible(true);
						} else if (evento.getActionCommand().equals(
								"Cantidad de Productos")) {
							JOptionPane.showMessageDialog(
									null,
									"El proveedor tiene "
											+ String.valueOf(productos.size())
											+ " productos.", "Información",
									JOptionPane.INFORMATION_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"No se ha encontrado un proveedor con CUIT: "
										+ txtCUIT.getText(), "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		{
			btnCancelar = new JButton();
			getContentPane().add(btnCancelar);
			btnCancelar.setText("Cancelar");
			btnCancelar.setBounds(170, 100, 80, 23);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					dispose();
				}
			});
		}
		{
			txtCUIT = new JTextField();
			getContentPane().add(txtCUIT);
			txtCUIT.setBounds(170, 40, 10, 23);
			txtCUIT.setSize(100, 23);
		}
		{
			lblCUIT = new JLabel();
			getContentPane().add(lblCUIT);
			lblCUIT.setText("CUIT:");
			lblCUIT.setBounds(72, 43, 80, 16);
			lblCUIT.setHorizontalAlignment(SwingConstants.LEFT);
		}
		{
			this.setSize(320, 200);
			this.setLocationRelativeTo(null);
			this.setTitle("Ingrese el CUIT");
		}
	}
}