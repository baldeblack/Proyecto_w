package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ONGs database table.
 * 
 */
@Entity
@Table(name="ONGs")
@NamedQuery(name="ONG.findAll", query="SELECT o FROM ONG o")
public class ONG implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idONGs;

	@Lob
	@Column(name="DatosPayPal")
	private String datosPayPal;

	@Column(name="Direccion")
	private String direccion;

	@Column(name="Email")
	private String email;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Origen")
	private String origen;

	@Column(name="Telefono")
	private String telefono;

	@Column(name="Web")
	private String web;

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

}