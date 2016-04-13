package com.hsofttecnologies.domicilios.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hsofttecnologies.domicilios.JUnitSpringDaoServiceTestBase;
import com.hsofttecnologies.domicilios.dao.CategoriaDao;
import com.hsofttecnologies.domicilios.entities.Categoria;

@Transactional
public class CategoriaDaoHibernateImplTest extends
		JUnitSpringDaoServiceTestBase {

	@Autowired
	CategoriaDao categoriaDao;

	@Before
	public void setUp() throws Exception {
		testAgregarCategoria();
	}

	@Test
	public void testListarCategorias() {
		List<Categoria> categorias = categoriaDao.listarCategorias();
		assertTrue(categorias.size() > 0);
	}

	@Test
	public void testBuscarPorId() {
		assertNotNull("Categoría no encontrada", categoriaDao.buscarPorId(7));
		assertNull("Categoría encontrada", categoriaDao.buscarPorId(1000));
	}

	@Test
	public void testAgregarCategoria() {
		Categoria categoria = new Categoria();
		categoria.setNombre("Hamburguesas 1");
		categoriaDao.agregarCategoria(categoria);
	}

	@Test
	public void testActualizarCategoria() {
		String nuevoNombre = "Nuevo nombre";

		Categoria categoria = categoriaDao.buscarPorId(7);
		categoria.setNombre(nuevoNombre);

		categoriaDao.actualizarCategoria(categoria);
		Categoria c2 = categoriaDao.buscarPorId(7);
		assertEquals(nuevoNombre, c2.getNombre());
	}

	@Test
	public void testBuscarPorNombre() {
		assertNotNull(categoriaDao.buscarPorNombre("Nuevo"));
	}

}
