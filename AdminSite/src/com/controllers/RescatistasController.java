package com.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.Controllers.CCatastrofe;
import com.Controllers.COngs;
import com.Entities.Catastrofe;
import com.Entities.ONG;
import com.Helper.ongsBorrado;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICOngs;
import com.google.gson.Gson;
import com.models.VincularModel;
import com.models.ongCatastofeModel;
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
	
}
