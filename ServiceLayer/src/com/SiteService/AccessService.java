package com.SiteService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Controllers.CCatastrofe;
import com.Entities.Catastrofe;
import com.Helper.CatastrofeMobile;
import com.Interfaces.ICCatastrofe;
import com.TenantControllers.CUsuario;
import com.TenantInterfaces.ICUsuario;
import com.entities.Usuario;
import com.google.gson.Gson;
import com.utilities.MessageInput;

@Path("/AccessService")
public class AccessService {

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/AllCatastrofes")
	public Response getAllCatastrofes(){
		ICCatastrofe controller = new CCatastrofe();
		Gson gson = new Gson();
		String dataString =  gson.toJson(controller.getAllCatastrofes(), List.class);
		return Response.ok(dataString).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/CatastrofeByDomain/{domain}")
	public Response getCatastrofeByDomain(@PathParam("domain") String domain){
		ICCatastrofe controller = new CCatastrofe();
		Gson gson = new Gson();
		String dataString =  gson.toJson(controller.GetCatastrofeByDomain(domain), Catastrofe.class);
		return Response.ok(dataString).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/CatastrofeByDomainMobile/{domain}")
	public Response getCatastrofeByDomainMobile(@PathParam("domain") String domain){
		ICCatastrofe controller = new CCatastrofe();
		Gson gson = new Gson();
		String dataString =  gson.toJson(controller.GetCatastrofeByDomainMobile(domain), CatastrofeMobile.class);
		return Response.ok(dataString).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Login/{input}")
	public Response getLoginUser(@PathParam("input") String input){
		Gson gson = new Gson();
		MessageInput request = gson.fromJson(input, MessageInput.class);
		ICUsuario controller = new CUsuario(request.getBdConnection());
		String dataString =  controller.getUsuarioByMail(request.getExtendedProperty().get(0).toString());
		return Response.ok(dataString).build();
		
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Registro/{input}")
	public Response inserUpdatetUser(@PathParam("input") String input){
		Gson gson = new Gson();
		MessageInput<Usuario> request = gson.fromJson(input, MessageInput.class);
		ICUsuario controller = new CUsuario(request.getBdConnection());
		int dataString =  controller.InsertUpdateUsuario(gson.toJson(request.getEntity()));
		
		return Response.ok(dataString).build();
	}
}
