package com.hsofttecnologies.domicilios.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Abstract class works like base for Dao implementations
 * 
 * @author Han057
 *
 * @param <T>
 *            Clase de objeto a ser listado o buscado
 */

public abstract class AbstractDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;

	Class<T> t;

	/**
	 * Get the current session to the repository (database)
	 * 
	 * @return Current session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Persist the object given
	 * 
	 * @param entity
	 *            - Object to persist
	 */
	public void save(Object entity) {
		getSession().save(entity);
	}

	/**
	 * Delete the object given
	 * 
	 * @param entity
	 *            - Object to delete
	 */
	public void delete(Object entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	protected T buscar(Query query) {
		List<T> list = query.list();
		return list.isEmpty() ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	protected List<T> buscarLista(Query query) {
		List<T> list = query.list();
		return (list.isEmpty() ? null : list);
	}

	@SuppressWarnings("unchecked")
	protected List<T> list(Class clazz) {
		return getSession().createCriteria(clazz).list();
	}

	protected List<T> list(Class clazz, int start, int end) {
		Criteria criteria = getSession().createCriteria(clazz);
		criteria.setFirstResult(start);
		criteria.setMaxResults(end);
		return criteria.list();
	}

	public void setSession(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}