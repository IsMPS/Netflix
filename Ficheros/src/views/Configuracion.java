package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.NetflixDAO;
import dao.UserDAO;
import models.Show;
import utils.Ficheros;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

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
	private JTextField textDelimiter;
	private JButton btnAbrirDel;
	private JPanel panel_1;
	private ArrayList<Show> shows = new ArrayList<Show>();

	/**
	 * Create the application.
	 */
	public Configuracion(JFrame parent, String user) {
		this.julioiglesias=parent;
		this.user = user;
		shows = NetflixDAO.getAll();
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
		this.panel.setBounds(177, 200, 340, 269);
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
		
		panel_1 = new JPanel();
		panel_1.setBounds(177, 200, 340, 269);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textDelimiter = new JTextField();
		textDelimiter.setBounds(109, 77, 141, 20);
		panel_1.add(textDelimiter);
		textDelimiter.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Delimitador");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(21, 78, 89, 14);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Crear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crearFichero();
			}
		});
		btnNewButton.setBounds(129, 172, 89, 23);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Crea tu propio fichero de favoritos, solo se tendra"+"\n"+"en cuenta el primer caracter");
		lblNewLabel_1.setBounds(10, 29, 320, 37);
		panel_1.add(lblNewLabel_1);
		
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
		
		btnAbrirDel = new JButton("Crear fichero");
		btnAbrirDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cambiarDel();
			}
		});
		btnAbrirDel.setBounds(280, 301, 139, 23);
		frame.getContentPane().add(btnAbrirDel);
		panel_1.setVisible(false);
		frame.setVisible(true);
	}
	
	public void cambiarDel() {
		btnCambiar.setVisible(false);
		btnSalirCon.setVisible(false);
		btnBorrar.setVisible(false);
		btnAbrirDel.setVisible(false);
		panel_1.setVisible(true);
	}
	
	public void crearFichero() {
		char del = textDelimiter.getText().charAt(0);
		if(!textDelimiter.getText().isEmpty()) {
			for (int i = 0; i < shows.size()-1; i++) {
				if(UserDAO.consultaFav(user, shows.get(i).getID())) {
					Ficheros.insertarFav(shows.get(i), del);
				}	
			}
				panel_1.setVisible(false);
				btnAbrirDel.setVisible(true);
				btnCambiar.setVisible(true);
				btnSalirCon.setVisible(true);
				btnBorrar.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Introduce un nombre");
		}
	}
	
	public void cambiarUser() {
		btnCambiar.setVisible(false);
		btnAbrirDel.setVisible(false);
		btnSalirCon.setVisible(false);
		btnBorrar.setVisible(false);
		panel.setVisible(true);
	}
	
	public void cambiar() {
		this.newpass= textFieldNombre.getText();
		if(!newpass.isEmpty()) {
				UserDAO.cambiar(user,newpass);
				panel.setVisible(false);
				btnAbrirDel.setVisible(true);
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
