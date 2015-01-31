package com.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rescatistacatastrofe database table.
 * 
 */
@Embeddable
public class RescatistacatastrofePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idrescatista;

	private int idcatastrofe;

	public RescatistacatastrofePK() {
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

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RescatistacatastrofePK)) {
			return false;
		}
		RescatistacatastrofePK castOther = (RescatistacatastrofePK)other;
		return 
			(this.idrescatista == castOther.idrescatista)
			&& (this.idcatastrofe == castOther.idcatastrofe);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idrescatista;
		hash = hash * prime + this.idcatastrofe;
		
		return hash;
	}
}