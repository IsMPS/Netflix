package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.UserDAO;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Configuracion {

	private JFrame frame;
	private JFrame julioiglesias;
	private String user;
	private String newpass;
	private JTextField textFieldNombre;
	private JPanel panel;
	private JButton btnCambiar;
	private JButton btnBorrar;
	private JButton btnSalirCon;
	private JButton btnSalirCambName;

	/**
	 * Create the application.
	 */
	public Configuracion(JFrame parent, String user) {
		this.julioiglesias=parent;
		this.user = user;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 720, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(new Color(178, 34, 34));
		this.panel.setBounds(177, 225, 340, 244);
		frame.getContentPane().add(panel);
		this.panel.setLayout(null);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(103, 98, 139, 20);
		this.panel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblTexto = new JLabel("Introduce tu nueva contrase\u00F1a");
		lblTexto.setForeground(Color.WHITE);
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		lblTexto.setBounds(10, 11, 320, 30);
		panel.add(lblTexto);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiar();
			}
		});
		btnConfirmar.setBounds(127, 151, 89, 23);
		panel.add(btnConfirmar);
		
		btnSalirCambName = new JButton("Atr\u00E1s");
		btnSalirCambName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				btnCambiar.setVisible(true);
				btnSalirCon.setVisible(true);
				btnBorrar.setVisible(true);
			}
		});
		btnSalirCambName.setBounds(108, 210, 123, 23);
		panel.add(btnSalirCambName);
		panel.setVisible(false);
		
		btnSalirCon = new JButton("Atr\u00E1s");
		btnSalirCon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				julioiglesias.setVisible(true);
			}
		});
		btnSalirCon.setBounds(285, 438, 123, 23);
		frame.getContentPane().add(btnSalirCon);
		
		JLabel minilogo = new JLabel("");
		minilogo.setIcon(new ImageIcon("asserts/NetflixLogoo.png"));
		minilogo.setBounds(596, 438, 108, 53);
		frame.getContentPane().add(minilogo);
		
		btnCambiar = new JButton("Cambiar Nombre");
		btnCambiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarUser();
			}
		});
		btnCambiar.setBounds(280, 335, 139, 23);
		frame.getContentPane().add(btnCambiar);
		
		btnBorrar = new JButton("Borrar Cuenta");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		btnBorrar.setBounds(280, 369, 139, 23);
		frame.getContentPane().add(btnBorrar);
		
		frame.setVisible(true);
	}
	
	public void cambiarUser() {
		btnCambiar.setVisible(false);
		btnSalirCon.setVisible(false);
		btnBorrar.setVisible(false);
		panel.setVisible(true);
	}
	
	public void cambiar() {
		this.newpass= textFieldNombre.getText();
		if(!newpass.isEmpty()) {
				UserDAO.cambiar(user,newpass);
				panel.setVisible(false);
				btnCambiar.setVisible(true);
				btnSalirCon.setVisible(true);
				btnBorrar.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Introduce un nombre");
		}
	}
	
	public void borrar() {
		if(JOptionPane.showConfirmDialog(frame, "¿Estás seguro de querer borrar esta cuenta? Usuario: " + user)==0) {
			frame.setVisible(false);
		UserDAO.borrar(user);
		new MenuPrincipal();
		}
	}

}
