package com.Entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Usuarios database table.
 * 
 */
@Entity
@Table(name="Usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idUsuarios;

	@Column(name="Apellido")
	private String apellido;

	@Column(name="Borrado")
	private byte borrado;

	@Column(name="Celular")
	private String celular;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Creacion")
	private Date creacion;

	@Column(name="Direccion")
	private String direccion;

	@Column(name="Email")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="Nacimiento")
	private Date nacimiento;

	@Column(name="Nick")
	private String nick;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Password")
	private String password;

	@Column(name="Sexo")
	private String sexo;

	@Column(name="TipoUsuario")
	private int tipoUsuario;

	public Usuario() {
	}

	public int getIdUsuarios() {
		return this.idUsuarios;
	}

	public void setIdUsuarios(int idUsuarios) {
		this.idUsuarios = idUsuarios;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public byte getBorrado() {
		return this.borrado;
	}

	public void setBorrado(byte borrado) {
		this.borrado = borrado;
	}

	public String getCelular() {
		return this.celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getCreacion() {
		return this.creacion;
	}

	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}