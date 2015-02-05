package com.Controllers;

import java.sql.SQLException;
import java.util.List;

import com.DAO.RescatistaCatastrofeDAO;
import com.DAO.UsuarioDAO;
import com.Entities.Rescatista;
import com.Entities.Rescatistacatastrofe;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;
import com.Interfaces.ICUsuarios;

public class CUsuarios implements ICUsuarios{

	UsuarioDAO _dao;
	RescatistaCatastrofeDAO _daor;
	
	public CUsuarios() {
		_dao = new UsuarioDAO();
		_daor = new RescatistaCatastrofeDAO();
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

	@Override
	public List<Usuario> GetUsuByTipo(int tipo) {
		// TODO Auto-generated method stub
		return _dao.GetUsuByTipo(tipo);
	}

	@Override
	public Integer estaAsociadoR(int idUSU) {
		// TODO Auto-generated method stub
		return _dao.estaAsociadoR(idUSU);
	}

	@Override
	public List<Rescatista> getRescatistas() {
		// TODO Auto-generated method stub
		return _dao.getRescatistas();
	}

	@Override
	public void AltaRel(Rescatistacatastrofe r) {
		// TODO Auto-generated method stub
		 _daor.AltaRel(r);
	}

}
