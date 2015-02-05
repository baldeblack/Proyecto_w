package com.Interfaces;

import java.sql.SQLException;
import java.util.List;

import com.Entities.Rescatista;
import com.Entities.Rescatistacatastrofe;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;

public interface ICUsuarios {

	List<Usuario> GetAllUsuarios();
	List<TipoRescatista>  GetTipoRescatista();
	List<Rescatista> getRescatistas();
	void AltaUsuario(Usuario u);
	void AltaRescatista(Rescatista r);
	void ActualizarUsuario(Usuario u, Rescatista r, int usuId) throws Exception;
	TipoRescatista getTipoByID(int ID);
	Usuario Login(String mail, String pass);
	Integer maxResId();
	Integer maxUsrId();
	Usuario getUsuById(int id);
	Rescatista getRescatistaByUsuID(int id) throws ClassNotFoundException, SQLException;
	List<Usuario> GetUsuByTipo(int tipo);
	Integer estaAsociadoR(int idUSU);
	void AltaRel(Rescatistacatastrofe r);
}
