package com.TenantInterfaces;


public interface ICUsuario {
	
	 String getAllUsuarios();
	
	 String getUsuarioById(int id);
	 
	 String getUsuarioByMail(String mail);
	 
	 int InsertUpdateUsuario(String  input);

}
