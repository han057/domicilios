/**
 * 
 */
package com.hsofttecnologies.domicilios.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hsofttecnologies.domicilios.dao.AbstractDAO;
import com.hsofttecnologies.domicilios.dao.ItemPedidoDao;
import com.hsofttecnologies.domicilios.entities.ItemPedido;

/**
 * @author INTERNET_2
 *
 */
@Repository("itemPedido")
public class ItemPedidoDaoHibernateImp extends AbstractDAO<ItemPedido> implements ItemPedidoDao {
	private Logger logger = Logger.getLogger(ItemPedidoDaoHibernateImp.class);
	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.ItemPedidoDao#listarItemsPedido()
	 */
	public List<ItemPedido> listarItemsPedido() {
		logger.debug("listado de items del pedido...");
		return list(ItemPedido.class);
	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.ItemPedidoDao#buscarPorId(int)
	 */
	public ItemPedido buscarPorId(int id) {
		logger.debug("Buscando Item pedido con id: " + id);
		return (ItemPedido) getSession().get(ItemPedido.class, id);
	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.ItemPedidoDao#buscarPorNombre(java.lang.String)
	 */
	public ItemPedido buscarPorNombre(String nombre) {
		logger.debug("Buscando categoria con nombre: " + nombre);
		return (ItemPedido) getSession().createCriteria(ItemPedido.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();

	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.ItemPedidoDao#agregarItemPedido(com.hsofttecnologies.domicilios.entities.ItemPedido)
	 */
	public void agregarItemPedido(ItemPedido itemPedido) {
		logger.debug("Agregando nueva categoría con nombre :"+ itemPedido.getProducto().getNombre() + "...");
		save(itemPedido);
		logger.debug("Nueva categoría con nombre :" + itemPedido.getProducto().getNombre() + " creada!");

	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.ItemPedidoDao#actualizarItemPedido(com.hsofttecnologies.domicilios.entities.ItemPedido)
	 */
	public void actualizarItemPedido(ItemPedido itemPedido) {
		logger.debug("Actualizando categoria con id: " + itemPedido.getProducto().getId());
		getSession().update(itemPedido);
		logger.debug("Categoria con id: " +  itemPedido.getProducto().getId() + " actualizada!");

	}

}
