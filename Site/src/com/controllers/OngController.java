package com.controllers;

import java.lang.reflect.Type;
import java.text.ParseException;
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
import com.entities.Donacione;
import com.entities.ONG;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.models.DonarModel;
import com.utilities.ServiceConnectionHelper;
import com.utilities.SessionHandler;

@Controller
@RequestMapping("/ong")
public class OngController {

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public ModelAndView getAllONGs(HttpServletRequest request) {
		
		Gson gson = new Gson();
		ModelAndView  model = new ModelAndView("RTRTR");
		Catastrofe c = SessionHandler.getInstance().getCurrentSite(request);
		
		String jspnresp = ServiceConnectionHelper.CallServiceMethoodGET("ContentServies", "AllONGs", c.getStringConeccion());
		Type listType = new TypeToken<List<ONG>>() {}.getType();
		List<ONG> list = gson.fromJson(jspnresp, listType);
		
		model.addObject("Ongs",list);
		return model;
	}
	
	@RequestMapping( value="/donate", method = RequestMethod.POST)
	@ResponseBody
	public String MakeDonation(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
		
		Gson g = new  Gson();
		DonarModel model = g.fromJson(json, DonarModel.class);
		 try {
			 if(model != null && model.getTipoDonacion() > 0){
				 Catastrofe c = SessionHandler.getInstance().getCurrentSite(request);
				 Donacione don = new Donacione();
				 don.setDescripcion(model.getDescripcion());
				 don.setIdTipoDonacion(model.getTipoDonacion());
				 ONG ong = new ONG();
				 ong.setIdONGs(model.getOng());
				 don.setOng(ong);
				 
				 if(model.getTipoDonacion()==1){//eco
					 don.setMoneda(model.getMoneda());
					 don.setMonto(model.getMonto());
				 }
				 else if(model.getTipoDonacion()==2){//bienes
					 don.setCantidad(model.getCantidad());
					 don.setFechaEntrega(model.getFechaEntrega());
				 }
				 else if(model.getTipoDonacion()==3){//servicios
					 don.setComienzoServico(model.getComienzoServico());
					 don.setFInalizacionServicio(model.getFInalizacionServicio());
					 don.setHsServicio(model.getHsServicio());
				 }
				
				 don.setUsuario(SessionHandler.getInstance().getActiveUser(request));
				 
				 String jsonresp = ServiceConnectionHelper.CallServiceMethoodPOST("ContentServies", "Donate", c.getStringConeccion(), don);
				
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
}
