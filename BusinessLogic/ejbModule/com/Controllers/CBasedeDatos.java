package com.Controllers;

import java.sql.SQLException;

import com.DAO.TenantDAO;
import com.Interfaces.ICBasedeDatos;

public class CBasedeDatos implements ICBasedeDatos{

	TenantDAO _dao;
	public CBasedeDatos() {
		_dao = new TenantDAO();
	}
	@Override
	public void CrearTenantTables(String tenantName) throws SQLException, ClassNotFoundException {
		_dao.CrearTenantTables(tenantName);
		
	}
	@Override
	public void CrearTenantDB(String tenantName) throws SQLException, ClassNotFoundException {
		_dao.CrearTenantDB(tenantName);
		
	}
}
