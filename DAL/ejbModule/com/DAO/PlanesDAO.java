package com.DAO;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.Entities.Catastrofetipo;
import com.Entities.Paso;
import com.Entities.Plan;
import com.Entities.Rescatistacatastrofe;
import com.Entities.Tipocatastrofe;
import com.Helper.EntityManagerHelper;

public class PlanesDAO {

		EntityManager _eManager;
		
		public PlanesDAO(){
			_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
		}
		
		
		public Rescatistacatastrofe getRescatistacatastrofe(int idUsr){
			Rescatistacatastrofe result; 
			Query query =_eManager.createQuery("Select c From Rescatistacatastrofe c Where c.idrescatista =?1 ", Rescatistacatastrofe.class);
			query.setParameter(1, idUsr);	
			result = (Rescatistacatastrofe)query.getSingleResult();
			return result;
			
		}
		
		public Tipocatastrofe getTipo(int ctId){
			Catastrofetipo ctTipo; 
			Tipocatastrofe tipo;
			Query query =_eManager.createQuery("Select c From Catastrofetipo c Where c.idcatastrofe =?1 ", Catastrofetipo.class);
			query.setParameter(1, ctId);	
			ctTipo = (Catastrofetipo)query.getSingleResult();
			
			Query querydos = _eManager.createQuery("Select c From Tipocatastrofe c Where c.idtipocatastrofe =?1 ", Tipocatastrofe.class);
			querydos.setParameter(1, ctTipo.getIdTipo());	
			tipo = (Tipocatastrofe)querydos.getSingleResult();
			return tipo;
			
		}
		
		public List<Plan> getPlanes(int tipoCT){
			List<Plan> lstPlanes = new ArrayList<Plan>();
			TypedQuery<Plan> query =_eManager.createQuery("Select p From Plan p Where p.idTipoCatastrofe =?1 ", Plan.class);
			query.setParameter(1, tipoCT);	
			lstPlanes = query.getResultList();
			return lstPlanes; 				
		}
		
		public List<Paso> getPasos(int idPlan){
			List<Paso> pasos = new ArrayList<Paso>();
			TypedQuery<Paso>  query =_eManager.createQuery("Select p From Paso p Where p.idPlan =?1 ", Paso.class);
			query.setParameter(1, idPlan);	
			pasos = query.getResultList();
		    return pasos;
		}
		
		public int InsertUpdatePlan(Plan input){
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
			return input.getIdPlan();
		}
		
}
