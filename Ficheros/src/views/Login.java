package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.UserDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class Login {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField txtUsu;
	private JLabel lblContrasea;

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);

		
		JButton btnLogin = new JButton("Confirmar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkLog()) {
					JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecta");
				} else {
					frame.setVisible(false);
				};
			}
		});
		btnLogin.setBounds(279, 315, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 214, 130, 20);
		frame.getContentPane().add(passwordField);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(298, 183, 130, 20);
		frame.getContentPane().add(txtUsu);
		txtUsu.setColumns(10);
		
		JLabel lblUsu = new JLabel("Usuario: ");
		lblUsu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsu.setForeground(new Color(192, 192, 192));
		lblUsu.setBounds(209, 183, 79, 17);
		frame.getContentPane().add(lblUsu);
		
		lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setForeground(Color.LIGHT_GRAY);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContrasea.setBounds(209, 217, 79, 17);
		frame.getContentPane().add(lblContrasea);
		frame.setBounds(100, 100, 715, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	
	public boolean checkLog() {
		String usu = txtUsu.getText();
		boolean dentro = false;
		char paslog[] = passwordField.getPassword();
		String passlog = new String(paslog);
		dentro= UserDAO.login(usu, passlog);
		return dentro;
	}
}