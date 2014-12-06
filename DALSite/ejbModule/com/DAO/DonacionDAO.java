package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import com.entities.Donacione;
import com.helper.EntityManagerHelper;

public class DonacionDAO {

	EntityManager _eManager;
	
	public DonacionDAO(String connection){
		_eManager = EntityManagerHelper.getInstance(connection).getJPAFactory().createEntityManager();
	}
	
	public List<Donacione> getAllDonaciones(){
		List<Donacione> result = null;
		try {
		TypedQuery<Donacione> query =_eManager.createQuery("Select d From Donacione d", Donacione.class);
		result = query.getResultList();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public Donacione getDonacionById(int id){
		Donacione result = null;
		try 
		{
			return _eManager.find(Donacione.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int InsertUpdateDonacion(Donacione input){
		try
		{
			//TODO: ver si funciona esto bien...
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
		return input.getIdDonaciones();
	}
}
