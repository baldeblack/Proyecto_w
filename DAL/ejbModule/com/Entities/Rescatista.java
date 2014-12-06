package com.Entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Rescatista database table.
 * 
 */
@Entity
@NamedQuery(name="Rescatista.findAll", query="SELECT r FROM Rescatista r")
public class Rescatista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idRescatista;

	@Column(name="IdTipoRescatista")
	private int idTipoRescatista;

	@Column(name="LatLongRecidencia")
	private String latLongRecidencia;

	@Column(name="Residencia")
	private String residencia;

	//bi-directional one-to-one association to TipoRescatista
	@OneToOne
	@JoinColumn(name="idRescatista")
	private TipoRescatista tipoRescatista;

	//uni-directional many-to-one association to Usuario
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="IdUsuarios")
	private Usuario usuario;

	public Rescatista() {
	}

	public int getIdRescatista() {
		return this.idRescatista;
	}

	public void setIdRescatista(int idRescatista) {
		this.idRescatista = idRescatista;
	}

	public int getIdTipoRescatista() {
		return this.idTipoRescatista;
	}

	public void setIdTipoRescatista(int idTipoRescatista) {
		this.idTipoRescatista = idTipoRescatista;
	}

	public String getLatLongRecidencia() {
		return this.latLongRecidencia;
	}

	public void setLatLongRecidencia(String latLongRecidencia) {
		this.latLongRecidencia = latLongRecidencia;
	}

	public String getResidencia() {
		return this.residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public TipoRescatista getTipoRescatista() {
		return this.tipoRescatista;
	}

	public void setTipoRescatista(TipoRescatista tipoRescatista) {
		this.tipoRescatista = tipoRescatista;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}