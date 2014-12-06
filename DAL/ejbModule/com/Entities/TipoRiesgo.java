package com.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the TipoRiesgo database table.
 * 
 */
@Entity
@NamedQuery(name="TipoRiesgo.findAll", query="SELECT t FROM TipoRiesgo t")
public class TipoRiesgo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTipoRiesgo;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to GestionRiesgo
	@OneToMany(mappedBy="tipoRiesgo")
	private List<GestionRiesgo> gestionRiesgos;

	public TipoRiesgo() {
	}

	public int getIdTipoRiesgo() {
		return this.idTipoRiesgo;
	}

	public void setIdTipoRiesgo(int idTipoRiesgo) {
		this.idTipoRiesgo = idTipoRiesgo;
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

	public List<GestionRiesgo> getGestionRiesgos() {
		return this.gestionRiesgos;
	}

	public void setGestionRiesgos(List<GestionRiesgo> gestionRiesgos) {
		this.gestionRiesgos = gestionRiesgos;
	}

	public GestionRiesgo addGestionRiesgo(GestionRiesgo gestionRiesgo) {
		getGestionRiesgos().add(gestionRiesgo);
		gestionRiesgo.setTipoRiesgo(this);

		return gestionRiesgo;
	}

	public GestionRiesgo removeGestionRiesgo(GestionRiesgo gestionRiesgo) {
		getGestionRiesgos().remove(gestionRiesgo);
		gestionRiesgo.setTipoRiesgo(null);

		return gestionRiesgo;
	}

}