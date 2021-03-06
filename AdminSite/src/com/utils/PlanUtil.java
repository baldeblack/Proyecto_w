package com.utils;

import java.util.List;

import com.models.pasoFormModel;

public class PlanUtil {
	
	private int idPlan;

	private int cantidadPasos;

	private String descripcion;

	private int estado;

	private int idTipoCatastrofe;

	private int idTipoPlan;

	private String nombre;

	private List<pasoFormModel> pasos;
	
	public int getIdPlan() {
		return idPlan;
	}

	public void setIdPlan(int idPlan) {
		this.idPlan = idPlan;
	}

	public int getCantidadPasos() {
		return cantidadPasos;
	}

	public void setCantidadPasos(int cantidadPasos) {
		this.cantidadPasos = cantidadPasos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getIdTipoCatastrofe() {
		return idTipoCatastrofe;
	}

	public void setIdTipoCatastrofe(int idTipoCatastrofe) {
		this.idTipoCatastrofe = idTipoCatastrofe;
	}

	public int getIdTipoPlan() {
		return idTipoPlan;
	}

	public void setIdTipoPlan(int idTipoPlan) {
		this.idTipoPlan = idTipoPlan;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<pasoFormModel> getPasos() {
		return pasos;
	}

	public void setPasos(List<pasoFormModel> pasos) {
		this.pasos = pasos;
	}
}
