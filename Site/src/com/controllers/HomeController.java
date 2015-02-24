package com.controllers;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


	@RequestMapping("/Index")
	  public String Index(HttpServletRequest request){
	    return "Index";
	  }
	
	@RequestMapping("/")
	  public String Start(HttpServletRequest request){
		
		System.out.println("layout - In");
	    return "layout";
	  
	}
	
	
	
}
