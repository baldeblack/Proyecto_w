package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.Entities.Catastrofe;
import com.Entities.ONG;
import com.Helper.EntityManagerHelper;

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

	public List<ONG> GetOngsTenant(int tenantId) throws ClassNotFoundException,
			SQLException {
		List<ONG> lstResult = new ArrayList<ONG>();

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
				ONG o = new ONG();
				o.setIdONGs(resultST.getInt("idONGs"));
				o.setNombre(resultST.getString("Nombre"));
				o.setDireccion(resultST.getString("Direccion"));
				o.setTelefono(resultST.getString("Telefono"));
				o.setEmail(resultST.getString("Email"));
				o.setWeb(resultST.getString("Web"));
				o.setOrigen(resultST.getString("Origen"));
				o.setDatosPayPal(resultST.getString("DatosPayPal"));
				lstResult.add(o);
			}
		} catch (Exception e) {
			throw e;
		}
		return lstResult;
	}

	public void ActualizarOTenant(int tenantId, List<ONG> lstMod ) throws ClassNotFoundException, SQLException {
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
		String query = "DELETE FROM ongs";
		statement.executeUpdate(query);
		String queryMax = "select max(idONGs) from ongs";
		ResultSet resultST = statement.executeQuery(queryMax);
		
		while (resultST.next()) {
			 i = resultST.getInt("max(idONGs)") ;
		}
		
			for (ONG o : lstMod) {
				o.setIdONGs(i);
				String queryIn = "INSERT INTO ongs ";
				queryIn = queryIn +	"(idONGs, Nombre, Direccion, Telefono, ";
				queryIn = queryIn + " Email, Web, Origen,DatosPayPal) VALUES ";
				queryIn = queryIn + "("+ i +", '"+o.getNombre()+"', '"+o.getDireccion()+"', "+o.getTelefono()+" , '"+o.getEmail()+"', '"+o.getWeb()+"', '"+o.getOrigen()+"','"+o.getDatosPayPal()+"')";
				statement.executeUpdate(queryIn);
				i = 1 + i;
			}	
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
			oMod.setNombre(o.getNombre());
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
}
