package com.hsofttecnologies.domicilios.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsofttecnologies.domicilios.entities.Usuario;
import com.hsofttecnologies.domicilios.services.UsuarioService;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

@RestController(value = "/api/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> listarUsuarios() {
		return usuarioService.listarUsuarios();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Usuario buscarUsuarioPorId(int id) {
		return usuarioService.buscarPorId(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Respuesta agregarUsuario(@ModelAttribute("usuario") Usuario usuario) {
		usuarioService.agregarUsuario(usuario);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El usuario ha sido agregado correctamente");
		respuesta.setBody(usuario);
		return respuesta;
	}

	/*
	 * @RequestMapping(method=RequestMethod.GET) public Usuario busarPorNombre()
	 * { Usuario u= new Usuario(); u.setId(1); u.setNombre("Fredy"); return u; }
	 * 
	 * @RequestMapping(value = "/usuarios", method = RequestMethod.GET) public
	 * List<Usuario> listaUsuarios() { List<Usuario> lista = new
	 * ArrayList<Usuario>(); return lista; }
	 */
}
