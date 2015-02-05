package com.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Controllers.CPlanes;
import com.Entities.Plan;
import com.Interfaces.ICPlanes;
import com.models.PlanModel;
import com.utils.accessControl;

@RequestMapping("/planes")
@Controller
public class PlanesControl {
	
	@RequestMapping(method = RequestMethod.GET)
	public String PlanesGet(ModelMap model, HttpServletRequest request) {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "planes")){
			return "redirect:/forbhiden";
		}
		PlanModel PlanModel = new PlanModel();
		model.addAttribute("PlanModel", PlanModel);		
		return "listCatastrofes";
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String PlanCreate(ModelMap model, HttpServletRequest request) {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "create")){
			return "redirect:/forbhiden";
		}
	
		PlanModel PlanModel = new PlanModel();
		PlanModel.setAction("Crear");
		model.addAttribute("PlanModel", PlanModel);
		return "Planes";		
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String PlanSave(
			@ModelAttribute("PlanModel") PlanModel PlanModel,
			BindingResult bindingResult, HttpServletRequest request) throws Exception {	
		
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "save")){
			return "redirect:/forbhiden";
		}
					
			if(PlanModel.getAction().equals("Crear")){
			try {
				  ICPlanes ip = new CPlanes();
				  Plan p = new Plan();						
				  p.setCantidadPasos(PlanModel.getPasos().size());
				  p.setDescripcion(PlanModel.getDesc());
				  p.setEstado(0);
				  p.setIdTipoCatastrofe(PlanModel.getIdTipoCatastrofe());
				  p.setIdTipoPlan(0);
				  p.setNombre(PlanModel.getNombre());
				  ip.InserUpdatePlanesWithPasos(p, PlanModel.getPasos());
				
			} catch (Exception e) {
				throw e;
			}
			
			}else{
				
					
					
				return "Result";
			}	
	
 		return "Result";

	}
}
