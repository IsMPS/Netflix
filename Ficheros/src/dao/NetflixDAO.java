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
	   
	   public static Show consultaS(int show) {
		   final String QUERY = "SELECT show_id, tipo, title, director, cast, country, date_added, release_year, rating, duration, listed_in, descripcion "
					+ "FROM shows where show_id = 's"+show+ "' ;";
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   Statement stmt = conn.createStatement();
			   ResultSet rs = stmt.executeQuery(QUERY);		      
			   	var show_id = rs.getString("show_id");
				var tipo = rs.getString("tipo");
				var title = rs.getString("title");
				var director = rs.getString("director");
				var cast = rs.getString("cast");
				var country = rs.getString("country");
				var date_added = rs.getString("date_added");
				var release_year = rs.getString("release_year");
				var rating = rs.getString("rating");
				var duration = rs.getString("duration");
				var listed_in = rs.getString("listed_in");
				var descripcion = rs.getString("descripcion");
				Show a = new Show(show_id,tipo,title,director,cast,country,date_added, release_year,rating,duration,listed_in,descripcion);
				return a;
		      } catch (SQLException e) {
		         e.printStackTrace();
		         return null; 
		      }
		
	   }
	   
	   public static ArrayList<Show> getAll() {
			final String QUERY = "SELECT show_id, tipo, title, director, cast, country, date_added, release_year, rating, duration, listed_in, descripcion "
					+ "FROM shows order by show_id";
			var coso = new ArrayList<Show>();
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);
				while (rs.next()) {
					var show_id = rs.getString("show_id");
					var tipo = rs.getString("tipo");
					var title = rs.getString("title");
					var director = rs.getString("director");
					var cast = rs.getString("cast");
					var country = rs.getString("country");
					var date_added = rs.getString("date_added");
					var release_year = rs.getString("release_year");
					var rating = rs.getString("rating");
					var duration = rs.getString("duration");
					var listed_in = rs.getString("listed_in");
					var descripcion = rs.getString("descripcion");
					Show a = new Show(show_id,tipo,title,director,cast,country,date_added, release_year,rating,duration,listed_in,descripcion);
					coso.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return coso;
		}
	   
	   public static ArrayList<Show> getAll(String condicion) {
			final String QUERY = "SELECT show_id, tipo, title, director, cast, country, date_added, release_year, rating, duration, listed_in, descripcion "
					+ "FROM shows where title like '%"+condicion+"%'";
			var coso = new ArrayList<Show>();
			try {
				Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(QUERY);
				while (rs.next()) {
					var show_id = rs.getString("show_id");
					var tipo = rs.getString("tipo");
					var title = rs.getString("title");
					var director = rs.getString("director");
					var cast = rs.getString("cast");
					var country = rs.getString("country");
					var date_added = rs.getString("date_added");
					var release_year = rs.getString("release_year");
					var rating = rs.getString("rating");
					var duration = rs.getString("duration");
					var listed_in = rs.getString("listed_in");
					var descripcion = rs.getString("descripcion");
					Show a = new Show(show_id,tipo,title,director,cast,country,date_added, release_year,rating,duration,listed_in,descripcion);
					coso.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return coso;
		}
}
