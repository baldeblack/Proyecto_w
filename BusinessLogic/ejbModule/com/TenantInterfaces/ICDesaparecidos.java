package com.TenantInterfaces;

import java.util.List;

import com.entities.Desaparecido;



public interface ICDesaparecidos {
	 String GetAllDesaparecidos();
	 String GetAllDesaparecidosMobile();
	 String GetDesaparecidosByState(short state);
	 String GetDesaparecidosById(int id);
	 List<Desaparecido> GetDesaparecidosByIdBO(int id);
	 int InsertUpdateDesaparecido(String input);
	 boolean UpdateDesaparecidoState(int idDes, short state);
	 void ChangeStateDesaparecido(int id, short state);
}
