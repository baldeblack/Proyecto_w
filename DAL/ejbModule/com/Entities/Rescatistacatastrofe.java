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

	@EmbeddedId
	private RescatistacatastrofePK id;

	public Rescatistacatastrofe() {
	}

	public RescatistacatastrofePK getId() {
		return this.id;
	}

	public void setId(RescatistacatastrofePK id) {
		this.id = id;
	}

}