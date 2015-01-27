package com.controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Validadores.OngValidador;

import com.Controllers.CCatastrofe;
import com.Controllers.COngs;
import com.Entities.Catastrofe;
import com.Entities.ONG;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICOngs;
import com.google.gson.Gson;
import com.models.OngModel;
import com.models.OngsListModel;
import com.models.ongCatastofeModel;

@RequestMapping("/ongs")
@Controller
public class ONGsController {	
	
	OngValidador CValidador;

	@Autowired
	public ONGsController(OngValidador CValidador) {
		this.CValidador = CValidador;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String OngsGet(ModelMap model) {
		 OngsListModel uModel = new OngsListModel();
		model.addAttribute("OngsListModel", uModel);		
		return "listOngs";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String getCreateForm(ModelMap model) {
		OngModel ongM = new OngModel();
		ongM.setAction("Crear");
		model.addAttribute("OngModel", ongM);
		return "altaONGs";
	}
	
	@RequestMapping(value="/vincular/{tenantID}", method=RequestMethod.GET)
	public String getVincularForm(@PathVariable int tenantID, ModelMap model) throws ClassNotFoundException, SQLException {
		ICOngs io = new COngs();
		ICCatastrofe ic = new CCatastrofe();
		Catastrofe c = ic.getCatastrofeByID(tenantID);
		ongCatastofeModel ongM = new ongCatastofeModel();
		List<ONG> lstSis = new ArrayList<ONG>();
		List<ONG> lstTnt = new ArrayList<ONG>();
		lstSis = io.ListarOngs();
		lstTnt = io.GetOngsTenant(tenantID);

		for (Iterator<ONG> iterator = lstSis.iterator(); iterator.hasNext(); ) {
			ONG o = iterator.next();
			for (Iterator<ONG> iteratort = lstTnt.iterator(); iteratort.hasNext(); ) {
				ONG ot = iteratort.next();
		    if (o.getNombre().equals(ot.getNombre())) {
		        iterator.remove();
		    }
			}
		}
		
		ongM.setOngSistemaLst(lstSis);
		ongM.setOngTenantLst(lstTnt);
		ongM.setCtNombre(c.getNombre());
		ongM.setIdCt(c.getIdCatastrofe());
		model.addAttribute("ongCatastofeModel", ongM);
		return "ongCatastrofe";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String Alta(
			@ModelAttribute("OngModel") OngModel OngModel,
			BindingResult bindingResult, HttpServletRequest request) throws Exception {			

			CValidador.validate(OngModel, bindingResult);
			
			if (bindingResult.hasErrors()) {
				return "altaONGs";
			} else {		
				
			ICOngs io = new COngs();
			ONG o = new ONG();
			
			o.setDatosPayPal(OngModel.getDatosPayPal());
			o.setDireccion(OngModel.getDireccion());
			o.setEmail(OngModel.getEmail());			
			o.setNombre(OngModel.getNombre());
			o.setTelefono(OngModel.getTelefono());
			o.setWeb(OngModel.getWeb());
			o.setOrigen(OngModel.getOrigen());
			
			if(OngModel.getAction().equals("Crear")){	
				o.setIdONGs(io.maxOngId());								
				io.AltaOng(o);
			}else{
				io.ActualizarOng(o, (Integer)request.getSession().getAttribute("idOng"));
			}
			}
		return "Result";
}

	@RequestMapping(value="/edit/{idOng}", method = RequestMethod.GET)
	public String UsuUpdate(@PathVariable int idOng, ModelMap model, HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("idOng", idOng);
		ICOngs io = new COngs();
		ONG o = io.getONG(idOng);
		OngModel oModel = new OngModel();
		oModel.setDatosPayPal(o.getDatosPayPal());
		oModel.setDireccion(o.getDireccion());
		oModel.setEmail(o.getEmail());
		oModel.setNombre(o.getNombre());
		oModel.setOrigen(o.getOrigen());
		oModel.setTelefono(o.getTelefono());
		oModel.setWeb(o.getWeb());
		oModel.setAction("Modificar");
		model.addAttribute("OngModel", oModel);
		return "altaONGs";	
		}
	
	@RequestMapping(value="/ongct", method = RequestMethod.POST)
	public String ongTenant(@ModelAttribute("ongCatastofeModel") ongCatastofeModel ongCatastofeModel, BindingResult bindingResult) throws ClassNotFoundException, SQLException{
		ICOngs io = new COngs();
		List<ONG> lstSis = new ArrayList<ONG>();
		lstSis = io.ListarOngs();
		
	for(ONG o: lstSis){
		for(ONG ot: ongCatastofeModel.getOngTenantLst()){
			if(o.getNombre().equals(ot.getNombre())){
				ot.setDatosPayPal(o.getDatosPayPal());
				ot.setDireccion(o.getDireccion());
				ot.setEmail(o.getEmail());
				ot.setNombre(o.getNombre());
				ot.setOrigen(o.getOrigen());
				ot.setTelefono(o.getTelefono());
				ot.setWeb(o.getWeb());
			}
		}
	}
		io.ActualizarOTenant(ongCatastofeModel.getIdCt(), ongCatastofeModel.getOngTenantLst());
		return "Result";
		
	}
	
	@RequestMapping(value = "/getonginfo", method = RequestMethod.POST)
	public @ResponseBody String getonginfo(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) {
		
		Gson g = new Gson();
		idC c = g.fromJson(json, idC.class);
		Integer id = Integer.parseInt(c.id);
		ICOngs io = new COngs();		
		String jsonresp = g.toJson(io.getONG(id));
		return jsonresp;
	 
	}
	
	public class idC {
		String id;
	}
}