package com.TenantControllers;

import java.util.List;

import com.DAO.UsuariosDAO;
import com.TenantInterfaces.ICUsuario;
import com.entities.Usuario;
import com.google.gson.Gson;

public class CUsuario implements ICUsuario {

	Gson _gson;
	UsuariosDAO _dao;
	
	public CUsuario(String connection){
		_dao = new UsuariosDAO(connection);
		_gson= new Gson();
	}
	
	@Override
	public String getAllUsuarios() {
		return _gson.toJson(_dao.getAllUsuarios(), List.class);
	}

	@Override
	public String getUsuarioById(int id) {
		return _gson.toJson(_dao.getUsuarioById(id), Usuario.class);
	}

	@Override
	public String getUsuarioByMail(String mail) {
		return _gson.toJson(_dao.getUsuarioByMail(mail), Usuario.class);
	}

	@Override
	public int InsertUpdateUsuario(String input) {
		return _dao.InsertUpdateUsuario(_gson.fromJson(input, Usuario.class));
	}

}
