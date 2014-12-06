package com.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.models.HelpModel;

@Controller
@RequestMapping("/help")
public class AyudaController {
	
	 
	@RequestMapping(value="/ask", method=RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String SendHelp(@RequestBody HttpServletRequest request) {
		
		//TODO: llamar a los servicios para guardar los datos
        return "success";
    }
	
	 @RequestMapping(value="ask2", method = RequestMethod.POST)
	  public @ResponseBody String post(@RequestParam("json") String json) {    
	 
	      return "success";
	  }

}
