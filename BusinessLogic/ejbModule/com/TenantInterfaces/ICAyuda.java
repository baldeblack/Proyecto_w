package com.TenantInterfaces;

import com.entities.Ayuda;

public interface ICAyuda {
	
	String getAyudabyId(int id);
	String getAll();
	int InsertUpdateAyuda(String input);
}
