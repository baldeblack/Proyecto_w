package com.TenantControllers;

import java.util.ArrayList;
import java.util.List;

import com.Controllers.CCatastrofe;
import com.DAO.AyudaDAO;
import com.Entities.Catastrofe;
import com.Interfaces.ICCatastrofe;
import com.TenantInterfaces.ICAyuda;
import com.Utilities.MailingHelper;
import com.entities.Ayuda;
import com.google.gson.Gson;

public class CAyuda implements ICAyuda {

	Gson _gson;
	AyudaDAO _dao;
	private String _connection;
	
	public CAyuda(String connection){
		_dao = new AyudaDAO(connection);
		_connection = connection;
		_gson= new Gson();
	}
	
	@Override
	public String getAyudabyId(int id) {
		return _gson.toJson(_dao.getAyudabyId(id));
	}

	@Override
	public String getAll() {
		return _gson.toJson(_dao.getAll());
	}

	@Override
	public int InsertUpdateAyuda(String input) {
		input = input.replace('+',  ' ');
		Ayuda help = _gson.fromJson(input, Ayuda.class);
		int id = _dao.InsertUpdateAyuda(help);
	
		if(id>0){
			SendHelpEmail(help);
		}
		return id;
	}
	
	private void SendHelpEmail(Ayuda help){
		MailingHelper mh= new MailingHelper();
		
		ICCatastrofe c = new CCatastrofe();
		Catastrofe cat =  c.getCatastrofeByStringConnection(_connection);
		
		String body = String.format("Pedido de ayuda desde %s <br/>"
				+ " el pedido es %s <br/> telefono $s <br/> Ubicación %s <br/>"
				+ " mensaje %s", cat.getNombre(), 
				help.getTipoSolicitor()==1?"Anonimo":help.getTipoSolicitor()==2?help.getUsuario().getNombre() +" "+help.getUsuario().getApellido():"Para alguien mas de parte de "+ help.getUsuario().getNombre() +" "+help.getUsuario().getApellido(),
				help.getTelefono(), help.getUbicacion(), help.getMensaje());
		
		List<String> to = new ArrayList<String>();
		to.add("sic.grupo5@gmail.com");
		 
		mh.SendHtmlEmail(cat.getDominio()+"@SIC.com", to, "AYUDA Catastrofe: "+cat.getNombre() , body);
	}
}
