package com.entities;

import java.text.ParseException;
import java.util.Date;

import com.models.UserModel;
public class Usuario {

	private int idUsuarios;
	private String apellido;
	private String celular;
	private String direccion;
	private String email;
	private Date fechaNacimiento;
	private String nik;
	private String nombre;
	private String password;
	private String sexo;

	public Usuario() {
	}
	
	public Usuario(UserModel m) throws ParseException {
		idUsuarios = m.getIdUsuarios();
		apellido = m.getApellido();
		celular = m.getCelular();
		direccion = m.getDireccion();
		email = m.getEmail();
		if(m.getFechaNacimiento() != null)
			fechaNacimiento = m.getFechaNacimiento();
		else
			fechaNacimiento = new Date(0);
		nik = m.getNik();
		nombre = m.getNombre();
		password = m.getPassword();
		sexo = m.getSexo();
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

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
