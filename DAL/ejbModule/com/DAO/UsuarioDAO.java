package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.Entities.Rescatista;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;
import com.Helper.EntityManagerHelper;

public class UsuarioDAO {

	EntityManager _eManager;
	public UsuarioDAO(){
		_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
	}
	
	public Usuario ExisteUsu(String mail, String pass){
		Usuario user = null;		
		try {
			Query query =_eManager.createQuery("Select c From Usuario c Where c.email =?1", Usuario.class);
			query.setParameter(1, mail);	
			user = (Usuario)query.getSingleResult();	
			
			if (pass.equals(user.getPassword())){
				return user;
			}				
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
		
	public List<TipoRescatista> GetTipoRescatista(){
		List<TipoRescatista> result = null;
		try {
		TypedQuery<TipoRescatista> query =_eManager.createQuery("Select t From TipoRescatista t", TipoRescatista.class);
		result = query.getResultList();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public void AltaUsuario(Usuario u){
		try {
			_eManager.getTransaction().begin();
			_eManager.persist(u);	
			_eManager.flush();
			_eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
		
		public void AltaRescatista(Rescatista r){
			try {
				_eManager.getTransaction().begin();
				_eManager.persist(r);	
				_eManager.flush();
				_eManager.getTransaction().commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
				
	}
		
		public TipoRescatista getTipoByID(int ID){
			TipoRescatista TipoRescatista = _eManager.find(TipoRescatista.class, ID);
			return TipoRescatista;
			}
		
		public Integer maxUsrId(){
			try {
			Integer i = (Integer)_eManager.createQuery("select max(u.id) from Usuario u").getSingleResult();
			if(i == null){
				i = 0;
				return i;
			}
			return i + 1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		
		public Integer maxResId(){
			try {
			Integer i = (Integer)_eManager.createQuery("select max(u.id) from Rescatista u").getSingleResult();
			if(i == null){
				i = 0;
				return i;
			}
			return i + 1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
}
