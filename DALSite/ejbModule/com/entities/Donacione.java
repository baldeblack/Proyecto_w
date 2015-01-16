package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


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

	private int comienzoServico;

	@Temporal(TemporalType.DATE)
	private Date fechaEntrega;

	private int FInalizacionServicio;

	private int hsServicio;

	private String moneda;

	private BigDecimal monto;

	//bi-directional many-to-one association to Ong
	@ManyToOne
	@JoinColumn(name="IdOng")
	private Ong ong;

	//bi-directional many-to-one association to Tipodonacion
	@ManyToOne
	@JoinColumn(name="IdTipoDonacion")
	private Tipodonacion tipodonacion;

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

	public Ong getOng() {
		return this.ong;
	}

	public void setOng(Ong ong) {
		this.ong = ong;
	}

	public Tipodonacion getTipodonacion() {
		return this.tipodonacion;
	}

	public void setTipodonacion(Tipodonacion tipodonacion) {
		this.tipodonacion = tipodonacion;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}