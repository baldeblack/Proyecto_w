package com.SiteService;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.Controllers.CCatastrofe;
import com.Entities.Catastrofe;
import com.Interfaces.ICCatastrofe;
import com.google.gson.Gson;

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

}
