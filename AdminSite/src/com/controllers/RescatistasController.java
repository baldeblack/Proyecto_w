package com.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.picketbox.commons.cipher.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.Controllers.CCatastrofe;
import com.Controllers.COngs;
import com.Controllers.CPlanes;
import com.Controllers.CUsuarios;
import com.Entities.Catastrofe;
import com.Entities.ONG;
import com.Entities.Plan;
import com.Entities.Rescatista;
import com.Entities.Rescatistacatastrofe;
import com.Entities.TipoRescatista;
import com.Entities.Tipocatastrofe;
import com.Entities.Usuario;
import com.Helper.ongsBorrado;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICOngs;
import com.Interfaces.ICPlanes;
import com.Interfaces.ICUsuarios;
import com.TenantControllers.CDesaparecidos;
import com.TenantInterfaces.ICDesaparecidos;
import com.entities.Desaparecido;
import com.google.gson.Gson;
import com.models.VincularModel;
import com.models.rescatisaHomeModel;
import com.utils.accessControl;

@RequestMapping("/rescatista")
@Controller
public class RescatistasController {

	@RequestMapping(method = RequestMethod.GET)
	public String UsuariosGet(ModelMap model, HttpServletResponse res, HttpServletRequest request) {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "rescatistahome")){
			return "redirect:/forbhiden";
		}
		
		 HttpSession session = request.getSession(true);
		 Usuario u = (Usuario) session.getAttribute("user");	
		 rescatisaHomeModel rh = new rescatisaHomeModel(u.getIdUsuarios());			
		model.addAttribute("model", rh);	
		
		return "rescatistahome";
	}
	
	@RequestMapping(value="/ctinfo", method = RequestMethod.POST)
	 public ModelAndView getCTInfo(@RequestBody String json, HttpServletResponse res,HttpServletRequest request) throws ClassNotFoundException, SQLException {  
		Gson g = new  Gson();
		idPl result = g.fromJson(json, idPl.class);	
		ICCatastrofe ic = new CCatastrofe();
		Catastrofe c = new Catastrofe();
		c = ic.getCatastrofeByID(result.id);
		HttpSession session = request.getSession(true);
		 Usuario u = (Usuario) session.getAttribute("user");
		 ICUsuarios iu = new CUsuarios();
		 Rescatista r = new Rescatista();
		 r = iu.getRescatistaByUsuID(u.getIdUsuarios());
		List<Tipocatastrofe> tipos = new ArrayList<Tipocatastrofe>();
		tipos = ic.getTiposCT();
		String tipoct = "";
		String tiporesc = "";
		for(Tipocatastrofe t: tipos){
			if(t.getIdtipocatastrofe() == c.getTipo()){
				tipoct = t.getNombre();
			}
		}
		List<TipoRescatista> ti = new ArrayList<TipoRescatista>();
		ti = iu.GetTipoRescatista();
		
		for (TipoRescatista t: ti){
			if(t.getIdTipoRescatista() == r.getIdTipoRescatista()){
				tiporesc = t.getNombre();
			}
		}
		
		String encodedLogo= Base64.encodeBytes(c.getLogo());	
		String zona = c.getZonaAfectada().replaceAll("\"", "'");
		c.setZonaAfectada(zona);
		ModelAndView  model = new ModelAndView("catastrofeinfo");
		model.addObject("catastrofe", c);
		model.addObject("rescatista", r);
		model.addObject("tipoc", tipoct);
		model.addObject("tipor", tiporesc);
		model.addObject("logo", encodedLogo);
        return model;
    }
	
	@RequestMapping(value="/planes", method = RequestMethod.POST)
	 public ModelAndView getPlan(@RequestBody String json, HttpServletResponse res,HttpServletRequest request) { 
		Gson g = new  Gson();
		idPl result = g.fromJson(json, idPl.class);		
		Plan plan = new Plan();
		ICPlanes ip = new CPlanes();		
		plan = ip.getPlan(result.id);
		
		ModelAndView  model = new ModelAndView("planresc");
		model.addObject( "plan", plan);
       return model;
   }
	
	@RequestMapping(value="/desaparecidos", method = RequestMethod.POST)
	 public ModelAndView getDesa(@RequestBody String json, HttpServletResponse res,HttpServletRequest request) { 
		Gson g = new  Gson();
		idPl result = g.fromJson(json, idPl.class);		
		ICDesaparecidos id = new CDesaparecidos(result.id);
		short i = 1;
		List<Desaparecido> lstdesa = id.GetDesaparecidosByIdBO(i);
		List<String> strlst = new ArrayList<String>();
		for(Desaparecido d: lstdesa){
			String encodedLogo= Base64.encodeBytes(d.getFoto());
			strlst.add(encodedLogo);
		}
		ModelAndView  model = new ModelAndView("desaparecidos");
		model.addObject("desaparecidos", lstdesa);
		model.addObject("fotos", strlst);
      return model;
  }
	
	@RequestMapping(value="/reportar", method = RequestMethod.POST)
	 public @ResponseBody String  reportar(@RequestBody String json, HttpServletResponse res,HttpServletRequest request) { 
		Gson g = new  Gson();
		update result = g.fromJson(json, update.class);		
		ICDesaparecidos id = new CDesaparecidos(result.idplan);
		short state = 2;
		id.ChangeStateDesaparecido(result.idpaso, state);
		String jsonresp = g.toJson(result);
		return jsonresp;
 }
	
	@RequestMapping(value = "/updatepaso", method = RequestMethod.POST)
	public @ResponseBody String deleteOng(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		Gson g = new Gson();
		update data = g.fromJson(json, update.class);		
		ICPlanes ip = new CPlanes();		
		HttpSession session = request.getSession(true);
		 Usuario u = (Usuario) session.getAttribute("user");
		ip.UpdatePasoStep(data.idplan,data.idpaso, u.getIdUsuarios());
		String jsonresp = g.toJson(data);
		return jsonresp;
	}
	
	@RequestMapping(value="/vincular/{tenantID}", method=RequestMethod.GET)
	public String getVincularForm(@PathVariable int tenantID, ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "vincular")){
			return "redirect:/forbhiden";
		}
		ICOngs io = new COngs();
		ICCatastrofe ic = new CCatastrofe();
		Catastrofe c = ic.getCatastrofeByID(tenantID);
		VincularModel ongM = new VincularModel();
		List<ONG> lstSis = new ArrayList<ONG>();
		List<ongsBorrado> lstTnt = new ArrayList<ongsBorrado>();
		lstSis = io.ListarOngs();
		lstTnt = io.GetOngsTenant(tenantID);

		for (Iterator<ONG> iterator = lstSis.iterator(); iterator.hasNext(); ) {
			ONG o = iterator.next();
			for (Iterator<ongsBorrado> iteratort = lstTnt.iterator(); iteratort.hasNext(); ) {
				ongsBorrado ot = iteratort.next();
		    if (o.getNombre().equals(ot.getNombre())) {
		        iterator.remove();
		    }
			}
		}
		
		ongM.setOngSistemaLst(lstSis);
		ongM.setOngTenantLst(lstTnt);
		ongM.setCtNombre(c.getNombre());
		ongM.setIdCt(c.getIdCatastrofe());
		Gson g = new Gson();
		ongM.setJsonData(g.toJson(lstTnt).replaceAll("\"", "'"));
		
		
		model.addAttribute("VincularModel", ongM);
		return "vincular";
	}
	
	public class idPl {
		int id;
	}
	
	public class update {
		int idplan;
		int idpaso;
	}
}
