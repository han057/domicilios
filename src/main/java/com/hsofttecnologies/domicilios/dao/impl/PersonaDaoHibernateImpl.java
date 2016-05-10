/**
 * 
 */
package com.hsofttecnologies.domicilios.dao.impl;

import java.util.List;

import javax.jms.Session;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsofttecnologies.domicilios.dao.AbstractDAO;
import com.hsofttecnologies.domicilios.dao.PersonaDao;
import com.hsofttecnologies.domicilios.entities.Categoria;
import com.hsofttecnologies.domicilios.entities.Persona;

/**
 * @author Javier cabrera
 *
 */
@Repository("PersonaDao")
public class PersonaDaoHibernateImpl  extends AbstractDAO<Persona> implements PersonaDao{
	private Logger logger = Logger.getLogger(PersonaDaoHibernateImpl.class);
	@Autowired
	SessionFactory session;
	public List<Persona> listarPersonas() {
		logger.debug("Listado de Personas.. ");
		return list(Persona.class);
	}

	public Persona buscarPorId(int id) {
		logger.debug("Busca una persona por su id: "+id);
		return (Persona)getSession().get(Persona.class, id);
	}

	public Persona buscarPorNombre(String nombre) {
		logger.debug("Buscar la persona por Nombre: "+nombre);
		return (Persona) getSession().createCriteria(Persona.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
	}

	public void agregarPersona(Persona persona) {
		logger.debug("Agregar una Nueva persona con Nombre: "+persona.getNombre()+" ....");
		save(persona);
		logger.debug("Agregar una Nueva persona con Nombre: "+persona.getNombre()+" agregado ....");
	}

	public void actualizarPersona(Persona persona) {
		logger.debug("actualizar una Nueva persona con Nombre: "+persona.getNombre()+" ....");
		getSession().update(persona);
		logger.debug("actualizo una Nueva persona con Nombre: "+persona.getNombre()+" ....");
		
	}

	public Persona buscarPorIdentificacion(String identificacion) {
		logger.debug("Buscar la persona por Documento de identificacion: "+identificacion);
		return (Persona) getSession().createCriteria(Persona.class).add(Restrictions.eq("identificacion", identificacion)).uniqueResult();
	}

}
