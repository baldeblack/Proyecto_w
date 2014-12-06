package com.BOService;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.Controllers.CCatastrofe;
import com.Entities.Catastrofe;
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

}
