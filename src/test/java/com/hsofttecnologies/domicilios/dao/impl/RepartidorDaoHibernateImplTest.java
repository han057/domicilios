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
import com.hsofttecnologies.domicilios.dao.RepartidorDao;
import com.hsofttecnologies.domicilios.entities.Pedido;
import com.hsofttecnologies.domicilios.entities.Repartidor;
@Transactional
public class RepartidorDaoHibernateImplTest extends JUnitSpringDaoServiceTestBase {
	@Autowired
	RepartidorDao repartidorDao;
	
	@Before
	public void setUp() throws Exception{
		testAgregarRepartidor();
	}

	@Test
	public void testListarRepartidor() {
		List<Repartidor> repartidores = repartidorDao.listarRepartidor();
		assertTrue(repartidores.size() > 0);
	}

	@Test
	public void testBuscarPorId() {
		assertNotNull("pedido no encontradao", repartidorDao.buscarPorId(7));
		assertNull("pedido encontrado", repartidorDao.buscarPorId(1000));
	}

	@Test
	public void testAgregarRepartidor() {
		Repartidor repartidor= new Repartidor();
		repartidor.setNombre("javier ");
		repartidorDao.agregarRepartidor(repartidor);
	}

	@Test 
	public void testActualizarRepartidor() {
		String nuevoNombre = "CARLOS";

		Repartidor repartidor = repartidorDao.buscarPorId(7);
		repartidor.setNombre(nuevoNombre);

		repartidorDao.actualizarRepartidor(repartidor);
		Repartidor r2 = repartidorDao.buscarPorId(7);
		assertEquals(nuevoNombre, r2.getNombre());
	}

	@Test
	public void testBuscarPorNombre() {
		assertNotNull(repartidorDao.buscarPorNombre("Nuevo"));
	}
}
