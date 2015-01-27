package com.TenantControllers;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.Controllers.CCatastrofe;
import com.Controllers.CUsuarios;
import com.DAO.DesaparecidosDAO;
import com.Entities.Catastrofe;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICUsuarios;
import com.TenantInterfaces.ICDesaparecidos;
import com.TenantInterfaces.ICUsuario;
import com.Utilities.MailingHelper;
import com.entities.Desaparecido;
import com.entities.Usuario;
import com.google.gson.Gson;


public class CDesaparecidos implements ICDesaparecidos {
	Gson _gson;
	DesaparecidosDAO _dao;
	String _connection;
	public CDesaparecidos(String connection){
		_dao = new DesaparecidosDAO(connection);
		_gson= new Gson();
		_connection = connection;
	}

	@Override
	public String GetAllDesaparecidos() {
		return _gson.toJson(_dao.getAllDesaparecidos(), List.class);
	}

	@Override
	public String GetDesaparecidosByState(short state) {
		return _gson.toJson(_dao.getAllDesaparecidosByState(state), List.class);
	}

	@Override
	public String GetDesaparecidosById(int id) {
		return _gson.toJson(_dao.getDesaparecidoById(id), Desaparecido.class);
	}

	@Override
	public int InsertUpdateDesaparecido(String input) {
		input = input.replace('+',  ' ');
		Desaparecido des = _gson.fromJson(input, Desaparecido.class);
		int idDesa = _dao.InsertUpdateDesaparecido(des);
		
		if(idDesa >0)
			SendMailALtaDesaparecido(des);

		return idDesa;
	}

	@Override
	public void ChangeStateDesaparecido(int id, short state) {
		 _dao.ChangeStateDesaparecido(id, state);
	}

	private void SendMailALtaDesaparecido(Desaparecido des){
		MailingHelper mh= new MailingHelper();
		
		ICCatastrofe c = new CCatastrofe();
		Catastrofe cat =  c.getCatastrofeByStringConnection(_connection);
		Usuario usFE = null;
		com.Entities.Usuario usBO = null;
		
		if(des.getTIpoUsuioReportado() == 1)/*BO*/{
			ICUsuarios CusBO = new CUsuarios();
			usBO = CusBO.getUsuById(des.getIdUsuarioReportado());
		}
		else{
			ICUsuario CusFE = new CUsuario(_connection);
			usFE =_gson.fromJson(CusFE.getUsuarioById(des.getIdUsuarioReportado()), Usuario.class);
		}
		
		SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(false);
		
		String body=String.format("Se ah reportado un nuevo desaparecido en %s <br/>"+
				"Notificado por un usuario del %s <br/>"+
				"Datos del desaparecido <br/><br/>"+
				"<img alt='Desaparecido-%s' src='data:image/jpeg;base64,%s'> <br/>"+
				"Nombre: %s <br/> Edad: %s </br> Sexo: %s <br/> Fecha Desaparici�n: %s <br/> Ultimo Paradero: %s </br>"+
				"Datos del contacto <br/>"+
				"Nombre: %s <br/> Tel�fono: %s <br/> Relaci�n con el desaparecido: %s",
				usFE!=null ?"Del Front End "+ usFE.getNombre()+" "+ usFE.getApellido():"Del BackOffice "+usBO.getNombre()+" "+usBO.getApellido(),
				des.getIdDesaparecidos(), des.getFoto().toString(), des.getNombre()+" "+des.getApellido(), df.format(des.getEdad()), des.getSexo()=="F"?"Femenino":"Masculino",
				SDF.format(des.getFechaDesaparicion()), des.getUltimoParadero(), des.getNombreContacto() +" "+des.getApellido(),
				des.getTelefonoContacto(), des.getRelacionContacto()==1?"Padre/Madre":des.getRelacionContacto()==2?"Hermano/a":des.getRelacionContacto()==3?"Pareja":"Otros");
		
		List<String> to = new ArrayList<String>();
		to.add("sic.grupo5@gmail.com");
		
		mh.SendHtmlEmail(cat.getDominio()+"@SIC.com", to, "Alta Desapareido: "+cat.getNombre() , body);
		
		
	}
	
}
