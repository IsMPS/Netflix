package models;

import java.util.ArrayList;

public class Users {
	
	private int idC;
	private String user;
	private String correo;
	private String password;
	private ArrayList<Show> shows;
	
	public Users(String user, String correo, String password) {
		this.user=user;
		this.correo=correo;
		this.password=password;
		shows = new ArrayList<Show>();
	}

	/**
	 * @return the idC
	 */
	public int getIdC() {
		return idC;
	}

	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	public void setFavorito(Show a) {
		shows.add(a);
	}
	
	public void borrarFav(Show a) {
		shows.remove(a);
	}

}
