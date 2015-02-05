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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idpasos;

	private String descripcion;

	private String estado;

	private String nombre;

	//bi-directional many-to-one association to Plan
	@ManyToOne
	@JoinColumn(name="idPlan")
	private Plan plan;

	public Paso() {
	}

	public int getIdpasos() {
		return this.idpasos;
	}

	public void setIdpasos(int idpasos) {
		this.idpasos = idpasos;
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

	public Plan getPlan() {
		return this.plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

}