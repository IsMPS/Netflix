package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import models.Show;

public class NetflixDAO {

	static final String DB_URL = "jdbc:mysql://localhost/netflix";
	static final String USER = "IsaMP";
	static final String PASS = "UnPatitoEnElAgua";
	static final String QUERY = "SELECT * FROM shows";
	
	   public static void insert(Show a) {
			final String INSERT = "INSERT INTO shows "
					+ "VALUES ('"+a.getID()+"','"+a.getType()+"','"+a.getTitle()+"','"+a.getDirector()+"', '"+a.getCast()+"','"+a.getCountry()+"','"+a.getDate_added()+"','"+a.getRelease_year()+"','"+a.getRating()+"','"+a.getDuration()+"','"+a.getListed_in()+"','"+a.getDescription()+"');";
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(INSERT);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	   
	   public static ArrayList<Show> getAll() {
			final String QUERY = "SELECT show_id, tipo, title, director, cast, country,  "
					+ "FROM shows order by show_id";
			var coso = new ArrayList<Show>();
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);
				while (rs.next()) {
					var num = rs.getInt("IdPoke");
					var nombre = rs.getString("NombrePoke");
					var peso = rs.getDouble("Peso");
					var altura = rs.getDouble("Altura");
					var tipo = rs.getString("ID_Tipo");
					var tipo2 = rs.getString("ID_Tipo2");
					Show a = new Show();
					coso.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return coso;
		}
}
