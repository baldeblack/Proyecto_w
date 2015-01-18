package com.models;

public class HelpModel {

	private int typeRequest;
	private String message;
	private String telefono;
	private String location;
	
	public HelpModel(){
		
	}
	
	public HelpModel(int type, String msj, String loc, String tel){
		typeRequest = type;
		message = msj;
		location=loc;
		telefono = tel;
	}
	
	
	public int getTypeRequest() {
		return this.typeRequest;
	}

	public void setTypeRequest(int type) {
		this.typeRequest = type;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String msg) {
		this.message = msg;
	}
	
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String tel) {
		this.telefono = tel;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String loc) {
		this.location = loc;
	}
}
