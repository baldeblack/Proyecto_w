package com.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.utils.accessControl;

@RequestMapping("/rescatista")
@Controller
public class RescatistasController {

	@RequestMapping(method = RequestMethod.GET)
	public String UsuariosGet(ModelMap model, HttpServletRequest request) {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "rescatistahome")){
			return "redirect:/forbhiden";
		}
		
		return "rescatistahome";
	}
}
