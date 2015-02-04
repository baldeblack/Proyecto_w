package com.Controllers;

import java.util.List;

import com.DAO.PasosDAO;
import com.DAO.PlanesDAO;
import com.DAO.RescatistaCatastrofeDAO;
import com.Entities.Paso;
import com.Entities.PasoPK;
import com.Entities.Plan;
import com.Entities.Rescatistacatastrofe;
import com.Entities.Tipocatastrofe;
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
	public List<Plan> getPlanes(int tipoCT) {
		return _dao.getPlanes(tipoCT);
	}
	@Override
	public List<Paso> getPasos(int idPlan) {
		return _dao.getPasos(idPlan);
	}
	
	@Override
	public int InserUpdatePlanesWithPasos(Plan plan, List<Paso> pasos) {
		
		PasosDAO pdao = new PasosDAO();
		int idPlan = _dao.InsertUpdatePlan(plan);
		if(idPlan > 0){
			for (Paso p : pasos) {
				PasoPK pk = new PasoPK();
				pk.setIdPlan(idPlan);
				p.setId(pk);
				
				pdao.InsertUpdatePlan(p);
			}
		
		}
		
		return idPlan;
	}
	
	public boolean UpdatePasoStep(int idPlan, int idPaso, int IdRescatista){
		
		PasosDAO pdao = new PasosDAO();
		PasoPK pk = new PasoPK();
		Paso p = pdao.GetPasoByPK(pk);
		if(p != null){
			p.setEstado("1");
			int res = pdao.InsertUpdatePlan(p);
			if(res > 0){
				RescatistaCatastrofeDAO rdao = new RescatistaCatastrofeDAO();
				return rdao.DeleteRescatista(IdRescatista);
			}
		}
		
		return false;
	}
}
