package com.Interfaces;

import java.sql.SQLException;
import java.util.List;

import com.Entities.ONG;
import com.Helper.ongsBorrado;

public interface ICOngs {
	 void AltaOng(ONG o);
	 List<ONG> ListarOngs();
	 ONG getONG(int idOng);
	 void ActualizarOng(ONG o, Integer idOng);
	 Integer maxOngId();
	 List<ongsBorrado> GetOngsTenant(int tenantId) throws ClassNotFoundException, SQLException;
	 void actualizaTodo(ONG o) throws ClassNotFoundException, SQLException;
	 void InsertOTenant(int tenantId, ONG ong) throws ClassNotFoundException, SQLException;
	 void DeleteOTenant(int tenantId, String nombreOng) throws ClassNotFoundException, SQLException;
	 Integer GetOngByNombre(String nombre);
	 
}
