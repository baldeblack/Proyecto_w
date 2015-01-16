package com.models;

public class LoginModel {
	private String email;
	private String password;
	
public LoginModel(){
		
	}
	
	public LoginModel(String mail, String passws){
		email = mail;
		password = passws;
	}
	
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String mail) {
		this.email = mail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String pswd) {
		this.password = pswd;
	}
	
}
