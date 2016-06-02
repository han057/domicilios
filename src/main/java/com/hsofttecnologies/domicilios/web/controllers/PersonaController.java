/**
 * 
 */
package com.hsofttecnologies.domicilios.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsofttecnologies.domicilios.entities.Persona;
import com.hsofttecnologies.domicilios.services.PersonaService;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

/**
 * @author Javier_cabrera
 *
 */
@RestController
@CrossOrigin
public class PersonaController {

	private static final String url = "/api/persona";

	@Autowired
	PersonaService personaService;

	@RequestMapping(value = url, method = RequestMethod.GET)
	public List<Persona> listarPersonas() {
		return personaService.listarPersonas();
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.GET)
	public Persona buscarPersonaPorId(@PathVariable("id") int id) {
		return personaService.buscarPorId(id);

	}

	@RequestMapping(value = url, method = RequestMethod.POST)
	public Respuesta agregarPersona(@ModelAttribute("persona") Persona persona) {
		personaService.agregarPersona(persona);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("la persona ha sido agregada correctamente");
		respuesta.setBody(persona);
		return respuesta;
	}

	@RequestMapping(value = url, method = RequestMethod.PUT)
	public Respuesta editarPersona(@ModelAttribute("persona") Persona persona) {
		personaService.actualizarPersona(persona);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("la persona ha sido agregada correctamente");
		respuesta.setBody(persona);
		return respuesta;
	}
}
