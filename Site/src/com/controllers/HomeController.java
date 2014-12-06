package com.controllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

	@RequestMapping("/Index")
	  public String Index(HttpServletRequest request){
		/*
		String jsnResult ="";
		HttpSession session = request.getSession(true);
		Catastrofe c = (Catastrofe)session.getAttribute("Catastrofe");
		jsnResult = ServiceConnectionHelper.CallServiceMethoodGET("LostsServies", "AllDesaparecidos", c.getStringConeccion());
		//return ModelAndView("contact", "command", new Contact());
		System.out.println(jsnResult);*/
	    return "Index";
	  }
	
	@RequestMapping("/")
	  public String Start(HttpServletRequest request){
		
		String jsnResult ="";
		//return ModelAndView("contact", "command", new Contact());
		System.out.println(jsnResult);
	    return "layout";
	  }
}
