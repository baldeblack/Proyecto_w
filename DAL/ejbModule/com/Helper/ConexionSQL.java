package com.Helper;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQL {
	
	private static ConexionSQL conexion;
	private static String url;
	private static String username;
	private static String pass;
	private static Connection psqlCon;
	
	public ConexionSQL(String tenatName){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			url = "jdbc:mysql://localhost:3306/" + tenatName;
			username = "root";
			pass = "123456";
			psqlCon = DriverManager.getConnection(url,username,pass);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}

	public static void setUrl(String myUrl) {
		url = myUrl;
	}

	public static void setUsername(String myUser) {
		username = myUser;
	}

	public static void setPassword(String myPass) {
		pass = myPass;
	}

	public static ConexionSQL getConexion(String tenatName) {
		if (conexion == null)
			conexion = new ConexionSQL(tenatName);
		return conexion;
	}

	public static Connection getConnection(String tenatName) {
		if (conexion == null)
			conexion = new ConexionSQL(tenatName);
		return psqlCon;
	}
	
	public void cerrarConexion(){
		try {
			if (!psqlCon.isClosed()){
				psqlCon.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}