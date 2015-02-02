package com.TenantControllers;

import java.util.List;

import com.DAO.UsuariosDAO;
import com.TenantInterfaces.ICUsuario;
import com.Utilities.LogHelper;
import com.entities.Usuario;
import com.google.gson.Gson;

public class CUsuario implements ICUsuario {

	Gson _gson;
	UsuariosDAO _dao;
	String _connection;
	public CUsuario(String connection){
		_dao = new UsuariosDAO(connection);
		_gson= new Gson();
		_connection = connection;
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
		input = input.replace('+', ' ');
		Usuario us =_gson.fromJson(input, Usuario.class);
		int id = _dao.InsertUpdateUsuario(us);
		
		if(id>0)
			LogHelper.RegistroLoged(_connection);
		
		return id;
	}

}
