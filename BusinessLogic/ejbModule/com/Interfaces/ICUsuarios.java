package com.Interfaces;

import java.util.List;

import com.Entities.Rescatista;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;

public interface ICUsuarios {

	List<Usuario> GetAllUsuarios();
	List<TipoRescatista>  GetTipoRescatista();
	void AltaUsuario(Usuario u);
	void AltaRescatista(Rescatista r);
	TipoRescatista getTipoByID(int ID);
	Usuario ExisteUsu(String mail, String pass);
	Integer maxResId();
	Integer maxUsrId();
}
