package com.models;

public class planFormModel {
	
	private int idPlan;

	private int cantidadPasos;

	private String descripcion;

	private int estado;

	private int idTipoCatastrofe;

	private int idTipoPlan;

	private String nombre;
	
	private String nombre_paso;
	
	private String descripcion_paso;

	private String accion;
	
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
}
