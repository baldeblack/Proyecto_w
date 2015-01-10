package com.controllers;


import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Catastrofe;
import com.entities.Desaparecido;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.models.LostsModel;
import com.utilities.ServiceConnectionHelper;

@Controller
@RequestMapping("/lost")
public class LostController {

	@RequestMapping(value = "/get",  method = RequestMethod.GET)
	public @ResponseBody Desaparecido getDesaparecido(HttpServletResponse res) {
	      Desaparecido des = new Desaparecido();
	      return des;
	 }
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public @ResponseBody String getAllDesaparecidos(HttpServletResponse res, HttpServletRequest request) {
		
		HttpSession session = request.getSession(true);
		Catastrofe c = (Catastrofe)session.getAttribute("Catastrofe");
		String jsonresp = ServiceConnectionHelper.CallServiceMethoodGET("LostsServies", "AllDesaparecidos", c.getStringConeccion());
		return jsonresp;
	 
	}
	
	@RequestMapping(value = "/getAllView", method = RequestMethod.GET)
	public ModelAndView getAllDesaparecidosView(LostsModel model,  HttpServletRequest request) {
		ModelAndView  model2 = new ModelAndView("desaparecidos");
		
		Gson gson = new Gson();
		List<LostsModel> listModel = null; 
		HttpSession session = request.getSession(true);
		Catastrofe c = (Catastrofe)session.getAttribute("Catastrofe");
		
		String jspnresp = ServiceConnectionHelper.CallServiceMethoodGET("LostsServies", "AllDesaparecidos", c.getStringConeccion());
		
			Type listType = new TypeToken<List<Desaparecido>>() {}.getType();
			List<Desaparecido> list = gson.fromJson(jspnresp, listType);
			if(list != null)
			{
				listModel =new ArrayList<LostsModel>(); 
				for (Desaparecido d : list) {
					
					LostsModel item = new LostsModel(d.getIdDesaparecidos(), d.getApellido(), d.getNombre(), d.getEdad(), d.getEstadoBusqueda(),
							d.getFechaDesaparicion(), d.getNombreContacto(), d.getRelacionContacto(), d.getSexo(), d.getTelefonoContacto(),
							d.getTIpoUsuioReportado(), d.getUltimoParadero(), d.getFoto());
					
					listModel.add(item);
				}
			}
		model2.addObject("Losts",listModel);
		return model2;
		
	}
	
	
	@RequestMapping(value="save", method = RequestMethod.POST)
	  public @ResponseBody Desaparecido saveDesaparecido(@RequestBody final  Desaparecido input) {    
	 
		
	     // System.out.println(person.getId() + " " + person.getName());
	      return input;
	  }
}
