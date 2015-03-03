package com.BOService;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Controllers.CCatastrofe;
import com.Controllers.CPlanes;
import com.Controllers.CUsuarios;
import com.Entities.Catastrofe;
import com.Entities.Paso;
import com.Entities.Rescatistacatastrofe;
import com.Entities.Tipocatastrofe;
import com.Entities.Usuario;
import com.Entities.Plan;
import com.Helper.PasoUtil;
import com.Helper.PlanUtil;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICPlanes;
import com.Interfaces.ICUsuarios;
import com.TenantControllers.CDesaparecidos;
import com.TenantInterfaces.ICDesaparecidos;
import com.google.gson.Gson;
import com.utilities.MessageInput;



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
		List<PlanUtil> lstPl = new ArrayList<PlanUtil>();
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
		Plan p = new Plan();
		List<PasoUtil> lstPl = new ArrayList<PasoUtil>();
		p = ip.getPlan(idPlan);
		
		for(Paso paso: p.getPasos()){
			PasoUtil pl = new PasoUtil();
			pl.setDescripcion(paso.getDescripcion());			
			pl.setIdpasos(paso.getIdpasos());
			pl.setNombre(paso.getNombre());		
			lstPl.add(pl);
		}	
		Gson g = new Gson();
		response = g.toJson(lstPl);
		return (callback + "(" + response + ")");
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updatePaso/{idPlan}/{idPaso}/{idRescatista}")
	public Response UpdatePasoStep(@PathParam("idPlan") int idPlan,@PathParam("idPaso") int idPaso, @PathParam("idRescatista") int idRescatista){
		ICPlanes ip = new CPlanes();
		int res = ip.UpdatePasoStep(idPlan, idPaso, idRescatista);
		return Response.ok(res).build(); 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/AllDesaparecidosMobileCallback/{input}")
	public String GetAllDesaparecidosMobile(@PathParam("input") String input, @QueryParam("callback") String callback){
		Gson gson = new Gson();
		MessageInput request = gson.fromJson(input, MessageInput.class);
		ICDesaparecidos controller = new CDesaparecidos(request.getBdConnection());
	
		String response =  controller.GetAllDesaparecidosMobile();
		//String response = gson.toJson(controller.GetAllDesaparecidosMobile());
		return (callback + "(" + response + ")");
		
	}

}
