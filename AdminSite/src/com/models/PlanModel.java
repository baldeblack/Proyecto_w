package com.models;

import java.util.ArrayList;
import java.util.List;

import com.Controllers.CUsuarios;
import com.Entities.PasosPlanEmergenca;
import com.Entities.TipoRescatista;
import com.Interfaces.ICUsuarios;

public class PlanModel {

	private byte[] plan;
	private String descripcion;
	private String nombre;
	private List<TipoRescatista> tiposrescatistas;
	private List<PasosPlanEmergenca> pasos;
	
	public PlanModel(){
		tiposrescatistas = new ArrayList<TipoRescatista>();
		ICUsuarios ic = new CUsuarios();
		tiposrescatistas = ic.GetTipoRescatista();
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<TipoRescatista> getTiposrescatistas() {
		return tiposrescatistas;
	}
	public void setTiposrescatistas(List<TipoRescatista> tiposrescatistas) {
		this.tiposrescatistas = tiposrescatistas;
	}
	public List<PasosPlanEmergenca> getPasos() {
		return pasos;
	}
	public void setPasos(List<PasosPlanEmergenca> pasos) {
		this.pasos = pasos;
	}
	public byte[] getPlan() {
		return plan;
	}
	public void setPlan(byte[] plan) {
		this.plan = plan;
	}
	
}
