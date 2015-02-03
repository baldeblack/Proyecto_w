package com.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the pasos database table.
 * 
 */
@Embeddable
public class PasoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idPlan;

	private int idpasos;

	public PasoPK() {
	}
	public int getIdPlan() {
		return this.idPlan;
	}
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}
	public int getIdpasos() {
		return this.idpasos;
	}
	public void setIdpasos(int idpasos) {
		this.idpasos = idpasos;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PasoPK)) {
			return false;
		}
		PasoPK castOther = (PasoPK)other;
		return 
			(this.idPlan == castOther.idPlan)
			&& (this.idpasos == castOther.idpasos);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPlan;
		hash = hash * prime + this.idpasos;
		
		return hash;
	}
}