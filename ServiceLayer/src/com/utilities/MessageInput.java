package com.utilities;

import java.util.List;


public class MessageInput<T> {

	private T _entity;
	private String _bdConnection;
	private List<String> _extendedProperty;
	
	public MessageInput(T entity, String connection, List<String> props){
		_entity = entity;
		_bdConnection = connection;
		_extendedProperty = props;
	}
	
	public T getEntity(){
		return _entity;
	}
	
	public void setEntity(T value){
		_entity = value;
	}
	
	public String getBdConnection(){
		return _bdConnection;
	}
	
	public void setBdConnection(String value){
		_bdConnection = value;
	}
	
	public List<String> getExtendedProperty(){
		return _extendedProperty;
	}
	
	public void setExtendedProperty(List<String> value){
		_extendedProperty = value;
	}
	
}
