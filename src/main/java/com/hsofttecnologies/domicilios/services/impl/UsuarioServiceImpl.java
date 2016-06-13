/**
 * 
 */
package com.hsofttecnologies.domicilios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hsofttecnologies.domicilios.dao.UsuarioDao;
import com.hsofttecnologies.domicilios.entities.Usuario;
import com.hsofttecnologies.domicilios.exception.ObjectAlreadyExistException;
import com.hsofttecnologies.domicilios.exception.ObjectNotFoundException;
import com.hsofttecnologies.domicilios.services.UsuarioService;

/**
 * @author javier cabrera
 *
 */
@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsofttecnologies.domicilios.services.UsuarioService#listarUsuarios()
	 */
	public List<Usuario> listarUsuarios() {

		return usuarioDao.listarUsuarios();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsofttecnologies.domicilios.services.UsuarioService#buscarPorId(int)
	 */
	public Usuario buscarPorId(int id) {
		Usuario usuario = usuarioDao.buscarPorId(id);
		if (usuario == null) {
			throw new ObjectNotFoundException("Usuario con id: " + id + " no encotrado");
		}
		return usuario;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsofttecnologies.domicilios.services.UsuarioService#agregarUsuario(
	 * com.hsofttecnologies.domicilios.entities.Usuario)
	 */
	public void agregarUsuario(Usuario usuario) {
		Usuario usuariotem = usuarioDao.buscarPorEmail(usuario.getEmail());
		if (usuariotem == null) {
			usuarioDao.agregarUsuario(usuario);
		} else {
			throw new ObjectAlreadyExistException("Usuario con id: " + usuario.getEmail() + " no encotrado");
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hsofttecnologies.domicilios.services.UsuarioService#actualizarUsuario
	 * (com.hsofttecnologies.domicilios.entities.Usuario)
	 */
	public void actualizarUsuario(Usuario usuario) {
		Usuario usuariotem = usuarioDao.buscarPorId(usuario.getId());
		if (usuariotem != null) {
			usuarioDao.actualizarUsuario(usuario);
		} else {
			throw new ObjectAlreadyExistException("Usuario con id: " + usuario.getEmail() + " no actualizado");
		}

	}

}
