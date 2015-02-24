package com.helper;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {
	private static EntityManagerHelper myHelper = null;
	private static EntityManagerFactory myFactory = null;
	private static String _currentConnection = "";
	
	private EntityManagerHelper(String connection){
		   synchronized (EntityManagerHelper.class) {
				    Map<String, Object> configOverrides = new HashMap<String, Object>();
					configOverrides.put("hibernate.connection.url", connection);
				     myFactory =  Persistence.createEntityManagerFactory("DALSite", configOverrides);
		   }
	}
	

	 public static EntityManagerHelper getInstance(String connection) {
		  if(myHelper == null || connection != _currentConnection) {
			  myHelper = new EntityManagerHelper(connection);
			  _currentConnection = connection;
		  }
		  return myHelper;
	 }
	 
	 public EntityManagerFactory getJPAFactory() {
		  return myFactory;
	 }
}
