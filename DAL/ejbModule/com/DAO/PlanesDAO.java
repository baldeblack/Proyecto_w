package com.DAO;


import javax.persistence.EntityManager;

import com.Helper.EntityManagerHelper;

public class PlanesDAO {

		EntityManager _eManager;
		
		public PlanesDAO(){
			_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
		}
		
		
		
}
