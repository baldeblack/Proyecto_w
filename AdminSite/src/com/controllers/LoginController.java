package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.models.AdminModel;

@Controller
public class LoginController {

	@RequestMapping(value={"/Login.html"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public ModelAndView getAdmissionForm()
	{
	ModelAndView model1 = new ModelAndView("Login");
	
	return model1;
	}
	
	@RequestMapping(value={"/Registro.html"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public ModelAndView submitAdmissionForm(@ModelAttribute("admin") AdminModel admin, BindingResult result)
	{
		RestTemplate rst = new RestTemplate();		
		String url = "http://localhost:8080/ServiceLayer/rest/SAdmin/admExiste/{mail}";
		String resulta = rst.getForObject(url, String.class, admin.getMail());
		
	if (result.hasErrors())
	{
	ModelAndView model1 = new ModelAndView("Login");
	return model1;
	}
	if(resulta.equals("true")){
	ModelAndView model1 = new ModelAndView("Registro");
	return model1;
	}else{
		ModelAndView model1 = new ModelAndView("Login");
		return model1;
	}
	}
	
}

