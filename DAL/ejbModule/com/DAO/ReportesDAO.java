package com.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.Entities.Catastrofe;
import com.Entities.Rptdata;
import com.Helper.EntityManagerHelper;
import com.Helper.RptType;
import com.Helper.donacionesRpt;

public class ReportesDAO {
	EntityManager _eManager;

	public ReportesDAO() {
		_eManager = EntityManagerHelper.getInstance().getJPAFactory()
				.createEntityManager();
	}
	
	public Rptdata getRptUso() throws SQLException, ClassNotFoundException{
		Rptdata result = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/sharedb";
		String username = "root";
		String pass = "123456";
		Connection con = DriverManager.getConnection(url,username,pass);
		Statement statement = con.createStatement();
		String query = "SELECT SUM(ongs) as ongs, SUM(desaparecidos) as desaparecidos, SUM(usuarios) as usuarios, SUM(pedidos) as pedidos  FROM rptdata";
		ResultSet resultST = statement.executeQuery(query);
		result = new Rptdata();
		while (resultST.next())
		{
		result.setDesaparecidos(resultST.getInt("desaparecidos"));
		result.setOngs(resultST.getInt("ongs"));
		result.setPedidos(resultST.getInt("pedidos"));
		result.setUsuarios(resultST.getInt("usuarios"));
		}
				
		return result;
	}
	
	public Rptdata getRptUsoTenant(int idTenat){
		Rptdata rpt = _eManager.find(Rptdata.class, idTenat);
		return rpt;
	}
	
	public List<donacionesRpt> getRptDonaciones(int idTenant, Date start, Date end) throws SQLException, ClassNotFoundException{
		List<donacionesRpt> lst = new ArrayList<donacionesRpt>();
		donacionesRpt result = null;
		CatastrofeDAO cd = new CatastrofeDAO();
		Catastrofe c = cd.getCatastrofeByID(idTenant);
		Class.forName("com.mysql.jdbc.Driver");
		String url = c.getStringConeccion();
		String username = "root";
		String pass = "123456";
		Connection con = DriverManager.getConnection(url,username,pass);
		Statement statement = con.createStatement();
		String query = "select d.IdTipoDonacion, d.Cantidad, d.Moneda, d.Monto, d.HsServicio, u.Nombre, u.Apellido, o.Nombre as Nombreong, o.Email from donaciones d join usuarios u on d.IdDonante = u.idUsuarios join ongs o on  o.idONGs = d.IdOng and d.Fecha >= '" +start+"' and d.Fecha <= '" +end +"'";
		ResultSet resultST = statement.executeQuery(query);
		
		while (resultST.next())
		{
			result = new donacionesRpt();
		result.setIdTipoDonacion(resultST.getInt("idTipoDonacion"));
		result.setApellido(resultST.getString("apellido"));
		result.setCantidad(resultST.getInt("cantidad"));
		result.setMoneda(resultST.getString("moneda"));
		result.setMonto(resultST.getBigDecimal("monto"));
		result.setHsServicio(resultST.getInt("hsServicio"));
		result.setNombre(resultST.getString("nombre"));
		result.setNombreong(resultST.getString("nombreong"));
		result.setEmail(resultST.getString("email"));
		lst.add(result);
		}
				
		return lst;
		}
	
	public int InsertUpdateRptData(Catastrofe c, RptType plastType){
		int incres=0;
		try
		{
			Rptdata data = _eManager.find(Rptdata.class, c.getIdCatastrofe());
			
			if(data == null || data.getIdTenant() <= 0){
				data = new Rptdata();
				data.setConeccion(c.getStringConeccion());
				data.setIdTenant(c.getIdCatastrofe());
				data.setDesaparecidos(0);
				data.setOngs(0);
				data.setPedidos(0);
				data.setUsuarios(0);
			}
			
			switch (plastType) {
			case Donacion:
				incres = data.getOngs()+1;
				data.setOngs(incres);
				break;
			case Desaparecido:
				incres = data.getDesaparecidos()+1;
				data.setDesaparecidos(incres);
				break;
			case Usuario:
				incres = data.getUsuarios()+1;
				data.setUsuarios(incres);
				break;
			case Ayuda:
				incres = data.getPedidos()+1;
				data.setPedidos(incres);
				break;
			default:
				incres = -1;
				break;
			}
			
			_eManager.getTransaction().begin();
		    _eManager.persist(data);
			_eManager.getTransaction().commit();
			_eManager.close();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally{
			if(_eManager.isOpen())
				_eManager.close();
		}
		
		return incres;
	}

}


