package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ongs database table.
 * 
 */
@Entity
@Table(name="ongs")
@NamedQuery(name="Ong.findAll", query="SELECT o FROM Ong o")
public class Ong implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idONGs;

	@Lob
	private String datosPayPal;

	private String direccion;

	private String email;

	private String nombre;

	private String origen;

	private String telefono;

	private String web;

	//bi-directional many-to-one association to Donacione
	@OneToMany(mappedBy="ong")
	private List<Donacione> donaciones;

	public Ong() {
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

	public Donacione addDonacione(Donacione donacione) {
		getDonaciones().add(donacione);
		donacione.setOng(this);

		return donacione;
	}

	public Donacione removeDonacione(Donacione donacione) {
		getDonaciones().remove(donacione);
		donacione.setOng(null);

		return donacione;
	}

}