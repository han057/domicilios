package com.hsofttecnologies.domicilios.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsofttecnologies.domicilios.dao.AbstractDAO;
import com.hsofttecnologies.domicilios.dao.ProductoDao;
import com.hsofttecnologies.domicilios.entities.Producto;

@Repository("ProductoDao")
public class ProductoDaoHibernateImpl extends AbstractDAO<Producto> implements ProductoDao {
	private Logger logger = Logger.getLogger(ProductoDaoHibernateImpl.class);

	@Autowired
	SessionFactory session;

	public List<Producto> listarProductos() {
		logger.debug("Listado de Productos....  ");
		Criteria criteria = getSession().createCriteria(Producto.class);
		criteria.addOrder(Order.asc("id"));
		return criteria.list();
	}

	public Producto buscarPorId(int id) {
		logger.debug("Buscar un nuevo producto pos id: " + id);
		return (Producto) getSession().get(Producto.class, id);
	}

	public Producto buscarPorNombre(String nombre) {
		logger.debug("Buscar nuevo producto por Nombre: " + nombre);
		return (Producto) getSession().createCriteria(Producto.class).add(Restrictions.eqOrIsNull("nombre", nombre))
				.uniqueResult();
	}

	public void agregarProducto(Producto producto) {
		logger.debug("Agregar nuevo producto con nombre :" + producto.getNombre() + ".. ");
		save(producto);
		logger.debug("Agregar nuevo producto con nombre :" + producto.getNombre() + " creada");
	}

	public void actualizarProducto(Producto producto) {
		logger.debug("Actualizando producto con id: " + producto.getId());
		getSession().update(producto);
		logger.debug("Actualizando producto con id: " + producto.getId());

	}

	@Override
	public List<Producto> listarProductosPorCategoria(int categoria) {
		logger.debug("Listar productos por categoria: " + categoria);
		Query query = getSession().createQuery("FROM Producto p WHERE p.categoria.id=:id AND p.activo=true ORDER BY p.id ASC");
		query.setInteger("id", categoria);
		return query.list();
	}

}
