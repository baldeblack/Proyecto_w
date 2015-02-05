package com.Controllers;

import java.util.List;

import com.DAO.PlanesDAO;
import com.Entities.Paso;
import com.Entities.Plan;
import com.Entities.Rescatistacatastrofe;
import com.Entities.Tipocatastrofe;
import com.Helper.PlanUtil;
import com.Interfaces.ICPlanes;

public class CPlanes implements ICPlanes{
	
	PlanesDAO _dao;
	public CPlanes() {
		_dao = new PlanesDAO();
	}
	@Override
	public Rescatistacatastrofe getRescatistacatastrofe(int idUsr) {
		return _dao.getRescatistacatastrofe(idUsr);
	}
	@Override
	public Tipocatastrofe getTipo(int ctId) {
		return _dao.getTipo(ctId);
	}
	@Override
	public List<PlanUtil> getPlanes(int tipoCT) {
		return _dao.getPlanes(tipoCT);
	}
	@Override
	public List<Paso> getPasos(int idPlan) {
		return _dao.getPasos(idPlan);
	}
	@Override
	public int InserUpdatePlanesWithPasos(Plan input, List<Paso> pasos) {
		// TODO Auto-generated method stub
		input.setPasos(pasos);
		return _dao.InsertUpdatePlan(input);
	}
	@Override
	public boolean UpdatePasoStep(int idPlan, int idPaso, int idRescatista) {
		// TODO Auto-generated method stub
		boolean result = false;
		
		if(_dao.getPlanStatus(idPlan)){
			_dao.removeRC(idRescatista);
				Plan p = new Plan();
					p.setEstado(1);
					result = true;
		}
		
		return result;
	}
	@Override
	public Plan getPlan(int idPlan) {
		// TODO Auto-generated method stub
		return _dao.getPlan(idPlan);
	}
}
