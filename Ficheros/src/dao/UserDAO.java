package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import models.Show;
import models.Users;

public class UserDAO {

	static final String DB_URL = "jdbc:mysql://localhost/netflix";
	static final String USER = "IsaMP";
	static final String PASS = "UnPatitoEnElAgua";
	static final String QUERY = "SELECT * FROM shows";
	
	   public static void insert(Users a) {
//			final String INSERT = "INSERT INTO cuentas "
//					+ "VALUES ('"+a.getID()+"','"+a.getType()+"','"+a.getTitle()+"','"+a.getDirector()+"', '"+a.getCast()+"','"+a.getCountry()+"','"+a.getDate_added()+"','"+a.getRelease_year()+"','"+a.getRating()+"','"+a.getDuration()+"','"+a.getListed_in()+"','"+a.getDescription()+"');";
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
//				stmt.executeUpdate(INSERT);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	   
}
