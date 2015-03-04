package com.Controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
	public int InserUpdatePlanesWithPasos(Plan input, List<Paso> pasos) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//input.setPasos(pasos);
		List<Paso> nuevo = new ArrayList<Paso>();
		for(Paso ps:pasos){
			Paso pc = new Paso();
			pc.setDescripcion(ps.getDescripcion());
			pc.setEstado(ps.getEstado());
			pc.setIdpasos(ps.getIdpasos());
			pc.setNombre(ps.getNombre());
			nuevo.add(pc);
		}
		input.setCantidadPasos(pasos.size());
		int ret = _dao.InsertUpdatePlan(input);
	
		_dao.updatepaso(nuevo, input);
		return ret;
	}
	@Override
	public int UpdatePasoStep(int idPlan, int idPaso, int idRescatista) {
		// TODO Auto-generated method stub
		
		Plan p = _dao.getPlan(idPlan);
		
		for (Iterator<Paso> iterator = p.getPasos().iterator(); iterator.hasNext(); ) {
			Paso pi = iterator.next();
			if(pi.getIdpasos() == idPaso){
				pi.setEstado(String.valueOf(1));
			}
		}
		int result = _dao.InsertUpdatePlan(p);
		
		if(_dao.getPlanStatus(idPlan)){
			_dao.removeRC(idRescatista);			
					p.setEstado(1);
					_dao.InsertUpdatePlan(p);
		}
		
		return result;
	}
	@Override
	public Plan getPlan(int idPlan) {
		// TODO Auto-generated method stub
		return _dao.getPlan(idPlan);
	}
	@Override
	public int maxPasoId() {
		// TODO Auto-generated method stub
		return _dao.maxPasoId();
	}
	@Override
	public List<Plan> getPlanesBO(int tipoCT) {
		// TODO Auto-generated method stub
		return _dao.getPlanesBO(tipoCT);
	}
	@Override
	public List<Plan> getPlanes() {
		// TODO Auto-generated method stub
		return _dao.getPlanes();
	}
}
