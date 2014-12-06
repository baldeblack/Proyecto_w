package com.Entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PasosPlanEmergenca database table.
 * 
 */
@Embeddable
public class PasosPlanEmergencaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	
	private int idPaso;

	@Column(name="IdPlan", insertable=false, updatable=false)
	private int idPlan;

	public PasosPlanEmergencaPK() {
	}
	public int getIdPaso() {
		return this.idPaso;
	}
	public void setIdPaso(int idPaso) {
		this.idPaso = idPaso;
	}
	public int getIdPlan() {
		return this.idPlan;
	}
	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PasosPlanEmergencaPK)) {
			return false;
		}
		PasosPlanEmergencaPK castOther = (PasosPlanEmergencaPK)other;
		return 
			(this.idPaso == castOther.idPaso)
			&& (this.idPlan == castOther.idPlan);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPaso;
		hash = hash * prime + this.idPlan;
		
		return hash;
	}
}