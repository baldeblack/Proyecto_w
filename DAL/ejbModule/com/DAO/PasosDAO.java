package com.DAO;

import javax.persistence.EntityManager;

import com.Entities.Paso;
import com.Helper.EntityManagerHelper;

public class PasosDAO {
	
	EntityManager _eManager;
	
	public PasosDAO(){
		_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
	}
	
	
	public int InsertUpdatePlan(Paso input){
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
		
		return input.getId().getIdpasos();
	}

}
