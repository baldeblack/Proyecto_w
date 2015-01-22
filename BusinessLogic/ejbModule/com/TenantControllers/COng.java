package com.TenantControllers;

import java.util.List;

import com.DAO.OngSiteDAO;
import com.TenantInterfaces.ICOng;
import com.entities.Ong;
import com.google.gson.Gson;

public class COng implements ICOng {

	Gson _gson;
	OngSiteDAO _dao;
	
	public COng(String connection){
		_dao = new OngSiteDAO(connection);
		_gson= new Gson();
	}
	
	@Override
	public String GetAllOngs() {
		return _gson.toJson(_dao.getAllONGs(), List.class);
	}

	@Override
	public Ong getONGbyId(int id) {
		return _dao.getONGbyId(id);
	}

}
