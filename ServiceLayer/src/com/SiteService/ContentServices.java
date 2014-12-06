package com.SiteService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.TenantControllers.COng;
import com.TenantInterfaces.ICOng;
import com.google.gson.Gson;
import com.utilities.MessageInput;

@Path("/ContentServies")
public class ContentServices {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/AllONGs/{input}")
	public Response GetAllDesaparecidos(@PathParam("input") String input){
		Gson gson = new Gson();
		MessageInput request = gson.fromJson(input, MessageInput.class);
		ICOng controller = new COng(request.getBdConnection());
	
		String response =  controller.GetAllOngs();
		return Response.ok(response).build();
	}
}
