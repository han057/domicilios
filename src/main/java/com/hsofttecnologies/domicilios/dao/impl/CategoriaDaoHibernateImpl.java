/**
 * 
 */
package com.hsofttecnologies.domicilios.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsofttecnologies.domicilios.dao.AbstractDAO;
import com.hsofttecnologies.domicilios.dao.CategoriaDao;
import com.hsofttecnologies.domicilios.entities.Categoria;

/**
 * Implemetación usando hibernate de la interfaz de acceso a datos categoría
 * 
 * @author han
 *
 */
@Repository("categoriaDao")
public class CategoriaDaoHibernateImpl extends AbstractDAO<Categoria> implements
		CategoriaDao {

	private Logger logger = Logger.getLogger(CategoriaDaoHibernateImpl.class);

	@Autowired
	SessionFactory session;

	public List<Categoria> listarCategorias() {
		logger.debug("Listando categorias...");
		return list(Categoria.class);
	}

	public Categoria buscarPorId(int id) {
		logger.debug("Buscando categoria con id: " + id);
		return (Categoria) getSession().get(Categoria.class, id);
	}

	public void agregarCategoria(Categoria categoria) {
		logger.debug("Agregando nueva categoría con nombre :"+ categoria.getNombre() + "...");
		save(categoria);
		logger.debug("Nueva categoría con nombre :" + categoria.getNombre()
				+ " creada!");
	}

	public void actualizarCategoria(Categoria categoria) {
		logger.debug("Actualizando categoria con id: " + categoria.getId());
		getSession().update(categoria);
		logger.debug("Categoria con id: " + categoria.getId() + " actualizada!");
	}

	public Categoria buscarPorNombre(String nombre) {
		logger.debug("Buscando categoria con nombre: " + nombre);
		return (Categoria) getSession().createCriteria(Categoria.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
	}

}
