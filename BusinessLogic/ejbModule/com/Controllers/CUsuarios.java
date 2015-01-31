package com.Controllers;

import java.sql.SQLException;
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
	public Usuario Login(String mail, String pass) {
		// TODO Auto-generated method stub
		return _dao.Login(mail, pass);
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

	@Override
	public List<Usuario> GetAllUsuarios() {
		// TODO Auto-generated method stub
		return _dao.GetAllUsuarios();
	}

	@Override
	public Usuario getUsuById(int id) {
		// TODO Auto-generated method stub
		return _dao.getUsuByID(id);
	}

	@Override
	public Rescatista getRescatistaByUsuID(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return _dao.getRescatistaByUsuID(id);
	}

	@Override
	public void ActualizarUsuario(Usuario u, Rescatista r, int usuId)
			throws Exception {
		_dao.ActualizarUsuario(u,r,usuId);		
	}

}
