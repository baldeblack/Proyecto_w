package com.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
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

import com.Controllers.CCatastrofe;
import com.Controllers.COngs;
import com.Controllers.CPlanes;
import com.Controllers.CUsuarios;
import com.Entities.Catastrofe;
import com.Entities.ONG;
import com.Entities.Rescatista;
import com.Entities.Rescatistacatastrofe;
import com.Entities.TipoRescatista;
import com.Entities.Usuario;
import com.Helper.ongsBorrado;
import com.Interfaces.ICCatastrofe;
import com.Interfaces.ICOngs;
import com.Interfaces.ICPlanes;
import com.Interfaces.ICUsuarios;
import com.google.gson.Gson;
import com.models.VincularModel;
import com.models.ongFormModel;
import com.models.usuarioFormModel;
import com.utils.RescatistaUtil;
import com.utils.accessControl;
import com.utils.tipoUsr;

@RequestMapping("/vincular")
@Controller
public class VincularController {
	
	@RequestMapping(value="/init/{tenantID}", method=RequestMethod.GET)
	public String getVincularForm(@PathVariable int tenantID, ModelMap model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		accessControl ac = new accessControl();
		if(!ac.tieneAcceso(request, "vincular")){
			return "redirect:/forbhiden";
		}
		ICOngs io = new COngs();
		ICCatastrofe ic = new CCatastrofe();
		Catastrofe c = ic.getCatastrofeByID(tenantID);
		VincularModel ongM = new VincularModel();
		List<ONG> lstSis = new ArrayList<ONG>();
		List<ongsBorrado> lstTnt = new ArrayList<ongsBorrado>();
		lstSis = io.ListarOngs();
		lstTnt = io.GetOngsTenant(tenantID);

		for (Iterator<ONG> iterator = lstSis.iterator(); iterator.hasNext(); ) {
			ONG o = iterator.next();
			for (Iterator<ongsBorrado> iteratort = lstTnt.iterator(); iteratort.hasNext(); ) {
				ongsBorrado ot = iteratort.next();
		    if (o.getNombre().equals(ot.getNombre())) {
		        iterator.remove();
		    }
			}
		}
		
		ongM.setOngSistemaLst(lstSis);
		ongM.setOngTenantLst(lstTnt);
		ongM.setCtNombre(c.getNombre());
		ongM.setIdCt(c.getIdCatastrofe());
		Gson g = new Gson();
		ongM.setJsonData(g.toJson(lstTnt).replaceAll("\"", "'"));
		
		ICUsuarios iu = new CUsuarios();
		List<TipoRescatista> ti = iu.GetTipoRescatista();
		List<tipoUsr> tu =  new ArrayList<tipoUsr>();
		for (TipoRescatista t: ti){
			tipoUsr tipo = new tipoUsr();
			tipo.setNombre(t.getNombre());
			tipo.setValue(t.getIdTipoRescatista());
			tu.add(tipo);
		}
	
		 ongM.setJsonDataResc(g.toJson(tu).replaceAll("\"", "'"));		
		
		model.addAttribute("VincularModel", ongM);
		return "vincular";
	}
	
