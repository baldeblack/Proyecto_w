package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Catastrofe implements Serializable {
	private static final long serialVersionUID = 1L;

	
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

	private String nombre;
	
	private String palabrasClaves;


	private String stringConeccion;

	private String zonaAfectada;
	
	private List<String> listOfImages;


	public Catastrofe() {
	}

	public int getIdCatastrofe() {
		return this.idCatastrofe;
	}

	public void setIdCatastrofe(int idCatastrofe) {
		this.idCatastrofe = idCatastrofe;
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
	
	public List<String> getlistOfImages(){
		return listOfImages;
	}
	
	public void setlistOfImages(List<String> imgs){
		listOfImages = imgs;
	}
}
