package com.BOService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.Controllers.CCatastrofe;
import com.Controllers.CPlanes;
import com.Controllers.CUsuarios;
import com.Entities.Catastrofe;
import com.Entities.Paso;
import com.Entities.Rescatistacatastrofe;
import com.Entities.Tipocatastrofe;
import com.Entities.Usuario;
import com.Entities.Plan;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICPlanes;
import com.Interfaces.ICUsuarios;
import com.google.gson.Gson;



@Path("/boservice")
public class boServices {
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/login/{mail}/{pass}")
	public String ExisteUsu(@PathParam("mail") String mail, @PathParam("pass") String pass, @QueryParam("callback") String callback){
		
		String response = null;
		ICUsuarios iu = new CUsuarios();
		Gson g = new Gson();
		Usuario u  = iu.Login(mail, pass);
		response = g.toJson(u);
		return (callback + "(" + response + ")");
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getcatastofe/{idUsr}")
	public String getCatastrofe(@PathParam("idUsr") Integer idUsr, @QueryParam("callback") String callback){
		
		String response = null;
		ICPlanes ip = new CPlanes();
		Rescatistacatastrofe rc = ip.getRescatistacatastrofe(idUsr);
		ICCatastrofe ic =  new CCatastrofe();
		Catastrofe c = ic.getCatastrofeByID(rc.getIdcatastrofe());
		Gson g = new Gson();
		response = g.toJson(c);
		return (callback + "(" + response + ")");
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getplanes/{idCt}")
	public String getPlanes(@PathParam("idCt") Integer idCt, @QueryParam("callback") String callback){
		
		String response = null;
		ICPlanes ip = new CPlanes();
		Tipocatastrofe tipo =  new Tipocatastrofe();
		tipo = ip.getTipo(idCt);
		List<Plan> lstPl = new ArrayList<Plan>();
		lstPl = ip.getPlanes(tipo.getIdtipocatastrofe());
		Gson g = new Gson();
		response = g.toJson(lstPl);
		return (callback + "(" + response + ")");
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getpasos/{idPlan}")
	public String getPasos(@PathParam("idPlan") Integer idPlan, @QueryParam("callback") String callback){
		
		String response = null;
		ICPlanes ip = new CPlanes();		
		List<Paso> lstPl = new ArrayList<Paso>();
		lstPl = ip.getPasos(idPlan);
		Gson g = new Gson();
		response = g.toJson(lstPl);
		return (callback + "(" + response + ")");
		
	}	

}
