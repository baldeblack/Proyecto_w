package com.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Donacione {
	private int idDonaciones;
	private int cantidad;
	private int comienzoServico;
	private Date fechaEntrega;
	private int FInalizacionServicio;
	private int hsServicio;
	private String moneda;
	private BigDecimal monto;
	private ONG ong;
	private TipoDonacion tipoDonacion;
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

	public int getComienzoServico() {
		return this.comienzoServico;
	}

	public void setComienzoServico(int comienzoServico) {
		this.comienzoServico = comienzoServico;
	}

	public Date getFechaEntrega() {
		return this.fechaEntrega;
	}

	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}

	public int getFInalizacionServicio() {
		return this.FInalizacionServicio;
	}

	public void setFInalizacionServicio(int FInalizacionServicio) {
		this.FInalizacionServicio = FInalizacionServicio;
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

	public ONG getOng() {
		return this.ong;
	}

	public void setOng(ONG ong) {
		this.ong = ong;
	}

	public TipoDonacion getTipoDonacion() {
		return this.tipoDonacion;
	}

	public void setTipoDonacion(TipoDonacion tipoDonacion) {
		this.tipoDonacion = tipoDonacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
