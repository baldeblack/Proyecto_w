package com.models;

import java.io.Serializable;

public class CatastrofesModel implements Serializable{

	
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String dominio;       

	public CatastrofesModel (){};
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	
}
