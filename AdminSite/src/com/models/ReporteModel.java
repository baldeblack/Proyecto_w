package com.models;

import java.util.ArrayList;
import java.util.List;

import com.Controllers.CCatastrofe;
import com.Entities.Catastrofe;
import com.Interfaces.ICCatastrofe;

public class ReporteModel {

	List<Catastrofe> lstCT;
	String jsonFirst;
	int idFirst;
	
	public List<Catastrofe> getLstCT() {
		return lstCT;
	}

	public String getJsonFirst() {
		return jsonFirst;
	}

	public void setJsonFirst(String jsonFirst) {
		this.jsonFirst = jsonFirst;
	}

	public int getIdFirst() {
		return idFirst;
	}

	public void setIdFirst(int idFirst) {
		this.idFirst = idFirst;
	}

	public void setLstCT(List<Catastrofe> lstCT) {
		this.lstCT = lstCT;
	}

	public ReporteModel(){
		ICCatastrofe ic = new CCatastrofe();
		lstCT = new ArrayList<Catastrofe>();
		lstCT = ic.getAllCatastrofes();
	}; 
}
