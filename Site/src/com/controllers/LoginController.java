package com.controllers;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Catastrofe;
import com.entities.Usuario;
import com.google.gson.Gson;
import com.models.LoginModel;
import com.utilities.HashHandler;
import com.utilities.ServiceConnectionHelper;
import com.utilities.SessionHandler;
import java.util.List;

@Controller
@RequestMapping("/access")
public class LoginController {
	
	
	
	@RequestMapping( value="/logon", method = RequestMethod.POST)
	@ResponseBody
	public String performLogin(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
		
		Gson g = new Gson();
		 try 
		 {
			 if(json.isEmpty()){
				SessionHandler.getInstance().closeActiveSesion(request);
			 }
			 else{
				 LoginModel model = g.fromJson(json, LoginModel.class);
				 if(model != null && model.getEmail() != "" && model.getPassword() != ""){
					 HttpSession session = request.getSession(true);
					 Catastrofe c = (Catastrofe)session.getAttribute("Catastrofe");

					 List<String> listProp = new ArrayList<String>();
					 listProp.add(model.getEmail());

					 String jspnresp = ServiceConnectionHelper.CallServiceMethoodPOST("AccessService", "Login", c.getStringConeccion(),listProp);
					
					 Usuario usr = g.fromJson(jspnresp, Usuario.class);
					 if(usr != null){
						 if(HashHandler.getSecurePassword(model.getPassword()).equals(usr.getPassword())){
							 SessionHandler.getInstance().setActiveUser(usr, request);
							 return "Sussess";
						 }
					 }
				 }
			}
			 return "onError";
		}
		catch (ServletException e) 
		{
			e.printStackTrace();
			return "onError";
		}
	}
	
}