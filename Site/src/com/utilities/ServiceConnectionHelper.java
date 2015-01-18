package com.utilities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import com.google.gson.Gson;

public class ServiceConnectionHelper {

	private static final String URL_SERVER = "http://localhost/ServiceLayer/rest/";
	
	ServiceConnectionHelper(){
	}
	
	public static<T> String CallServiceMethoodGET(String serviceName, String methoodName, String bdConnection){
		return CallServiceMethood("GET", serviceName, methoodName, bdConnection, null, null);
	}
	
	public static<T> String CallServiceMethoodPOST(String serviceName, String methoodName, String bdConnection, T entity){
		return CallServiceMethood("POST", serviceName, methoodName, bdConnection, entity, null);
	}
	
	public static<T> String CallServiceMethoodGET(String serviceName, String methoodName, String bdConnection, T entity){
		return CallServiceMethood("GET", serviceName, methoodName, bdConnection, entity, null);
	}
	
	public static<T> String CallServiceMethoodPOST(String serviceName, String methoodName, String bdConnection, List<String> extendedData){
		return CallServiceMethood("POST", serviceName, methoodName, bdConnection, null, extendedData);
	}
	
	public static<T> String CallServiceMethoodGET(String serviceName, String methoodName, String bdConnection, List<String> extendedData){
		return CallServiceMethood("GET", serviceName, methoodName, bdConnection, null, extendedData);
	}
	
	public static<T> String CallServiceMethoodPOST(String serviceName, String methoodName, String bdConnection, T entity, List<String> extendedData){
		return CallServiceMethood("POST", serviceName, methoodName, bdConnection, entity, extendedData);
	}
	
	public static<T> String CallServiceMethoodGET(String serviceName, String methoodName, String bdConnection, T entity, List<String> extendedData){
		return CallServiceMethood("GET", serviceName, methoodName, bdConnection, entity, extendedData);
	}
	
	

	private static<T> String CallServiceMethood(String typeS, String serviceName, String methoodName, String bdConnection, T entity, List<String> extendedData){
		
		String uri = URL_SERVER +serviceName+"/"+methoodName;
		HttpURLConnection connection=null;
		Gson gson = new Gson();
		try 
		{
			if(entity != null || bdConnection != "" || extendedData != null){
				MessageInput<T> input = new MessageInput<T>(entity, bdConnection, extendedData);
				String param = gson.toJson(input);
				uri+="/"+ URLEncoder.encode(param, "UTF-8");
			}
			URL url = new URL(uri);
			
		    connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(typeS);
			connection.setRequestProperty("Accept", "application/json");
			
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ connection.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));
			
			String output;
			String msj = "";
			while ((output = br.readLine()) != null) {
				msj +=output;
			}
			
			return msj;
			
		} catch (MalformedURLException e) {
			 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		finally{
			if(connection!=null)
				connection.disconnect();
		}
		return "";
	}
	
	public static String CallServiceMethood(String serviceName, String methoodName, List<String> parameters){
		
		String uri = URL_SERVER +serviceName+"/"+methoodName;
		HttpURLConnection connection=null;
		
		if(parameters!= null){
			for (String param : parameters) {
				uri+="/"+param;
			}
		}
		
		try {
			URL url = new URL(uri);
			
		    connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
			
			if (connection.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ connection.getResponseCode());
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));
			
			String output;
			String msj = "";
			while ((output = br.readLine()) != null) {
				msj +=output;
			}
			
			return msj;
			
		} catch (MalformedURLException e) {
			 
			e.printStackTrace();
	 
		  } catch (IOException e) {
	 
			e.printStackTrace();
	 
		  }
		finally{
			if(connection!=null)
				connection.disconnect();
		}
		return "";
	}
}
