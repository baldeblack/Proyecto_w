package com.SiteService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.TenantControllers.CDesaparecidos;
import com.TenantInterfaces.ICDesaparecidos;
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
	
		String response =  controller.GetAllDesaparecidos();
		return Response.ok(response).build();
	}
}
