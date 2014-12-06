package com.BOService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Controllers.CAdministrador;
import com.Entities.Administrador;
import com.Interfaces.ICAdministrador;

@Path("/SAdmin")
public class SAdmin {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("admSave/{mail}")
	public Response GuardarUsu(@PathParam("mail") String admMail){
	ICAdministrador iAdm = new CAdministrador();
	Administrador adm = new Administrador();
	adm.setMail(admMail);
	adm.setPassword("123456");
	iAdm.AltaAdmin(adm);
	return Response.ok("Se dio de alta el administrador con el mail " + admMail).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("admExiste/{mail}")
	public Response ExisteUsu(@PathParam("mail") String admMail){
	Boolean response = null;
	ICAdministrador iAdm = new CAdministrador();
	Administrador adm = new Administrador();
	adm.setMail(admMail);
	adm.setPassword("123456");	
	
	response = iAdm.Existe(adm);
	return Response.ok(response).build();
	}
}
