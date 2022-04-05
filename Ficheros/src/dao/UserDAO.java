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
	   
	   public static void Consulta() {
		      // Open a connection
		      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		            //Display values
		            System.out.print("user: " + rs.getInt("user"));
		            System.out.print(", pass: " + rs.getInt("pass"));
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 
		   }
		   
		   public static boolean login(String correo, String pass) {
			   final String QUERY = "SELECT  user, pass FROM cuentas " +
					   				"where user = '" + correo + "' AND " +
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
		   
		   public static String cambiar(String username, String newuser) {
			   try{
				   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				   PreparedStatement stmt = conn.prepareStatement("update cuentas set user = '"+ newuser+"' where user = '"+ username +"' ;");
				   stmt.executeUpdate();
				      } catch (SQLException e) {
				         e.printStackTrace();
				      } 
			   return newuser;
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
	   
}
