package com.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

public class ONG {

	private int idONGs;
	private String datosPayPal;
	private String direccion;
	private String email;
	private String nombre;
	private String origen;
	private String telefono;
	private String web;
	private List<Donacione> donaciones;

	public ONG() {
	}

	public int getIdONGs() {
		return this.idONGs;
	}

	public void setIdONGs(int idONGs) {
		this.idONGs = idONGs;
	}

	public String getDatosPayPal() {
		return this.datosPayPal;
	}

	public void setDatosPayPal(String datosPayPal) {
		this.datosPayPal = datosPayPal;
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getWeb() {
		return this.web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public List<Donacione> getDonaciones() {
		return this.donaciones;
	}

	public void setDonaciones(List<Donacione> donaciones) {
		this.donaciones = donaciones;
	}
}
