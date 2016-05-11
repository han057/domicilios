/**
 * 
 */
package com.hsofttecnologies.domicilios.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.hsofttecnologies.domicilios.dao.PersonaDao;
import com.hsofttecnologies.domicilios.entities.Persona;
import com.hsofttecnologies.domicilios.exception.ObjectAlreadyExistException;
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
		Persona tem=personaDao.buscarPorIdentificacion(persona.getIdentificacion());
		if(tem==null){
			personaDao.agregarPersona(persona);	
		}else{
			throw new ObjectAlreadyExistException("Persona con identifricacion: "+persona.getIdentificacion()+" ya existe");
		}
		
		
	}

	public void actualizarPersona(Persona persona) {
		Persona tem=personaDao.buscarPorId(persona.getId());
		if(tem!=null){
			personaDao.actualizarPersona(persona);
		}else{
			throw new ObjectAlreadyExistException("persona con id: "+persona.getId()+" no actualizado");
		}
	}
	public List<Persona> listarPersonas() {
		return personaDao.listarPersonas();
	}

	public Persona buscarPorIdentificacion(String identificacion) {
		Persona persona=personaDao.buscarPorIdentificacion(identificacion);
		if(persona==null){
			throw new ObjectNotFoundException("Persona con identifricacion : "+identificacion+" No encontrado");
		}
		return persona;
	}
}