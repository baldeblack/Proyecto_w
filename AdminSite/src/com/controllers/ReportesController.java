package com.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Controllers.CReporte;
import com.Entities.Rptdata;
import com.Helper.donacionesRpt;
import com.Interfaces.ICReporte;
import com.google.gson.Gson;
import com.models.ReporteModel;

@RequestMapping("/rpt")
@Controller
public class ReportesController {

	@RequestMapping(method = RequestMethod.GET)
	public String getPage(ModelMap model) {
		 ReporteModel rModel = new ReporteModel();
		 
		model.addAttribute("ReporteModel", rModel);	
		return "rptTablas";
	}
	
	@RequestMapping(value = "/rptuso", method = RequestMethod.POST)
	public @ResponseBody String getonginfo(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		Gson g = new Gson();
		idC c = g.fromJson(json, idC.class);
		ICReporte rpt = new CReporte();	
		Rptdata rdata = new Rptdata();
		if (c.id.equals("g")){
			rdata = rpt.getRptUso();
		}else{
			Integer id = Integer.parseInt(c.id);
			rdata = rpt.getRptUsoTenant(id);
		}
				
		String jsonresp = g.toJson(rdata);
		return jsonresp;	
	}
	
	@RequestMapping(value = "/rptdon", method = RequestMethod.POST)
	public @ResponseBody String getdoninfo(@RequestBody String resf, HttpServletResponse res, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		Gson g = new Gson();
		donParameters d = g.fromJson(resf, donParameters.class);
		ICReporte rpt = new CReporte();	
		 List<donacionesRpt> lst = new ArrayList<donacionesRpt>();
		donacionesRpt drpt = new donacionesRpt();
		  String dateStr [] = d.start.split("-");
	       
	       Calendar cal = Calendar.getInstance();
	       cal.set(Calendar.YEAR, (Integer.parseInt(dateStr[0])));
	       cal.set(Calendar.MONTH, (Integer.parseInt(dateStr[1])-1));
	       cal.set(Calendar.DAY_OF_MONTH, (Integer.parseInt(dateStr[2])));
	       Date datestar = cal.getTime();   
	       
	       String dateStre [] = d.end.split("-");
	       
	       Calendar cale = Calendar.getInstance();
	       cale.set(Calendar.YEAR, (Integer.parseInt(dateStre[0])));
	       cale.set(Calendar.MONTH, (Integer.parseInt(dateStre[1])-1));
	       cale.set(Calendar.DAY_OF_MONTH, (Integer.parseInt(dateStre[2])));
	       Date datend = cale.getTime();   
	       
	       java.sql.Date sqlDateS = new java.sql.Date(datestar.getTime());
	       java.sql.Date sqlDateE = new java.sql.Date(datend.getTime());
	       
	       lst = rpt.getRptDonaciones(Integer.parseInt(d.id), sqlDateS, sqlDateE);
		String jsonresp = g.toJson(lst);
		return jsonresp;	
		}
	
	public class idC {
		String id;
	}
	
	public class donParameters {
		String id;
		String start;
		String end;
	}
}
	

