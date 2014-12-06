package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import com.Entities.Catastrofe;
import com.Helper.EntityManagerHelper;

public class CatastrofeDAO {
	EntityManager _eManager;
	public CatastrofeDAO(){
		_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
	}

	public List<Catastrofe> GetAllCatastrofes(){
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
		Query query =_eManager.createQuery("Select c From Catastrofe c Where c.Dominio =?1 and c.Activa =?2", Catastrofe.class);
		query.setParameter(1, domain);
		query.setParameter(2, 1);
		result = (Catastrofe)query.getSingleResult();
		} catch (Exception e) {
			throw e;
		}
		return result;
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

}
