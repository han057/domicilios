package com.hsofttecnologies.domicilios.dao;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Producto;

public interface ProductoDao {
	/**
	 * Lista las categorias desde el repositorio de datos
	 * 
	 * @return Lista de categorias
	 */
	public List<Producto> listarProductos();
	
	/**
	 * Lista Productos por categoria
	 * 
	 * @return Lista de Productos
	 */
	public List<Producto> listarProductosPorCategoria(int categoria);


	/**
	 * Buscar un Producto por su identificador único
	 * 
	 * @param id- identificador a buscar
	 * @return el Producto con id como identificador si lo encuentra, de lo
	 *         contrario null
	 */
	public Producto buscarPorId(int id);

	/**
	 * Buscar un Producto por su nombre
	 * 
	 * @param nombre - nombre a buscar
	 * @return el producto cuyo nombre es igual al parametro dado, si no existe
	 *         null
	 */
	public Producto buscarPorNombre(String nombre);

	/**
	 * Agrega un nuevoi Producto
	 * 
	 * @param Producto
	 *            - prodeucto a agregar
	 */
	public void agregarProducto(Producto producto);

	/**
	 * Modifica la información dl Producto
	 * 
	 * @param producto
	 *            - producto a actualizar
	 */
	public void actualizarProducto(Producto producto);
}
