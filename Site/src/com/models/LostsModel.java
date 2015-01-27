package com.models;

import java.util.Date;

import org.picketbox.commons.cipher.Base64;

public class LostsModel {
	private int idDesaparecidos;
	private String apellido;
	private int edad;
	private String estadoBusqueda;
	private Date fechaDesaparicion;
	private String nombre;
	private String nombreContacto;
	private String relacionContacto;
	private String sexo;
	private String telefonoContacto;
	private int TIpoUsuioReportado;
	private String ultimoParadero;
	private String foto;
	
	public LostsModel() {
	}
	
	public LostsModel(int id, String ape, String nom, int age, short estado, Date fecha,
			String contact, int rela, String sex, String tel, int tipo, String ultimoPar, byte[] pic) {
		idDesaparecidos = id;
		apellido = ape;
		nombre = nom;
		edad = age;
		estadoBusqueda = estado==1?"Buscando":"Encontrado";
		fechaDesaparicion = fecha;
		nombreContacto = contact;
		relacionContacto = rela==1?"Padre/Madre":rela==2?"Hermanos":rela==3?"Pareja":"Otros";
		sexo = sex=="F"?"Femenino":"Masculino";
		telefonoContacto = tel;
		TIpoUsuioReportado = tipo;
		ultimoParadero = ultimoPar;
		foto = Base64.encodeBytes(pic);
	}

	public int getIdDesaparecidos() {
		return this.idDesaparecidos;
	}

	public void setIdDesaparecidos(int idDesaparecidos) {
		this.idDesaparecidos = idDesaparecidos;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEstadoBusqueda() {
		return this.estadoBusqueda;
	}

	public void setEstadoBusqueda(String estadoBusqueda) {
		this.estadoBusqueda = estadoBusqueda;
	}

	public Date getFechaDesaparicion() {
		return this.fechaDesaparicion;
	}

	public void setFechaDesaparicion(Date fechaDesaparicion) {
		this.fechaDesaparicion = fechaDesaparicion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public String getRelacionContacto() {
		return this.relacionContacto;
	}

	public void setRelacionContacto(String relacionContacto) {
		this.relacionContacto = relacionContacto;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefonoContacto() {
		return this.telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public int getTIpoUsuioReportado() {
		return this.TIpoUsuioReportado;
	}

	public void setTIpoUsuioReportado(int TIpoUsuioReportado) {
		this.TIpoUsuioReportado = TIpoUsuioReportado;
	}

	public String getUltimoParadero() {
		return this.ultimoParadero;
	}

	public void setUltimoParadero(String ultimoParadero) {
		this.ultimoParadero = ultimoParadero;
	}

	
	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
