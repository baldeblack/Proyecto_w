package com.Controllers;

import com.DAO.AdminDAO;
import com.Entities.Administrador;
import com.Interfaces.ICAdministrador;

public class CAdministrador implements ICAdministrador {
	
	private AdminDAO admDAO;
	
	public CAdministrador(){
		admDAO = new AdminDAO();
	}	

	@Override
	public void AltaAdmin(Administrador adm) {
		// TODO Auto-generated method stub
		admDAO.GuardarUsuario(adm);
	}

	@Override
	public Boolean Existe(Administrador adm) {
		// TODO Auto-generated method stub
		return admDAO.ExisteUsu(adm);
	}

	@Override
	public void CrearTenant(String queryCommand) {
		// TODO Auto-generated method stub
		admDAO.CrearTenant(queryCommand);
	}	
	
}
