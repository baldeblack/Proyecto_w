package com.models;

import java.util.List;

import com.Entities.ONG;
import com.Helper.ongsBorrado;

public class ongCatastofeModel {
	
	private String ctNombre;
	private Integer idCt;
	private List<ONG> ongSistemaLst;
	private List<ongsBorrado> ongTenantLst;
	private String jsonData;
	
	public List<ongsBorrado> getOngTenantLst() {
		return ongTenantLst;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}
	public void setOngTenantLst(List<ongsBorrado> ongTenantLst) {
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
