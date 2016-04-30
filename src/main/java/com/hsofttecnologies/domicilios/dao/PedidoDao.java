package com.hsofttecnologies.domicilios.dao;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Pedido;


public interface PedidoDao {


	/**
	 * Lista los pedidos desde el repositorio de datos
	 * 
	 * @return Lista de Pedidos
	 */
	public List<Pedido> listarPedidos();

	/**
	 * Buscar un pedido por su identificador único
	 * 
	 * @param id - identificador a buscar
	 * @return El pedido con id como identificador si lo encuentra, de lo
	 *         contrario null
	 */
	public Pedido buscarPorId(int id);

	/**
	 * Buscar un Pedido  por su cliente Nombre
	 * 
	 * @param cliente Nombre- clienteNombre  a buscar
	 * @return la categoría cuyo nombre es igual al parametro dado, si no existe
	 *         null
	 */
	public Pedido buscarPorNombre(String clienteNombre);

	/**
	 * Agrega un Nuevo pedido
	 * 
	 * @param Pedido - pedido a agregar
	 */
	public void agregarPedido(Pedido pedido);

	/**
	 * Modifica la información del Pedido
	 * 
	 * @param Pedido - Pedido a actualizar
	 */
	public void actualizarPedido(Pedido pedido);
}
