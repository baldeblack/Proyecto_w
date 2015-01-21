package com.models;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DonarModel {
	
	private int cantidad;
	private String comienzoServico;
	private String fechaEntrega;
	private String FInalizacionServicio;
	private int hsServicio;
	private String moneda;
	private BigDecimal monto;
	private int ong;
	private int tipoDonacion;
	private String descripcion;
	
	public DonarModel() {
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getComienzoServico() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(this.comienzoServico);
		return date;
	}

	public void setComienzoServico(Date comienzoServico) {
		 SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		 this.comienzoServico =  SDF.format(comienzoServico);
	}

	public Date getFechaEntrega() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(this.fechaEntrega);
		return date;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		 this.fechaEntrega =  SDF.format(fechaEntrega);
	}

	public Date getFInalizacionServicio() throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(this.FInalizacionServicio);
		return date;
	}

	public void setFInalizacionServicio(Date FInalizacionServicio) {
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
		 this.FInalizacionServicio =  SDF.format(FInalizacionServicio);
	}

	public int getHsServicio() {
		return this.hsServicio;
	}

	public void setHsServicio(int hsServicio) {
		this.hsServicio = hsServicio;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public int getOng() {
		return this.ong;
	}

	public void setOng(int ong) {
		this.ong = ong;
	}

	public int getTipoDonacion() {
		return this.tipoDonacion;
	}

	public void setTipoDonacion(int tipoDonacion) {
		this.tipoDonacion = tipoDonacion;
	}
	
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}

}
