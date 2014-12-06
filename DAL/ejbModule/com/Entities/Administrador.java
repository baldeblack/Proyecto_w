package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Administradores database table.
 * 
 */
@Entity
@Table(name="Administradores")
@NamedQuery(name="Administrador.findAll", query="SELECT a FROM Administrador a")
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String mail;

	private String password;

	public Administrador() {
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}