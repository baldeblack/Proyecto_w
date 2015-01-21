package com.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.math.BigDecimal;


/**
 * The persistent class for the donaciones database table.
 * 
 */
@Entity
@Table(name="donaciones")
@NamedQuery(name="Donacione.findAll", query="SELECT d FROM Donacione d")
public class Donacione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDonaciones;

	private int cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date comienzoServico;

	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaEntrega;

	@Temporal(TemporalType.TIMESTAMP)
	private Date FInalizacionServicio;

	private int hsServicio;

	private int idTipoDonacion;

	private String moneda;

	private BigDecimal monto;

	//bi-directional many-to-one association to Ong
	@ManyToOne
	@JoinColumn(name="IdOng")
	private Ong ong;

	//uni-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="IdDonante")
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

	public Ong getOng() {
		return this.ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}