package com.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.Entities.Catastrofe;
import com.utils.imagenShow;

public class CatastrofeModel {

	 byte activa;
	 String carpetaImagenes;	
	 String css;
     String dominio;
	 Date fechaCreacion;
	 String informacion;
	 String nombre;
	 String stringConeccion;
	 String zonaAfectada;
	 String logoString;
	 public String getLogoString() {
		return logoString;
	}

	public void setLogoString(String logoString) {
		this.logoString = logoString;
	}

	int idCatastrofe;
	 CommonsMultipartFile logo;		
	  List<MultipartFile> multiUploadedFileList;
	  List<String> fuenteDedatos;
	  List<String> fuenteDedatosMod;
	  List<String> palabrasList;
	  List<imagenShow> imagenes;
	  List<String> imagenesNuevas;
	  
	  public List<String> getImagenesNuevas() {
		return imagenesNuevas;
	}

	public void setImagenesNuevas(List<String> imagenesNuevas) {
		this.imagenesNuevas = imagenesNuevas;
	}

	String action;
	
	public String getAction() {
		return action;
	}

	public List<imagenShow> getImagenes() {
		return imagenes;
	}

	public void setImagenes(List<imagenShow> imagenes) {
		this.imagenes = imagenes;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public CatastrofeModel(Catastrofe c){
		this.activa = c.getActiva();
		this.carpetaImagenes = c.getCarpetaImagenes();
		this.css = c.getCss();
		this.dominio = c.getDominio();
		this.nombre = c.getNombre();
		this.fechaCreacion = c.getFechaCreacion();
		this.informacion = c.getInformacion();
		this.stringConeccion = c.getStringConeccion();
		this.zonaAfectada = c.getZonaAfectada();
		this.idCatastrofe = c.getIdCatastrofe();
		this.fuenteDedatos = new ArrayList<String>();
		this.palabrasList =  new ArrayList<String>();
		this.fuenteDedatosMod =  new ArrayList<String>();
		this.imagenes = new ArrayList<imagenShow>();
		this.fuenteDedatos.add("youTube");  
		this.fuenteDedatos.add("Twitter");  
		this.fuenteDedatos.add("RSS"); 	
		
		String[] partsFuentes = c.getFuentesDatos().split(";");
		for(String fuente : partsFuentes) {
			if(!fuente.equals("")){
				this.fuenteDedatosMod.add(fuente);
				if(this.fuenteDedatos.contains(fuente)){
					this.fuenteDedatos.remove(fuente);
				}
				
			}
		}
		
		
		String[] partsPalabras = c.getPalabrasClaves().split(";");
		for(String palabras : partsPalabras) {
			if(!palabras.equals("")){
				this.palabrasList.add(palabras);
			}
		}
		
	}
	 
	public int getIdCatastrofe() {
		return idCatastrofe;
	}

	public void setIdCatastrofe(int idCatastrofe) {
		this.idCatastrofe = idCatastrofe;
	}

	public CatastrofeModel(){
			fuenteDedatos = new ArrayList<String>();
			fuenteDedatosMod  = new ArrayList<String>();
			palabrasList = new ArrayList<String>();			 
			fuenteDedatos.add("youTube");  
			fuenteDedatos.add("Twitter");  
			fuenteDedatos.add("RSS"); 					
		}
	 
	public byte getActiva() {
		return activa;
	}
	public void setActiva(byte activa) {
		this.activa = activa;
	}
	public String getCarpetaImagenes() {
		return carpetaImagenes;
	}
	public void setCarpetaImagenes(String carpetaImagenes) {
		this.carpetaImagenes = carpetaImagenes;
	}
	public String getCss() {
		return css;
	}
	public void setCss(String css) {
		this.css = css;
	}
	public String getDominio() {
		return dominio;
	}
	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getInformacion() {
		return informacion;
	}
	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getStringConeccion() {
		return stringConeccion;
	}
	public void setStringConeccion(String stringConeccion) {
		this.stringConeccion = stringConeccion;
	}
	public String getZonaAfectada() {
		return zonaAfectada;
	}
	public void setZonaAfectada(String zonaAfectada) {
		this.zonaAfectada = zonaAfectada;
	}
	public CommonsMultipartFile getLogo() {
		return logo;
	}
	public void setLogo(CommonsMultipartFile logo) {
		this.logo = logo;
	}

    public List<MultipartFile> getMultiUploadedFileList() {
        return multiUploadedFileList;
    }

    public void setMultiUploadedFileList(List<MultipartFile> 
                multiUploadedFileList) {
        this.multiUploadedFileList = multiUploadedFileList;
    }
	public List<String> getFuenteDedatos() {
		return fuenteDedatos;
	}
	public void setFuenteDedatos(List<String> fuenteDedatos) {
		this.fuenteDedatos = fuenteDedatos;
	}
	public List<String> getPalabrasList() {
		return palabrasList;
	}
	public void setPalabrasList(List<String> palabrasLst) {
		palabrasList = palabrasLst;
	}

	public List<String> getFuenteDedatosMod() {
		return fuenteDedatosMod;
	}

	public void setFuenteDedatosMod(List<String> fuenteDedatosMod) {
		this.fuenteDedatosMod = fuenteDedatosMod;
	}
    
	
}
