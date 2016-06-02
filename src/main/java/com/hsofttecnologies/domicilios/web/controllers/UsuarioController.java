package com.hsofttecnologies.domicilios.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsofttecnologies.domicilios.entities.Usuario;
import com.hsofttecnologies.domicilios.services.UsuarioService;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

@RestController
@CrossOrigin
public class UsuarioController {

	private static final String url = "/api/usuario";
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = url, method = RequestMethod.GET)
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.GET)
	public Usuario buscarUsuarioPorId(@PathVariable("id") int id) {
		return usuarioService.buscarPorId(id);
	}

	@RequestMapping(value = url, method = RequestMethod.POST)
	public Respuesta agregarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.agregarUsuario(usuario);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El usuario ha sido agregado correctamente");
		respuesta.setBody(usuario);
		return respuesta;
	}

	@RequestMapping(value = url, method = RequestMethod.PUT)
	public Respuesta actualizargregarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.agregarUsuario(usuario);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El usuario ha sido actualizado correctamente");
		respuesta.setBody(usuario);
		return respuesta;
	}

}
