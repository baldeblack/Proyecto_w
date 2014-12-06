package com.models;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ListaFicheros {

 private List<CommonsMultipartFile> archivos;
	 
	 public List<CommonsMultipartFile> getArchivos() {
	  return archivos;
	 }
	 
	 public void setArchivos(List<CommonsMultipartFile> archivos) {
	  this.archivos = archivos;
	 }
	 
	 public int size() {
	  return archivos.size();
	 }    
	 
}
