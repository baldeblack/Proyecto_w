package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.models.HelpModel;

@Controller
@RequestMapping("/help")
public class AyudaController {
	
	 
	/*@RequestMapping(value="/ask", method=RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String SendHelp(@RequestBody HttpServletRequest request) {
		
		//TODO: llamar a los servicios para guardar los datos
        return "success";
    }*/
	
	@RequestMapping(value="ask", method = RequestMethod.POST)
	@ResponseBody
	public String SendHelp(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
		
		Gson g = new  Gson();
		HelpModel help = g.fromJson(json, HelpModel.class);
		
		return "success";
	}

}
