package com.hsofttecnologies.domicilios.services;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Producto;

public interface ProductoService {
	/**
	 * Lista Productos
	 * 
	 * @return Lista de Productos
	 */
	public List<Producto> listarProductos();

	/**
	 * Lista Productos por categoria
	 * 
	 * @return Lista de Productos
	 */
	public List<Producto> listarProductosPorCategoria(int categoria);

	/**
	 * Buscar un producto por su identificador único, si no lo encuentra lanza
	 * un ObjectNotFoundException
	 * 
	 * @param id
	 *            - identificador a buscar
	 * @return el Producto con id como identificador si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public Producto buscarPorId(int id);

	/**
	 * Agrega una nuevo producto, si ya existe una categoría con el mismo nombre
	 * lanza un ObjectAlreadyExistEception
	 * 
	 * @param producto
	 *            - prodcuto a agregar
	 */
	public void agregarProducto(Producto producto);

	/**
	 * Modifica la información de la Producto
	 * 
	 * @param Producto-Producto
	 *            a actualizar
	 */
	public void actualizarProducto(Producto producto);

	/**
	 * Cambia el estado del producto a inactivo
	 * 
	 * @param producto
	 *            - Producto a eliminar
	 */
	public void eliminarProducto(int id);

}
