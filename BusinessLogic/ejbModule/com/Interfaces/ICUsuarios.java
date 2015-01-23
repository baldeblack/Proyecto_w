package com.Interfaces;

import java.sql.SQLException;
import java.util.List;

import com.Entities.Rescatista;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;

public interface ICUsuarios {

	List<Usuario> GetAllUsuarios();
	List<TipoRescatista>  GetTipoRescatista();
	void AltaUsuario(Usuario u);
	void AltaRescatista(Rescatista r);
	void ActualizarUsuario(Usuario u, Rescatista r, int usuId) throws Exception;
	TipoRescatista getTipoByID(int ID);
	Usuario ExisteUsu(String mail, String pass);
	Integer maxResId();
	Integer maxUsrId();
	Usuario getUsuById(int id);
	Rescatista getRescatistaByUsuID(int id) throws ClassNotFoundException, SQLException;
}
