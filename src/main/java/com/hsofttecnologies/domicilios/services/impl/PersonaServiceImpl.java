/**
 * 
 */
package com.hsofttecnologies.domicilios.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.hsofttecnologies.domicilios.dao.PersonaDao;
import com.hsofttecnologies.domicilios.entities.Persona;
import com.hsofttecnologies.domicilios.exception.ObjectNotFoundException;
import com.hsofttecnologies.domicilios.services.PersonaService;

/**
 * @author Javier Cabrera
 *
 */
@Service("personaService")
public class PersonaServiceImpl implements PersonaService {
	@Autowired 
	PersonaDao personaDao;

	public Persona buscarPorId(int id) {
		Persona persona=personaDao.buscarPorId(id);
		if(persona==null){
			throw new ObjectNotFoundException("Persona con id: "+id+" No encontrado");
		}
		return persona;
	}

	public void agregarPersona(Persona persona) {
		personaDao.agregarPersona(persona);
		
	}

	public void actualizarPersona(Persona persona) {
		personaDao.actualizarPersona(persona);
		
	}
	public List<Persona> listarPersonas() {
		return personaDao.listarPersonas();
	}
}