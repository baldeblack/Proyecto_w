package com.models;

import java.util.ArrayList;
import java.util.List;

import com.Controllers.CCatastrofe;
import com.Controllers.CPlanes;
import com.Entities.Catastrofe;
import com.Entities.Plan;
import com.Entities.Rescatistacatastrofe;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICPlanes;
import com.TenantControllers.CDesaparecidos;
import com.TenantInterfaces.ICDesaparecidos;
import com.entities.Desaparecido;

public class rescatisaHomeModel {
	
	private Catastrofe ct;
	private List<Plan> lstPlanes;
	private List<Desaparecido> lstdesaparecidos;	
	
	
	
	public rescatisaHomeModel(int idUsr){
		lstPlanes = new ArrayList<Plan>();
		ICPlanes ip = new CPlanes();
		Rescatistacatastrofe rc =  new Rescatistacatastrofe();
		rc = ip.getRescatistacatastrofe(idUsr);
		ICCatastrofe ic =  new CCatastrofe();
		lstPlanes = new ArrayList<Plan>();
		lstdesaparecidos = new ArrayList<Desaparecido>();
		ct = new Catastrofe();
		if (rc != null){		
		ct = ic.getCatastrofeByID(rc.getIdcatastrofe());	
		lstPlanes = ip.getPlanesBO(ct.getTipo());		
		ICDesaparecidos id = new CDesaparecidos(rc.getIdcatastrofe());
		lstdesaparecidos = id.GetDesaparecidosByIdBO(rc.getIdcatastrofe());	
		}
		
	}
	public Catastrofe getCt() {
		return ct;
	}
	public void setCt(Catastrofe ct) {
		this.ct = ct;
	}
	public List<Plan> getLstPlanes() {
		return lstPlanes;
	}
	public void setLstPlanes(List<Plan> lstPlanes) {
		this.lstPlanes = lstPlanes;
	}
	public List<Desaparecido> getLstdesaparecidos() {
		return lstdesaparecidos;
	}
	public void setLstdesaparecidos(List<Desaparecido> lstdesaparecidos) {
		this.lstdesaparecidos = lstdesaparecidos;
	}
	
}
