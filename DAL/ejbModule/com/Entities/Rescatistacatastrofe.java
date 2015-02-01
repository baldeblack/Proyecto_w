package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rescatistacatastrofe database table.
 * 
 */
@Entity
@NamedQuery(name="Rescatistacatastrofe.findAll", query="SELECT r FROM Rescatistacatastrofe r")
public class Rescatistacatastrofe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idrescatista;

	private int idcatastrofe;

	public Rescatistacatastrofe() {
	}

	public int getIdrescatista() {
		return this.idrescatista;
	}

	public void setIdrescatista(int idrescatista) {
		this.idrescatista = idrescatista;
	}

	public int getIdcatastrofe() {
		return this.idcatastrofe;
	}

	public void setIdcatastrofe(int idcatastrofe) {
		this.idcatastrofe = idcatastrofe;
	}

}