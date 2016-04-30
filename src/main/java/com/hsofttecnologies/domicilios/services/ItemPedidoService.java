package com.hsofttecnologies.domicilios.services;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Categoria;
import com.hsofttecnologies.domicilios.entities.ItemPedido;

public interface ItemPedidoService {

	/**
	 * Lista los items del pedido
	 * 
	 * @return Lista de Items del pedido
	 */
	public List<ItemPedido> listaritemsPedido();

	/**
	 * Buscar un  item por su identificador único, si no lo encuentra lanza
	 * un ObjectNotFoundException
	 * 
	 * @param id  - identificador a buscar
	 * @return el item de pedido con id como identificador si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public ItemPedido buscarPorId(int id);

	/**
	 * Agrega un nuevo item de pedido, si ya existe ya exixte el el item  con el mismo
	 * nombre deproducto  lanza un ObjectAlreadyExistEception
	 * 
	 * @param item de pedido - item de pedido a agregar
	 */
	public void agregarItemPedido(ItemPedido itempedido);

	/**
	 * Modifica la información del item de pedido
	 * 
	 * @param item de pedido - item de pedido a actualizar
	 */
	public void actualizarItemPedido(ItemPedido itempedido);
}
