package com.BOService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Controllers.CCatastrofe;
import com.Entities.Catastrofe;
import com.Helper.CatastrofeLight;
import com.Interfaces.ICCatastrofe;

@Path("/CatastrofeServices")
public class CatastrofeServices {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("GetAllCatastrofes/")
	public Response GetAllCatastrofes(){
		List<Catastrofe> response = null;
	
		ICCatastrofe controller = new CCatastrofe();
		response = controller.getAllCatastrofes();
		return Response.ok(response).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("GetAllCatastrofesLight/")
	public Response GetAllCatastrofesLight(){
		List<CatastrofeLight> response = null;
		ICCatastrofe controller = new CCatastrofe();
		response = controller.getAllCatastrofesLight();
		return Response.ok(response).build();
	}

}
