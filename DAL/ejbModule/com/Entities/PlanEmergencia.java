package com.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PlanEmergencia database table.
 * 
 */
@Entity
@NamedQuery(name="PlanEmergencia.findAll", query="SELECT p FROM PlanEmergencia p")
public class PlanEmergencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPlanEmergencia;

	@Column(name="Costo")
	private BigDecimal costo;

	@Lob
	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Nombre")
	private String nombre;

	@Lob
	@Column(name="Plan")
	private byte[] plan;

	//bi-directional many-to-one association to GestionRiesgo
	@OneToMany(mappedBy="planEmergencia")
	private List<GestionRiesgo> gestionRiesgos;

	//bi-directional many-to-one association to PasosPlanEmergenca
	@OneToMany(mappedBy="planEmergencia")
	private List<PasosPlanEmergenca> pasosPlanEmergencas;

	//bi-directional many-to-one association to WorkFlow
	@OneToMany(mappedBy="planEmergencia")
	private List<WorkFlow> workFlows;

	public PlanEmergencia() {
	}

	public int getIdPlanEmergencia() {
		return this.idPlanEmergencia;
	}

	public void setIdPlanEmergencia(int idPlanEmergencia) {
		this.idPlanEmergencia = idPlanEmergencia;
	}

	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
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

	public byte[] getPlan() {
		return this.plan;
	}

	public void setPlan(byte[] plan) {
		this.plan = plan;
	}

	public List<GestionRiesgo> getGestionRiesgos() {
		return this.gestionRiesgos;
	}

	public void setGestionRiesgos(List<GestionRiesgo> gestionRiesgos) {
		this.gestionRiesgos = gestionRiesgos;
	}

	public GestionRiesgo addGestionRiesgo(GestionRiesgo gestionRiesgo) {
		getGestionRiesgos().add(gestionRiesgo);
		gestionRiesgo.setPlanEmergencia(this);

		return gestionRiesgo;
	}

	public GestionRiesgo removeGestionRiesgo(GestionRiesgo gestionRiesgo) {
		getGestionRiesgos().remove(gestionRiesgo);
		gestionRiesgo.setPlanEmergencia(null);

		return gestionRiesgo;
	}

	public List<PasosPlanEmergenca> getPasosPlanEmergencas() {
		return this.pasosPlanEmergencas;
	}

	public void setPasosPlanEmergencas(List<PasosPlanEmergenca> pasosPlanEmergencas) {
		this.pasosPlanEmergencas = pasosPlanEmergencas;
	}

	public PasosPlanEmergenca addPasosPlanEmergenca(PasosPlanEmergenca pasosPlanEmergenca) {
		getPasosPlanEmergencas().add(pasosPlanEmergenca);
		pasosPlanEmergenca.setPlanEmergencia(this);

		return pasosPlanEmergenca;
	}

	public PasosPlanEmergenca removePasosPlanEmergenca(PasosPlanEmergenca pasosPlanEmergenca) {
		getPasosPlanEmergencas().remove(pasosPlanEmergenca);
		pasosPlanEmergenca.setPlanEmergencia(null);

		return pasosPlanEmergenca;
	}

	public List<WorkFlow> getWorkFlows() {
		return this.workFlows;
	}

	public void setWorkFlows(List<WorkFlow> workFlows) {
		this.workFlows = workFlows;
	}

	public WorkFlow addWorkFlow(WorkFlow workFlow) {
		getWorkFlows().add(workFlow);
		workFlow.setPlanEmergencia(this);

		return workFlow;
	}

	public WorkFlow removeWorkFlow(WorkFlow workFlow) {
		getWorkFlows().remove(workFlow);
		workFlow.setPlanEmergencia(null);

		return workFlow;
	}

}