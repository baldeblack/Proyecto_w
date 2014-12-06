package com.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Entities.PasosPlanEmergenca;
import com.Entities.PlanEmergencia;
import com.models.PlanModel;

@RequestMapping("/plan")
@Controller
public class PlanController {
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String PlanCreate(ModelMap model) {
		PlanModel pModel = new PlanModel();
	    model.addAttribute("PlanModel", pModel);
		return "altaplan";		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String PlanSave(
			@ModelAttribute("PlanModel") PlanModel PlanModel,
			BindingResult bindingResult, HttpServletRequest request) throws Exception {	
		
		PlanEmergencia p = new PlanEmergencia();
		p.setNombre(PlanModel.getNombre());
		p.setDescripcion(PlanModel.getDescripcion());
		List<PasosPlanEmergenca> lst = new ArrayList<PasosPlanEmergenca>();
		p.setPasosPlanEmergencas(lst);
		for (PasosPlanEmergenca pasos : PlanModel.getPasos()) {
			p.getPasosPlanEmergencas().add(pasos);			
		}
		
		return "Result";
	}

}
