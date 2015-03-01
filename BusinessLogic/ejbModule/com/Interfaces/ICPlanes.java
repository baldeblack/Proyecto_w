package com.Interfaces;

import java.util.List;

import com.Entities.Paso;
import com.Entities.Plan;
import com.Entities.Rescatistacatastrofe;
import com.Entities.Tipocatastrofe;
import com.Helper.PlanUtil;

public interface ICPlanes {
	Rescatistacatastrofe getRescatistacatastrofe(int idUsr);
	Tipocatastrofe getTipo(int ctId);
	List<PlanUtil> getPlanes(int tipoCT);
	List<Paso> getPasos(int idPlan);
	List<Plan> getPlanesBO(int tipoCT);
	int InserUpdatePlanesWithPasos(Plan input, List<Paso> pasos);
	int UpdatePasoStep(int idPlan, int idPaso, int idRescatista);
	 Plan getPlan(int idPlan);
	 int maxPasoId();
}
