package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipodonacion database table.
 * 
 */
@Entity
@NamedQuery(name="Tipodonacion.findAll", query="SELECT t FROM Tipodonacion t")
public class Tipodonacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTipoDonacion;

	private String descripcion;

	private String nombre;

	//bi-directional many-to-one association to Donacione
	@OneToMany(mappedBy="tipodonacion")
	private List<Donacione> donaciones;

	public Tipodonacion() {
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
		donacione.setTipodonacion(this);

		return donacione;
	}

	public Donacione removeDonacione(Donacione donacione) {
		getDonaciones().remove(donacione);
		donacione.setTipodonacion(null);

		return donacione;
	}

}