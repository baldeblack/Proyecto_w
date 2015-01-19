package com.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class UserModel {

	private int idUsuarios;
	private String apellido;
	private String celular;
	private String direccion;
	private String email;
	private String fechaNacimiento;
	private String nik;
	private String nombre;
	private String password;
	private String sexo;

	public UserModel () {
	}

	public int getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(this.fechaNacimiento);
		return date;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		 SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		 this.fechaNacimiento =  SDF.format(fechaNacimiento);;
	}

	public String getNik() {
		return this.nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
}
