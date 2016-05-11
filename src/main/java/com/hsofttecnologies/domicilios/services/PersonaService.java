package com.hsofttecnologies.domicilios.services;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Persona;

/**
 * 
 * @author Javier cabrera
 *
 */
public interface PersonaService {

	/**
	 * Lista  persona
	 * 
	 * @return Lista de personas
	 */
	public List<Persona> listarPersonas();

	/**
	 * Buscar una Persona por su identificador único, si no lo encuentra lanza
	 * un ObjectNotFoundException
	 * 
	 * @param id- identificador a buscar
	 * @return la Persona con id como identificador si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public Persona buscarPorId(int id);

	/**
	 * Buscar una Persona por su identificacion único, si no lo encuentra lanza
	 * un ObjectNotFoundException
	 * 
	 * @param identificacion- identificacion a buscar
	 * @return la Persona con documento de identificacion si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public Persona buscarPorIdentificacion(String identificacion);
	
	/**
	 * Agrega una nueva Persooan, si ya existe la persona con el mismo
	 * nombre lanza un ObjectAlreadyExistEception
	 * 
	 * @param Persona - Persona a agregar
	 */
	public void agregarPersona(Persona persona);

	/**
	 * Modifica la información de la persona
	 * 
	 * @param Persona - Persona a actualizar
	 */
	public void actualizarPersona(Persona persona);
}
