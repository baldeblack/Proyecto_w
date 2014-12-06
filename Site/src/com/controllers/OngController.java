package com.controllers;

import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Catastrofe;
import com.entities.ONG;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.utilities.ServiceConnectionHelper;

@Controller
@RequestMapping("/ong")
public class OngController {

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ModelAndView getAllONGs(HttpServletRequest request) {
		
		Gson gson = new Gson();
		ModelAndView  model = new ModelAndView("ong");
	
		HttpSession session = request.getSession(true);
		Catastrofe c = (Catastrofe)session.getAttribute("Catastrofe");
		
		String jspnresp = ServiceConnectionHelper.CallServiceMethoodGET("ContentServies", "AllONGs", c.getStringConeccion());
		Type listType = new TypeToken<List<ONG>>() {}.getType();
		List<ONG> list = gson.fromJson(jspnresp, listType);
		
		model.addObject("Ongs",list);
		return model;
	}
}
