package com.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Controllers.CUsuarios;
import com.Entities.Rescatista;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;
import com.Interfaces.ICUsuarios;
import com.utils.generoUsr;
import com.utils.tipoUsr;

public class UsuariosModel {

	private String apellido;
	private byte borrado;
	private String celular;
	private Date creacion;
	private String direccion;
	private String email;
	private Date nacimiento;
	private String nick;
	private String nombre;
	private String password;
	private String sexo;
	private int tipoUsuario;
	private TipoRescatista tiporescatisa;
	private List<TipoRescatista> tiposrescatistas;
	private String latLongRecidencia;
	private String residencia;
	private List<tipoUsr> tipos;	
	private List<generoUsr> generos;
	
	String action;
	
	public UsuariosModel (Usuario u) throws ClassNotFoundException, SQLException{
		this.apellido = u.getApellido();
		this.borrado = u.getBorrado();
		this.celular = u.getCelular();
		this.creacion = u.getCreacion();
		this.direccion = u.getDireccion();
		this.email = u.getEmail();
		this.nacimiento = u.getNacimiento();
		this.nick = u.getNick();
		this.nombre = u.getNombre();
		this.password = u.getPassword();
		this.sexo = u.getSexo();
		this.tipoUsuario = u.getTipoUsuario();		
		this.latLongRecidencia = getLatLongRecidencia();
		this.residencia = getResidencia();			
		ICUsuarios ic = new CUsuarios();
		Rescatista idRT = ic.getRescatistaByUsuID(u.getIdUsuarios());
		this.tiposrescatistas = ic.GetTipoRescatista();	
		for (TipoRescatista tr : this.tiposrescatistas) {
			if(tr.getIdTipoRescatista() == idRT.getIdTipoRescatista()){
				this.tiporescatisa = tr;
			}
		} 
		this.tipos = new ArrayList<tipoUsr>();
		tipoUsr uno = new tipoUsr();
		uno.setValue(0);
		uno.setNombre("ADMINISTRADOR");
		this.tipos.add(uno);
		tipoUsr dos = new tipoUsr();
		dos.setValue(1);
		dos.setNombre("RESCATISTA");
		this.tipos.add(dos);
		
		this.generos = new ArrayList<generoUsr>();
		generoUsr g1 = new generoUsr();
		g1.setNombre("MASCULINO");
		g1.setValor("M");
		generoUsr g2 = new generoUsr();
		g2.setNombre("FEMENINO");
		g2.setValor("F");
		this.generos.add(g1);
		this.generos.add(g2);
				
	}

	public List<tipoUsr> getTipos() {
		return tipos;
	}

	public List<generoUsr> getGeneros() {
		return generos;
	}

	public void setGeneros(List<generoUsr> generos) {
		this.generos = generos;
	}

	public void setTipos(List<tipoUsr> tipos) {
		this.tipos = tipos;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public UsuariosModel() {
		tiposrescatistas = new ArrayList<TipoRescatista>();
		ICUsuarios ic = new CUsuarios();
		tiposrescatistas = ic.GetTipoRescatista();
		this.tipos = new ArrayList<tipoUsr>();
		tipoUsr uno = new tipoUsr();
		uno.setValue(0);
		uno.setNombre("ADMINISTRADOR");
		this.tipos.add(uno);
		tipoUsr dos = new tipoUsr();
		dos.setValue(1);
		dos.setNombre("RESCATISTA");
		this.tipos.add(dos);
	};

	public byte getBorrado() {
		return borrado;
	}

	public void setBorrado(byte borrado) {
		this.borrado = borrado;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getCreacion() {
		return creacion;
	}

	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(int tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public TipoRescatista getTiporescatisa() {
		return tiporescatisa;
	}

	public void setTiporescatisa(TipoRescatista tiporescatisa) {
		this.tiporescatisa = tiporescatisa;
	}

	public List<TipoRescatista> getTiposrescatistas() {
		return tiposrescatistas;
	}

	public void setTiposrescatistas(List<TipoRescatista> tiposrescatistas) {
		this.tiposrescatistas = tiposrescatistas;
	}

	public String getLatLongRecidencia() {
		return latLongRecidencia;
	}

	public void setLatLongRecidencia(String latLongRecidencia) {
		this.latLongRecidencia = latLongRecidencia;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
