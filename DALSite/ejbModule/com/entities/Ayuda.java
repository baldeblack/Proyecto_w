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

	private String telefono;

	private int tipoSolicitor;

	private String ubicacion;

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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
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

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}