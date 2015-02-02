package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.Entities.Catastrofe;
import com.Entities.ONG;
import com.Helper.EntityManagerHelper;
import com.Helper.ongsBorrado;

public class OngDAO {
	EntityManager _eManager;

	public OngDAO() {
		_eManager = EntityManagerHelper.getInstance().getJPAFactory()
				.createEntityManager();
	}

	public void AltaOng(ONG o) {
		try {
			_eManager.getTransaction().begin();
			_eManager.persist(o);
			_eManager.flush();
			_eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public List<ONG> GetOngs() {
		List<ONG> result = null;
		try {
			TypedQuery<ONG> query = _eManager.createQuery(
					"Select o From ONG o", ONG.class);
			result = query.getResultList();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public List<ongsBorrado> GetOngsTenant(int tenantId) throws ClassNotFoundException,
			SQLException {
		List<ongsBorrado> lstResult = new ArrayList<ongsBorrado>();

		try {

			CatastrofeDAO cd = new CatastrofeDAO();
			Catastrofe c = cd.getCatastrofeByID(tenantId);
			Class.forName("com.mysql.jdbc.Driver");
			String url = c.getStringConeccion();
			String username = "root";
			String pass = "123456";
			Connection con = DriverManager.getConnection(url, username, pass);	
			Statement statement = con.createStatement();
			String query = "SELECT * FROM ongs";
			ResultSet resultST = statement.executeQuery(query);
			while (resultST.next()) {
				ongsBorrado o = new ongsBorrado();
				o.setIdONGs(resultST.getInt("idONGs"));
				o.setNombre(resultST.getString("Nombre"));
				o.setDireccion(resultST.getString("Direccion"));
				o.setTelefono(resultST.getString("Telefono"));
				o.setEmail(resultST.getString("Email"));
				o.setWeb(resultST.getString("Web"));
				o.setOrigen(resultST.getString("Origen"));
				o.setDatosPayPal(resultST.getString("DatosPayPal"));
				o.setBorrar(getBorrado(con, o.getIdONGs()));
				lstResult.add(o);
			}
		} catch (Exception e) {
			throw e;
		}
		return lstResult;
	}

	
	public int getBorrado(Connection con, int idOng) throws SQLException{
		Statement statement = con.createStatement();
		String query = "select idDonaciones from donaciones where IdOng =" + idOng;
		ResultSet resultST = statement.executeQuery(query);
		if (!resultST.next() ) {
			return 0;
		}else{
			return 1;
		}
		
	}
	
	public void actualizaTodo(ONG o) throws ClassNotFoundException, SQLException{
		CatastrofeDAO cd = new CatastrofeDAO();
		List<Catastrofe> clst = cd.GetAllCatastrofes();
		for(Catastrofe c: clst){
			ActualizarOTenant(c.getIdCatastrofe(), o );
		}	
	}
	
	private void ActualizarOTenant(int tenantId, ONG o ) throws ClassNotFoundException, SQLException {
		CatastrofeDAO cd = new CatastrofeDAO();
		Catastrofe c = cd.getCatastrofeByID(tenantId);
		Class.forName("com.mysql.jdbc.Driver");
		String url = c.getStringConeccion();
		String username = "root";
		String pass = "123456";
		Connection con = DriverManager.getConnection(url, username, pass);		
	try {
		
		con.setAutoCommit(false);
		Statement statement = con.createStatement();
	
	
		String queryUp = "UPDATE ongs SET  Direccion = '"+o.getDireccion()+"'";
		queryUp = queryUp + ", Telefono = "+o.getTelefono();
		queryUp = queryUp + ", Email = '"+o.getEmail()+"'";
		queryUp = queryUp + ", Web = '"+o.getWeb()+"'";
		queryUp = queryUp + ", Origen = '"+o.getOrigen()+"'";
		queryUp = queryUp + ", DatosPayPal = '"+o.getDatosPayPal()+"'";
		queryUp = queryUp + " WHERE Nombre = '"+o.getNombre()+"'";
		
		statement.executeUpdate(queryUp);
		con.commit();
		
	} catch (Exception e) {
		con.rollback();
		throw e;
	}
	finally{
		con.close();
	}
	}

	
	
	public void InsertOTenant(int tenantId, ONG ong) throws ClassNotFoundException, SQLException {
		CatastrofeDAO cd = new CatastrofeDAO();
		Catastrofe c = cd.getCatastrofeByID(tenantId);
		Class.forName("com.mysql.jdbc.Driver");
		String url = c.getStringConeccion();
		String username = "root";
		String pass = "123456";
		Connection con = DriverManager.getConnection(url, username, pass);		
	try {
		int i = 0;
		con.setAutoCommit(false);
		Statement statement = con.createStatement();	
		String queryMax = "select max(idONGs) from ongs";
		ResultSet resultST = statement.executeQuery(queryMax);
		
		

			while (resultST.next()) {
				 i = resultST.getInt("max(idONGs)") ;
			}
			
			i = 1 + i;
			String queryIn = "INSERT INTO ongs ";
			queryIn = queryIn +	"(idONGs, Nombre, Direccion, Telefono, ";
			queryIn = queryIn + " Email, Web, Origen,DatosPayPal) VALUES ";
			queryIn = queryIn + "("+ i +", '"+ong.getNombre()+"', '"+ong.getDireccion()+"', "+ong.getTelefono()+" , '"+ong.getEmail()+"', '"+ong.getWeb()+"', '"+ong.getOrigen()+"','"+ong.getDatosPayPal()+"')";
			statement.executeUpdate(queryIn);
			
	
		
			con.commit();
	} catch (Exception e) {
		con.rollback();
		throw e;
	}
	finally{
		con.close();
	}
	}
	
	public void DeleteOTenant(int tenantId, String nombreOng) throws ClassNotFoundException, SQLException {
		CatastrofeDAO cd = new CatastrofeDAO();
		Catastrofe c = cd.getCatastrofeByID(tenantId);
		Class.forName("com.mysql.jdbc.Driver");
		String url = c.getStringConeccion();
		String username = "root";
		String pass = "123456";
		Connection con = DriverManager.getConnection(url, username, pass);		
	try {
		con.setAutoCommit(false);
		Statement statement = con.createStatement();	
		String query = "Delete from ongs where Nombre = '" + nombreOng + "'";
		statement.executeUpdate(query);		
		con.commit();
	} catch (Exception e) {
		con.rollback();
		throw e;
	}
	finally{
		con.close();
	}
	}
	
	
	public ONG getONG(int idOng) {
		ONG o = _eManager.find(ONG.class, idOng);
		return o;
	}

	public void ActualizarOng(ONG o, Integer idOng) {
		try {
			ONG oMod = _eManager.find(ONG.class, idOng);
			_eManager.getTransaction().begin();
			oMod.setDatosPayPal(o.getDatosPayPal());
			oMod.setDireccion(o.getDireccion());
			oMod.setEmail(o.getEmail());
			//oMod.setNombre(o.getNombre());
			oMod.setOrigen(o.getOrigen());
			oMod.setTelefono(o.getTelefono());
			oMod.setWeb(o.getWeb());
			_eManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}

	}

	public Integer maxOngId() {
		try {
			Integer i = (Integer) _eManager.createQuery(
					"select max(o.id) from ONG o").getSingleResult();
			if (i == null) {
				i = 0;
				return i;
			}
			return i + 1;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public int GetOngByNombre(String nombre){
		Integer result;
		try {
		Query query =_eManager.createQuery("Select o.idONGs From ONG o Where o.nombre =?1", Integer.class);
		query.setParameter(1, nombre);
		result = (Integer)query.getSingleResult();
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
}
