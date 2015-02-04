package com.models;

import java.util.ArrayList;
import java.util.List;

import com.Controllers.CCatastrofe;
import com.Entities.Paso;
import com.Entities.Tipocatastrofe;
import com.Interfaces.ICCatastrofe;

public class PlanModel {
	
	private String nombre;
	private String desc;
	private List<Paso> pasos;
	private int idTipoCatastrofe;
	private List<Tipocatastrofe> tiposct;
	String action;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public PlanModel(){
		ICCatastrofe ic = new CCatastrofe();
		this.tiposct = new ArrayList<Tipocatastrofe>();
		this.tiposct = ic.getTiposCT();
	}
	
	public List<Tipocatastrofe> getTiposct() {
		return tiposct;
	}
	public void setTiposct(List<Tipocatastrofe> tiposct) {
		this.tiposct = tiposct;
	}
	public List<Paso> getPasos() {
		return pasos;
	}
	public void setPasos(List<Paso> pasos) {
		this.pasos = pasos;
	}

	public int getIdTipoCatastrofe() {
		return idTipoCatastrofe;
	}

	public void setIdTipoCatastrofe(int idTipoCatastrofe) {
		this.idTipoCatastrofe = idTipoCatastrofe;
	}
		
}
