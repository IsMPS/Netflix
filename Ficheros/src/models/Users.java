package models;

public class Users {
	
	int idC;
	String user;
	String correo;
	String password;
	int codVerifica;
	
	public Users(int idC, String user, String correo, String password, int codVerifica) {
		this.idC=idC;
		this.user=user;
		this.correo=correo;
		this.password=password;
		this.codVerifica=codVerifica;
	}

}
