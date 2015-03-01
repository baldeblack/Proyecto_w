package com.models;

public class pasoFormModel {
	
	private int idPlan;

	private int idPaso;
	
	private int estado;
	
	private String nombre_paso;
	
	private String descripcion_paso;

	private String accion;
	
	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	public String getNombre_paso() {
		return nombre_paso;
	}

	public void setNombre_paso(String nombre_paso) {
		this.nombre_paso = nombre_paso;
	}

	public String getDescripcion_paso() {
		return descripcion_paso;
	}

	public void setDescripcion_paso(String descripcion_paso) {
		this.descripcion_paso = descripcion_paso;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public int getIdPaso() {
		return idPaso;
	}

	public void setIdPaso(int idPaso) {
		this.idPaso = idPaso;
	}
}
