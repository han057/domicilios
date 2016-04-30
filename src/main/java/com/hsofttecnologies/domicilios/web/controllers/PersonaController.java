package com.hsofttecnologies.domicilios.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.hsofttecnologies.domicilios.entities.Persona;
import com.hsofttecnologies.domicilios.services.PersonaService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
	
	@Autowired
	PersonaService personaService;
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public Persona busarPorId() {
//		Persona p = new Persona();
//		p.setId(1);
//		p.setNombre("Fredy");
//		return p;
//	}
//	
//	
//	@RequestMapping(method=RequestMethod.GET)
//	public Persona busarPorNombre() {
//		Persona p = new Persona();
//		p.setId(1);
//		p.setNombre("Fredy");
//		return p;
//	}
//	// {[],methods=[GET]}
//	
	@RequestMapping(method = RequestMethod.GET)
	public List<Persona> listaPersona() {
		List<Persona> lista = personaService.listarPersonas();
		return lista;
	}
	

}
