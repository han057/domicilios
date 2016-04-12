/**
 * 
 */
package com.hsofttecnologies.domicilios.dao;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Categoria;

/**
 * Interfaz de acceso a datos para las categorias
 * 
 * @author han
 * @version 1.0
 */
public interface CategoriaDao {

	/**
	 * Lista las categorias desde el repositorio de datos
	 * 
	 * @return Lista de categorias
	 */
	public List<Categoria> listarCategorias();

	/**
	 * Buscar una categoria por su identificador único
	 * 
	 * @param id
	 *            - identificador a buscar
	 * @return la categoría con id como identificador si lo encuentra, de lo
	 *         contrario null
	 */
	public Categoria buscarPorId(int id);

	/**
	 * Buscar una categoria por su nombre
	 * 
	 * @param nombre
	 *            - nombre a buscar
	 * @return la categoría cuyo nombre es igual al parametro dado, si no existe
	 *         null
	 */
	public Categoria buscarPorNombre(String nombre);

	/**
	 * Agrega una nueva categoría
	 * 
	 * @param categoria
	 *            - categoría a agregar
	 */
	public void agregarCategoria(Categoria categoria);

	/**
	 * Modifica la información de la categoría
	 * 
	 * @param categoria
	 *            - Categoría a actualizar
	 */
	public void actualizarCategoria(Categoria categoria);
}
