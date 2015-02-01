package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the plan database table.
 * 
 */
@Entity
@NamedQuery(name="Plan.findAll", query="SELECT p FROM Plan p")
public class Plan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idPlan;

	private int cantidadPasos;

	private String descripcion;

	private int estado;

	private int idTipoCatastrofe;

	private int idTipoPlan;

	private String nombre;

	public Plan() {
	}

	public int getIdPlan() {
		return this.idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public int getCantidadPasos() {
		return this.cantidadPasos;
	}

	public void setCantidadPasos(int cantidadPasos) {
		this.cantidadPasos = cantidadPasos;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdTipoCatastrofe() {
		return this.idTipoCatastrofe;
	}

	public void setIdTipoCatastrofe(int idTipoCatastrofe) {
		this.idTipoCatastrofe = idTipoCatastrofe;
	}

	public int getIdTipoPlan() {
		return this.idTipoPlan;
	}

	public void setIdTipoPlan(int idTipoPlan) {
		this.idTipoPlan = idTipoPlan;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}