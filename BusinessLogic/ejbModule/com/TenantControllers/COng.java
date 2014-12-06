package com.TenantControllers;

import java.util.List;

import com.DAO.ONGDAO;
import com.TenantInterfaces.ICOng;
import com.google.gson.Gson;

public class COng implements ICOng {

	Gson _gson;
	ONGDAO _dao;
	
	public COng(String connection){
		_dao = new ONGDAO(connection);
		_gson= new Gson();
	}
	
	@Override
	public String GetAllOngs() {
		return _gson.toJson(_dao.getAllONGs(), List.class);
	}

}
