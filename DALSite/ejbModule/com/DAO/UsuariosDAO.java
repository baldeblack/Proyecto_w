package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.entities.Usuario;
import com.helper.EntityManagerHelper;

public class UsuariosDAO {

	EntityManager _eManager;
	
	public UsuariosDAO(String connection){
		_eManager = EntityManagerHelper.getInstance(connection).getJPAFactory().createEntityManager();
	}
	
	public List<Usuario> getAllUsuarios(){
		List<Usuario> result = null;
		try {
		TypedQuery<Usuario> query =_eManager.createQuery("Select u From Usuario u", Usuario.class);
		result = query.getResultList();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public Usuario getUsuarioById(int id){
		Usuario result = null;
		try {
			result = _eManager.find(Usuario.class, id);
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public Usuario getUsuarioByMail(String mail){
		Usuario result = null;
		try {
			TypedQuery<Usuario> query =_eManager.createQuery("Select u From Usuario u where u.Email = ?1", Usuario.class);
			query.setParameter(1, mail);
			result = query.getSingleResult();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int InsertUpdateUsuario(Usuario input){
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
		return input.getIdUsuarios();
	}
}
