package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class MenuPrincipal {

	private JFrame frame;
	
	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("assets/NetflixLog.png"));
		lblLogo.setBounds(554, 365, 55, 65);
		frame.getContentPane().add(lblLogo);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnLogin.setBackground(new Color(0, 0, 0));
		btnLogin.setForeground(new Color(204, 0, 0));
		btnLogin.setBorder(null);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.setVisible(false);
			}
		});
		btnLogin.setBounds(251, 167, 117, 37);
		frame.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Register();
				frame.setVisible(false);
			}
		});
		btnRegister.setForeground(new Color(204, 0, 0));
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnRegister.setBorder(null);
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setBounds(251, 215, 117, 37);
		frame.getContentPane().add(btnRegister);
		
		JLabel lblNeflih = new JLabel("");
		lblNeflih.setIcon(new ImageIcon("assets/netflih.gif"));
		lblNeflih.setBounds(59, 29, 464, 135);
		frame.getContentPane().add(lblNeflih);
		
		JLabel lblTitulo = new JLabel("");
		lblTitulo.setIcon(new ImageIcon("assets/NetflixLetrass.png"));
		lblTitulo.setBounds(199, 11, 287, 159);
		frame.getContentPane().add(lblTitulo);
		
		
//		lblNeflih.setVisible(false);
		
		frame.setBounds(100, 100, 635, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}
}
