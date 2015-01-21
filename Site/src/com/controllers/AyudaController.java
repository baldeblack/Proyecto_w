package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Ayuda;
import com.entities.Catastrofe;
import com.entities.Usuario;
import com.google.gson.Gson;
import com.models.HelpModel;
import com.utilities.ServiceConnectionHelper;
import com.utilities.SessionHandler;

@Controller
@RequestMapping("/help")
public class AyudaController {
	
	@RequestMapping( value="/ask", method = RequestMethod.POST)
	@ResponseBody
	public String SendHelp(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
		Gson g = new  Gson();
		HelpModel model = g.fromJson(json, HelpModel.class);
		 if(model != null && model.getMessage() != "" ){
			 HttpSession session = request.getSession(true);
			 Catastrofe c = (Catastrofe)session.getAttribute("Catastrofe");
			 Ayuda help = new Ayuda();
			 help.setCanal((short)1);
			 help.setTelefono(model.getTelefono());
			 help.setMensaje(model.getMessage());
			 help.setTipoSolicitor(model.getTypeRequest());
			 help.setUsuario(SessionHandler.getInstance().getActiveUser(request));
			 help.setUbicacion(model.getLocation());
			 String jsonresp = ServiceConnectionHelper.CallServiceMethoodPOST("ContentServies", "AskHelp", c.getStringConeccion(), help);
			
			 if(Integer.parseInt(jsonresp) >0){
				return "success";
			}
			else{
				return "onError";
			} 
		 }
		 
		 return "onError";
	}
}
