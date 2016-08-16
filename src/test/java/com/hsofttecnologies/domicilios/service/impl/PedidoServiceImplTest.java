package com.hsofttecnologies.domicilios.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hsofttecnologies.domicilios.JUnitSpringDaoServiceTestBase;
import com.hsofttecnologies.domicilios.entities.Pedido;
import com.hsofttecnologies.domicilios.services.PedidoService;

public class PedidoServiceImplTest extends JUnitSpringDaoServiceTestBase {

	@Autowired
	PedidoService pedidoService;
	
	@Test
	public void testListarPedidos() {
		List<Pedido> pedidos = pedidoService.listarPedidos();
		assertTrue(pedidos.size()>0);
	}

	@Test
	public void testBuscarPorId() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregarPedido() {
		fail("Not yet implemented");
	}

	@Test
	public void testActualizarPedido() {
		fail("Not yet implemented");
	}

	@Test
	public void testListarPedidosEstado() {
		fail("Not yet implemented");
	}

	@Test
	public void testConfirmarPedido() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnviarPedido() {
		fail("Not yet implemented");
	}

	@Test
	public void testEntregaPedido() {
		fail("Not yet implemented");
	}

	@Test
	public void testCancelarPedido() {
		fail("Not yet implemented");
	}

	@Test
	public void testAgregarItemPedido() {
		fail("Not yet implemented");
	}

}
