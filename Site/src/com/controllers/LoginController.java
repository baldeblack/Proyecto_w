package com.controllers;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Catastrofe;
import com.entities.Usuario;
import com.google.gson.Gson;
import com.models.LoginModel;
import com.models.UserModel;
import com.utilities.HashHandler;
import com.utilities.ServiceConnectionHelper;
import com.utilities.SessionHandler;

import java.util.List;

@Controller
@RequestMapping("/access")
public class LoginController {
	

	@RequestMapping( value="/logOut", method = RequestMethod.GET)
	public String logOut(HttpServletRequest request, HttpServletResponse response) {
		try {
			SessionHandler.getInstance().closeActiveSesion(request);
		} catch (ServletException e) {
			e.printStackTrace();
		}
		 return "redirect:/";
	}
	
	
	@RequestMapping( value="/logon", method = RequestMethod.POST)
	@ResponseBody
	public String doLogin(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
		
		Gson g = new Gson();
		 try 
		 {
			 if(json.isEmpty()){
				SessionHandler.getInstance().closeActiveSesion(request);
			 }
			 else{
				 LoginModel model = g.fromJson(json, LoginModel.class);
				 if(model != null && model.getEmail() != "" && model.getPassword() != ""){
					 Catastrofe c = SessionHandler.getInstance().getCurrentSite(request);

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
	
	@RequestMapping( value="/register", method = RequestMethod.POST)
	@ResponseBody
	public String insertUser(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
		Gson g = new Gson();
		try 
		{
			UserModel model = g.fromJson(json, UserModel.class);
			if(model != null && model.getEmail() != ""){
				Catastrofe c = SessionHandler.getInstance().getCurrentSite(request);
				model.setPassword(HashHandler.getSecurePassword(model.getPassword()));
				String jsonresp = ServiceConnectionHelper.CallServiceMethoodPOST("AccessService", "Registro", c.getStringConeccion(), new Usuario(model));
				
				if(Integer.parseInt(jsonresp) >0){
					return "success";
				}
				else{
					return "onError";
				} 
			}
			return "onError";
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "onError";
		}
	}
	
	@RequestMapping( value="/logonfb", method = RequestMethod.POST)
	@ResponseBody
	public String LoginRegistroFB(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
	
		Gson g = new Gson();
		try 
		{
			UserModel model = g.fromJson(json, UserModel.class);
			if(model != null && model.getEmail() != ""){
				Usuario usr;
				Catastrofe c = SessionHandler.getInstance().getCurrentSite(request);

				 List<String> listProp = new ArrayList<String>();
				 listProp.add(model.getEmail());
				 
				 String jspnresp = ServiceConnectionHelper.CallServiceMethoodPOST("AccessService", "Login", c.getStringConeccion(),listProp);
					
				 usr = g.fromJson(jspnresp, Usuario.class);
				 if(usr != null){
						 SessionHandler.getInstance().setActiveUser(usr, request);
						 return "Sussess";
				 }
				 else{
					 
					 usr = new Usuario(model);
					 String jsonresp = ServiceConnectionHelper.CallServiceMethoodPOST("AccessService", "Registro", c.getStringConeccion(), usr);
					 if(Integer.parseInt(jsonresp) >0){
						 SessionHandler.getInstance().setActiveUser(usr, request);
						 return "Sussess";
						}
						else{
							return "onError";
						} 
				 }
				 
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "onError";
		}
		return "";
	}
}
