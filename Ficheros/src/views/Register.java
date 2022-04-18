package views;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;

import dao.UserDAO;
import models.Users;
import utils.Emails;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;

public class Register {

	private JFrame frame;
	private JTextField txtFUser;
	private int codVal;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtCorreo;
	private JLabel lblCorreo;

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		txtFUser = new JTextField();
		txtFUser.setBounds(298, 170, 130, 20);
		frame.getContentPane().add(txtFUser);
		txtFUser.setColumns(10);
		
		JButton btnRegister = new JButton("Confirmar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkreg();
			}
		});
		btnRegister.setBounds(279, 315, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 214, 130, 20);
		frame.getContentPane().add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(298, 259, 130, 20);
		frame.getContentPane().add(passwordField_1);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(298, 128, 130, 20);
		frame.getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCorreo.setForeground(new Color(255, 240, 240));
		lblCorreo.setBounds(215, 119, 74, 37);
		frame.getContentPane().add(lblCorreo);
		frame.setBounds(100, 100, 715, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
	
	public void checkreg() {
		String us = txtFUser.getText();

		char pas[] = passwordField.getPassword();
		String pass = new String(pas);

		char pasc[] = passwordField_1.getPassword();
		String passc = new String(pasc);
		
		if (pass.equals(passc)) {
			if (!us.isEmpty() && !pass.isEmpty()) {
				if (!UserDAO.consultaN(us)) {
					int Validacion = (int) (Math.random()*9999);
					Emails.sendConfirm(txtCorreo.getText(), Validacion);
					
					codVal = Integer.parseInt(JOptionPane.showInputDialog("Introduzca el código de confirmación, "));
					if(codVal!=Validacion) {
						JOptionPane.showMessageDialog(null,"Codigo incorrecto");
					} else {
					Users newUser = new Users(us,txtCorreo.getText(),pass);
					UserDAO.register(newUser);
					frame.setVisible(false);
					new MenuPrincipal();
					}
				} else {
					JOptionPane.showMessageDialog(null, "El nombre está en uso.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Rellena todos los campos.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden.");
		}
	}
}
