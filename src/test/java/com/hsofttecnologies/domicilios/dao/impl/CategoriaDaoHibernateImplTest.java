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
		Categoria categoria = new Categoria();
		categoria.setId(1);
		categoria.setNombre("Hamburguesas");
		categoriaDao.agregarCategoria(categoria);
	}

	@Test
	public void testListarCategorias() {
		List<Categoria> categorias = categoriaDao.listarCategorias();
		assertTrue(categorias.size() > 0);
	}

	@Test
	public void testBuscarPorId() {
		System.out.println(categoriaDao.buscarPorId(2));
		assertNotNull("Categoría no encontrada", categoriaDao.buscarPorId(2));
		assertNull("Categoría encontrada", categoriaDao.buscarPorId(1000));
	}

	@Test
	public void testAgregarCategoria() {
		Categoria categoria = new Categoria();
		categoria.setNombre("Hamburguesas 2");
		categoriaDao.agregarCategoria(categoria);
	}

	@Test
	public void testActualizarCategoria() {
		String nuevoNombre = "Nuevo nombre";
		
		Categoria categoria = categoriaDao.buscarPorId(2);
		categoria.setNombre(nuevoNombre);
		
		categoriaDao.actualizarCategoria(categoria);
		Categoria c2 = categoriaDao.buscarPorId(1);
		assertEquals(nuevoNombre,  c2.getNombre());
	}

	@Test
	public void testBuscarPorNombre() {
		assertNotNull(categoriaDao.buscarPorNombre("Hamburguesas"));
	}

}
