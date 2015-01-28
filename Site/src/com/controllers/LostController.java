package com.controllers;


import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.picketbox.commons.cipher.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Catastrofe;
import com.entities.Desaparecido;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.models.LostFormModel;
import com.models.LostsModel;
import com.utilities.ServiceConnectionHelper;
import com.utilities.SessionHandler;

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
	
	
	@RequestMapping( value="/save", method = RequestMethod.POST)
	@ResponseBody
	public String saveDesaparecido(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
		Gson g = new  Gson();
		LostFormModel model = g.fromJson(json, LostFormModel.class);
		try {
			if(model != null && model.getNombre() != null){
				 HttpSession session = request.getSession(true);
				 Catastrofe c = (Catastrofe)session.getAttribute("Catastrofe");
				 
				 Desaparecido des = new Desaparecido();
				 des.setApellido(model.getApellido());
				 des.setEdad(model.getEdad());
				 des.setEstadoBusqueda((short)1);
				 des.setFechaDesaparicion(model.getFechaDesaparicion());
				 des.setFoto(model.getFoto());
				 des.setIdUsuarioReportado(SessionHandler.getInstance().getActiveUser(request).getIdUsuarios());
				 des.setNombre(model.getNombre());
				 des.setNombreContacto(model.getNombreContacto());
				 des.setRelacionContacto(model.getRelacionContacto());
				 des.setSexo(model.getSexo());
				 des.setTelefonoContacto(model.getTelefonoContacto());
				 des.setTIpoUsuioReportado(2);
				 des.setUltimoParadero(model.getUltimoParadero());
				 
				 String jsonresp = ServiceConnectionHelper.CallServiceMethoodPOST("LostsServies", "LostReport", c.getStringConeccion(), des);
					
				 if(Integer.parseInt(jsonresp) >0){
					return "success";
				}
				else{
					return "onError";
				} 
				 
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "onError";
	}
	
	  
    @RequestMapping( value="/upload", method = RequestMethod.POST)
	@ResponseBody
	public String SendHelp(@RequestParam("file") MultipartFile file, HttpServletRequest request, HttpServletResponse response) {
    	 if (!file.isEmpty()) {
		     try {
		    	 byte[] buffer = file.getBytes();
		         return Base64.encodeBytes(buffer);  
			 } catch (Exception e) {
	             return "onError";
	         }
		 } else {
             return "onError";
         }
    }
	  
	  
	
}
