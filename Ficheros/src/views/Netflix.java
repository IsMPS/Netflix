package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import dao.NetflixDAO;
import dao.UserDAO;
import models.Show;
import models.Users;
import utils.Ficheros;

import javax.swing.JTextField;

public class Netflix {

	private JFrame frame;
	private JTextField txtBuscador;
	private Users usuarioDentro;
	private Show show;
	private int n;
	private ArrayList<Show> shows;
	private String condicion;

	/**
	 * Create the application.
	 */
	public Netflix(Users usu, int n, String condicion) {
		this.condicion = condicion;
		usuarioDentro = usu;

		shows = new ArrayList<Show>();
		if (condicion.isEmpty()) {
			shows = NetflixDAO.getAll();
			show = shows.get(n);
		} else {
			shows = NetflixDAO.getAll(condicion);
			if (shows.isEmpty()) {
				show = new Show("vacio", "vacio", "vacio", "vacio", "vacio", "vacio", "vacio", "vacio", "vacio",
						"vacio", "vacio", "vacio");
			} else {
				show = shows.get(n);
			}
		}

		this.n = n;
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

		JLabel lblNeflih = new JLabel("NETFLIX");
		lblNeflih.setFont(new Font("Sylfaen", Font.BOLD, 32));
		lblNeflih.setForeground(new Color(178, 34, 34));
		lblNeflih.setBounds(236, 70, 165, 65);
		frame.getContentPane().add(lblNeflih);

		JLabel lblTitulo = new JLabel(show.getTitle());
		lblTitulo.setVerticalAlignment(SwingConstants.TOP);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBounds(41, 122, 436, 92);
		frame.getContentPane().add(lblTitulo);

		txtBuscador = new JTextField();
		txtBuscador.setText(condicion);
		txtBuscador.setBounds(458, 55, 133, 20);
		frame.getContentPane().add(txtBuscador);
		txtBuscador.setColumns(10);

		JButton btnNewButton = new JButton("Favorito");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!UserDAO.consultaFav(usuarioDentro.getUser(), show.getID())) {
					UserDAO.meterFavoritos(show.getID(), usuarioDentro.getUser());
					btnNewButton.setBackground(new Color(100, 0, 0));
				} else if (UserDAO.consultaFav(usuarioDentro.getUser(), show.getID())) {
					UserDAO.borrarFavoritos(show.getID(), usuarioDentro.getUser());
					btnNewButton.setBackground(new Color(0, 0, 0));
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		if (UserDAO.consultaFav(usuarioDentro.getUser(), show.getID())) {
			btnNewButton.setBackground(new Color(100, 0, 0));
		} else
			btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setBounds(28, 53, 99, 23);
		frame.getContentPane().add(btnNewButton);

		JButton btnRetrocede = new JButton("<--");
		btnRetrocede.setBackground(Color.BLACK);
		btnRetrocede.setForeground(Color.WHITE);
		btnRetrocede.setBorder(null);
		btnRetrocede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retroceder();
			}
		});
		btnRetrocede.setBounds(10, 251, 45, 23);
		frame.getContentPane().add(btnRetrocede);

		JButton btnAvanza = new JButton("-->");
		btnAvanza.setBackground(Color.BLACK);
		btnAvanza.setForeground(Color.WHITE);
		btnAvanza.setBorder(null);
		btnAvanza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				avanzar();
			}
		});
		btnAvanza.setBounds(564, 251, 45, 23);
		frame.getContentPane().add(btnAvanza);

		JButton btnConfg = new JButton("Configuraci\u00F3n");
		btnConfg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Configuracion(frame, usuarioDentro.getUser());
				frame.setVisible(false);
			}
		});
		btnConfg.setBounds(374, 407, 140, 23);
		frame.getContentPane().add(btnConfg);
		
		JLabel lblCast = new JLabel(show.getCast());
		lblCast.setForeground(Color.WHITE);
		lblCast.setBounds(103, 311, 436, 65);
		frame.getContentPane().add(lblCast);
		
		JLabel lblDesc = new JLabel(show.getDescription());
		lblDesc.setForeground(Color.WHITE);
		lblDesc.setBounds(88, 200, 444, 74);
		frame.getContentPane().add(lblDesc);
		
		JLabel lblDirctor = new JLabel(show.getDirector());
		lblDirctor.setForeground(Color.WHITE);
		lblDirctor.setBounds(28, 87, 198, 35);
		frame.getContentPane().add(lblDirctor);
		
		JLabel lblNewLabel = new JLabel("Solo se busca por t\u00EDtulo");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(458, 30, 192, 14);
		frame.getContentPane().add(lblNewLabel);

		frame.setBounds(100, 100, 635, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}

	public void avanzar() {
		if (shows.size() - 1 == n) {
			new Netflix(usuarioDentro, 0, txtBuscador.getText());
			frame.setVisible(false);
		} else {
			new Netflix(usuarioDentro, n + 1, txtBuscador.getText());
			frame.setVisible(false);
		}
	}

	public void retroceder() {
		if (show.getID().equals("s1")) {
			new Netflix(usuarioDentro, shows.size() - 1, txtBuscador.getText());
			frame.setVisible(false);
		} else {
			new Netflix(usuarioDentro, n - 1, txtBuscador.getText());
			frame.setVisible(false);
		}
	}

}
