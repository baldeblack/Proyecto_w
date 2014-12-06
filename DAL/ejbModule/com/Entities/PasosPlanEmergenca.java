package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the PasosPlanEmergenca database table.
 * 
 */
@Entity
@NamedQuery(name="PasosPlanEmergenca.findAll", query="SELECT p FROM PasosPlanEmergenca p")
public class PasosPlanEmergenca implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PasosPlanEmergencaPK id;

	@Lob
	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to PlanEmergencia
	@ManyToOne
	@JoinColumn(name="IdPlan", insertable=false, updatable=false)
	private PlanEmergencia planEmergencia;

	//bi-directional many-to-one association to TipoRescatista
	@ManyToOne
	@JoinColumn(name="IdTipoEjecutor")
	private TipoRescatista tipoRescatista;

	public PasosPlanEmergenca() {
	}

	public PasosPlanEmergencaPK getId() {
		return this.id;
	}

	public void setId(PasosPlanEmergencaPK id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public PlanEmergencia getPlanEmergencia() {
		return this.planEmergencia;
	}

	public void setPlanEmergencia(PlanEmergencia planEmergencia) {
		this.planEmergencia = planEmergencia;
	}

	public TipoRescatista getTipoRescatista() {
		return this.tipoRescatista;
	}

	public void setTipoRescatista(TipoRescatista tipoRescatista) {
		this.tipoRescatista = tipoRescatista;
	}

}