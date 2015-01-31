package com.Interfaces;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.Entities.Rptdata;
import com.Helper.donacionesRpt;

public interface ICReporte {

	 Rptdata getRptUso() throws SQLException, ClassNotFoundException;
	 Rptdata getRptUsoTenant(int idTenat);
	 List<donacionesRpt> getRptDonaciones(int idTenant, Date start, Date end) throws SQLException, ClassNotFoundException;
}
