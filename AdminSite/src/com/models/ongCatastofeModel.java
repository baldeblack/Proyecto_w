package com.models;

import java.util.List;

import com.Entities.ONG;

public class ongCatastofeModel {
	
	private String ctNombre;
	private Integer idCt;
	private List<ONG> ongSistemaLst;
	private List<ONG> ongTenantLst;
	
	public List<ONG> getOngTenantLst() {
		return ongTenantLst;
	}
	public void setOngTenantLst(List<ONG> ongTenantLst) {
		this.ongTenantLst = ongTenantLst;
	}
	public List<ONG> getOngSistemaLst() {
		return ongSistemaLst;
	}
	public void setOngSistemaLst(List<ONG> ongSistemaLst) {
		this.ongSistemaLst = ongSistemaLst;
	}
	public String getCtNombre() {
		return ctNombre;
	}
	public void setCtNombre(String ctNombre) {
		this.ctNombre = ctNombre;
	}
	public Integer getIdCt() {
		return idCt;
	}
	public void setIdCt(Integer idCt) {
		this.idCt = idCt;
	}

}
