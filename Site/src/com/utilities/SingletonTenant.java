package com.utilities;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.picketbox.commons.cipher.Base64;

import com.entities.Catastrofe;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SingletonTenant {

	private static SingletonTenant _instance;
	private static  Map<String, Catastrofe> _mapSites;
	
	private SingletonTenant(String domain){ 
		_mapSites = new HashMap<String, Catastrofe>();
		LoadData(domain);
	}
	
	public static SingletonTenant getInstance(String newDomain, String currentDomain) {
		
		if(_instance == null){
			_instance = new SingletonTenant(newDomain);
		}
		else if(newDomain != currentDomain){
			LoadData(newDomain);
		}
		
	    return _instance;
	}
	
	private static Catastrofe _site;
	public Catastrofe getSite(){
		return _site;
	}
	
	private static void LoadData(String domain){
		
		if(!_mapSites.containsKey(domain))
		{
			Gson gson = new Gson();
			
			String jsonString = CallService(domain);

			Type listType = new TypeToken<List<Catastrofe>>() {}.getType();
			List<Catastrofe> listCatastrofe = gson.fromJson(jsonString, listType);
			
			if(listCatastrofe != null){
				for (Catastrofe obj : listCatastrofe) {
					
					if(!_mapSites.containsKey(obj.getDominio())){
						obj.setlistOfImages(LoadImages(obj.getCarpetaImagenes()));
						obj.setZonaAfectada(obj.getZonaAfectada().replace('"', '\''));
						_mapSites.put(obj.getDominio(), obj);
					}
				}
			}
		}
		
		LoadDefaultSite();
		
		_site = _mapSites.get(domain);
	}
	
	private static void LoadDefaultSite()
	{
		Catastrofe c = new Catastrofe();
		c.setDominio("localhost");
		c.setIdCatastrofe(0);
		c.setNombre("Local test");
		c.setInformacion("Sitio no valido -> no asignado a ninguna catastrofe...");
		c.setCarpetaImagenes("C:\\wildfly-8.0.0.Final\\standalone\\deployments\\BackOffice.war\\WEB-INF\\imagenesT\\CT20150110054132");
		c.setlistOfImages(LoadImages(c.getCarpetaImagenes()));
		_mapSites.put(c.getDominio(), c);
	}
	
	private static String CallService(String domain) {		
		 
		String jsnResult ="";
		jsnResult = ServiceConnectionHelper.CallServiceMethood("AccessService", "AllCatastrofes", null);
		/*
		 * TODO:: por ahora no anda el CatastrofeByDomain asi que siempre traigo todo. corregir mas adelante el servicio
		if(_mapSites.isEmpty())
			jsnResult = ServiceConnectionHelper.CallServiceMethood("AccessService", "AllCatastrofes", null);
		else{
			List<String> params = Arrays.asList(domain);
			jsnResult = ServiceConnectionHelper.CallServiceMethood("AccessService", "CatastrofeByDomain", params);
		}
		*/
			
		return jsnResult;
	}
	
	private static List<String> LoadImages(String folder){
		try {
			
		if(folder !=null){
		
			File dir = new File(folder);
		
		 File[] files = dir.listFiles();

	        List<String> filPaths = new ArrayList<String>();
	        
	        if(files != null)
		        for (File file : files) {
		        	
						FileInputStream fis=new FileInputStream(file);
						ByteArrayOutputStream bos=new ByteArrayOutputStream();
						int b;
						byte[] buffer = new byte[1024];
						
						while((b=fis.read(buffer))!=-1){
						   bos.write(buffer,0,b);
						}
						
						byte[] fileBytes=bos.toByteArray();
						fis.close();
						bos.close();
						
						String encodedString= Base64.encodeBytes(fileBytes);
						//String encodedString = new String(encoded);
					
		            filPaths.add(encodedString);
		        }
	        return filPaths;
	         
		}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
