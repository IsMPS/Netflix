package models;

public class Users {
	
	int idC;
	String user;
	String correo;
	String password;
	
	public Users(String user, String correo, String password) {
		this.user=user;
		this.correo=correo;
		this.password=password;
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
	
	

}
