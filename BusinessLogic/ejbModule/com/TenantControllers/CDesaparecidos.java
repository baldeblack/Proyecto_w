package com.TenantControllers;

import java.util.List;
import com.DAO.DesaparecidosDAO;
import com.TenantInterfaces.ICDesaparecidos;
import com.entities.Desaparecido;
import com.google.gson.Gson;


public class CDesaparecidos implements ICDesaparecidos {
	Gson _gson;
	DesaparecidosDAO _dao;
	
	public CDesaparecidos(String connection){
		_dao = new DesaparecidosDAO(connection);
		_gson= new Gson();
	}

	@Override
	public String GetAllDesaparecidos() {
		return _gson.toJson(_dao.getAllDesaparecidos(), List.class);
	}

	@Override
	public String GetDesaparecidosByState(short state) {
		return _gson.toJson(_dao.getAllDesaparecidosByState(state), List.class);
	}

	@Override
	public String GetDesaparecidosById(int id) {
		return _gson.toJson(_dao.getDesaparecidoById(id), Desaparecido.class);
	}

	@Override
	public int InsertUpdateDesaparecido(String input) {
		return _dao.InsertUpdateDesaparecido(_gson.fromJson(input, Desaparecido.class));
	}

	@Override
	public void ChangeStateDesaparecido(int id, short state) {
		 _dao.ChangeStateDesaparecido(id, state);
	}

}
