package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.Entities.Catastrofetipo;
import com.Entities.Paso;
import com.Entities.Plan;
import com.Entities.Rescatistacatastrofe;
import com.Entities.Tipocatastrofe;
import com.Helper.EntityManagerHelper;
import com.Helper.PlanUtil;

public class PlanesDAO {

		EntityManager _eManager;
		
		public PlanesDAO(){
			_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
		}
		
		public boolean getPlanStatus(int idPlan){
			boolean result = false;
			_eManager.getTransaction().begin();
			 Plan pMod = _eManager.find(Plan.class, idPlan);
			 int contador = 0;		
			 for(Paso p: pMod.getPasos())
				 if(p.getEstado().equals(Integer.toString(1)))
					 contador = contador + 1;
			 
			 if(contador == pMod.getPasos().size())
				 result = true;
			 
			 return result;
		}
		
		public Plan getPlan(int idPlan){
			Plan plan = new Plan();
			_eManager.getTransaction().begin();
			plan= _eManager.find(Plan.class, idPlan);
			return plan;
		}
		
		public void removeRC(int idUs){
			if (!_eManager.getTransaction().isActive()) {
				_eManager.getTransaction().begin();
			}	
			Rescatistacatastrofe rDel = _eManager.find(Rescatistacatastrofe.class, idUs);
			_eManager.remove(rDel);
			_eManager.getTransaction().commit();
		}
		
		public Rescatistacatastrofe getRescatistacatastrofe(int idUsr){
			Rescatistacatastrofe result = null; 
			
			try {				
				Query query =_eManager.createQuery("Select c From Rescatistacatastrofe c Where c.idrescatista =?1 ", Rescatistacatastrofe.class);
				query.setParameter(1, idUsr);	
				result = (Rescatistacatastrofe)query.getSingleResult();
			} catch (NoResultException e) {
				return result;
			}
			
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
		
		public List<Plan> getPlanesBO(int tipoCT){
			List<Plan> lstPlanes = new ArrayList<Plan>();
			TypedQuery<Plan> query =_eManager.createQuery("Select p From Plan p Where p.idTipoCatastrofe =?1 and p.estado =?2", Plan.class);
			query.setParameter(1, tipoCT);	
			query.setParameter(2, 0);	
			lstPlanes = query.getResultList();
			
			return lstPlanes; 				
		}
		
		public List<Plan> getPlanes(){
			List<Plan> lstPlanes = new ArrayList<Plan>();
			try {
				TypedQuery<Plan> query =_eManager.createQuery("Select p From Plan p", Plan.class);
				
				lstPlanes = query.getResultList();
			} catch (Exception e) {
				// TODO: handle exception
			}
						
			return lstPlanes; 				
		}
		
		public List<PlanUtil> getPlanes(int tipoCT){
			List<Plan> lstPlanes = new ArrayList<Plan>();
			TypedQuery<Plan> query =_eManager.createQuery("Select p From Plan p Where p.idTipoCatastrofe =?1 and p.estado =?2", Plan.class);
			query.setParameter(1, tipoCT);	
			query.setParameter(2, 0);	
			lstPlanes = query.getResultList();
			
			List<PlanUtil> lspu = new ArrayList<PlanUtil>();
			for(Plan p: lstPlanes){
				PlanUtil pu = new PlanUtil();
				pu.setCantidadPasos(p.getCantidadPasos());
				pu.setDescripcion(p.getDescripcion());
				pu.setEstado(p.getEstado());
				pu.setIdPlan(p.getIdPlan());
				pu.setIdTipoCatastrofe(p.getIdTipoCatastrofe());
				pu.setIdTipoPlan(p.getIdTipoPlan());
				pu.setNombre(p.getNombre());
				lspu.add(pu);
			}
			return lspu; 				
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
			
				
				if (!_eManager.getTransaction().isActive()) {
					_eManager.getTransaction().begin();
				}
				 Plan pMod = _eManager.find(Plan.class, input.getIdPlan());
				
				 if(pMod == null){
					 _eManager.persist(input);
				 }else{
					 _eManager.merge(input);
				 }
				
//		    for(Paso p: input.getPasos())
//		    {
//		    	p.setPlan(input);
//		    	Paso psMod = _eManager.find(Paso.class, p.getIdpasos());
//			    	
//		    	 if(psMod == null){
//					 _eManager.persist(p);
//				 }else{
//					 _eManager.merge(p);
//					 }			    	
//		    }
			    
				_eManager.getTransaction().commit();
			} catch (Exception e) {				
				_eManager.getTransaction().rollback();
				System.out.println(e.getMessage());
			}
			
			return input.getIdPlan();
		}
		
