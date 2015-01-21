package com.models;
import java.util.ArrayList;
import java.util.List;

import com.Controllers.COngs;
import com.Entities.ONG;
import com.Interfaces.ICOngs;

public class OngsListModel {

	private List<ONG> lstOngs;
	
	public OngsListModel(){
		setLstOngs(new ArrayList<ONG>());
		ICOngs ic = new COngs();
		setLstOngs(ic.ListarOngs());	
		
	}

	public List<ONG> getLstOngs() {
		return lstOngs;
	}

	public void setLstOngs(List<ONG> lstOngs) {
		this.lstOngs = lstOngs;
	}

	
}
