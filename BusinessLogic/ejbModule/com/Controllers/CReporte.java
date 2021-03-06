package com.Controllers;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.DAO.ReportesDAO;
import com.Entities.Catastrofe;
import com.Entities.Rptdata;
import com.Helper.RptType;
import com.Helper.ayudaRpt;
import com.Helper.donacionesRpt;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICReporte;

public class CReporte implements ICReporte{

	ReportesDAO _dao;
	
	public CReporte() {
		_dao = new ReportesDAO();
	}
	
	@Override
	public Rptdata getRptUso() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return _dao.getRptUso();
	}

	@Override
	public Rptdata getRptUsoTenant(int idTenat) {
		// TODO Auto-generated method stub
		return _dao.getRptUsoTenant(idTenat);
	}

	@Override
	public  List<donacionesRpt>  getRptDonaciones(int idTenant, Date start, Date end)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return _dao.getRptDonaciones(idTenant, start, end);
	}

	@Override
	public int InsertUpdateRptData(String strngCatastrofe, RptType plastType) {
		ICCatastrofe cat = new CCatastrofe();
		Catastrofe c = cat.getCatastrofeByStringConnection(strngCatastrofe);
		return _dao.InsertUpdateRptData(c, plastType);
	}

	@Override
	public List<ayudaRpt> getRptAyuda(int idTenant, Date start, Date end)
			throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return _dao.getRptAyuda(idTenant, start, end);
	}

}
