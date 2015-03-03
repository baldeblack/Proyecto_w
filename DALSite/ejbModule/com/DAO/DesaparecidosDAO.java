package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.entities.Desaparecido;
import com.helper.EntityManagerHelper;

public class DesaparecidosDAO {

	EntityManager _eManager;
	public DesaparecidosDAO(String connection){
		_eManager = EntityManagerHelper.getInstance(connection).getJPAFactory().createEntityManager();
	}
	
	public List<Desaparecido> getAllDesaparecidos(){
		List<Desaparecido> result = null;
		try {
		TypedQuery<Desaparecido> query =_eManager.createQuery("SELECT d FROM Desaparecido d", Desaparecido.class);
		
		System.out.println("despues de la query");
		result = query.getResultList();
		System.out.println(query.getResultList().size());
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	
	public List<Desaparecido> getAllDesaparecidosByState(short state){
		List<Desaparecido> result = null;
		try {
		TypedQuery<Desaparecido> query =_eManager.createQuery("Select d From Desaparecido d where d.estadoBusqueda = ?1", Desaparecido.class);
		query.setParameter(1, state);
		result = query.getResultList();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public Desaparecido getDesaparecidoById(int id){
		Desaparecido result = null;
		try {
		TypedQuery<Desaparecido> query =_eManager.createQuery("Select d From Desaparecido d where d.idDesaparecido = ?1", Desaparecido.class);
		query.setParameter(1, id);
		result = query.getSingleResult();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public int InsertUpdateDesaparecido(Desaparecido input){
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
		return input.getIdDesaparecidos();
	}
	
	public boolean ChangeStateDesaparecido(int id, short newState){
		try
		{
			Desaparecido toSave = _eManager.find(Desaparecido.class, id);
			if(toSave != null)
			{
				_eManager.getTransaction().begin();
				toSave.setEstadoBusqueda(newState);
				_eManager.persist(toSave);
				_eManager.getTransaction().commit();
				_eManager.close();
				return true;
			}
			else
			{
				System.out.println("No existe el desaparecido que desea borrar");
				return false;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally{
			if(_eManager.isOpen())
				_eManager.close();
		}
	}
}
