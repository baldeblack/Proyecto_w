package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.Entities.Rescatista;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;
import com.Helper.EntityManagerHelper;

public class UsuarioDAO {

	EntityManager _eManager;
	public UsuarioDAO(){
		_eManager = EntityManagerHelper.getInstance().getJPAFactory().createEntityManager();
	}
	
	public List<Usuario> GetAllUsuarios(){
		List<Usuario> result = null;
		try {
		TypedQuery<Usuario> query =_eManager.createQuery("Select u From Usuario u", Usuario.class);
		result = query.getResultList();
		
		} catch (Exception e) {
			throw e;
		}
		return result;
	}
	
	public Usuario Login(String mail, String pass){
		Usuario user = null;		
		try {
			Query query =_eManager.createQuery("Select c From Usuario c Where c.email =?1 and c.password =?2", Usuario.class);
			query.setParameter(1, mail);	
			query.setParameter(2, pass);	
			user = (Usuario)query.getSingleResult();
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		
			return user;
	}
	
	public List<TipoRescatista> GetTipoRescatista(){
		List<TipoRescatista> result = null;
		try {
		TypedQuery<TipoRescatista> query =_eManager.createQuery("Select t From TipoRescatista t", TipoRescatista.class);
		result = query.getResultList();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	
	public void AltaUsuario(Usuario u){
		try {
			_eManager.getTransaction().begin();
			_eManager.persist(u);	
			_eManager.flush();
			_eManager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}	
		
	public void AltaRescatista(Rescatista r){
			try {
				_eManager.getTransaction().begin();
				_eManager.persist(r);	
				_eManager.flush();
				_eManager.getTransaction().commit();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
				
	}
		
	public TipoRescatista getTipoByID(int ID){
			TipoRescatista TipoRescatista = _eManager.find(TipoRescatista.class, ID);
			return TipoRescatista;
			}
		
	public Integer maxUsrId(){
			try {
			Integer i = (Integer)_eManager.createQuery("select max(u.id) from Usuario u").getSingleResult();
			if(i == null){
				i = 0;
				return i;
			}
			return i + 1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}
		
	public Integer maxResId(){
			try {
			Integer i = (Integer)_eManager.createQuery("select max(u.id) from Rescatista u").getSingleResult();
			if(i == null){
				i = 0;
				return i;
			}
			return i + 1;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return null;
		}

	public Usuario getUsuByID(int id){
		Usuario u = null;
		try {
		_eManager.getTransaction().begin();
	     u = _eManager.find(Usuario.class, id);
		_eManager.flush();
		_eManager.getTransaction().commit();
		} catch (Exception e) {
			throw e;
		}
		return u;
	}
	
	public Rescatista getRescatistaByUsuID(int id) throws ClassNotFoundException, SQLException{
		Rescatista result = null;
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/sharedb";
		String username = "root";
		String pass = "123456";
		Connection con = DriverManager.getConnection(url,username,pass);
		Statement statement = con.createStatement();
		String query = "SELECT * FROM rescatista WHERE IdUsuarios = " + id ;
		ResultSet resultST = statement.executeQuery(query);
		result = new Rescatista();
		while (resultST.next())
		{
		result.setIdRescatista(resultST.getInt("idRescatista"));
		result.setIdTipoRescatista(resultST.getInt("IdTipoRescatista"));
		result.setLatLongRecidencia(resultST.getString("LatLongRecidencia"));
		result.setResidencia(resultST.getString("Residencia"));
		result.setUsuario(getUsuByID(id));
		}
		return result;
	}
	
	public void ActualizarUsuario(Usuario u, Rescatista r, int usuId) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/sharedb";
		String username = "root";
		String pass = "123456";	
		String query = null; 
		String queryu = null; 
		
		Connection con = DriverManager.getConnection(url,username,pass);
		
		try
		{	
		con.setAutoCommit(false);
		Statement statementu = con.createStatement();
	      SimpleDateFormat SDF = new SimpleDateFormat("yyyy/MM/dd");
		queryu = "UPDATE usuarios SET Nombre = '"+ u.getNombre() + "' , Apellido = '" + u.getApellido() + "' , Nick = '" + u.getNick() + "' ,";
		queryu = queryu + " Nacimiento = '" + SDF.format((u.getNacimiento()).getTime()) +"', Sexo = '" + u.getSexo() +"', Celular = " + u.getCelular() + ", Direccion = '" + u.getDireccion() + "', Borrado = " + u.getBorrado() + " WHERE idUsuarios  = " + usuId;
	
		if(u.getTipoUsuario() == 1){
		Statement statement = con.createStatement();
			
	    query = "UPDATE rescatista SET IdTipoRescatista =" + r.getIdTipoRescatista() + ",	Residencia = ";
		query = query + "'" + r.getResidencia() + "', LatLongRecidencia = '" + r.getLatLongRecidencia() + "' WHERE IdUsuarios = " + usuId;

		statement.executeUpdate(query);
		}		
		
		statementu.executeUpdate(queryu);
		con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		}
		finally
		{
		   con.close();
		}
	}

}
