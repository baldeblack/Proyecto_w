package com.Interfaces;

import com.Entities.Administrador;

public interface ICAdministrador {

	void AltaAdmin(Administrador adm);
	Boolean Existe(Administrador adm);
	void CrearTenant(String queryCommand);
}
