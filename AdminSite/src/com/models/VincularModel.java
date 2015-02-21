package com.models;

import java.util.List;

import com.Entities.ONG;
import com.Helper.ongsBorrado;
import com.utils.RescatistaUtil;

public class VincularModel {

	private String ctNombre;
	private Integer idCt;
	private List<RescatistaUtil> rescatisasLst;	
	private String jsonData;
	private List<ONG> ongSistemaLst;
	private List<ongsBorrado> ongTenantLst;
	private String jsonDataResc;
	
	public List<ongsBorrado> getOngTenantLst() {
		return ongTenantLst;
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
	public List<RescatistaUtil> getRescatisasLst() {
		return rescatisasLst;
	}
	public void setRescatisasLst(List<RescatistaUtil> rescatisasLst) {
		this.rescatisasLst = rescatisasLst;
	}
	public String getJsonData() {
		return jsonData;
	}
	public void setJsonData(String jsonData) {
		this.jsonData = jsonData;
	}

	public String getJsonDataResc() {
		return jsonDataResc;
	}

	public void setJsonDataResc(String jsonDataResc) {
		this.jsonDataResc = jsonDataResc;
	}
}
