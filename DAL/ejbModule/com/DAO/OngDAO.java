package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.Entities.ONG;
import com.Helper.EntityManagerHelper;

public class OngDAO {
	EntityManager _eManager;
	
	public OngDAO(){
		_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
	}
			
	public void AltaOng(ONG o){
		try {
			_eManager.getTransaction().begin();
			_eManager.persist(o);	
			_eManager.flush();
			_eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
		
	public List<ONG> GetOngs(){
		List<ONG> result = null;
		try {
		TypedQuery<ONG> query =_eManager.createQuery("Select o From ONGs o", ONG.class);
		result = query.getResultList();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
}
