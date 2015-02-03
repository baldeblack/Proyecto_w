package com.Interfaces;

import java.util.List;

import com.Entities.Paso;
import com.Entities.Plan;
import com.Entities.Rescatistacatastrofe;
import com.Entities.Tipocatastrofe;

public interface ICPlanes {
	Rescatistacatastrofe getRescatistacatastrofe(int idUsr);
	Tipocatastrofe getTipo(int ctId);
	List<Plan> getPlanes(int tipoCT);
	List<Paso> getPasos(int idPlan);
	
	int InserUpdatePlanesWithPasos(Plan plan, List<Paso> pasos);
}
