package com.DAO;

import javax.persistence.EntityManager;

import com.Entities.Rescatistacatastrofe;
import com.Helper.EntityManagerHelper;

public class RescatistaCatastrofeDAO {

	EntityManager _eManager;
	public RescatistaCatastrofeDAO(){
		_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
	}
	
	
	public boolean DeleteRescatista(int idRescatista){
		try
		{
			Rescatistacatastrofe obj =  _eManager.find(Rescatistacatastrofe.class, idRescatista);
			_eManager.getTransaction().begin();
			_eManager.remove(obj);
			_eManager.getTransaction().commit();
			_eManager.close();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			if(_eManager.isOpen())
				_eManager.close();
		}
		
		if(_eManager.find(Rescatistacatastrofe.class, idRescatista) == null)
			return true;
		else
			return false;
	}
}
