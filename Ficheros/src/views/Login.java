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
import models.Users;
import utils.Emails;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;

public class Login {

	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField txtUsu;
	private JLabel lblContrasea;
	private JButton btnNoContra;
	private JTextField textField;
	private JPanel panel;
	private JButton btnNewButton;
	private JLabel lblNewLabel;

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
					char paslog[] = passwordField.getPassword();
					String passlog = new String(paslog);
					frame.setVisible(false);
					new Netflix(new Users(txtUsu.getText(),null,passlog),0,"");
				} else {
					JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecta");
				};
			}
		});
		btnLogin.setBounds(223, 311, 89, 23);
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
		
		JButton btnAtrs = new JButton("Atr\u00E1s");
		btnAtrs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new MenuPrincipal();
			}
		});
		btnAtrs.setBounds(350, 311, 89, 23);
		frame.getContentPane().add(btnAtrs);
		
		btnNoContra = new JButton("Contrase\u00F1a olvidada");
		btnNoContra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(true);
				textField.setVisible(true);
				btnNewButton.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});
		btnNoContra.setBounds(460, 348, 152, 23);
		frame.getContentPane().add(btnNoContra);
		
		panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(460, 50, 216, 262);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 173, 196, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Introduce tu correo");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 148, 130, 14);
		panel.add(lblNewLabel);
		
		btnNewButton = new JButton("Enviar recuperaci\u00F3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel.setVisible(false);
				textField.setVisible(false);
				btnNewButton.setVisible(false);
				lblNewLabel.setVisible(false);
				Emails.sendNoContra(textField.getText(),UserDAO.usuario(textField.getText()));
			}
		});
		btnNewButton.setBounds(36, 228, 151, 23);
		panel.add(btnNewButton);
		frame.setBounds(100, 100, 715, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setVisible(false);
		textField.setVisible(false);
		btnNewButton.setVisible(false);
		lblNewLabel.setVisible(false);
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