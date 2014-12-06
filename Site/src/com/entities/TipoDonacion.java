package com.entities;

import java.util.List;

public class TipoDonacion {
	private int idTipoDonacion;
	private String descripcion;
	private String nombre;
	private List<Donacione> donaciones;
	public TipoDonacion() {
	}

	public int getIdTipoDonacion() {
		return this.idTipoDonacion;
	}

	public void setIdTipoDonacion(int idTipoDonacion) {
		this.idTipoDonacion = idTipoDonacion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Donacione> getDonaciones() {
		return this.donaciones;
	}

	public void setDonaciones(List<Donacione> donaciones) {
		this.donaciones = donaciones;
	}

	public Donacione addDonacione(Donacione donacione) {
		getDonaciones().add(donacione);
		donacione.setTipoDonacion(this);

		return donacione;
	}

	public Donacione removeDonacione(Donacione donacione) {
		getDonaciones().remove(donacione);
		donacione.setTipoDonacion(null);

		return donacione;
	}
}
