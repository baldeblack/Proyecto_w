package com.SiteService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.TenantControllers.CDesaparecidos;
import com.TenantInterfaces.ICDesaparecidos;
import com.entities.Desaparecido;
import com.google.gson.Gson;
import com.utilities.MessageInput;

@Path("/LostsServies")
public class LostsServies {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/AllDesaparecidos/{input}")
	public Response GetAllDesaparecidos(@PathParam("input") String input){
		Gson gson = new Gson();
		MessageInput request = gson.fromJson(input, MessageInput.class);
		ICDesaparecidos controller = new CDesaparecidos(request.getBdConnection());
		short state = 1;
		String response =  controller.GetDesaparecidosByState(state);
		return Response.ok(response).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/AllDesaparecidosMobile/{input}")
	public Response GetAllDesaparecidosMobile(@PathParam("input") String input){
		Gson gson = new Gson();
		MessageInput request = gson.fromJson(input, MessageInput.class);
		ICDesaparecidos controller = new CDesaparecidos(request.getBdConnection());
	
		String response =  controller.GetAllDesaparecidosMobile();
		return Response.ok(response).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/LostReport/{input}")
	public Response InsertUpdateLost(@PathParam("input") String input){
	    Gson gson = new Gson();
		MessageInput<Desaparecido> request = gson.fromJson(input, MessageInput.class);
		ICDesaparecidos controller = new CDesaparecidos(request.getBdConnection());
		
		int response =  controller.InsertUpdateDesaparecido(gson.toJson(request.getEntity()));
		return Response.ok(response).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/LostChangeState/{idCat}/{idDes}/{state}")
	public String ChangeStateLost(@PathParam("idCat") int idCat, @PathParam("idDes") int idDes, @PathParam("state") Short state,  @QueryParam("callback") String callback){
	    
		ICDesaparecidos controller = new CDesaparecidos(idCat);
		boolean response = controller.UpdateDesaparecidoState(idDes, state);
		
		return (callback + "(" + response + ")");
	}
}
