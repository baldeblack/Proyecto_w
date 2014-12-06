package com.entities;

import java.util.Date;
import java.util.List;
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
	private List<Ayuda> ayudas;
	private List<Donacione> donaciones;

	public Usuario() {
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

	public List<Ayuda> getAyudas() {
		return this.ayudas;
	}

	public void setAyudas(List<Ayuda> ayudas) {
		this.ayudas = ayudas;
	}

	public Ayuda addAyuda(Ayuda ayuda) {
		getAyudas().add(ayuda);
		ayuda.setUsuario(this);

		return ayuda;
	}

	public Ayuda removeAyuda(Ayuda ayuda) {
		getAyudas().remove(ayuda);
		ayuda.setUsuario(null);

		return ayuda;
	}

	public List<Donacione> getDonaciones() {
		return this.donaciones;
	}

	public void setDonaciones(List<Donacione> donaciones) {
		this.donaciones = donaciones;
	}

	public Donacione addDonacione(Donacione donacione) {
		getDonaciones().add(donacione);
		donacione.setUsuario(this);

		return donacione;
	}

	public Donacione removeDonacione(Donacione donacione) {
		getDonaciones().remove(donacione);
		donacione.setUsuario(null);

		return donacione;
	}
}
