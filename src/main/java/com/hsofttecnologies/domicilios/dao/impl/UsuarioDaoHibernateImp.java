/**
 * 
 */
package com.hsofttecnologies.domicilios.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.hsofttecnologies.domicilios.dao.AbstractDAO;
import com.hsofttecnologies.domicilios.dao.UsuarioDao;
import com.hsofttecnologies.domicilios.entities.Usuario;

/**
 * @author javier cabrera
 * @version 1.0
 *
 */
@Repository("UsuarioDao")
public class UsuarioDaoHibernateImp extends AbstractDAO<Usuario> implements UsuarioDao {
	private Logger logger = Logger.getLogger(UsuarioDaoHibernateImp.class);
	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.UsuarioDao#listarUsuarios()
	 */
	public List<Usuario> listarUsuarios() {
		logger.debug("Listado de usuarios ");
		return list(Usuario.class);
	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.UsuarioDao#buscarPorId(int)
	 */
	public Usuario buscarPorId(int id) {
		logger.debug("Busca un usuario por el id: "+id);
		return (Usuario) getSession().get(Usuario.class, id);
	}
	
	

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.UsuarioDao#buscarPorNombre(java.lang.String)
	 */
	public Usuario buscarPorNombre(String nombre) {
		logger.debug("Busca un usuario por el nombre: "+nombre);
		return (Usuario)getSession().createCriteria(Usuario.class).add(Restrictions.eq("nombre", nombre)).uniqueResult();
	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.UsuarioDao#agregarUsuario(com.hsofttecnologies.domicilios.entities.Usuario)
	 */
	public void agregarUsuario(Usuario usuario) {
		logger.debug("Agrega un nuevo usuario con nombre :"+usuario.getNombre()+".... ");
		save(usuario);
		logger.debug("Agrega un nuevo usuario con nombre :"+usuario.getNombre()+"creada ");

	}

	/* (non-Javadoc)
	 * @see com.hsofttecnologies.domicilios.dao.UsuarioDao#actualizarUsuario(com.hsofttecnologies.domicilios.entities.Usuario)
	 */
	public void actualizarUsuario(Usuario usuario) {
		logger.debug("actualiza un usuario con nombre :"+usuario.getNombre()+".... ");
	getSession().update(usuario);
		logger.debug("Actualiza un usuario con nombre :"+usuario.getNombre()+" actualizado ");


	}

	public Usuario buscarPorEmail(String email) {
		logger.debug("Busca un usuario por el nombre: "+email);
		return (Usuario)getSession().createCriteria(Usuario.class).add(Restrictions.eq("email", email)).uniqueResult();
	}

	

}
