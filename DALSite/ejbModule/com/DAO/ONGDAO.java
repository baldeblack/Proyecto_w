package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.entities.Ong;
import com.helper.EntityManagerHelper;

public class ONGDAO {

	EntityManager _eManager;
	public ONGDAO(String connection){
		_eManager = EntityManagerHelper.getInstance(connection).getJPAFactory().createEntityManager();
	}
	
	public List<Ong> getAllONGs(){
		List<Ong> result = null;
		try {
		TypedQuery<Ong> query =_eManager.createQuery("Select o From ONG o", Ong.class);
		result = query.getResultList();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public Ong getONGbyId(int id){
		Ong result = null;
		try 
		{
			return _eManager.find(Ong.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
}
