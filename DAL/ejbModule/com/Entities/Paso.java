package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pasos database table.
 * 
 */
@Entity
@Table(name="pasos")
@NamedQuery(name="Paso.findAll", query="SELECT p FROM Paso p")
public class Paso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PasoPK id;

	private String descripcion;

	private String estado;

	private String nombre;

	public Paso() {
	}

	public PasoPK getId() {
		return this.id;
	}

	public void setId(PasoPK id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}