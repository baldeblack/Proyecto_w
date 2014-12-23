package com.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ayuda database table.
 * 
 */
@Entity
@NamedQuery(name="Ayuda.findAll", query="SELECT a FROM Ayuda a")
public class Ayuda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAyuda;

	private short canal;

	@Lob
	private String mensaje;

	private int tipoSolicitor;

	private String ubicacion;

	private String ubicacionLatLong;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="IdSolicitor")
	private Usuario usuario;

	public Ayuda() {
	}

	public int getIdAyuda() {
		return this.idAyuda;
	}

	public void setIdAyuda(int idAyuda) {
		this.idAyuda = idAyuda;
	}

	public short getCanal() {
		return this.canal;
	}

	public void setCanal(short canal) {
		this.canal = canal;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public int getTipoSolicitor() {
		return this.tipoSolicitor;
	}

	public void setTipoSolicitor(int tipoSolicitor) {
		this.tipoSolicitor = tipoSolicitor;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getUbicacionLatLong() {
		return this.ubicacionLatLong;
	}

	public void setUbicacionLatLong(String ubicacionLatLong) {
		this.ubicacionLatLong = ubicacionLatLong;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}