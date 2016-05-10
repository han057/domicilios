package com.hsofttecnologies.domicilios.services;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Pedido;


public interface PedidoService {

	/**
	 * Lista los pedidos
	 * 
	 * @return Lista de pedidos
	 */
	public List<Pedido> listarPedidos();

	/**
	 * Buscar unpedido por su identificador único, si no lo encuentra lanza
	 * un ObjectNotFoundException
	 * 
	 * @param id - identificador a buscar
	 * @return el pedido con id como identificador si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public Pedido buscarPorId(int id);

	/**
	 * Agrega un nuevoi pedido, si ya existe pedido con el mismo id lanza un ObjectAlreadyExistEception
	 * 
	 * @param pedido - pedido a agregar
	 */
	public void agregarPedido(Pedido pedido);

	/**
	 * Modifica la información del pedido
	 * 
	 * @param Pedido - Pedicoa actualizar
	 */
	public void actualizarPedido(Pedido pedido);

}
