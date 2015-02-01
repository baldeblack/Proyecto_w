package com.Controllers;

import java.util.List;

import com.DAO.PlanesDAO;
import com.Entities.Paso;
import com.Entities.Plan;
import com.Entities.Rescatistacatastrofe;
import com.Entities.Tipocatastrofe;
import com.Interfaces.ICPlanes;

public class CPlanes implements ICPlanes{
	
	PlanesDAO _dao;
	public CPlanes() {
		// TODO Auto-generated constructor stub
		_dao = new PlanesDAO();
	}
	@Override
	public Rescatistacatastrofe getRescatistacatastrofe(int idUsr) {
		// TODO Auto-generated method stub
		return _dao.getRescatistacatastrofe(idUsr);
	}
	@Override
	public Tipocatastrofe getTipo(int ctId) {
		// TODO Auto-generated method stub
		return _dao.getTipo(ctId);
	}
	@Override
	public List<Plan> getPlanes(int tipoCT) {
		// TODO Auto-generated method stub
		return _dao.getPlanes(tipoCT);
	}
	@Override
	public List<Paso> getPasos(int idPlan) {
		// TODO Auto-generated method stub
		return _dao.getPasos(idPlan);
	}
}
