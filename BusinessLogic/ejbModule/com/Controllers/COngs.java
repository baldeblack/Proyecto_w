package com.Controllers;

import java.sql.SQLException;
import java.util.List;

import com.DAO.OngDAO;
import com.Entities.ONG;
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
	public List<ONG> GetOngsTenant(int tenantId) throws ClassNotFoundException,
			SQLException {
		// TODO Auto-generated method stub
		return _dao.GetOngsTenant(tenantId);
	}
	@Override
	public void ActualizarOTenant(int tenantId, List<ONG> lstMod)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		_dao.ActualizarOTenant(tenantId, lstMod);
	}
	
	
}
