package com.hsofttecnologies.domicilios.dao;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Persona;

public interface PersonaDao {
	/**
	 * Lista las persona desde el repositorio de datos
	 * 
	 * @return Lista de Personas
	 */
	public List<Persona> listarPersonas();

	/**
	 * Buscar uan persona por su identificador único
	 * 
	 * @param id- identificador a buscar
	 * @return el Producto con id como identificador si lo encuentra, de lo
	 *         contrario null
	 */
	public Persona buscarPorId(int id);

	/**
	 * Buscar una persona por su nombre
	 * 
	 * @param nombre - nombre a buscar
	 * @return la persona cuyo nombre es igual al parametro dado, si no existe
	 *         null
	 */
	public Persona buscarPorNombre(String nombre);

	/**
	 * Buscar una persona por su documento de identificacion
	 * 
	 * @param documento - documento de identificacion a buscar
	 * @return la persona cuyo documento de identificacion es igual al parametro dado, si no existe
	 *         null
	 */
	public Persona buscarPorIdentificacion(String identificacion);

	
	/**
	 * Agrega una nueva Persona
	 * 
	 * @param Persona
	 *            - Persona a agregar
	 */
	public void agregarPersona(Persona persona);

	/**
	 * Modifica la información de la persona
	 * 
	 * @param Persona
	 *            - Persona a actualizar
	 */
	public void actualizarPersona(Persona persona);
}
