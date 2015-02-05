package com.models;

import java.util.List;

import com.utils.RescatistaUtil;

public class RescatistaModel {
		
	private String ctNombre;
	private Integer idCt;
	private List<RescatistaUtil> rescatisasLst;	
	private String jsonData;
	
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
		
}
