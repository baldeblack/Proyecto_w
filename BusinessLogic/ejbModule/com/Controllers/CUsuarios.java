package com.Controllers;

import java.util.List;

import com.DAO.UsuarioDAO;
import com.Entities.Rescatista;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;
import com.Interfaces.ICUsuarios;

public class CUsuarios implements ICUsuarios{

	UsuarioDAO _dao;
	public CUsuarios() {
		_dao = new UsuarioDAO();
	}
	
	@Override
	public List<TipoRescatista>  GetTipoRescatista() {
		return	_dao.GetTipoRescatista();
	}

	@Override
	public void AltaUsuario(Usuario u) {
		_dao.AltaUsuario(u);		
	}

	@Override
	public void AltaRescatista(Rescatista r) {
		_dao.AltaRescatista(r);		
	}

	@Override
	public TipoRescatista getTipoByID(int ID) {
		return _dao.getTipoByID(ID);		
	}

	@Override
	public Usuario ExisteUsu(String mail, String pass) {
		// TODO Auto-generated method stub
		return _dao.ExisteUsu(mail, pass);
	}

	@Override
	public Integer maxResId() {
		// TODO Auto-generated method stub
		return _dao.maxResId();
	}

	@Override
	public Integer maxUsrId() {
		// TODO Auto-generated method stub
		return _dao.maxUsrId();
	}

}
