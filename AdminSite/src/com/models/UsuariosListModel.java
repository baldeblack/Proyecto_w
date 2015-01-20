package com.models;
import java.util.ArrayList;
import java.util.List;

import com.Controllers.CUsuarios;
import com.Entities.Usuario;
import com.Interfaces.ICUsuarios;

public class UsuariosListModel {

	private List<Usuario> lstUsuarios;
	
	public UsuariosListModel(){
		setLstUsuarios(new ArrayList<Usuario>());
			ICUsuarios ic = new CUsuarios();
			setLstUsuarios(ic.GetAllUsuarios());	
	}

	public List<Usuario> getLstUsuarios() {
		return lstUsuarios;
	}

	public void setLstUsuarios(List<Usuario> lstUsuarios) {
		this.lstUsuarios = lstUsuarios;
	}
}
