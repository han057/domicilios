package com.hsofttecnologies.domicilios.services;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Categoria;

public interface CategoriaService {

	/**
	 * Lista las categorias
	 * 
	 * @return Lista de categorias
	 */
	public List<Categoria> listarCategorias();

	/**
	 * Buscar una categoria por su identificador único, si no lo encuentra lanza
	 * un ObjectNotFoundException
	 * 
	 * @param id
	 *            - identificador a buscar
	 * @return la categoría con id como identificador si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public Categoria buscarPorId(int id);

	
	/**
	 * Buscar una categoria por su nombre único, si no lo encuentra lanza
	 * un ObjectNotFoundException
	 * 
	 * @param nombre - nombrea buscar
	 * @return la categoría con Nombre si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public Categoria buscarPorNombre(String nombre);
	
	/**
	 * Agrega una nueva categoría, si ya existe una categoría con el mismo
	 * nombre lanza un ObjectAlreadyExistEception
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
