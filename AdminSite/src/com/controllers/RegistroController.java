package com.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.models.AdminModel;

@Controller
public class RegistroController {
	@RequestMapping(value={"/Exito.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public ModelAndView submitAdmissionForm(@ModelAttribute("admin") AdminModel admin, BindingResult result)
	{
		RestTemplate rst = new RestTemplate();
		
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("mail", admin.getMail());

			rst.getForObject("http://localhost:8080/ServiceLayer/rest/SAdmin/admSave/{mail}", String.class, vars);
		
				
			ModelAndView model1 = new ModelAndView("Exito");
	
			return model1;

	}
}



