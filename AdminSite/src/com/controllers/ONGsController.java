package com.controllers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Controllers.COngs;
import com.Entities.ONG;
import com.Helper.ongsBorrado;
import com.Interfaces.ICOngs;
import com.google.gson.Gson;
import com.models.OngsListModel;

import com.models.ongFormModel;
import com.utils.accessControl;

@RequestMapping("/ongs")
@Controller
public class ONGsController {	
		
	@RequestMapping(method = RequestMethod.GET)
	public String OngsGet(ModelMap model, HttpServletRequest request) {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "listOngs")){
			return "redirect:/forbhiden";
		}
		 OngsListModel uModel = new OngsListModel();
		model.addAttribute("OngsListModel", uModel);		
		return "listOngs";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreateFormABM(ModelMap model) {
		model.addAttribute("idOng", "");
		model.addAttribute("action", "Crear");
		model.addAttribute("jsondata", "");
	    return "ongABM";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String updateForm(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		Gson g = new Gson();
		String jsonresp = "";
		ongFormModel of = g.fromJson(json, ongFormModel.class);
		ICOngs io = new COngs();
		ONG o = new ONG();
		
		o.setDatosPayPal(of.getDatosPayPal());
		o.setDireccion(of.getDireccion());
		o.setEmail(of.getEmail());
		o.setTelefono(of.getTelefono());
		o.setWeb(of.getWeb());
		o.setOrigen(of.getOrigen());		
		
		if(of.getAccion().equals("Crear")){
			o.setNombre(of.getNombre());
			o.setIdONGs(io.maxOngId());				
			io.AltaOng(o);
			
			idC idong = new idC();
			int realId = io.maxOngId();
			
			if(realId == 0){
				idong.id = String.valueOf(0);
			}else{
				idong.id = String.valueOf(io.maxOngId() - 1);
			}
			
			jsonresp = g.toJson(idong);
			
		}else{
			io.ActualizarOng(o, of.getIdONGs());
			io.actualizaTodo(o);
			jsonresp = g.toJson(o.getIdONGs());;	
		}
		
		
	    return jsonresp;
	}
	
	@RequestMapping(value="/edit/{idOng}", method = RequestMethod.GET)
	public String OngEdit(@PathVariable int idOng, ModelMap model, HttpServletRequest request) throws Exception {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "edit")){
			return "redirect:/forbhiden";
		}
		
		ICOngs io = new COngs();
		Gson g = new Gson();
		ONG o = io.getONG(idOng);		
		model.addAttribute("idOng", idOng);		
		model.addAttribute("action", "Modificar");
		model.addAttribute("jsondata", g.toJson(o).replaceAll("\"", "'"));		
		return "ongABM";
		}
	
		
	@RequestMapping(value = "/addOng", method = RequestMethod.POST)
	public @ResponseBody String addOng(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		Gson g = new Gson();
		ids c = g.fromJson(json, ids.class);
		ICOngs io = new COngs();
		
		io.InsertOTenant(Integer.parseInt(c.idc),io.getONG(Integer.parseInt(c.ido)));		
		List<ONG> lstSis = new ArrayList<ONG>();
		List<ongsBorrado> lstTnt = new ArrayList<ongsBorrado>();
		lstSis = io.ListarOngs();
		lstTnt = io.GetOngsTenant(Integer.parseInt(c.idc));

		for (Iterator<ONG> iterator = lstSis.iterator(); iterator.hasNext(); ) {
			ONG o = iterator.next();
			for (Iterator<ongsBorrado> iteratort = lstTnt.iterator(); iteratort.hasNext(); ) {
				ongsBorrado ot = iteratort.next();
		    if (o.getNombre().equals(ot.getNombre())) {
		        iterator.remove();
		    }
			}
		}
		
		
		String jsonresp = g.toJson(lstTnt);
		return jsonresp;
	}
	
	@RequestMapping(value = "/delOng", method = RequestMethod.POST)
	public @ResponseBody String deleteOng(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		Gson g = new Gson();
		ids c = g.fromJson(json, ids.class);
		ICOngs io = new COngs();
		
		io.DeleteOTenant(Integer.parseInt(c.idc),c.ido);		
		List<ONG> lstSis = new ArrayList<ONG>();
		List<ongsBorrado> lstTnt = new ArrayList<ongsBorrado>();
		lstSis = io.ListarOngs();
		lstTnt = io.GetOngsTenant(Integer.parseInt(c.idc));

		for (Iterator<ONG> iterator = lstSis.iterator(); iterator.hasNext(); ) {
			ONG o = iterator.next();
			for (Iterator<ongsBorrado> iteratort = lstTnt.iterator(); iteratort.hasNext(); ) {
				ongsBorrado ot = iteratort.next();
		    if (o.getNombre().equals(ot.getNombre())) {
		        iterator.remove();
		    }
			}
		}
		
		
		String jsonresp = g.toJson(lstTnt);
		return jsonresp;
	}
	
	
	@RequestMapping(value = "/getongid", method = RequestMethod.POST)
	public @ResponseBody String getIdO(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) {
		
		Gson g = new Gson();
		nomO c = g.fromJson(json, nomO.class);		
		ICOngs io = new COngs();		
		ids result = new ids();
		result.idc = io.GetOngByNombre(c.nombre).toString();
		result.ido = c.nombre;
		String jsonresp = g.toJson(result);
		return jsonresp;
	 
	}
	
	public class idC {
		String id;
	}
	
	public class nomO {
		String nombre;
	}
	
	public class ids {
		String idc;
		String ido;
	}
}