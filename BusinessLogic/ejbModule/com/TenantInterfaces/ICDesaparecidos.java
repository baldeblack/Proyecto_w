package com.TenantInterfaces;



public interface ICDesaparecidos {
	 String GetAllDesaparecidos();
	 String GetDesaparecidosByState(short state);
	 String GetDesaparecidosById(int id);
	 int InsertUpdateDesaparecido(String input);
	 void ChangeStateDesaparecido(int id, short state);
}
