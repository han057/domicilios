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
import com.hsofttecnologies.domicilios.dao.RepartidorDao;
import com.hsofttecnologies.domicilios.entities.Repartidor;
import com.hsofttecnologies.domicilios.entities.Usuario;

/**
 * Implementacion usando hibernate de la interfaz de acceso a datos Repartidor
 * @author javier Cabrera
 *
 */
@Repository("RepartidorDoa")
public class RepartidorDaoHibernateIpml extends AbstractDAO<Repartidor> implements RepartidorDao {
	private Logger logger = Logger.getLogger(RepartidorDaoHibernateIpml.class);
	@Autowired SessionFactory session;
	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.RepartidorDao#listarRepartidor()
	 */
	public List<Repartidor> listarRepartidor() {
		logger.debug("Listado de Repartidores   ");
		return list(Repartidor.class);
	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.RepartidorDao#buscarPorId(int)
	 */
	public Repartidor buscarPorId(int id) {
		logger.debug("Busca Repartidor por id: "+id);
		return (Repartidor)getSession().get(Repartidor.class, id);
	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.RepartidorDao#buscarPorNombre(java.lang.String)
	 */
	public Repartidor buscarPorNombre(String nombre) {
		logger.debug("Busca Repartidor por nombre: "+nombre);
		return (Repartidor)getSession().createCriteria(Repartidor.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.RepartidorDao#agregarRepartidor(com.hsofttecnologies.domicilios.entities.Repartidor)
	 */
	public void agregarRepartidor(Repartidor repartidor) {
		logger.debug("Agregando un nuevo repartidor con nombre :"+ repartidor.getNombre() + "...");
		save(repartidor);
		logger.debug("Nuevo repartidor con nombre :" + repartidor.getNombre()
				+ " creado!");

	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.RepartidorDao#actualizarRepartidor(com.hsofttecnologies.domicilios.entities.Repartidor)
	 */
	public void actualizarRepartidor(Repartidor repartidor) {
		logger.debug("Actualizando repartidor con id: " + repartidor.getId());
		getSession().update(repartidor);
		logger.debug("Repartidor con id: " + repartidor.getId() + " actualizada!");

	}

}
