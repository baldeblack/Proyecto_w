package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.Entities.ONG;
import com.Helper.EntityManagerHelper;

public class OngDAO {
	EntityManager _eManager;
	
	public OngDAO(){
		_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
	}
			
	public void AltaOng(ONG o){
		try {
			_eManager.getTransaction().begin();
			_eManager.persist(o);	
			_eManager.flush();
			_eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
		
	public List<ONG> GetOngs(){
		List<ONG> result = null;
		try {
		TypedQuery<ONG> query =_eManager.createQuery("Select o From ONG o", ONG.class);
		result = query.getResultList();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public ONG getONG(int idOng){
		ONG o = _eManager.find(ONG.class, idOng);
		return o;
	}
	
	public void ActualizarOng(ONG o, Integer idOng){
		try {
			 ONG oMod = _eManager.find(ONG.class, idOng);			 
			 _eManager.getTransaction().begin();
			 oMod.setDatosPayPal(o.getDatosPayPal());
			 oMod.setDireccion(o.getDireccion());
			 oMod.setEmail(o.getEmail());
			 oMod.setNombre(o.getNombre());
			 oMod.setOrigen(o.getOrigen());
			 oMod.setTelefono(o.getTelefono());
			 oMod.setWeb(o.getWeb());
			 _eManager.getTransaction().commit();			
		} catch (Exception e) {
			throw e;
		}
			
	}
	
	public Integer maxOngId(){
		try {
		Integer i = (Integer)_eManager.createQuery("select max(o.id) from ONG o").getSingleResult();
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
