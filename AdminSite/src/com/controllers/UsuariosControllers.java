package com.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Controllers.CPlanes;
import com.Controllers.CUsuarios;
import com.Entities.Rescatista;
import com.Entities.Rescatistacatastrofe;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;
import com.Interfaces.ICPlanes;
import com.Interfaces.ICUsuarios;
import com.controllers.ONGsController.ids;
import com.google.gson.Gson;
import com.models.UsuariosListModel;
import com.models.usuarioFormModel;
import com.utils.RescatistaUtil;
import com.utils.accessControl;
import com.utils.tipoUsr;

@RequestMapping("/usuarios")
@Controller
public class UsuariosControllers {
	
	@RequestMapping(method = RequestMethod.GET)
	public String UsuariosGet(ModelMap model, HttpServletRequest request) {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "listUsuarios")){
			return "redirect:/forbhiden";
		}
		 UsuariosListModel uModel = new UsuariosListModel();
		model.addAttribute("UsuariosListModel", uModel);		
		return "listUsuarios";
	}
		
	
	@RequestMapping(value = "/edit/{idUsuarios}", method = RequestMethod.GET)
	public String getEditFormABM(@PathVariable int idUsuarios, ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		Gson g = new Gson();
		ICUsuarios iu = new CUsuarios();
		List<TipoRescatista> ti = iu.GetTipoRescatista();
		List<tipoUsr> tu =  new ArrayList<tipoUsr>();
		for (TipoRescatista t: ti){
			tipoUsr tipo = new tipoUsr();
			tipo.setNombre(t.getNombre());
			tipo.setValue(t.getIdTipoRescatista());
			tu.add(tipo);
		}
		
		model.addAttribute("idUsu", idUsuarios);
		
		Usuario u = iu.getUsuById(idUsuarios);
		
		   Calendar cal = Calendar.getInstance();
		   cal.setTime( u.getNacimiento());	       
		   u.setNacimiento(cal.getTime());
		if(u.getTipoUsuario() == 1){
			Rescatista r = iu.getRescatistaByUsuID(u.getIdUsuarios());	
			model.addAttribute("jsonusu", g.toJson(r).replaceAll("\"", "'"));
		}else{
			model.addAttribute("jsonusu",  g.toJson(u).replaceAll("\"", "'"));
		}
		
		model.addAttribute("action", "Modificar");
		model.addAttribute("jsondata", g.toJson(tu).replaceAll("\"", "'"));
	    return "usuarioABM";
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getCreateFormABM(ModelMap model) {
		Gson g = new Gson();
		ICUsuarios iu = new CUsuarios();
		List<TipoRescatista> ti = iu.GetTipoRescatista();
		List<tipoUsr> tu =  new ArrayList<tipoUsr>();
		for (TipoRescatista t: ti){
			tipoUsr tipo = new tipoUsr();
			tipo.setNombre(t.getNombre());
			tipo.setValue(t.getIdTipoRescatista());
			tu.add(tipo);
		}
		model.addAttribute("idUsu", "");
		model.addAttribute("jsonusu", "");
		model.addAttribute("action", "Crear");
		model.addAttribute("jsondata", g.toJson(tu).replaceAll("\"", "'"));
	    return "usuarioABM";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody String updateForm(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws Exception {
		
		Gson g = new Gson();
		String jsonresp = "";
		usuarioFormModel uf = g.fromJson(json, usuarioFormModel.class);
		ICUsuarios iu = new CUsuarios();
		Usuario usr = new Usuario();
		
		   String dateStr [] = uf.getNacimiento().split("-");	       
	       Calendar cal = Calendar.getInstance();
	       cal.set(Calendar.YEAR, (Integer.parseInt(dateStr[0])));
	       cal.set(Calendar.MONTH, (Integer.parseInt(dateStr[1])));
	       cal.set(Calendar.DAY_OF_MONTH, (Integer.parseInt(dateStr[2])));
	       Date dateRepresentation = cal.getTime();      
	       
				byte b = 0;				
				usr.setApellido(uf.getApellido());
				usr.setNombre(uf.getNombre());				
				usr.setBorrado(b);
				usr.setCelular(uf.getCelular());				
				usr.setNacimiento(dateRepresentation);
				usr.setDireccion(uf.getDireccion());
				usr.setNick(uf.getNick());			
				usr.setSexo(uf.getSexo());				
				usr.setEmail(uf.getEmail());
				usr.setTipoUsuario(uf.getTipoUsuario());
				usr.setPassword(uf.getPassword());
				
		if(uf.getAccion().equals("Crear")){
			
			usr.setIdUsuarios(iu.maxUsrId());
			usr.setCreacion(new Date());		
	
				if (usr.getTipoUsuario() == 1) {
					Rescatista r = new Rescatista();
					r.setIdRescatista(iu.maxResId());
					r.setIdTipoRescatista(uf.getTiporescatisa());
					r.setUsuario(usr);
					r.setResidencia(usr.getDireccion());
					r.setTipoRescatista(iu.getTipoByID(r.getIdTipoRescatista()));
					r.setResidencia(usr.getDireccion());				
					iu.AltaRescatista(r);
				} else {
	
					iu.AltaUsuario(usr);
				}
				
				idU idusu = new idU();
				int realId = iu.maxUsrId();
				
				if(realId == 0){
					idusu.id = String.valueOf(0);
				}else{
					idusu.id = String.valueOf(iu.maxUsrId() - 1);
				}
				
				jsonresp = g.toJson(idusu);	
				
		}else{
			if (usr.getTipoUsuario() == 1) {
				Rescatista r = new Rescatista();
				r.setResidencia(usr.getDireccion());
				r.setTipoRescatista(iu.getTipoByID(uf.getTiporescatisa()));
				r.setResidencia(usr.getDireccion());	
				r.setUsuario(usr);
				r.setResidencia(usr.getDireccion());	
				r.setIdTipoRescatista(r.getTipoRescatista().getIdTipoRescatista());
				iu.ActualizarUsuario(usr, r, uf.getIdUsu());
			} else {
				iu.ActualizarUsuario(usr, null, uf.getIdUsu());		
			}
			
			jsonresp = g.toJson(uf.getIdUsu());	
		}
				return jsonresp;
	}
	
	public class idU {
		String id;
	}
	
		
	@RequestMapping(value = "/updateres", method = RequestMethod.POST)
	public @ResponseBody String udpateRes(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		Gson g = new Gson();
		ids c = g.fromJson(json, ids.class);
		ICUsuarios iu = new CUsuarios();
		Rescatistacatastrofe rc = new Rescatistacatastrofe();
		rc.setIdcatastrofe(Integer.parseInt(c.idc));
		rc.setIdrescatista(Integer.parseInt(c.ido));
		iu.AltaRel(rc);
			
		List<Usuario> lstu = new ArrayList<>();
		List<RescatistaUtil> lstru = new ArrayList<RescatistaUtil>();
		List<Rescatista> lstr = new ArrayList<Rescatista>();
		lstu = iu.GetUsuByTipo(1);
		ICPlanes ip = new CPlanes();
		
		for (Usuario u: lstu){
			Rescatistacatastrofe rct = ip.getRescatistacatastrofe(u.getIdUsuarios()) ;
			if(rct == null){
			Rescatista r = new Rescatista();
			r = iu.getRescatistaByUsuID(u.getIdUsuarios());
			r.setUsuario(u);
			lstr.add(r);
			}
		}
		
		
		for (Rescatista r: lstr){			
			RescatistaUtil ru = new RescatistaUtil();
			ru.setNombre(r.getUsuario().getNombre());
			ru.setCelular(r.getUsuario().getCelular());
			ru.setApellido(r.getUsuario().getApellido());
			ru.setEmail(r.getUsuario().getEmail());
			ru.setIdUsuarios(r.getUsuario().getIdUsuarios());
			TipoRescatista ti = iu.getTipoByID(r.getIdTipoRescatista());
			ru.setTipoRescatista(ti.getNombre());
			lstru.add(ru);
		}
		
		
		String jsonresp = g.toJson(lstru);
		return jsonresp;
	}
}