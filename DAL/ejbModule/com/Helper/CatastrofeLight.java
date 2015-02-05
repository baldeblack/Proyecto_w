package com.Helper;

import java.util.Date;

import com.Entities.Catastrofe;


public class CatastrofeLight {
		
		private int idCatastrofe;

		private String dominio;

		private Date fechaCreacion;

		private String informacion;

		private String nombre;

		private String palabrasClaves;

		private String stringConeccion;

		private int tipo;

		private String zonaAfectada;

		public CatastrofeLight() {
		}
		
		public CatastrofeLight(Catastrofe c) {
			idCatastrofe = c.getIdCatastrofe();
			dominio = c.getDominio();
			fechaCreacion = c.getFechaCreacion();
			informacion = c.getInformacion();
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