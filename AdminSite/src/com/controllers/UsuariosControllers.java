package com.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Validadores.UsuarioValidador;

import com.Controllers.CCatastrofe;
import com.Controllers.CUsuarios;
import com.Entities.Catastrofe;
import com.Entities.Rescatista;
import com.Entities.Rescatistacatastrofe;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICUsuarios;
import com.controllers.ONGsController.ids;
import com.google.gson.Gson;
import com.models.RescatistaModel;
import com.models.UsuariosListModel;
import com.models.UsuariosModel;
import com.utils.RescatistaUtil;
import com.utils.accessControl;

@RequestMapping("/usuarios")
@Controller
public class UsuariosControllers {

	UsuarioValidador CValidador;

	@Autowired
	public UsuariosControllers(UsuarioValidador CValidador) {
		this.CValidador = CValidador;
	}

	
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
	
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String getCreateForm(ModelMap model, HttpServletRequest request) {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "create")){
			return "redirect:/forbhiden";
		}
		UsuariosModel usuM = new UsuariosModel();
		usuM.setAction("Crear");
		model.addAttribute("UsuariosModel", usuM);
		return "altaUsuario";
	}
	
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String Alta(
			@ModelAttribute("UsuariosModel") UsuariosModel UsuarioModel,
			BindingResult bindingResult, HttpServletRequest request) throws Exception {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "save")){
			return "redirect:/forbhiden";
		}
		
		CValidador.validate(UsuarioModel, bindingResult);
		ICUsuarios icu = new CUsuarios();
		Usuario usr = new Usuario();
		
		if(UsuarioModel.getAction().equals("Crear")){
			if (bindingResult.hasErrors()) {
				return "altaUsuario";
			} else {		
				byte b = 0;				
				usr.setApellido(UsuarioModel.getApellido());
				usr.setNombre(UsuarioModel.getNombre());
				usr.setIdUsuarios(icu.maxUsrId());
				usr.setBorrado(b);
				usr.setCelular(UsuarioModel.getCelular());
				usr.setCreacion(new Date());
				usr.setNacimiento(UsuarioModel.getNacimiento());
				usr.setDireccion(UsuarioModel.getDireccion());
				usr.setNick(UsuarioModel.getNick());
				usr.setPassword(UsuarioModel.getPassword());
				usr.setSexo(UsuarioModel.getSexo());
				usr.setTipoUsuario(UsuarioModel.getTipoUsuario());
				usr.setEmail(UsuarioModel.getEmail());
	
				if (usr.getTipoUsuario() == 1) {
					Rescatista r = new Rescatista();
					r.setIdRescatista(icu.maxResId());
					r.setLatLongRecidencia(UsuarioModel.getLatLongRecidencia());
					r.setIdTipoRescatista(UsuarioModel.getTiporescatisa()
							.getIdTipoRescatista());
					r.setUsuario(usr);
					r.setResidencia(usr.getDireccion());
					r.setTipoRescatista(icu.getTipoByID(r.getIdTipoRescatista()));
					icu.AltaRescatista(r);
				} else {
	
					icu.AltaUsuario(usr);
				}
			}
	}else{
		byte b = 0;				
		usr.setApellido(UsuarioModel.getApellido());
		usr.setNombre(UsuarioModel.getNombre());
		usr.setBorrado(b);
		usr.setCelular(UsuarioModel.getCelular());	    
		usr.setNacimiento(UsuarioModel.getNacimiento());
		usr.setDireccion(UsuarioModel.getDireccion());
		usr.setNick(UsuarioModel.getNick());
		usr.setSexo(UsuarioModel.getSexo());
		usr.setTipoUsuario(UsuarioModel.getTipoUsuario());
		usr.setEmail(UsuarioModel.getEmail());

		if (usr.getTipoUsuario() == 1) {
			Rescatista r = new Rescatista();
			r.setLatLongRecidencia(UsuarioModel.getLatLongRecidencia());
			r.setIdTipoRescatista(UsuarioModel.getTiporescatisa()
					.getIdTipoRescatista());
			r.setUsuario(usr);
			r.setResidencia(usr.getDireccion());
			r.setTipoRescatista(icu.getTipoByID(r.getIdTipoRescatista()));		
			icu.ActualizarUsuario(usr, r, (Integer)request.getSession().getAttribute("idUsuarios"));
		} else {
			icu.ActualizarUsuario(usr, null, (Integer)request.getSession().getAttribute("idUsuarios"));		
		}
		
	}
		return "Result";
	}

	@RequestMapping(value="/edit/{idUsuarios}", method = RequestMethod.GET)
	public String UsuUpdate(@PathVariable int idUsuarios, ModelMap model, HttpServletRequest request) throws Exception {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "edit")){
			return "redirect:/forbhiden";
		}
		request.getSession().setAttribute("idUsuarios", idUsuarios);
		ICUsuarios ic = new CUsuarios();
		Usuario u = ic.getUsuById(idUsuarios);
		Rescatista r = ic.getRescatistaByUsuID(idUsuarios);
		TipoRescatista t = ic.getTipoByID(r.getIdTipoRescatista());
		UsuariosModel uModel = new UsuariosModel(u);
		uModel.setLatLongRecidencia(r.getLatLongRecidencia());
		uModel.setTiporescatisa(t);
		uModel.setAction("Modificar");
		model.addAttribute("UsuariosModel", uModel);
		return "altaUsuario";	
		}
	
	@RequestMapping(value="/vincresc/{tenantID}", method=RequestMethod.GET)
	public String getVincularForm(@PathVariable int tenantID, ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "vincresc")){
			return "redirect:/forbhiden";
		}
		ICCatastrofe ic = new CCatastrofe();
		Catastrofe c = ic.getCatastrofeByID(tenantID);
		
		ICUsuarios iu = new CUsuarios();
		List<Usuario> lstu = new ArrayList<>();
		List<RescatistaUtil> lstru = new ArrayList<RescatistaUtil>();
		List<Rescatista> lstr = new ArrayList<Rescatista>();
		lstu = iu.GetUsuByTipo(1);
	
		for (Usuario u: lstu){
			Rescatista r = new Rescatista();
			r = iu.getRescatistaByUsuID(u.getIdUsuarios());
			r.setUsuario(u);
			lstr.add(r);
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
		
		
		RescatistaModel rMod = new RescatistaModel();
		rMod.setCtNombre(c.getNombre());
		rMod.setIdCt(c.getIdCatastrofe());
		rMod.setRescatisasLst(lstru);
		
		Gson g = new Gson();
		rMod.setJsonData(g.toJson(lstru).replaceAll("\"", "'"));
		model.addAttribute("RescatistaModel", rMod);
		
		return "vincularesc";
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
	
		for (Usuario u: lstu){
			Rescatista r = new Rescatista();
			r = iu.getRescatistaByUsuID(u.getIdUsuarios());
			r.setUsuario(u);
			lstr.add(r);
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