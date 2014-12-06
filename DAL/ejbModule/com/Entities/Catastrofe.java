package com.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Catastrofe database table.
 * 
 */
@Entity
@NamedQuery(name="Catastrofe.findAll", query="SELECT c FROM Catastrofe c")
public class Catastrofe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idCatastrofe;

	@Column(name="Activa")
	private byte activa;

	@Lob
	@Column(name="CarpetaImagenes")
	private String carpetaImagenes;

	@Lob
	@Column(name="Css")
	private String css;

	@Column(name="Dominio")
	private String dominio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FechaCreacion")
	private Date fechaCreacion;

	@Column(name="FuentesDatos")
	private String fuentesDatos;

	@Lob
	@Column(name="Informacion")
	private String informacion;

	@Lob
	@Column(name="Logo")
	private byte[] logo;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="PalabrasClaves")
	private String palabrasClaves;

	@Column(name="StringConeccion")
	private String stringConeccion;

	@Column(name="ZonaAfectada")
	private String zonaAfectada;

	public Catastrofe() {
	}

	public int getIdCatastrofe() {
		return this.idCatastrofe;
	}

	public void setIdCatastrofe(int idCatastrofe) {
		this.idCatastrofe = idCatastrofe;
	}

	public byte getActiva() {
		return this.activa;
	}

	public void setActiva(byte activa) {
		this.activa = activa;
	}

	public String getCarpetaImagenes() {
		return this.carpetaImagenes;
	}

	public void setCarpetaImagenes(String carpetaImagenes) {
		this.carpetaImagenes = carpetaImagenes;
	}

	public String getCss() {
		return this.css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getDominio() {
		return this.dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Date getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getFuentesDatos() {
		return this.fuentesDatos;
	}

	public void setFuentesDatos(String fuentesDatos) {
		this.fuentesDatos = fuentesDatos;
	}

	public String getInformacion() {
		return this.informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}

	public byte[] getLogo() {
		return this.logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPalabrasClaves() {
		return this.palabrasClaves;
	}

	public void setPalabrasClaves(String palabrasClaves) {
		this.palabrasClaves = palabrasClaves;
	}

	public String getStringConeccion() {
		return this.stringConeccion;
	}

	public void setStringConeccion(String stringConeccion) {
		this.stringConeccion = stringConeccion;
	}

	public String getZonaAfectada() {
		return this.zonaAfectada;
	}

	public void setZonaAfectada(String zonaAfectada) {
		this.zonaAfectada = zonaAfectada;
	}

}