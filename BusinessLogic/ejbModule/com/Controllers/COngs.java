package com.Controllers;

import java.sql.SQLException;
import java.util.List;

import com.DAO.OngDAO;
import com.Entities.ONG;
import com.Helper.ongsBorrado;
import com.Interfaces.ICOngs;

public class COngs implements ICOngs {

	OngDAO _dao;
	public COngs() {
		// TODO Auto-generated constructor stub
		_dao = new OngDAO();
	}
	@Override
	public void AltaOng(ONG o) {
		_dao.AltaOng(o);
		
	}
	@Override
	public List<ONG> ListarOngs() {
		// TODO Auto-generated method stub
		return _dao.GetOngs();
	}
	@Override
	public ONG getONG(int idOng) {
		// TODO Auto-generated method stub
		return _dao.getONG(idOng);
	}
	@Override
	public void ActualizarOng(ONG o, Integer idOng) {
		_dao.ActualizarOng(o, idOng);		
	}
	@Override
	public Integer maxOngId() {
		// TODO Auto-generated method stub
		return _dao.maxOngId();
	}
	@Override
	public List<ongsBorrado> GetOngsTenant(int tenantId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return _dao.GetOngsTenant(tenantId);
	}
	
	@Override
	public void InsertOTenant(int tenantId, ONG ong)
			throws ClassNotFoundException, SQLException {
		_dao.InsertOTenant(tenantId, ong);
		
	}
	@Override
	public void DeleteOTenant(int tenantId, String nombreOng)
			throws ClassNotFoundException, SQLException {
		_dao.DeleteOTenant(tenantId, nombreOng);
		
	}
	@Override
	public Integer GetOngByNombre(String nombre) {
		// TODO Auto-generated method stub
		return _dao.GetOngByNombre(nombre);
	}
	@Override
	public void actualizaTodo(ONG o) throws ClassNotFoundException,
			SQLException {
		_dao.actualizaTodo(o);
		
	}
	
	
}
