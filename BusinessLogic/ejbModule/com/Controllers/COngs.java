package com.Controllers;

import java.util.List;

import com.DAO.OngDAO;
import com.Entities.ONG;
import com.Interfaces.ICOngs;

public class COngs implements ICOngs {

	OngDAO _dao;
	public COngs() {
		// TODO Auto-generated constructor stub
		_dao = new OngDAO();
	}
	@Override
	public void AltaOng(ONG o) {
		_dao.AltaOng(o);
		
	}
	@Override
	public List<ONG> ListarOngs() {
		// TODO Auto-generated method stub
		return _dao.GetOngs();
	}
	
	
}
