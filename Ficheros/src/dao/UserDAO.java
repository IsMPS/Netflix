package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.Show;
import models.Users;

public class UserDAO {

	static final String DB_URL = "jdbc:mysql://localhost/netflix";
	static final String USER = "IsaMP";
	static final String PASS = "UnPatitoEnElAgua";
	static final String QUERY = "SELECT * FROM shows";
	
	/**
	 * Insertar un usuario en la bbdd
	 * @param a Usuario
	 */
	   public static void insert(Users a) {
		   try{
			   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			   PreparedStatement stmt = conn.prepareStatement("insert into cuentas (user,pass,correo) values (?,?,?)");
			   stmt.setString(1, a.getUser());
			   stmt.setString(2, a.getPassword());
			   stmt.setString(3, a.getCorreo());
			   stmt.executeUpdate();
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
		}
	   
		   /**
		    * Login, para acceder a la cuenta
		    * @param usu
		    * @param pass
		    * @return 
		    */
		   public static boolean login(String usu, String pass) {
			   final String QUERY = "SELECT  user, pass FROM cuentas " +
					   				"where user = '" + usu + "' AND " +
					   				"pass = '" + pass + "' ;";
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   Statement stmt = conn.createStatement();
				   ResultSet rs = stmt.executeQuery(QUERY);
				   return rs.next();
				      } catch (SQLException e) {
				         e.printStackTrace();
				      } 
			   return false;
		   }
		   
		   /**
		    * Buscar usuarios dentro de la bbdd
		    * @param usu
		    */
		   public static String usuario(String correo) {
			   final String QUERY = "SELECT correo,pass FROM cuentas " +
					   				"where correo = '" + correo + "';";
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   Statement stmt = conn.createStatement();
				   ResultSet rs = stmt.executeQuery(QUERY);
				   rs.next();
				   return rs.getString("pass");
				      } catch (SQLException e) {
				         e.printStackTrace();
				      }
			   return "No hay cuenta";
		   }
		   
		   public static boolean consultaN(String username) {
			   final String QUERY = "SELECT  user FROM cuentas " +
					   				"where user = '" + username+ "' ;";
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   Statement stmt = conn.createStatement();
				   ResultSet rs = stmt.executeQuery(QUERY);		      
				   return rs.next();
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
		   return false;
		   }
		   
		   public static void borrar(String username) {
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   PreparedStatement stmt = conn.prepareStatement("delete from cuentas where user = '"+ username +"' ;");
				   stmt.executeUpdate();
				      } catch (SQLException e) {
				         e.printStackTrace();
				      } 
		   }
		   
		   public static void cambiar(String user, String newPass) {
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   PreparedStatement stmt = conn.prepareStatement("update cuentas set pass = '"+ newPass+"' where user = '"+ user +"';");
				   stmt.executeUpdate();
				      } catch (SQLException e) {
				         e.printStackTrace();
				      } 
		   }
		   
		   public static void register(Users a) {
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   PreparedStatement stmt = conn.prepareStatement("insert into cuentas (user,pass,correo) values (?,?,?)");
				   stmt.setString(1, a.getUser());
				   stmt.setString(2, a.getPassword());
				   stmt.setString(3, a.getCorreo());
				   stmt.executeUpdate();
				      } catch (SQLException e) {
				         e.printStackTrace();
				      } 
		   }
	   
		   public static void meterFavoritos(String idShow, String user) {
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   PreparedStatement stmt = conn.prepareStatement("insert into favoritos (user,idShow) values (?,?)");
				   stmt.setString(1, user);
				   stmt.setString(2, idShow);
				   stmt.executeUpdate();
				      } catch (SQLException e) {
				         e.printStackTrace();
				      } 
		   }
		   
		   public static void borrarFavoritos(String idShow, String user) {
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   PreparedStatement stmt = conn.prepareStatement("delete from favoritos where idShow = '"+ idShow +"' and user = '"+ user +"';");
				   stmt.executeUpdate();
				      } catch (SQLException e) {
				         e.printStackTrace();
				      } 
		   }
		   
		   public static boolean consultaFav(String username, String show) {
			   final String QUERY = "SELECT  user, idShow FROM favoritos " +
					   				"where user = '" + username+ "' and idShow = '" + show + "' ;";
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   Statement stmt = conn.createStatement();
				   ResultSet rs = stmt.executeQuery(QUERY);		      
				   return rs.next();
			      } catch (SQLException e) {
			         e.printStackTrace();
			      } 
		   return false;
		   }
		   
}
