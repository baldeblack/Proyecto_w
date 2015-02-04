package com.helper;

import java.util.Date;



import org.picketbox.commons.cipher.Base64;

import com.entities.Desaparecido;

public class DesaparecidoMobile {

	private int idDesaparecidos;

	private String apellido;

	private int edad;

	private short estadoBusqueda;

	private Date fechaDesaparicion;
	
	private String foto;

	private int idUsuarioReportado;

	private String nombre;

	private String nombreContacto;

	private int relacionContacto;

	private String sexo;

	private String telefonoContacto;

	private int TIpoUsuioReportado;

	private String ultimoParadero;

	public DesaparecidoMobile() {
	}
	
	public DesaparecidoMobile(Desaparecido d) {
		
		idDesaparecidos = d.getIdDesaparecidos();
		apellido = d.getApellido();
		edad = d.getEdad();
		estadoBusqueda = d.getEstadoBusqueda();
		fechaDesaparicion = d.getFechaDesaparicion();
		foto = Base64.encodeBytes(d.getFoto());
		idUsuarioReportado = d.getIdUsuarioReportado();
		nombre  = d.getNombre();
		nombreContacto = d.getNombreContacto();
		relacionContacto = d.getRelacionContacto();
		sexo = d.getSexo();
		telefonoContacto = d.getTelefonoContacto();
		TIpoUsuioReportado = d.getTIpoUsuioReportado();
		ultimoParadero = d.getUltimoParadero();
	}

	public int getIdDesaparecidos() {
		return this.idDesaparecidos;
	}

	public void setIdDesaparecidos(int idDesaparecidos) {
		this.idDesaparecidos = idDesaparecidos;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public short getEstadoBusqueda() {
		return this.estadoBusqueda;
	}

	public void setEstadoBusqueda(short estadoBusqueda) {
		this.estadoBusqueda = estadoBusqueda;
	}

	public Date getFechaDesaparicion() {
		return this.fechaDesaparicion;
	}

	public void setFechaDesaparicion(Date fechaDesaparicion) {
		this.fechaDesaparicion = fechaDesaparicion;
	}

	public String getFoto() {
		return this.foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public int getIdUsuarioReportado() {
		return this.idUsuarioReportado;
	}

	public void setIdUsuarioReportado(int idUsuarioReportado) {
		this.idUsuarioReportado = idUsuarioReportado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreContacto() {
		return this.nombreContacto;
	}

	public void setNombreContacto(String nombreContacto) {
		this.nombreContacto = nombreContacto;
	}

	public int getRelacionContacto() {
		return this.relacionContacto;
	}

	public void setRelacionContacto(int relacionContacto) {
		this.relacionContacto = relacionContacto;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefonoContacto() {
		return this.telefonoContacto;
	}

	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;
	}

	public int getTIpoUsuioReportado() {
		return this.TIpoUsuioReportado;
	}

	public void setTIpoUsuioReportado(int TIpoUsuioReportado) {
		this.TIpoUsuioReportado = TIpoUsuioReportado;
	}

	public String getUltimoParadero() {
		return this.ultimoParadero;
	}

	public void setUltimoParadero(String ultimoParadero) {
		this.ultimoParadero = ultimoParadero;
	}
}
