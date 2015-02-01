package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the catastrofetipo database table.
 * 
 */
@Entity
@NamedQuery(name="Catastrofetipo.findAll", query="SELECT c FROM Catastrofetipo c")
public class Catastrofetipo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idcatastrofe;

	private int idTipo;

	public Catastrofetipo() {
	}

	public int getIdcatastrofe() {
		return this.idcatastrofe;
	}

	public void setIdcatastrofe(int idcatastrofe) {
		this.idcatastrofe = idcatastrofe;
	}

	public int getIdTipo() {
		return this.idTipo;
	}

	public void setIdTipo(int idTipo) {
		this.idTipo = idTipo;
	}

}