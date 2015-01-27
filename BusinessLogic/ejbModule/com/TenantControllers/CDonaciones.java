package com.TenantControllers;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.Controllers.CCatastrofe;
import com.DAO.DonacionDAO;
import com.Entities.Catastrofe;
import com.Interfaces.ICCatastrofe;
import com.TenantInterfaces.ICDonaciones;
import com.TenantInterfaces.ICOng;
import com.TenantInterfaces.ICUsuario;
import com.Utilities.MailingHelper;
import com.entities.Donacione;
import com.entities.Ong;
import com.entities.Usuario;
import com.google.gson.Gson;

public class CDonaciones implements ICDonaciones {

	DonacionDAO _dao;
	Gson _gson;
	String _connection;
	public CDonaciones (String connection){
		_dao = new DonacionDAO(connection);
		_connection=connection;
		_gson = new Gson();
	}
	
	@Override
	public int InsertUpdateDonacion(String input) {
		input = input.replace('+', ' ');
		Donacione d =_gson.fromJson(input, Donacione.class);
		int idDon = _dao.InsertUpdateDonacion(d);
		
		if(idDon>0)
			SendNotificacionDonacion(d);
		return idDon;
	}
	
	private void SendNotificacionDonacion(Donacione don){
		MailingHelper mh= new MailingHelper();
		
		ICCatastrofe c = new CCatastrofe();
		Catastrofe cat =  c.getCatastrofeByStringConnection(_connection);
		
		ICUsuario Cus = new CUsuario(_connection);
		Usuario us =_gson.fromJson(Cus.getUsuarioById(don.getUsuario().getIdUsuarios()), Usuario.class);
		
		ICOng cOng = new COng(_connection);
		Ong o = cOng.getONGbyId(don.getOng().getIdONGs());
		
		SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(false);

		String body = String.format("Se ah hecho una donación para %s <br/>"
				+ " La donacion es de: %s <br/> el donante es: %s <br/> pongase en contacto al: %s <br/>",
				cat.getNombre(), 
				don.getIdTipoDonacion()==1?"Económica":don.getIdTipoDonacion()==2?"De bienes":"De servicio",
				us.getNombre() +" "+us.getApellido(), 
				us.getEmail()+" - "+us.getCelular());
				
		if(don.getIdTipoDonacion()==1){
			body+=String.format("<br/> Mas Detalles: %s <br/> Moneda: %s <br/> Monto: %s",don.getDescripcion(), don.getMoneda(), df.format(don.getMonto()));
		}
		else if(don.getIdTipoDonacion()==2){
			body+=String.format("<br/> Mas Detalles: %s <br/> Cantidad: %s <br/> Fecha Entrega: %s ",don.getDescripcion(), df.format(don.getCantidad()), SDF.format(don.getFechaEntrega()));
		}
		else{
			body+=String.format("<br/> Mas Detalles: %s <br/> Hs Servicio: %s <br/> Comienzo: %s <br/> Finalizacion: %s",don.getDescripcion(), df.format(don.getHsServicio()),SDF.format( don.getComienzoServico()), SDF.format(don.getFInalizacionServicio()));
		}
		
		List<String> to = new ArrayList<String>();
		to.add("sic.grupo5@gmail.com");
		to.add(o.getEmail());
		 
		mh.SendHtmlEmail(cat.getDominio()+"@SIC.com", to, "Donación Catastrofe: "+cat.getNombre() , body);
	}

}
