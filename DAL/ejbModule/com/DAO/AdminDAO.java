package com.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.Entities.Administrador;
import com.Helper.ConexionSQL;


public class AdminDAO {

	private EntityManager em;
	
	public AdminDAO(){}
	
	private EntityManager GetEntityManger()
	{
		Map<String, Object> configOverrides = new HashMap<String, Object>();
		configOverrides.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/ShareDB");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("DAL", configOverrides);
		em = entityManagerFactory.createEntityManager();
		return em;

	}

	public void GuardarUsuario(Administrador adm){
		em = GetEntityManger();
		em.getTransaction().begin();
		em.persist(adm);	
		em.flush();
		em.getTransaction().commit();	
	}
	
	public Boolean ExisteUsu(Administrador adm){
		Boolean existe = false;
		Administrador result;
		em = GetEntityManger();
		em.getTransaction().begin();
		result = em.find(Administrador.class, adm.getMail());	
		em.flush();
		em.getTransaction().commit();
		if (result != null){existe = true;}
		return existe;	
	}
	
	public void CrearTenant(String queryCommand){
		Connection con = ConexionSQL.getConnection("");
		Statement st = null;	
			try {
				st = con.createStatement();
				st.executeUpdate(queryCommand);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
	}
	
}
