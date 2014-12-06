package com.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the WorkFlow database table.
 * 
 */
@Entity
@NamedQuery(name="WorkFlow.findAll", query="SELECT w FROM WorkFlow w")
public class WorkFlow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idWorkFlow;

	@Lob
	@Column(name="Comentarios")
	private String comentarios;

	@Column(name="Estado")
	private short estado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Fecha")
	private Date fecha;

	//bi-directional many-to-one association to PlanEmergencia
	@ManyToOne
	@JoinColumn(name="IdPlan")
	private PlanEmergencia planEmergencia;

	//bi-directional many-to-one association to Catastrofe
	@ManyToOne
	@JoinColumn(name="IdCatastrofe")
	private Catastrofe catastrofe;

	//bi-directional many-to-one association to Rescatista
	@ManyToOne
	@JoinColumn(name="IdResponzable")
	private Rescatista rescatista;

	public WorkFlow() {
	}

	public int getIdWorkFlow() {
		return this.idWorkFlow;
	}

	public void setIdWorkFlow(int idWorkFlow) {
		this.idWorkFlow = idWorkFlow;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public PlanEmergencia getPlanEmergencia() {
		return this.planEmergencia;
	}

	public void setPlanEmergencia(PlanEmergencia planEmergencia) {
		this.planEmergencia = planEmergencia;
	}

	public Catastrofe getCatastrofe() {
		return this.catastrofe;
	}

	public void setCatastrofe(Catastrofe catastrofe) {
		this.catastrofe = catastrofe;
	}

	public Rescatista getRescatista() {
		return this.rescatista;
	}

	public void setRescatista(Rescatista rescatista) {
		this.rescatista = rescatista;
	}

}