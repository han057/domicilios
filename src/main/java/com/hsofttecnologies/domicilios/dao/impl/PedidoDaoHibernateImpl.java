/**
 * 
 */
package com.hsofttecnologies.domicilios.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsofttecnologies.domicilios.dao.AbstractDAO;
import com.hsofttecnologies.domicilios.dao.PedidoDao;
import com.hsofttecnologies.domicilios.entities.Pedido;

/**
 * @author INTERNET_2
 *
 */
@Repository("pedidoDao")
public class PedidoDaoHibernateImpl extends AbstractDAO<Pedido> implements PedidoDao {

	private Logger logger = Logger.getLogger(PedidoDaoHibernateImpl.class);
	@Autowired
	SessionFactory session;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hsofttecnologies.domicilios.dao.PedidoDao#listarPedidos()
	 */
	public List<Pedido> listarPedidos() {
		logger.debug("Listando pedidos...");
		return list(Pedido.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hsofttecnologies.domicilios.dao.PedidoDao#buscarPorId(int)
	 */
	public Pedido buscarPorId(int id) {
		logger.debug("Buscar pedido id: " + id);
		return (Pedido) getSession().get(Pedido.class, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsofttecnologies.domicilios.dao.PedidoDao#buscarPorNombre(java.lang.
	 * String)
	 */
	public Pedido buscarPorNombre(String clienteNombre) {
		logger.debug("Buscar pedido por Nombre de  Clienet: " + clienteNombre);
		return (Pedido) getSession().createCriteria(Pedido.class).add(Restrictions.eq("clienteNombre", clienteNombre))
				.uniqueResult();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hsofttecnologies.domicilios.dao.PedidoDao#agregarPedido(com.
	 * hsofttecnologies.domicilios.entities.Pedido)
	 */
	public void agregarPedido(Pedido pedido) {
		logger.debug("agrega nuevo pedido " + pedido.getClienteNombre() + " ");
		save(pedido);
		logger.debug("nuevo pedido con nombre de cleite " + pedido.getClienteNombre() + " creado  ");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hsofttecnologies.domicilios.dao.PedidoDao#actualizarPedido(com.
	 * hsofttecnologies.domicilios.entities.Pedido)
	 */
	public void actualizarPedido(Pedido pedido) {
		logger.debug("actualiza pedido con id: " + pedido.getId() + "  ");
		getSession().update(pedido);
		logger.debug("actualiza pedido con id: " + pedido.getId() + " actualizado  ");
	}

	@Override
	public List<Pedido> listarPedidosEstado(int id) {
		/*return getSession().createCriteria(Pedido.class)
				.add(Restrictions.eq("estado", id))
				.addOrder(Order.asc("fecha")).list();*/
		Query query = getSession().createQuery("FROM Pedido p WHERE p.estado=:id");
		query.setInteger("id",id);
		return query.list();
	}

}
