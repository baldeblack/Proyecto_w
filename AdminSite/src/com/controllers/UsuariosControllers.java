package com.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Validadores.UsuarioValidador;

import com.Controllers.CUsuarios;
import com.Entities.Rescatista;
import com.Entities.Usuario;
import com.Interfaces.ICUsuarios;
import com.models.UsuariosListModel;
import com.models.UsuariosModel;

@RequestMapping("/usuarios")
@Controller
public class UsuariosControllers {

	UsuarioValidador CValidador;

	@Autowired
	public UsuariosControllers(UsuarioValidador CValidador) {
		this.CValidador = CValidador;
	}

	
	@RequestMapping(method = RequestMethod.GET)
	public String UsuariosGet(ModelMap model) {
		 UsuariosListModel uModel = new UsuariosListModel();
		model.addAttribute("UsuariosListModel", uModel);		
		return "listUsuarios";
	}
	
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String getCreateForm(ModelMap model) {
		UsuariosModel usuM = new UsuariosModel();
		model.addAttribute("UsuariosModel", usuM);
		return "altaUsuario";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String Alta(
			@ModelAttribute("UsuariosModel") UsuariosModel UsuarioModel,
			BindingResult bindingResult) throws Exception {

		CValidador.validate(UsuarioModel, bindingResult);

		if (bindingResult.hasErrors()) {
			return "altaUsuario";
		} else {
			ICUsuarios icu = new CUsuarios();
			byte b = 0;
			Usuario usr = new Usuario();
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

		return "Result";
	}
}