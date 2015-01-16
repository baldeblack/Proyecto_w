package com.utilities;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.entities.Usuario;

public class SessionHandler {
	 private static SessionHandler instance;
	    
	    
	    private SessionHandler() {}
	    
	    
	    public static SessionHandler getInstance() {
	        if (instance == null) {
	            instance = new SessionHandler();
	        }
	        return instance;
	    }
	    
	    
	    public Boolean logguedUser(HttpServletRequest request) {          
	        if (request != null && request.isRequestedSessionIdValid()) {
	            return (request.getSession().getAttribute("active_user") != null);
	        }
	        return false;
	    }
	    
	    
	    public void setActiveUser(Usuario usr, HttpServletRequest request) {
	        if (request.isRequestedSessionIdValid()) {
	            if (request.getSession().getAttribute("active_user") == null) {
	                request.getSession().setAttribute("active_user_nick", usr.getNik()); 
	                request.getSession().setAttribute("active_user", usr.getNik());
	            }
	        }        
	    }
	    
	    
	    public void setActiveSID(String sid, HttpServletRequest request) {
	        if (request.isRequestedSessionIdValid()) {
	            if (request.getSession().getAttribute("active_user") != null && 
	                request.getSession().getAttribute("active_sid") == null) {
	                
	                request.getSession().setAttribute("active_sid", sid);                
	            }
	        }        
	    }    
	    
	    
	    public Usuario getActiveUser(HttpServletRequest request) {
	        if (request.isRequestedSessionIdValid()) {
	            return (Usuario)request.getSession().getAttribute("active_user");
	        }
	        return null;
	    }
	    
	    public String getActiveUserNick(HttpServletRequest request) {
	        if (request.isRequestedSessionIdValid()) {
	            return (String)request.getSession().getAttribute("active_user_nick");
	        }
	        return null;
	    }
	    
	    
	    public String getActiveSID(HttpServletRequest request) {
	        if (request.isRequestedSessionIdValid()) {
	            return (String)request.getSession().getAttribute("active_sid");
	        }
	        return null;
	    }    
	    
	    
	    public void closeActiveSesion(HttpServletRequest request) throws ServletException {
	        if (request != null && request.isRequestedSessionIdValid()) {
	            request.getSession().setAttribute("active_user", null);
	            request.getSession().setAttribute("active_sid", null);
	            request.getSession().setAttribute("active_user_nick", null); 
	            request.logout();
	        }
	    }
}
