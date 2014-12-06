package com.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GestionRiesgo database table.
 * 
 */
@Entity
@NamedQuery(name="GestionRiesgo.findAll", query="SELECT g FROM GestionRiesgo g")
public class GestionRiesgo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idGestionRiesgo;

	@Column(name="Ciudad")
	private String ciudad;

	@Column(name="Costo")
	private BigDecimal costo;

	@Column(name="Departamento")
	private String departamento;

	@Lob
	@Column(name="Descripcion")
	private String descripcion;

	@Temporal(TemporalType.DATE)
	@Column(name="FechaOcurrencia")
	private Date fechaOcurrencia;

	@Column(name="NroAfectados")
	private int nroAfectados;

	@Column(name="NroOcurrencias")
	private short nroOcurrencias;

	@Column(name="Perdidas")
	private BigDecimal perdidas;

	@Lob
	@Column(name="Plan")
	private byte[] plan;

	@Column(name="Titulo")
	private String titulo;

	@Column(name="ZonaAfectada")
	private String zonaAfectada;

	//bi-directional many-to-one association to PlanEmergencia
	@ManyToOne
	@JoinColumn(name="IdPlan")
	private PlanEmergencia planEmergencia;

	//bi-directional many-to-one association to TipoRiesgo
	@ManyToOne
	@JoinColumn(name="IdTipoRiesgo")
	private TipoRiesgo tipoRiesgo;

	public GestionRiesgo() {
	}

	public int getIdGestionRiesgo() {
		return this.idGestionRiesgo;
	}

	public void setIdGestionRiesgo(int idGestionRiesgo) {
		this.idGestionRiesgo = idGestionRiesgo;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public BigDecimal getCosto() {
		return this.costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaOcurrencia() {
		return this.fechaOcurrencia;
	}

	public void setFechaOcurrencia(Date fechaOcurrencia) {
		this.fechaOcurrencia = fechaOcurrencia;
	}

	public int getNroAfectados() {
		return this.nroAfectados;
	}

	public void setNroAfectados(int nroAfectados) {
		this.nroAfectados = nroAfectados;
	}

	public short getNroOcurrencias() {
		return this.nroOcurrencias;
	}

	public void setNroOcurrencias(short nroOcurrencias) {
		this.nroOcurrencias = nroOcurrencias;
	}

	public BigDecimal getPerdidas() {
		return this.perdidas;
	}

	public void setPerdidas(BigDecimal perdidas) {
		this.perdidas = perdidas;
	}

	public byte[] getPlan() {
		return this.plan;
	}

	public void setPlan(byte[] plan) {
		this.plan = plan;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getZonaAfectada() {
		return this.zonaAfectada;
	}

	public void setZonaAfectada(String zonaAfectada) {
		this.zonaAfectada = zonaAfectada;
	}

	public PlanEmergencia getPlanEmergencia() {
		return this.planEmergencia;
	}

	public void setPlanEmergencia(PlanEmergencia planEmergencia) {
		this.planEmergencia = planEmergencia;
	}

	public TipoRiesgo getTipoRiesgo() {
		return this.tipoRiesgo;
	}

	public void setTipoRiesgo(TipoRiesgo tipoRiesgo) {
		this.tipoRiesgo = tipoRiesgo;
	}

}