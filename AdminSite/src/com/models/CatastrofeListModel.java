package com.models;

import java.util.ArrayList;
import java.util.List;

import com.Controllers.CCatastrofe;
import com.Entities.Catastrofe;
import com.Interfaces.ICCatastrofe;

public class CatastrofeListModel {
	
	public CatastrofeListModel(){
	    ctList = new ArrayList<Catastrofe>();
		ICCatastrofe ic = new CCatastrofe();
		ctList = ic.getAllCatastrofes();		
	}
	
	public List<Catastrofe> getCtList() {
		return ctList;
	}

	public void setCtList(List<Catastrofe> ctList) {
		this.ctList = ctList;
	}

	public List<Catastrofe> ctList;
}
