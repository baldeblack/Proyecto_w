package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rptdata database table.
 * 
 */
@Entity
@NamedQuery(name="Rptdata.findAll", query="SELECT r FROM Rptdata r")
public class Rptdata implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTenant;

	private String coneccion;

	private int desaparecidos;

	private int ongs;

	private int pedidos;

	private int usuarios;

	public Rptdata() {
	}

	public int getIdTenant() {
		return this.idTenant;
	}

	public void setIdTenant(int idTenant) {
		this.idTenant = idTenant;
	}

	public String getConeccion() {
		return this.coneccion;
	}

	public void setConeccion(String coneccion) {
		this.coneccion = coneccion;
	}

	public int getDesaparecidos() {
		return this.desaparecidos;
	}

	public void setDesaparecidos(int desaparecidos) {
		this.desaparecidos = desaparecidos;
	}

	public int getOngs() {
		return this.ongs;
	}

	public void setOngs(int ongs) {
		this.ongs = ongs;
	}

	public int getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(int pedidos) {
		this.pedidos = pedidos;
	}

	public int getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(int usuarios) {
		this.usuarios = usuarios;
	}

}