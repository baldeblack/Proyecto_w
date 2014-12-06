/**
 * 
 */
package com.Helper;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author proyecto
 *
 */

public class EntityManagerHelper {

	private static EntityManagerHelper myHelper = null;
	private static EntityManagerFactory myFactory = null;
	
	private EntityManagerHelper(){
		if(myFactory == null) {
			   synchronized (EntityManagerHelper.class) {
				   if(myFactory == null) {
					    Map<String, Object> configOverrides = new HashMap<String, Object>();
						configOverrides.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/ShareDB");
					     myFactory =  Persistence.createEntityManagerFactory("DAL", configOverrides);
					 }
			   }
		}
	}
	
	 public static EntityManagerHelper getInstance() {
		  if(myHelper == null) {
		   myHelper = new EntityManagerHelper();
		  }
		  return myHelper;
	 }
	 
	 public EntityManagerFactory getJPAFactory() {
		  return myFactory;
	 }
}