	@RequestMapping(value = "/createong", method = RequestMethod.POST)
	public @ResponseBody String createong(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		
		ICOngs io = new COngs();
		ONG ong = new ONG();
		Gson g = new Gson();		
		
		ongFormModel oM  = g.fromJson(json, ongFormModel.class);
		ong.setDatosPayPal(oM.getDatosPayPal());
		ong.setDireccion(oM.getDireccion());
		ong.setEmail(oM.getEmail());
		ong.setTelefono(oM.getTelefono());
		ong.setWeb(oM.getWeb());
		ong.setOrigen(oM.getOrigen());
		ong.setNombre(oM.getNombre());
		ong.setIdONGs(io.maxOngId());				
		io.AltaOng(ong);
		io.InsertOTenant(oM.getIdC(), ong);		
	
			List<ONG> lstSis = new ArrayList<ONG>();
			List<ongsBorrado> lstTnt = new ArrayList<ongsBorrado>();
			lstSis = io.ListarOngs();
			lstTnt = io.GetOngsTenant(oM.getIdC());

			for (Iterator<ONG> iterator = lstSis.iterator(); iterator.hasNext(); ) {
				ONG o = iterator.next();
				for (Iterator<ongsBorrado> iteratort = lstTnt.iterator(); iteratort.hasNext(); ) {
					ongsBorrado ot = iteratort.next();
			    if (o.getNombre().equals(ot.getNombre())) {
			        iterator.remove();
			    }
				}
			}
			
			
			String jsonresp = g.toJson(lstTnt);
			return jsonresp;	
	}
	
	
	@RequestMapping(value = "/addOng", method = RequestMethod.POST)
	public @ResponseBody String addOng(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		Gson g = new Gson();
		ids c = g.fromJson(json, ids.class);
		ICOngs io = new COngs();
		if(!c.ido.equals("")){
			io.InsertOTenant(Integer.parseInt(c.idc),io.getONG(Integer.parseInt(c.ido)));		
		}
		List<ONG> lstSis = new ArrayList<ONG>();
		List<ongsBorrado> lstTnt = new ArrayList<ongsBorrado>();
		lstSis = io.ListarOngs();
		lstTnt = io.GetOngsTenant(Integer.parseInt(c.idc));

		for (Iterator<ONG> iterator = lstSis.iterator(); iterator.hasNext(); ) {
			ONG o = iterator.next();
			for (Iterator<ongsBorrado> iteratort = lstTnt.iterator(); iteratort.hasNext(); ) {
				ongsBorrado ot = iteratort.next();
		    if (o.getNombre().equals(ot.getNombre())) {
		        iterator.remove();
		    }
			}
		}
		
		
		String jsonresp = g.toJson(lstTnt);
		return jsonresp;
	}
	
