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
import com.hsofttecnologies.domicilios.dao.PedidoDao;
import com.hsofttecnologies.domicilios.entities.Pedido;

@Transactional
public class PedidoDaoHibernateImplTest extends JUnitSpringDaoServiceTestBase {

	@Autowired
	PedidoDao pedidoDao;

	@Before
	public void setUp() throws Exception {
		testAgregarPedido();
	}

	@Test
	public void testListarPedidos() {
		List<Pedido> pedidos = pedidoDao.listarPedidos();
		assertTrue(pedidos.size() > 0);
	}

	@Test
	public void testBuscarPorId() {
		assertNotNull("pedido no encontradao", pedidoDao.buscarPorId(31));
		assertNull("pedido encontrado", pedidoDao.buscarPorId(32));
	}

	@Test
	public void testAgregarPedido() {
		Pedido pedido= new Pedido();
		pedido.setClienteNombre("javier ");
		pedidoDao.agregarPedido(pedido);
	}

	@Test 
	public void testActualizarPedido() {
		String nuevoNombre = " nombre";

		Pedido pedido = pedidoDao.buscarPorId(31);
		pedido.setClienteNombre(nuevoNombre);

		pedidoDao.actualizarPedido(pedido);
		Pedido p2 = pedidoDao.buscarPorId(31);
		assertEquals(nuevoNombre, p2.getClienteNombre());
	}

	@Test
	public void testBuscarPorNombre() {
		assertNotNull(pedidoDao.buscarPorNombre("Nuevo"));
	}

}
