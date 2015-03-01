package com.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Controllers.CCatastrofe;
import com.Controllers.CPlanes;
import com.Entities.Paso;
import com.Entities.Plan;
import com.Entities.Tipocatastrofe;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICPlanes;
import com.google.gson.Gson;
import com.models.PlanModel;
import com.models.pasoFormModel;
import com.models.planFormModel;
import com.utils.PlanUtil;
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
		 ICPlanes ip = new CPlanes();
		 List <Plan> planes = new ArrayList<Plan>();
		 planes = ip.getPlanes();
		model.addAttribute("planes", planes);	
		ICCatastrofe ic = new CCatastrofe();
		List<Tipocatastrofe> tiposct = new ArrayList<Tipocatastrofe>();
		tiposct = ic.getTiposCT();
		model.addAttribute("tiposct", tiposct);	
		return "listPlanes";
	}
	
	@RequestMapping(value="/edit/{planid}", method=RequestMethod.GET)
	public String getEdit(@PathVariable int planid, ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "edit")){
			return "redirect:/forbhiden";
		}
		Gson g = new Gson();
		 ICPlanes ip = new CPlanes();
		  Plan p = new Plan();	
		  p = ip.getPlan(planid); 
		  
		  PlanUtil pu = new PlanUtil();
		  List<pasoFormModel> lstp = new ArrayList<pasoFormModel>();
		  pu.setPasos(lstp);
		  pu.setCantidadPasos(p.getCantidadPasos());
		  pu.setDescripcion(p.getDescripcion());
		  pu.setEstado(p.getEstado());
		  pu.setIdPlan(p.getIdPlan());
		  pu.setIdTipoCatastrofe(p.getIdTipoCatastrofe());
		  pu.setIdTipoPlan(p.getIdTipoPlan());
		  pu.setNombre(p.getNombre());
		  
		 

			for (Iterator<Paso> iterator = p.getPasos().iterator(); iterator.hasNext(); ) {
				Paso pi = iterator.next();
				pasoFormModel pf = new pasoFormModel();
				pf.setIdPlan(pi.getPlan().getIdPlan());
				pf.setAccion("accion");
				pf.setDescripcion_paso(pi.getDescripcion());
				pf.setEstado(Integer.parseInt(pi.getEstado()));
				pf.setIdPaso(pi.getIdpasos());
				pf.setNombre_paso(pi.getNombre());
				pu.getPasos().add(pf);				
			}
			
			ICCatastrofe ic = new CCatastrofe();
			List<Tipocatastrofe> lst = new ArrayList<Tipocatastrofe>();
			lst = ic.getTiposCT();
		
			 
			model.addAttribute("tiposCatastrofe", lst);
			model.addAttribute("idPlan", pu.getIdPlan());
			model.addAttribute("jsondata", g.toJson(pu).replaceAll("\"", "'"));
		model.addAttribute("plan", pu);
		return "Plan";
		
	}
	
	@RequestMapping(value="/create", method = RequestMethod.GET)
	public String PlanCreate(ModelMap model, HttpServletRequest request) {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "create")){
			return "redirect:/forbhiden";
		}	
		
		ICCatastrofe ic = new CCatastrofe();
		List<Tipocatastrofe> lst = new ArrayList<Tipocatastrofe>();
		lst = ic.getTiposCT();
		
		model.addAttribute("tiposCatastrofe", lst);
		model.addAttribute("idPlan", "");
		model.addAttribute("jsondata", "");
		return "Plan";		
		//return "redirect:/planes/edit/29";
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String updateForm(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		Gson g = new Gson();
		String jsonresp = "";
		int idplan, idpaso;
		planFormModel pf = new planFormModel();
		pf = g.fromJson(json, planFormModel.class);
		
		  ICPlanes ip = new CPlanes();
		
		  idp idp = new idp();
		  Plan p = new Plan();	
		  
		if(pf.getAccion().equals("Crear")){									
			  p.setCantidadPasos(pf.getCantidadPasos());
			  p.setDescripcion(pf.getDescripcion());
			  p.setEstado(pf.getEstado());		
			  p.setIdTipoPlan(pf.getIdTipoPlan());
			  p.setNombre(pf.getNombre());
			  p.setIdTipoCatastrofe(pf.getIdTipoCatastrofe());			
			  Paso pas = new Paso();
			  pas.setDescripcion(pf.getDescripcion_paso());
			  pas.setEstado("0");
			  pas.setNombre(pf.getNombre_paso());
			  pas.setPlan(p);
			  List<Paso> pasos = new ArrayList<Paso>();
			  pasos.add(pas);
			  idplan = ip.InserUpdatePlanesWithPasos(p, pasos);
			  idpaso = ip.maxPasoId();			 
			  idp.idc = String.valueOf(idplan);
			  idp.ido = String.valueOf(idpaso);
		}else{
			  p = ip.getPlan(pf.getIdPlan());
			  p.setNombre(pf.getNombre());		
			  p.setDescripcion(pf.getDescripcion());
			  idplan = ip.InserUpdatePlanesWithPasos(p, p.getPasos());
			  idp.idc = String.valueOf(idplan);
			  idp.ido = String.valueOf(0);
		}
		
		 
		jsonresp = g.toJson(idp);
		return jsonresp;
	}
	
	@RequestMapping(value = "/addpaso", method = RequestMethod.POST)
	public @ResponseBody String addPasoForm(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		Gson g = new Gson();
		String jsonresp = "";		
		pasoFormModel pf = new pasoFormModel();
		pf = g.fromJson(json, pasoFormModel.class);
		
		  ICPlanes ip = new CPlanes();
		  Plan p = new Plan();	
		  p = ip.getPlan(pf.getIdPlan()); 
		  
		  Paso paso = new Paso();
		  paso.setDescripcion(pf.getDescripcion_paso());
		  paso.setEstado(String.valueOf(pf.getEstado()));
		  paso.setNombre(pf.getNombre_paso());
		  paso.setPlan(p);
		  p.getPasos().add(paso);
		  ip.InserUpdatePlanesWithPasos(p, p.getPasos());		
		  idp idp = new idp();
		  paso.setIdpasos(ip.maxPasoId());
		  idp.idc = String.valueOf(p.getIdPlan());
		  idp.ido = String.valueOf(paso.getIdpasos());
		  jsonresp = g.toJson(idp);
		return jsonresp;
	}
	
	@RequestMapping(value = "/editpaso", method = RequestMethod.POST)
	public @ResponseBody String updatePasoForm(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		Gson g = new Gson();
		String jsonresp = "";		
		pasoFormModel pf = new pasoFormModel();
		pf = g.fromJson(json, pasoFormModel.class);
		
		  ICPlanes ip = new CPlanes();
		  Plan p = new Plan();	
		  p = ip.getPlan(pf.getIdPlan()); 
		  
		  Paso paso = new Paso();
		  paso.setIdpasos(pf.getIdPaso());
		  paso.setDescripcion(pf.getDescripcion_paso());		
		  paso.setNombre(pf.getNombre_paso());
		 

			for (Iterator<Paso> iterator = p.getPasos().iterator(); iterator.hasNext(); ) {
				Paso pi = iterator.next();
				if(pi.getIdpasos() == paso.getIdpasos()){
					pi.setDescripcion(paso.getDescripcion());
					pi.setNombre(paso.getNombre());
				}
			}
			
		  ip.InserUpdatePlanesWithPasos(p, p.getPasos());		
		  idp idp = new idp();
		  idp.idc = String.valueOf(p.getIdPlan());
		  idp.ido = String.valueOf(paso.getIdpasos());
		  jsonresp = g.toJson(idp);
		return jsonresp;
	}
	
	
	public class idp{
		String idc;
		String ido;
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
