package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipocatastrofe database table.
 * 
 */
@Entity
@NamedQuery(name="Tipocatastrofe.findAll", query="SELECT t FROM Tipocatastrofe t")
public class Tipocatastrofe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idtipocatastrofe;

	private String nombre;

	public Tipocatastrofe() {
	}

	public int getIdtipocatastrofe() {
		return this.idtipocatastrofe;
	}

	public void setIdtipocatastrofe(int idtipocatastrofe) {
		this.idtipocatastrofe = idtipocatastrofe;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}