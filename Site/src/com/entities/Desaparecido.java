package com.entities;
import java.util.Date;

public class Desaparecido {
		private int idDesaparecidos;
		private String apellido;
		private int edad;
		private short estadoBusqueda;
		private Date fechaDesaparicion;
		private Integer idUsuarioReportado;
		private String nombre;
		private String nombreContacto;
		private int relacionContacto;
		private String sexo;
		private String telefonoContacto;
		private int TIpoUsuioReportado;
		private String ultimoParadero;
		private String ultimoParaderoLatLong;
		private byte[] foto;
		
		public Desaparecido() {
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

		public Integer getIdUsuarioReportado() {
			return this.idUsuarioReportado;
		}

		public void setIdUsuarioReportado(Integer idUsuarioReportado) {
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

		public String getUltimoParaderoLatLong() {
			return this.ultimoParaderoLatLong;
		}

		public void setUltimoParaderoLatLong(String ultimoParaderoLatLong) {
			this.ultimoParaderoLatLong = ultimoParaderoLatLong;
		}
		
		public byte[] getFoto() {
			return this.foto;
		}

		public void setFoto(byte[] foto) {
			this.foto = foto;
		}
}
