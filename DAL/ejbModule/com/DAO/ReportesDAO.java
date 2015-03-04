package com.DAO;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.Entities.Catastrofe;
import com.Entities.Rptdata;
import com.Helper.EntityManagerHelper;
import com.Helper.RptType;
import com.Helper.ayudaRpt;
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
			if(resultST.getString("moneda") != null){
				result.setMoneda(resultST.getString("moneda"));
			}else{
				result.setMoneda("");
			}
			
			if(resultST.getString("apellido") != null){
				result.setApellido(resultST.getString("apellido"));
			}else{
				result.setNombre("");
			}
		
		result.setCantidad(resultST.getInt("cantidad"));
		
		if(resultST.getBigDecimal("monto") != null){
			result.setMonto(resultST.getBigDecimal("monto"));			
		}else{
			BigDecimal f = new BigDecimal(0);
			result.setMonto(f);
		}
		
		result.setHsServicio(resultST.getInt("hsServicio"));
		
		if(resultST.getString("nombre") != null){
			result.setNombre(resultST.getString("nombre"));
		}else{
			result.setNombre(resultST.getString(""));
		}
		
		if(resultST.getString("nombreong") != null){
			result.setNombreong(resultST.getString("nombreong"));
		}else{
			result.setNombreong(resultST.getString(""));
		}
	
		if(resultST.getString("email") != null){
			result.setEmail(resultST.getString("email"));
		}else{
			result.setEmail(resultST.getString(""));
		}
	
	
		lst.add(result);
		}
				
		return lst;
		}
	
	public List<ayudaRpt> getRptAyuda(int idTenant, Date start, Date end) throws SQLException, ClassNotFoundException{
		List<ayudaRpt> lst = new ArrayList<ayudaRpt>();
		ayudaRpt result = null;
		CatastrofeDAO cd = new CatastrofeDAO();
		Catastrofe c = cd.getCatastrofeByID(idTenant);
		Class.forName("com.mysql.jdbc.Driver");
		String url = c.getStringConeccion();
		String username = "root";
		String pass = "123456";
		Connection con = DriverManager.getConnection(url,username,pass);
		Statement statement = con.createStatement();
		String query = "select TipoSolicitor, Canal, Ubicacion, Fecha from ayuda where Fecha >= '" +start+"' and Fecha <= '" +end +"'";
		ResultSet resultST = statement.executeQuery(query);
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd");
		while (resultST.next())
		{
			result = new ayudaRpt();
			
			switch (resultST.getInt("Canal")) {
			case 0:
				result.setCanal("Móvil");
				break;
			case 1:
				result.setCanal("Web");
				break;		
			default:
				result.setCanal("");
				break;
			}
			
			switch (resultST.getInt("TipoSolicitor")) {
			case 1:
				result.setTipoSolicitor("Anonimo");
				break;
			case 2:
				result.setTipoSolicitor("Personal");
				break;
			case 3:
				result.setTipoSolicitor("De Terceros");
				break;
			default:
				result.setTipoSolicitor("");
				break;
			}
	
		result.setUbicacion(resultST.getString("Ubicacion"));
		result.setFecha(SDF.format(resultST.getTimestamp("Fecha").getTime()));
		
		if(result.getCanal() == null){
			result.setCanal("");
		}
		
		if(result.getFecha() == null){
			result.setFecha("");
		}
		
		if(result.getTipoSolicitor() == null){
			result.setTipoSolicitor("");
		}
		
		if(result.getUbicacion() == null){
			result.setUbicacion("");
		}
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


