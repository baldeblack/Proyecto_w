package com.Controllers;

import java.util.List;

import com.DAO.CatastrofeDAO;
import com.Entities.Catastrofe;
import com.Entities.Tipocatastrofe;
import com.Helper.CatastrofeLight;
import com.Helper.CatastrofeMobile;
import com.Interfaces.ICCatastrofe;

public class CCatastrofe implements ICCatastrofe {

	CatastrofeDAO _dao;
	public CCatastrofe() {
		_dao = new CatastrofeDAO();
	}

	@Override
	public List<Catastrofe> getAllCatastrofes() {
		return _dao.GetAllCatastrofes();
	}

	@Override
	public Catastrofe GetCatastrofeByDomain(String domain) {
		return _dao.GetCatastrofeByDomain(domain);
	}
	
	public CatastrofeMobile GetCatastrofeByDomainMobile(String domain) {
		return new CatastrofeMobile(_dao.GetCatastrofeByDomain(domain));
	}

	@Override
	public void GuardarCatastrofe(Catastrofe c) {
		  _dao.AltaCtastrofe(c);
		
	}

	@Override
	public Catastrofe getCatastrofeByID(int id) {
		// TODO Auto-generated method stub
		return _dao.getCatastrofeByID(id);
	}
	
	@Override
	public void ActualizarCatastrofe(Catastrofe c, Integer tenatId) {
		// TODO Auto-generated method stub
		_dao.ActualizarCatastrofe(c, tenatId);
		
	}
	
	@Override
	public Catastrofe getCatastrofeByStringConnection(String conn) {

		return _dao.getCatastrofeByStringConnection(conn);
	}

	@Override
	public Integer minCtId() {
		// TODO Auto-generated method stub
		return _dao.minCtId();
	}

	@Override
	public List<Tipocatastrofe> getTiposCT() {
		// TODO Auto-generated method stub
		return _dao.getTiposCT();
	}

	@Override
	public List<CatastrofeLight> getAllCatastrofesLight() {
		// TODO Auto-generated method stub
		return _dao.GetAllCatastrofesLight();
	}

	@Override
	public Integer maxCatId() {
		// TODO Auto-generated method stub
		return _dao.maxCatId();
	}

	@Override
	public List<Catastrofe> GetAllCatastrofesBO() {
		// TODO Auto-generated method stub
		return  _dao.GetAllCatastrofesBO();
	}

}
