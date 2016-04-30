package com.hsofttecnologies.domicilios.services;

import java.util.List;


import com.hsofttecnologies.domicilios.entities.Usuario;

public interface UsuarioService {
	/**
	 * Lista los usuarios
	 * 
	 * @return Lista de usuario
	 */
	public List<Usuario> listarUsuarios();

	/**
	 * Buscar un usuario por su identificador único, si no lo encuentra lanza
	 * un ObjectNotFoundException
	 * 
	 * @param id- identificador a buscar
	 * @return el usuario con id como identificador si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public Usuario buscarPorId(int id);

	/**
	 * Agrega un  nuevo usuario, si ya existe un usuario con el mismo
	 * nombre lanza un ObjectAlreadyExistEception
	 * 
	 * @param usuario - usuario a agregar
	 */
	public void agregarUsuario(Usuario usuario);

	/**
	 * Modifica la información del usuario
	 * 
	 * @param usuario - Usuario a actualizar
	 */
	public void actualizarUsuario(Usuario usuario);
}
