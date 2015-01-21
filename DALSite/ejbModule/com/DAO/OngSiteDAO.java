package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.entities.Ong;
import com.helper.EntityManagerHelper;

public class OngSiteDAO {

	EntityManager _eManager;
	public OngSiteDAO(String connection){
		_eManager = EntityManagerHelper.getInstance(connection).getJPAFactory().createEntityManager();
	}
	
	public List<Ong> getAllONGs(){
		List<Ong> result = null;
		try {
			TypedQuery<Ong> query =_eManager.createQuery("SELECT o FROM Ong o", Ong.class);
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
