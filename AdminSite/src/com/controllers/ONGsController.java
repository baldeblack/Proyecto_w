package com.controllers;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Validadores.OngValidador;

import com.Controllers.COngs;
import com.Entities.ONG;
import com.Interfaces.ICOngs;
import com.models.OngModel;
import com.models.OngsListModel;

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
}