package com.hsofttecnologies.domicilios.dao;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.ItemPedido;
/**
 * 
 * @author INTERNET_2
 *
 */
public interface ItemPedidoDao {
	/**
	 * Lista los Itemes del pedido  de el repositorio de datos
	 * 
	 * @return Lista de Items de Pedido
	 */
	public List<ItemPedido> listarItemsPedido();

	/**
	 * Buscar una categoria por su identificador único
	 * 
	 * @param id - identificador a buscar
	 * @return el item con id como identificador si lo encuentra, de lo
	 *         contrario null
	 */
	public ItemPedido buscarPorId(int id);

	/**
	 * Buscar un Item de pedido por su nombre
	 * 
	 * @param nombre - nombre a buscar
	 * @return lItem de pedido cuyo nombre es igual al parametro dado, si no existe
	 *         null
	 */
	public ItemPedido buscarPorNombre(String nombre);

	/**
	 * Agrega una nuevo Item de pedido
	 * 
	 * @param Itempedido
	 *            - Itempedido a agregar
	 */
	public void agregarItemPedido(ItemPedido itempedido);

	/**
	 * Modifica la información de la ItemPedido
	 * 
	 * @param Itempdido
	 *            - ItemPedido a actualizar
	 */
	public void actualizarItemPedido(ItemPedido itempedido);
}
