package com.Interfaces;

import java.sql.SQLException;

public interface ICBasedeDatos {

	 void CrearTenantTables(String tenantName) throws SQLException, ClassNotFoundException;
	 void CrearTenantDB(String tenantName) throws SQLException, ClassNotFoundException;
}
