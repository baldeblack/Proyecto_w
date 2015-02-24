package com.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Catastrofe;
import com.utilities.SessionHandler;
import com.utilities.SingletonTenant;

@Component
public class TenantInterceptor implements HandlerInterceptor{
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
    		Object handler) throws Exception {
		 
		if(request != null)
		{
			String baseUrl = String.format("%s", request.getServerName());
			Catastrofe current = SessionHandler.getInstance().getCurrentSite(request);
			
			String param = "";
			if (current != null) {
	        	param = current.getDominio();
	        }
	        
	        Catastrofe c = SingletonTenant.getInstance(baseUrl, param).getSite();
	        SessionHandler.getInstance().setCurrentSite(c, request);
		}
		return true;
    }
	
	//@Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	System.out.println("----> Post handler");
        //we can add attributes in the modelAndView and use that in the view page
    }
	 
	//@Override
    public void afterCompletion(HttpServletRequest request,
        HttpServletResponse response, Object handler, Exception ex)
        throws Exception {
    	System.out.println("----> After Completion");
    }

}
