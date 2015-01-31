package com.Helper;

import java.math.BigDecimal;

public class donacionesRpt {	
	int IdTipoDonacion; 
    int Cantidad;
    String Moneda; 
    BigDecimal Monto;
    int HsServicio; 
	String Nombre; 
	String Apellido;
	String Nombreong; 
	String Email;
	
	public int getIdTipoDonacion() {
		return IdTipoDonacion;
	}
	public void setIdTipoDonacion(int idTipoDonacion) {
		IdTipoDonacion = idTipoDonacion;
	}
	public int getCantidad() {
		return Cantidad;
	}
	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}
	public String getMoneda() {
		return Moneda;
	}
	public void setMoneda(String moneda) {
		Moneda = moneda;
	}
	public BigDecimal getMonto() {
		return Monto;
	}
	public void setMonto(BigDecimal monto) {
		Monto = monto;
	}
	public int getHsServicio() {
		return HsServicio;
	}
	public void setHsServicio(int hsServicio) {
		HsServicio = hsServicio;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getNombreong() {
		return Nombreong;
	}
	public void setNombreong(String nombreong) {
		Nombreong = nombreong;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
}
