package com.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.sun.jmx.snmp.Timestamp;

public class Donacione {
	
	private int idDonaciones;
	private int cantidad;
	private Date comienzoServico;
	private String descripcion;
	private Date fechaEntrega;
	private Date FInalizacionServicio;
	private int hsServicio;
	private int idTipoDonacion;
	private String moneda;
	private BigDecimal monto;
	private ONG ong;
	private Usuario usuario;

	public Donacione() {
	}

	public int getIdDonaciones() {
		return this.idDonaciones;
	}

	public void setIdDonaciones(int idDonaciones) {
		this.idDonaciones = idDonaciones;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getComienzoServico() {
		return this.comienzoServico;
	}

	public void setComienzoServico(Date comienzoServico) {
		this.comienzoServico = comienzoServico;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public Date getFInalizacionServicio() {
		return this.FInalizacionServicio;
	}

	public void setFInalizacionServicio(Date FInalizacionServicio) {
		this.FInalizacionServicio = FInalizacionServicio;
	}

	public int getHsServicio() {
		return this.hsServicio;
	}

	public void setHsServicio(int hsServicio) {
		this.hsServicio = hsServicio;
	}

	public int getIdTipoDonacion() {
		return this.idTipoDonacion;
	}

	public void setIdTipoDonacion(int idTipoDonacion) {
		this.idTipoDonacion = idTipoDonacion;
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

	public ONG getOng() {
		return this.ong;
	}

	public void setOng(ONG ong) {
		this.ong = ong;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
