package com.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		model.addAttribute("OngModel", ongM);
		return "altaONGs";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String Alta(
			@ModelAttribute("OngModel") OngModel OngModel,
			BindingResult bindingResult) throws Exception {			

			CValidador.validate(OngModel, bindingResult);
			
			if (bindingResult.hasErrors()) {
				return "altaONGs";
			} else {
				ONG o = new ONG();
				o.setDatosPayPal(OngModel.getDatosPayPal());
				o.setDireccion(OngModel.getDireccion());
				o.setEmail(OngModel.getEmail());
				o.setIdONGs(0);
				o.setNombre(OngModel.getNombre());
				o.setTelefono(OngModel.getTelefono());
				o.setWeb(OngModel.getWeb());
				o.setOrigen(OngModel.getOrigen());
				ICOngs io = new COngs();
				io.AltaOng(o);
			}
		return "Result";
}
}