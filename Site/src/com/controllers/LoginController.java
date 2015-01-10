package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.security.annotation.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

	@RequestMapping(value="login", method = RequestMethod.POST)
	@ResponseBody
	public String performLogin(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
		
		/*	 try {
			 String mail ="";
			 String password = "";
			 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(mail, password);
		        Authentication authentication = AuthenticationManager.authenticate(token);
		        SecurityContextHolder.getContext().setAuthentication(authentication);
		        repository.saveContext(SecurityContextHolder.getContext(), request, response);
		        rememberMeServices.loginSuccess(request, response, authentication);
		        return "{\"status\": true}";
		    } catch (BadCredentialsException e) {
		        return "{\"status\": false, \"error\": \"Bad Credentials\"}";
		    }
		 */
		return "";
	}
	
}
