package com.hsofttecnologies.domicilios.services;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.ItemPedido;
import com.hsofttecnologies.domicilios.entities.Pedido;

public interface PedidoService {

	/**
	 * Lista los pedidos
	 * 
	 * @return Lista de pedidos
	 */
	public List<Pedido> listarPedidos();

	/**
	 * Lista los pedidos por su estado
	 * 
	 * @param id
	 * @return
	 */
	public List<Pedido> listarPedidosEstado(int id);

	/**
	 * Buscar unpedido por su identificador único, si no lo encuentra lanza un
	 * ObjectNotFoundException
	 * 
	 * @param id
	 *            - identificador a buscar
	 * @return el pedido con id como identificador si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public Pedido buscarPorId(int id);

	/**
	 * Agrega un nuevoi pedido, si ya existe pedido con el mismo id lanza un
	 * ObjectAlreadyExistEception
	 * 
	 * @param pedido
	 *            - pedido a agregar
	 */
	public void agregarPedido(Pedido pedido);

	/**
	 * Modifica la información del pedido
	 * 
	 * @param Pedido
	 *            - Pedicoa actualizar
	 */
	public void actualizarPedido(Pedido pedido);

	
	
	/**
	 * Método que modifica el estado del pedido a confirmado y esperando para enviar	
	 * 
	 * @param pedido - codigo del pedido
	 * @param repartidor - codigo del repartidor
	 */
	public void confirmarPedido(int pedido, int repartidor);
	
	/**
	 * Método que modifica el estado del pedido a enviado	
	 * 
	 * @param pedido - codigo del pedido
	 * @param repartidor - codigo del repartidor
	 */
	public void enviarPedido(int pedido);
	
	/**
	 * Método que modifica el estado del pedido a entregado (4) o no entregado (5)	
	 * 
	 * @param pedido - codigo del pedido
	 * @param estado - codigo de estado (4 o 5) 
	 */
	public void entregaPedido(int pedido, int estado);
	
	/**
	 * Método para cancelar pedido (6)
	 * @param pedido
	 */
	public void cancelarPedido(int pedido);

	/**
	 * Agrega un nuevo item al pedido
	 * @param itemPedido
	 * @param id
	 */
	public void agregarItemPedido(ItemPedido itemPedido, int id);
	
	/**
	 * Elimina el item de pedido
	 * @param itemPedido
	 * @param id
	 */
	public void eliminarItemPedido(int id);
	

}
