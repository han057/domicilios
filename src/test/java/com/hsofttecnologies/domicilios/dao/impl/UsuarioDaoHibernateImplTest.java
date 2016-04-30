package com.hsofttecnologies.domicilios.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hsofttecnologies.domicilios.JUnitSpringDaoServiceTestBase;
import com.hsofttecnologies.domicilios.dao.UsuarioDao;
import com.hsofttecnologies.domicilios.entities.Usuario;
@Transactional
public class UsuarioDaoHibernateImplTest extends JUnitSpringDaoServiceTestBase {

	@Autowired
	UsuarioDao usuarioDao;

	@Before
	public void setUp() throws Exception {
		testAgregarUsuario();
	}

	@Test
	public void testListarUsuario() {
		List<Usuario> usuarios = usuarioDao.listarUsuarios();
		assertTrue(usuarios.size() > 0);
	}

	@Test
	public void testBuscarPorId() {
		assertNotNull("usuario no encontradao", usuarioDao.buscarPorId(7));
		assertNull("usuario encontrado", usuarioDao.buscarPorId(1000));
	}

	@Test
	public void testAgregarUsuario() {
		Usuario usuario= new Usuario();
		usuario.setNombre("javier ");
		usuarioDao.agregarUsuario(usuario);
	}

	@Test 
	public void testActualizarUsuario() {
		String nuevoNombre = "nombre";

		Usuario usuario = usuarioDao.buscarPorId(31);
		usuario.setNombre(nuevoNombre);

		usuarioDao.actualizarUsuario(usuario);
		Usuario u2 = usuarioDao.buscarPorId(31);
		assertEquals(nuevoNombre, u2.getNombre());
	}

	@Test
	public void testBuscarPorNombre() {
		assertNotNull(usuarioDao.buscarPorNombre("Nuevo"));
	}
}
