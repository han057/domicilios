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
import com.hsofttecnologies.domicilios.dao.ItemPedidoDao;
import com.hsofttecnologies.domicilios.entities.ItemPedido;
import com.hsofttecnologies.domicilios.entities.Pedido;
@Transactional
public class ItemPedidoDaoHibernateImplTest  extends JUnitSpringDaoServiceTestBase {
	@Autowired
	ItemPedidoDao itemPedidoDao;
	
	@Before
	public void setUp() throws Exception {
		testAgregarItemPedido();
	}

	@Test
	public void testListarItemPedidos() {
		List<ItemPedido> itemPedidos = itemPedidoDao.listarItemsPedido();
		assertTrue(itemPedidos.size() > 0);
	}

	@Test
	public void testBuscarPorId() {
		assertNotNull("pedido no encontradao", itemPedidoDao.buscarPorId(7));
		assertNull("pedido encontrado", itemPedidoDao.buscarPorId(1000));
	}

	@Test
	public void testAgregarItemPedido() {
		ItemPedido itemPedido= new ItemPedido();
//		itemPedido.setClienteNombre("javier ");
		itemPedidoDao.agregarItemPedido(itemPedido);
	}

	@Test 
	public void testActualizarPedido() {
		String nuevoNombre = "Nuevo nombre";

		ItemPedido itempedido = itemPedidoDao.buscarPorId(7);
		itempedido.getPedido().setClienteNombre(nuevoNombre);

		itemPedidoDao.actualizarItemPedido(itempedido);
		ItemPedido ip2 = itemPedidoDao.buscarPorId(7);
		assertEquals(nuevoNombre, ip2.getPedido().getClienteNombre());
	}

	@Test
	public void testBuscarPorNombre() {
		assertNotNull(itemPedidoDao.buscarPorNombre("Nuevo"));
	}
}
