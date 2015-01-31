package com.Interfaces;

import java.util.List;

import com.Entities.Catastrofe;

public interface ICCatastrofe {

	List<Catastrofe> getAllCatastrofes();
	
	Catastrofe GetCatastrofeByDomain(String domain);
	
	void GuardarCatastrofe(Catastrofe c);
	
	Catastrofe getCatastrofeByID(int id);
	
	void ActualizarCatastrofe(Catastrofe c, Integer tenatId);
	
	Catastrofe getCatastrofeByStringConnection(String conn);
	
	Integer minCtId();
}
