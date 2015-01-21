package com.TenantControllers;

import com.DAO.DonacionDAO;
import com.TenantInterfaces.ICDonaciones;
import com.entities.Donacione;
import com.google.gson.Gson;

public class CDonaciones implements ICDonaciones {

	DonacionDAO _dao;
	Gson _gson;
	
	public CDonaciones (String connection){
		_dao = new DonacionDAO(connection);
		_gson = new Gson();
	}
	
	@Override
	public int InsertUpdateDonacion(String input) {
		input = input.replace('+', ' ');
		Donacione d =_gson.fromJson(input, Donacione.class);
		return _dao.InsertUpdateDonacion(d);
	}

}
