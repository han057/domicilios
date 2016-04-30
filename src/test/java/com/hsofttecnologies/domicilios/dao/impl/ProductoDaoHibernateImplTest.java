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
import com.hsofttecnologies.domicilios.dao.ProductoDao;
import com.hsofttecnologies.domicilios.entities.Producto;
@Transactional
public class ProductoDaoHibernateImplTest extends JUnitSpringDaoServiceTestBase {

	@Autowired
	ProductoDao productoDao;

	@Before
	public void setUp() throws Exception {
		testAgregarProducto();
	}

	@Test
	public void testListarProductos() {
		List<Producto> productos = productoDao.listarProductos();
		assertTrue(productos.size() > 0);
	}

	@Test
	public void testBuscarPorId() {
		assertNotNull("Producto no encontrado", productoDao.buscarPorId(1));
		assertNull("Categoría encontrada", productoDao.buscarPorId(1000));
	}

	@Test
	public void testAgregarProducto() {
		Producto producto = new Producto();
		producto.setNombre("Hamburguesas 1");
		productoDao.agregarProducto(producto);
	}

	@Test 
	public void testActualizarProducto() {
		String nuevoNombre = "Nuevo nombre";

		Producto producto = productoDao.buscarPorId(7);
		producto.setNombre(nuevoNombre);

		productoDao.actualizarProducto(producto);
		Producto p2 = productoDao.buscarPorId(7);
		assertEquals(nuevoNombre, p2.getNombre());
	}

	@Test
	public void testBuscarPorNombre() {
		assertNotNull(productoDao.buscarPorNombre("Nuevo"));
	}

}

