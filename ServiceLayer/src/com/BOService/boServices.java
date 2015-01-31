package com.BOService;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Controllers.CUsuarios;
import com.Entities.Usuario;
import com.Interfaces.ICUsuarios;
import com.google.gson.Gson;



@Path("/boservice")
public class boServices {
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("login/{mail}/{pass}")
//	public Response ExisteUsu(@PathParam("mail") String mail, @PathParam("pass") String pass){
//		
//		String response = null;
//		ICUsuarios iu = new CUsuarios();
//		Usuario u  = iu.Login(mail, pass);
//		Gson g = new Gson();
//		response = g.toJson(u);
//		return Response.ok(response).build();
//
//		
//	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("login/{input}")
	public Response ExisteUsu(@PathParam("input") String input){
		
		String response = null;
		ICUsuarios iu = new CUsuarios();
		Gson g = new Gson();
		login l = g.fromJson(input, login.class);
		Usuario u  = iu.Login(l.mail, l.pass);
		
		response = g.toJson(u);
		return Response.ok(response).build();

		
	}
	
	public class login{
		public String mail;
		public String pass;
	}
	
}
