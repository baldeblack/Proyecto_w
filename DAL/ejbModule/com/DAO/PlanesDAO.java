package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import com.Entities.PasosPlanEmergenca;
import com.Entities.PlanEmergencia;
import com.Helper.EntityManagerHelper;

public class PlanesDAO {

		EntityManager _eManager;
		
		public PlanesDAO(){
			_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
		}
		
		public void AltaPlan(PlanEmergencia plan, List<PasosPlanEmergenca> pasos){
			
		}
		
}
