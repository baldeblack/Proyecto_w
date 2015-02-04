package com.Helper;

import java.util.Date;

import org.picketbox.commons.cipher.Base64;

import com.Entities.Catastrofe;


public class CatastrofeMobile {
	
	private int idCatastrofe;

	private byte activa;

	private String apiFb;

	private String apiTw;

	private String carpetaImagenes;

	private String css;

	private String dominio;

	private Date fechaCreacion;

	private String fuentesDatos;

	private String informacion;

	private String logo;

	private String nombre;

	private String palabrasClaves;

	private String stringConeccion;

	private int tipo;

	private String zonaAfectada;

	public CatastrofeMobile() {
	}
	
	public CatastrofeMobile(Catastrofe c) {
		idCatastrofe = c.getIdCatastrofe();
		activa = c.getActiva();
		apiFb = c.getApiFb();
		apiTw = c.getApiTw();
		carpetaImagenes = c.getCarpetaImagenes();
		css = c.getCss();
		dominio = c.getDominio();
		fechaCreacion = c.getFechaCreacion();
		fuentesDatos = c.getFuentesDatos();
		informacion = c.getInformacion();
		logo = Base64.encodeBytes(c.getLogo());
		nombre = c.getNombre();
		palabrasClaves = c.getPalabrasClaves();
		stringConeccion = c.getStringConeccion();
		tipo = c.getTipo();
		zonaAfectada = c.getZonaAfectada();
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

	public String getApiFb() {
		return this.apiFb;
	}

	public void setApiFb(String apiFb) {
		this.apiFb = apiFb;
	}

	public String getApiTw() {
		return this.apiTw;
	}

	public void setApiTw(String apiTw) {
		this.apiTw = apiTw;
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

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
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

	public int getTipo() {
		return this.tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getZonaAfectada() {
		return this.zonaAfectada;
	}

	public void setZonaAfectada(String zonaAfectada) {
		this.zonaAfectada = zonaAfectada;
	}
}
