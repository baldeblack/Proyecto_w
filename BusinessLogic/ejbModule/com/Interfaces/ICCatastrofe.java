package com.Interfaces;

import java.util.List;

import com.Entities.Catastrofe;
import com.Entities.Tipocatastrofe;
import com.Helper.CatastrofeLight;
import com.Helper.CatastrofeMobile;

public interface ICCatastrofe {

	List<Catastrofe> getAllCatastrofes();
	
	 List<Catastrofe> GetAllCatastrofesBO();
	 
	List<CatastrofeLight> getAllCatastrofesLight();
	
	Catastrofe GetCatastrofeByDomain(String domain);
	
	CatastrofeMobile GetCatastrofeByDomainMobile(String domain);
	
	void GuardarCatastrofe(Catastrofe c);
	
	Catastrofe getCatastrofeByID(int id);
	
	void ActualizarCatastrofe(Catastrofe c, Integer tenatId);
	
	Catastrofe getCatastrofeByStringConnection(String conn);
	
	Integer minCtId();
	
	List<Tipocatastrofe> getTiposCT();
	
	Integer maxCatId();
}
