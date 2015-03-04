package com.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.entities.Catastrofe;
import com.entities.Usuario;

public class SessionHandler {
	 private static SessionHandler instance;
	    private static String USER_KEY = "active_user";
	    private static String USER_NAME_KEY = "active_user_nick";
	    public static String CATASTROFE_KEY ="Catastrofe";

	    private SessionHandler() {
	    	Date date = new Date();
		    Calendar calendar = Calendar.getInstance();
		    calendar.setTime(date);
		    SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddhhmmss");
		    //CATASTROFE_KEY = "CT" + SDF.format(date);
	    }
	    
	    
	    public static SessionHandler getInstance() {
	        if (instance == null) {
	            instance = new SessionHandler();
	        }
	        return instance;
	    }
	    
	    public Catastrofe getCurrentSite(HttpServletRequest request){
	    	if (request.isRequestedSessionIdValid()) {
	            return (Catastrofe)request.getSession().getAttribute(CATASTROFE_KEY);
	        }
	        return null;
	    }
	    
	    public void setCurrentSite(Catastrofe c, HttpServletRequest request) {
	       // if (request.isRequestedSessionIdValid()) {
	                request.getSession().setAttribute(CATASTROFE_KEY, c);
	      //   }        
	    }
	    
	    public Boolean logguedUser(HttpServletRequest request) {          
	        if (request != null && request.isRequestedSessionIdValid()) {
	            return (request.getSession().getAttribute(USER_KEY) != null);
	        }
	        return false;
	    }
	    
	    
	    public void setActiveUser(Usuario usr, HttpServletRequest request) {
	        if (request.isRequestedSessionIdValid()) {
	            if (request.getSession().getAttribute(USER_KEY) == null) {
	                request.getSession().setAttribute(USER_NAME_KEY, usr.getNik()); 
	                request.getSession().setAttribute(USER_KEY, usr);
	            }
	        }        
	    }
	    
	    public Usuario getActiveUser(HttpServletRequest request) {
	        if (request.isRequestedSessionIdValid()) {
	            return (Usuario)request.getSession().getAttribute(USER_KEY);
	        }
	        return null;
	    }
	    
	    public String getActiveUserNick(HttpServletRequest request) {
	        if (request.isRequestedSessionIdValid()) {
	            return (String)request.getSession().getAttribute(USER_NAME_KEY);
	        }
	        return null;
	    }
	    
	    public void closeActiveSesion(HttpServletRequest request) throws ServletException {
	        if (request != null && request.isRequestedSessionIdValid()) {
	            request.getSession().setAttribute(USER_KEY, null);
	            request.getSession().setAttribute(USER_NAME_KEY, null); 
	            request.logout();
	        }
	    }
}
