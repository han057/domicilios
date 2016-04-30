package com.hsofttecnologies.domicilios.web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsofttecnologies.domicilios.entities.Usuario;
import com.hsofttecnologies.domicilios.services.UsuarioService;

@RestController("/api/usuario")
public class UsuarioController {
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Usuario busarPorId() {
		Usuario u = new Usuario();
		u.setId(1);
		u.setNombre("Fredy");
		return u;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public Usuario busarPorNombre() {
		Usuario u= new Usuario();
		u.setId(1);
		u.setNombre("Fredy");
		return u;
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public List<Usuario> listaUsuarios() {
		List<Usuario> lista = new ArrayList<Usuario>();
		return lista;
	}
	

}
