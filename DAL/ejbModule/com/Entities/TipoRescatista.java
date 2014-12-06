package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TipoRescatista database table.
 * 
 */
@Entity
@NamedQuery(name="TipoRescatista.findAll", query="SELECT t FROM TipoRescatista t")
public class TipoRescatista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTipoRescatista;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional one-to-one association to Rescatista
	@OneToOne(mappedBy="tipoRescatista")
	private Rescatista rescatista;

	public TipoRescatista() {
	}

	public int getIdTipoRescatista() {
		return this.idTipoRescatista;
	}

	public void setIdTipoRescatista(int idTipoRescatista) {
		this.idTipoRescatista = idTipoRescatista;
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

	public Rescatista getRescatista() {
		return this.rescatista;
	}

	public void setRescatista(Rescatista rescatista) {
		this.rescatista = rescatista;
	}

}