	@RequestMapping(value = "/createresc", method = RequestMethod.POST)
	public @ResponseBody String createresc(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, SQLException {
		Gson g = new Gson();
		usuarioFormModel uf = g.fromJson(json, usuarioFormModel.class);
		ICUsuarios iu = new CUsuarios();
		Usuario usr = new Usuario();
		ICPlanes ip = new CPlanes();
		List<Usuario> lstu = new ArrayList<>();
		List<RescatistaUtil> lstru = new ArrayList<RescatistaUtil>();
		List<Rescatista> lstr = new ArrayList<Rescatista>();
		
		
		   String dateStr [] = uf.getNacimiento().split("-");
	       
	       Calendar cal = Calendar.getInstance();
	       cal.set(Calendar.YEAR, (Integer.parseInt(dateStr[0])));
	       cal.set(Calendar.MONTH, (Integer.parseInt(dateStr[1])));
	       cal.set(Calendar.DAY_OF_MONTH, (Integer.parseInt(dateStr[2])));
	       Date dateRepresentation = cal.getTime();      
	       
		byte b = 0;				
		usr.setApellido(uf.getApellido());
		usr.setNombre(uf.getNombre());
		usr.setIdUsuarios(iu.maxUsrId());
		usr.setBorrado(b);
		usr.setCelular(uf.getCelular());
		usr.setCreacion(new Date());
		usr.setNacimiento(dateRepresentation);
		usr.setDireccion(uf.getDireccion());
		usr.setNick(uf.getNick());
		usr.setPassword(uf.getPassword());
		usr.setSexo(uf.getSexo());
		usr.setTipoUsuario(uf.getTipoUsuario());
		usr.setEmail(uf.getEmail());


			Rescatista r = new Rescatista();
			r.setIdRescatista(iu.maxResId());
			r.setLatLongRecidencia("");
			r.setIdTipoRescatista(uf.getTiporescatisa());
			r.setUsuario(usr);
			r.setResidencia(usr.getDireccion());
			r.setTipoRescatista(iu.getTipoByID(r.getIdTipoRescatista()));
			iu.AltaRescatista(r);
			
			Rescatistacatastrofe rc = new Rescatistacatastrofe();
			rc.setIdcatastrofe(uf.getIdC());	
			rc.setIdrescatista(usr.getIdUsuarios());
			iu.AltaRel(rc);
			
			lstu = iu.GetUsuByTipo(1);
			for (Usuario u: lstu){
				Rescatistacatastrofe rct = ip.getRescatistacatastrofe(u.getIdUsuarios()) ;
				if(rct == null){
				Rescatista rlo = new Rescatista();
				rlo = iu.getRescatistaByUsuID(u.getIdUsuarios());
				rlo.setUsuario(u);
				lstr.add(rlo);
				}
			}
			
			
			for (Rescatista rl: lstr){			
				RescatistaUtil ru = new RescatistaUtil();
				ru.setNombre(rl.getUsuario().getNombre());
				ru.setCelular(rl.getUsuario().getCelular());
				ru.setApellido(rl.getUsuario().getApellido());
				ru.setEmail(rl.getUsuario().getEmail());
				ru.setIdUsuarios(rl.getUsuario().getIdUsuarios());
				TipoRescatista ti = iu.getTipoByID(rl.getIdTipoRescatista());
				ru.setTipoRescatista(ti.getNombre());
				lstru.add(ru);
			}
			
			
			String jsonresp = g.toJson(lstru);			
			return jsonresp;
	}
		
	@RequestMapping(value = "/delOng", method = RequestMethod.POST)
	public @ResponseBody String deleteOng(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, SQLException {
		
		Gson g = new Gson();
		ids c = g.fromJson(json, ids.class);
		ICOngs io = new COngs();
		
		io.DeleteOTenant(Integer.parseInt(c.idc),c.ido);		
		List<ONG> lstSis = new ArrayList<ONG>();
		List<ongsBorrado> lstTnt = new ArrayList<ongsBorrado>();
		lstSis = io.ListarOngs();
		lstTnt = io.GetOngsTenant(Integer.parseInt(c.idc));

		for (Iterator<ONG> iterator = lstSis.iterator(); iterator.hasNext(); ) {
			ONG o = iterator.next();
			for (Iterator<ongsBorrado> iteratort = lstTnt.iterator(); iteratort.hasNext(); ) {
				ongsBorrado ot = iteratort.next();
		    if (o.getNombre().equals(ot.getNombre())) {
		        iterator.remove();
		    }
			}
		}
		
		
		String jsonresp = g.toJson(lstTnt);
		return jsonresp;
	}
	
	
	@RequestMapping(value = "/getongid", method = RequestMethod.POST)
	public @ResponseBody String getIdO(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) {
		
		Gson g = new Gson();
		nomO c = g.fromJson(json, nomO.class);		
		ICOngs io = new COngs();		
		ids result = new ids();
		result.idc = io.GetOngByNombre(c.nombre).toString();
		result.ido = c.nombre;
		String jsonresp = g.toJson(result);
		return jsonresp;
	 
	}
	
	public class idC {
		String id;
	}
	
	public class nomO {
		String nombre;
	}
	
	public class ids {
		String idc;
		String ido;
	}

@RequestMapping(value = "/updateres", method = RequestMethod.POST)
public @ResponseBody String udpateRes(@RequestBody String json, HttpServletResponse res, HttpServletRequest request) throws NumberFormatException, ClassNotFoundException, SQLException {
	
	Gson g = new Gson();
	ids c = g.fromJson(json, ids.class);
	ICUsuarios iu = new CUsuarios();
	Rescatistacatastrofe rc = new Rescatistacatastrofe();
	rc.setIdcatastrofe(Integer.parseInt(c.idc));
	
	if(!c.ido.equals("")){
	rc.setIdrescatista(Integer.parseInt(c.ido));
	iu.AltaRel(rc);
	} 
	
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

