package com.hsofttecnologies.domicilios.dao;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Usuario;



/**
 * Interface de acceso a los datos para los usuarios
 * @author Javier cabrera
 * @version 1.0
 *
 */
public interface UsuarioDao {


	/**
	 * Lista los usuarios desde el repositorio de datos
	 * 
	 * @return Lista de usuario
	 */
	public List<Usuario> listarUsuarios();



	/**
	 * Buscar un usuario por su identificador único
	 * 
	 * @param documento- identificador a buscar
	 * @return El usuario con id como identificador si lo encuentra, de lo
	 *         contrario null
	 */
	public Usuario buscarPorId(int id);
	/**
	 * Buscar un usuario por su nombre
	 * 
	 * @param nombre - nombre a buscar
	 * @return El usuario cuyo nombre es igual al parametro dado, si no existe
	 *         null
	 */
	public Usuario buscarPorNombre(String nombre);

	/**
	 * Buscar un usuario por su email
	 * 
	 * @param email - email a buscar
	 * @return El usuario cuyo email es igual al parametro dado, si no existe
	 *         null
	 */
	public Usuario buscarPorEmail(String email);
	/**
	 * Agrega un nuevo usuario
	 * 
	 * @param usuario - usuario a agregar
	 */
	public void agregarUsuario(Usuario usuario);

	/**
	 * Modifica la información del usuario
	 * 
	 * @param usuario - usuario a actualizar
	 */
	public void actualizarUsuario(Usuario usuario);
}