		public void updatepaso(List<Paso> lstpasos, Plan pl) throws ClassNotFoundException, SQLException{
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sharedb";
			String username = "root";
			String pass = "123456";	
			
			Connection con = DriverManager.getConnection(url,username,pass);
			
			try
			{	
			con.setAutoCommit(false);
			
			
			
		    for(Paso p: lstpasos){
		    	Boolean flag = false;
		    	String exsist = "SELECT * FROM pasos WHERE idpasos = " + p.getIdpasos();
		    	Statement statement = con.createStatement();
		    	ResultSet resultexist = statement.executeQuery(exsist);
		    	
		    	while (resultexist.next())
				{
		    		flag = true;
				}
		    	
		    	if(!flag){
		    		
			    	Statement insertatement = con.createStatement();
			    	String insert  = "INSERT INTO pasos (idPlan, nombre, descripcion, estado) ";
			    	insert = insert + "VALUES( "+ pl.getIdPlan() + " , '" + p.getNombre() + "'  , '" + p.getDescripcion() + "' , '" + p.getEstado() + "' )";
			    				
			    	insertatement.executeUpdate(insert);
			    	
		    	}else{
		    		Statement updatestatement = con.createStatement();
					
				    String update = "UPDATE pasos SET nombre ='" + p.getNombre() + "',	descripcion = ";
				    update = update + "'" + p.getDescripcion() + "', estado = '" + p.getEstado() + "' WHERE idpasos = " + p.getIdpasos();

				    updatestatement.executeUpdate(update);
		    		
		    	}
		    }
//			    {
//			    	p.setPlan(input);
//			    	Paso psMod = _eManager.find(Paso.class, p.getIdpasos());
//				    	
//			    	 if(psMod == null){
//						 _eManager.persist(p);
//					 }else{
//						 _eManager.merge(p);
//						 }			    	
//			   }
		
			con.commit();
			} catch (Exception e) {
				con.rollback();
				throw e;
			}
			finally
			{
			   con.close();
			}
			
			
//			try
//			{	
//				if (!_eManager.getTransaction().isActive()) {
//					_eManager.getTransaction().begin();
//				}
//				
//		    for(Paso p: lstpasos)
//		    {
//		    	//p.setPlan(pl);
//		    	Paso psMod = _eManager.find(Paso.class, p.getIdpasos());
//			    	
//		    	 if(psMod == null){
//		    		 pl.addPaso(p);
//		    		 p.setPlan(pl);
//					 _eManager.persist(p);
//				 }else{
//					 _eManager.merge(p);
//					 }			    	
//		    }
//			    
//				_eManager.getTransaction().commit();
//			} catch (Exception e) {				
//				_eManager.getTransaction().rollback();
//				System.out.println(e.getMessage());
//			}			
		
		}
		
		public Integer maxPasoId() {		
			try {
				if (!_eManager.getTransaction().isActive()) {
					_eManager.getTransaction().begin();
				}
				
				Integer i = (Integer) _eManager.createQuery(
						"select max(p.id) from Paso p").getSingleResult();
				if (i == null) {
					i = 0;
					return i;
				}
				_eManager.getTransaction().commit();			
				return i;
						
			} catch (Exception e) {				
				_eManager.getTransaction().rollback();
				System.out.println(e.getMessage());
			}
			return null;
		}
}
