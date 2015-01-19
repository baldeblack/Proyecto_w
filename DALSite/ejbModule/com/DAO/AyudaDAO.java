package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.entities.Ayuda;
import com.helper.EntityManagerHelper;

public class AyudaDAO {
	
	EntityManager _eManager;
	public AyudaDAO(){}
	public AyudaDAO(String connection){
		_eManager = EntityManagerHelper.getInstance(connection).getJPAFactory().createEntityManager();
	}
	
	public Ayuda getAyudabyId(int id) {
		Ayuda result = null;
		try 
		{
			TypedQuery<Ayuda> query =_eManager.createQuery("Select a From Ayuda a where a.idAyuda = ?1", Ayuda.class);
			query.setParameter(1, id);
			result = query.getSingleResult();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return result;
	}

	public List<Ayuda> getAll() {
		List<Ayuda> result = null;
		try 
		{
			TypedQuery<Ayuda> query =_eManager.createQuery("Select a From Ayuda a", Ayuda.class);
			result = query.getResultList();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int InsertUpdateAyuda(Ayuda input){
		try
		{
			_eManager.getTransaction().begin();
		    _eManager.persist(input);
			_eManager.getTransaction().commit();
			_eManager.close();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			if(_eManager.isOpen())
				_eManager.close();
		}
		return input.getIdAyuda();
	}

}
