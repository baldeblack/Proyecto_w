package com.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.Entities.Usuario;

public class accessControl {
	
	List<String> prmisosAdm;
	List<String> permisosRes;

	public accessControl (){
		this.prmisosAdm = new ArrayList<>();
		this.permisosRes = new ArrayList<>();
		
		this.prmisosAdm.add("edit");
		this.prmisosAdm.add("create");
		this.prmisosAdm.add("save");
		this.prmisosAdm.add("listCatastrofes");
		this.prmisosAdm.add("listOngs");
		this.prmisosAdm.add("listUsuarios");		
		this.prmisosAdm.add("rptTablas");		
		this.prmisosAdm.add("vincular");
		this.prmisosAdm.add("planes");
		this.prmisosAdm.add("Result");
		this.prmisosAdm.add("otra");
		
		this.permisosRes.add("rescatistahome");
	}
	
	
	public Boolean tieneAcceso(HttpServletRequest request, String viewName){
		 HttpSession session = request.getSession(true);
		 Boolean flag = false;
		 if(session.getAttribute("user") != null){
			 Usuario u = (Usuario) session.getAttribute("user");
			 if(u.getTipoUsuario() == 0){
				 if(this.prmisosAdm.contains(viewName)){
					 flag = true;
				 }
			 }else{
				 if(this.permisosRes.contains(viewName)){
					 flag = true;
				 }
			 }
		 }
			
		return flag;
		
	}
}
