package com.SiteService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.TenantControllers.CAyuda;
import com.TenantControllers.CDonaciones;
import com.TenantControllers.COng;
import com.TenantInterfaces.ICAyuda;
import com.TenantInterfaces.ICDonaciones;
import com.TenantInterfaces.ICOng;
import com.entities.Ayuda;
import com.entities.Donacione;
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
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/AskHelp/{input}")
	public Response AskHelp(@PathParam("input") String input){
	    Gson gson = new Gson();
		MessageInput<Ayuda> request = gson.fromJson(input, MessageInput.class);
		ICAyuda controller = new CAyuda(request.getBdConnection());
		
		int response =  controller.InsertUpdateAyuda(gson.toJson(request.getEntity()));
		return Response.ok(response).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Donate/{input}")
	public Response MakeDonation(@PathParam("input") String input){
	    Gson gson = new Gson();
		MessageInput<Donacione> request = gson.fromJson(input, MessageInput.class);
		ICDonaciones controller = new CDonaciones(request.getBdConnection());
		
		int response =  controller.InsertUpdateDonacion(gson.toJson(request.getEntity()));
		return Response.ok(response).build();
	}
}
