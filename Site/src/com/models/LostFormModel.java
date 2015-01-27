package com.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.picketbox.commons.cipher.Base64;

public class LostFormModel {

	private String apellido;
	private int edad;
	private String fechaDesaparicion;
	private String nombre;
	private String nombreContacto;
	private int relacionContacto;
	private String sexo;
	private String telefonoContacto;
	private String ultimoParadero;
	private String foto;
	
	public LostFormModel() {
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

	public Date getFechaDesaparicion() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(this.fechaDesaparicion);
		return date;
	}

	public void setFechaDesaparicion(Date fechaDesaparicion) {
		 SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		 this.fechaDesaparicion =  SDF.format(fechaDesaparicion);
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

	public int getRelacionContacto() {
		return this.relacionContacto;
	}

	public void setRelacionContacto(int relacionContacto) {
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

	

	public String getUltimoParadero() {
		return this.ultimoParadero;
	}

	public void setUltimoParadero(String ultimoParadero) {
		this.ultimoParadero = ultimoParadero;
	}

	
	public byte[] getFoto() {
		return Base64.decode(this.foto);
	}

	public void setFoto(byte[] foto) {
		this.foto = Base64.encodeBytes(foto);
	}
}
