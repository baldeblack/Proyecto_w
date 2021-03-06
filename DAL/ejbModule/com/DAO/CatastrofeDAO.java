package com.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.Entities.Catastrofe;
import com.Entities.Tipocatastrofe;
import com.Helper.CatastrofeLight;
import com.Helper.EntityManagerHelper;

public class CatastrofeDAO {
	EntityManager _eManager;
	public CatastrofeDAO(){
		_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
	}

	public List<Catastrofe> GetAllCatastrofes(){
		List<Catastrofe> result = null;
		try {
		TypedQuery<Catastrofe> query =_eManager.createQuery("Select c From Catastrofe c Where c.activa =?1", Catastrofe.class);
		byte est = 1;
		query.setParameter(1,est);
		result = query.getResultList();
		
		} catch (Exception e) {
			throw e;
		}
		return result;
	}

	public List<Catastrofe> GetAllCatastrofesBO(){
		List<Catastrofe> result = null;
		try {
		TypedQuery<Catastrofe> query =_eManager.createQuery("Select c From Catastrofe c", Catastrofe.class);
		result = query.getResultList();
		
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	public Catastrofe GetCatastrofeByDomain(String domain){
		Catastrofe result = null;
		try {
		Query query =_eManager.createQuery("Select c From Catastrofe c Where c.dominio =?1", Catastrofe.class);
		query.setParameter(1, domain);
		//query.setParameter(2, 1);
		result = (Catastrofe)query.getSingleResult();
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	public Integer maxCatId(){
		try {
		Integer i = (Integer)_eManager.createQuery("select max(c.id) from Catastrofe c").getSingleResult();
		if(i == null){
			i = 0;
			return i;
		}
		return i;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	public void AltaCtastrofe(Catastrofe c){
		try {
			_eManager.getTransaction().begin();
			_eManager.persist(c);	
			_eManager.flush();
			_eManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
			
	}
	
	public void ActualizarCatastrofe(Catastrofe c, Integer tenatId){
		try {
			 Catastrofe cMod = _eManager.find(Catastrofe.class, tenatId);			 
			 _eManager.getTransaction().begin();
			 cMod.setNombre(c.getNombre());
			 cMod.setCss(c.getCss());
			 cMod.setActiva(c.getActiva());
			 cMod.setDominio(c.getDominio());
			 cMod.setFuentesDatos(c.getFuentesDatos());
			 cMod.setInformacion(c.getInformacion());
			 cMod.setLogo(c.getLogo());
			 cMod.setPalabrasClaves(c.getPalabrasClaves());
			 cMod.setZonaAfectada(c.getZonaAfectada());
			 cMod.setApiFb(c.getApiFb());
			 cMod.setApiTw(c.getApiTw());
			 cMod.setTipo(c.getTipo());
			 _eManager.getTransaction().commit();			
		} catch (Exception e) {
			throw e;
		}
			
	}
	
	public Catastrofe getCatastrofeByID(int id){
		Catastrofe c = null;
		try {
		_eManager.getTransaction().begin();
	     c = _eManager.find(Catastrofe.class, id);
		_eManager.flush();
		_eManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
		return c;
	}
	
	public Integer minCtId(){
		try {
		
		Integer i = (Integer)_eManager.createQuery("select min(c.id) from Catastrofe c").getSingleResult();
		if(i == null){
			i = 0;
			return i;
		}
		return i + 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public Catastrofe getCatastrofeByStringConnection(String conn){
		Catastrofe result = null;
		try {
			
			List<Catastrofe> list = GetAllCatastrofes();
			for (Catastrofe catastrofe : list) {
				if(catastrofe.getStringConeccion().equalsIgnoreCase(conn))
					return catastrofe;
			}
			//result = _eManager.find(Catastrofe.class,  conn);
			/*
			TypedQuery<Catastrofe> query =_eManager.createQuery("Select c From Catastrofe c Where c.StringConeccion =:conn and c.Activa =:act", Catastrofe.class);
			query.setParameter("conn", conn);
			query.setParameter("act", 1);
			result = (Catastrofe)query.getSingleResult();*/
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	public List<Tipocatastrofe> getTiposCT(){
		TypedQuery<Tipocatastrofe> query =
			      _eManager.createNamedQuery("Tipocatastrofe.findAll", Tipocatastrofe.class);
			  List<Tipocatastrofe> results = query.getResultList();
			  return results;
	}
	

	public List<CatastrofeLight> GetAllCatastrofesLight() {
		List<CatastrofeLight> result = new ArrayList<CatastrofeLight>();
		try {
			TypedQuery<Catastrofe> query =_eManager.createQuery("Select c From Catastrofe c", Catastrofe.class);
			List<Catastrofe>resultado = query.getResultList();
			
			for (Catastrofe u: resultado){
                CatastrofeLight r = new CatastrofeLight(u);
                result.add(r);
			}
		
		
		
		} catch (Exception e) {
			throw e;
		}
		return result;
	}


}
