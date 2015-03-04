package com.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TenantDAO {
		
	public void CrearTenantTables(String tenantName) throws SQLException, ClassNotFoundException{
		
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/" + tenantName;
				String username = "root";
				String pass = "123456";
				Connection con = DriverManager.getConnection(url,username,pass);
				
				String usuariosTable = "Usuarios"; 
				String ayudTable = "Ayuda"; 
				String desaparecidosTable = "Desaparecidos"; 
				String ONGsTable = "ONGs"; 
				String tipoDonacionTable = "TipoDonacion"; 
				String donacionesTable = "Donaciones"; 
					
				//Connection con = ConexionSQL.getConnection("tenantName");
				con.setAutoCommit(false);
						Statement st = null;		
						st = con.createStatement();					
						
						String sql =  "CREATE TABLE usuarios " +
						"(idUsuarios int(11) NOT NULL AUTO_INCREMENT, " +
						"Nombre varchar(50) NOT NULL, " +
						"Apellido varchar(50) NOT NULL, " +
						"Nik varchar(50) DEFAULT NULL, " +
						"Email varchar(100) NOT NULL, " +
						"Password varchar(100) NOT NULL, " +
						"FechaNacimiento date DEFAULT NULL, " +
						"Sexo char(1) NOT NULL, " +
						"Celular varchar(50) DEFAULT NULL, " +
						"Direccion varchar(200)DEFAULT NULL, " +
						"FECHA timestamp NULL DEFAULT CURRENT_TIMESTAMP, " +
						"PRIMARY KEY (idUsuarios))";
						st.execute(sql);			
						st.execute("LOCK TABLES "+usuariosTable+" WRITE");
						st.execute("UNLOCK TABLES");							
						sql ="CREATE TABLE ayuda " +
						"(idAyuda int(11) NOT NULL AUTO_INCREMENT, " +
						"TipoSolicitor int(11) NOT NULL, " +
						"IdSolicitor int(11) DEFAULT NULL, " +
						"Canal smallint(6) DEFAULT NULL, " +
						"Mensaje longtext NOT NULL, " +
						"Ubicacion varchar(500) NOT NULL, " +
						"Telefono varchar(45) NOT NULL, " +
						"UbicacionLatLong varchar(300) DEFAULT NULL, " +
						"Fecha timestamp NULL DEFAULT CURRENT_TIMESTAMP, " +
						"PRIMARY KEY (idAyuda), " +
						"KEY fk_Ayuda_Solicitor_idx (IdSolicitor), " +
						"CONSTRAINT fk_Ayuda_Solicitor FOREIGN KEY (IdSolicitor) REFERENCES Usuarios (idUsuarios) ON DELETE NO ACTION ON UPDATE NO ACTION)";
						st.execute(sql);
						st.execute("LOCK TABLES "+ ayudTable +" WRITE");				
					    st.execute("UNLOCK TABLES");
						sql = "CREATE TABLE desaparecidos " + 
						"(idDesaparecidos int(11) NOT NULL AUTO_INCREMENT, " +
						"Nombre varchar(100) NOT NULL, " +
						"Apellido varchar(100) NOT NULL, " +
						"Edad int(11) DEFAULT NULL, " +
						"Sexo char(1) NOT NULL, " +
						"FechaDesaparicion datetime NOT NULL, " +
						"UltimoParadero varchar(300) NOT NULL, " +
						"EstadoBusqueda smallint(6) NOT NULL, " +
						"NombreContacto varchar(100) NOT NULL, " +
						"TelefonoContacto varchar(100) NOT NULL, " +
						"RelacionContacto int(11) DEFAULT NULL, " +
						"IdUsuarioReportado int(11) DEFAULT NULL, " +
						"TIpoUsuioReportado int(11) DEFAULT NULL,  " +
						"Foto blob, " +
						"Fecha timestamp NULL DEFAULT CURRENT_TIMESTAMP, " +
						"PRIMARY KEY (idDesaparecidos))";				
						st.execute(sql);
						st.execute("LOCK TABLES " + desaparecidosTable + " WRITE");				
					    st.execute("UNLOCK TABLES");
						sql = "CREATE TABLE ongs " +
						"(idONGs int(11) NOT NULL, " +
						"Nombre varchar(100) DEFAULT NULL, " +
						"Direccion varchar(200) DEFAULT NULL, " +
						"Telefono varchar(50) DEFAULT NULL, " +
						"Email varchar(100) DEFAULT NULL, " +
						"Web varchar(50) DEFAULT NULL, " +
						"Origen varchar(200) DEFAULT NULL, " +
						"DatosPayPal longtext, " +
						"PRIMARY KEY (idONGs))";
						st.execute(sql);
						st.execute("LOCK TABLES " + ONGsTable + " WRITE");				
					    st.execute("UNLOCK TABLES");
						sql = "CREATE TABLE TipoDonacion " +
						"(idTipoDonacion int(11) NOT NULL, " +
						"Nombre varchar(50) NOT NULL, " +
						"Descripcion varchar(500) DEFAULT NULL, " +
						"PRIMARY KEY (idTipoDonacion))";
						st.execute(sql);
						st.execute("LOCK TABLES " + tipoDonacionTable + " WRITE");				
						st.execute("UNLOCK TABLES");
						sql = "CREATE TABLE donaciones " +
						"(idDonaciones int(11) NOT NULL AUTO_INCREMENT, " +
						"IdDonante int(11) NOT NULL, " +
						"IdOng int(11) NOT NULL, " +
						"IdTipoDonacion int(11) NOT NULL, " +
						"Cantidad int(11) DEFAULT NULL, " +
						"Moneda varchar(20) DEFAULT NULL, " +
						"Monto decimal(9,2) DEFAULT NULL, " +
						"FechaEntrega date DEFAULT NULL, " +
						"HsServicio int(11) DEFAULT NULL, " +
						"ComienzoServico date DEFAULT NULL, " +
						"FInalizacionServicio date DEFAULT NULL, " +
						"Fecha timestamp NULL DEFAULT CURRENT_TIMESTAMP, " +
						"Descripcion varchar(300) DEFAULT NULL, " +
						"PRIMARY KEY (idDonaciones), " +
						"KEY fk_Donaciones_Ong_idx (IdOng), " +
						"KEY fk_Donaciones_Tipo_idx (IdTipoDonacion), " +
						"KEY fk_Donaciones_Usuario_idx (IdDonante), " +
						"CONSTRAINT fk_Donaciones_Ong FOREIGN KEY (IdOng) REFERENCES ONGs (idONGs) ON DELETE NO ACTION ON UPDATE NO ACTION, " +
						"CONSTRAINT fk_Donaciones_Usuario FOREIGN KEY (IdDonante) REFERENCES Usuarios (idUsuarios) ON DELETE NO ACTION ON UPDATE NO ACTION)"; 					
						st.execute(sql);
						st.execute("LOCK TABLES " + donacionesTable + " WRITE");				
					    st.execute("UNLOCK TABLES");
					    
					    st.close();
					    con.commit();				 
					    con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw e;
			}
			
	}
	
	public void CrearTenantDB(String tenantName) throws SQLException, ClassNotFoundException{
	    try {			
	    	Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/ShareDB";
			String username = "root";
			String pass = "123456";
			Connection conShare = DriverManager.getConnection(url,username,pass);		
			conShare.setAutoCommit(false);
			CallableStatement callableStatement = conShare.prepareCall("{call altaSitio(?)}");
	        callableStatement.setString(1, tenantName);
	        callableStatement.executeQuery();
			conShare.commit();	
			conShare.close();
	    } catch (SQLException e) {
	    	e.printStackTrace();
	    	throw e;
		}  
	 
	}
}
