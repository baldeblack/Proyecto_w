package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Controllers.CUsuarios;
import com.Entities.Usuario;
import com.Interfaces.ICUsuarios;
import com.google.gson.Gson;

@Controller
public class AccessController {


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String  getRedirect() {	
		return "Login";
	}     
	
	@RequestMapping(value = "dologin", method = RequestMethod.POST)
	public @ResponseBody String  doLogin(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) {		     
		Gson g = new Gson();		
		String url = null;
		credenciales cr = g.fromJson(json, credenciales.class);
		ICUsuarios cu = new CUsuarios();
		Usuario u = cu.Login(cr.mail, cr.pass);
		if(u != null){
			 HttpSession session = request.getSession(true);
			 session.setAttribute("user", u);
			 if(u.getTipoUsuario() == 0){
				 url = "/BackOffice/catastrofes";
			 }else{
				 url = "/BackOffice/rescatista";
			 }
		}
	    	       
		String jsonresp = g.toJson(url);
		return jsonresp;
		
	}
	
	@RequestMapping(value = "dologout", method = RequestMethod.GET)
	public  String  doLogout(HttpServletResponse res, HttpServletRequest request) {	     
			 HttpSession session = request.getSession(true);
			 session.setAttribute("user", null);
			 return  "Login";	
	}
	
	@RequestMapping(value = "forbhiden", method = RequestMethod.GET)
	public  String  forbhiden(HttpServletResponse res, HttpServletRequest request) {	     
			
			 return  "noaccess";	
	}
	
	
	
	public class credenciales {
		String mail;
		String pass;
	}
	
}
