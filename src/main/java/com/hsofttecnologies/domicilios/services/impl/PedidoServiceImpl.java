package com.hsofttecnologies.domicilios.services.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsofttecnologies.domicilios.dao.PedidoDao;
import com.hsofttecnologies.domicilios.dao.ProductoDao;
import com.hsofttecnologies.domicilios.entities.ItemPedido;
import com.hsofttecnologies.domicilios.entities.Pedido;
import com.hsofttecnologies.domicilios.entities.Repartidor;
import com.hsofttecnologies.domicilios.exception.EmptyCollectionException;
import com.hsofttecnologies.domicilios.exception.ObjectNotFoundException;
import com.hsofttecnologies.domicilios.exception.ValueNotPermittedException;
import com.hsofttecnologies.domicilios.services.PedidoService;
import com.hsofttecnologies.domicilios.services.RepartidorService;

@Service("pedidoService")
@Transactional
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoDao pedidoDao;

	@Autowired
	ProductoDao productoDao;

	@Autowired
	RepartidorService repartidorService;

	public List<Pedido> listarPedidos() {
		List<Pedido> pedidos = pedidoDao.listarPedidos();
		for (Pedido p : pedidos) {
			p.getDetalle();
		}
		return pedidos;
	}

	public Pedido buscarPorId(int id) {
		Pedido pedido = pedidoDao.buscarPorId(id);
		if (pedido == null) {
			throw new ObjectNotFoundException("Pedido con id:" + id + " no encontrado ");
		}
		return pedido;
	}

	public void agregarPedido(Pedido pedido) {
		if (pedido.getDetalle() == null || pedido.getDetalle().size() == 0) {
			throw new EmptyCollectionException("El pedido no cuenta con productos");
		} else {
			pedido.setEstado(1);
			pedido.setFecha(new Date());
			for (ItemPedido ip : pedido.getDetalle()) {
				ip.setValor(productoDao.buscarPorId(ip.getProducto().getId()).getValor() * ip.getCantidad());
				ip.setPedido(pedido);
			}
			pedidoDao.agregarPedido(pedido);
			pedido = pedidoDao.buscarPorId(pedido.getId());
		}
	}

	public void actualizarPedido(Pedido pedido) {
		pedidoDao.actualizarPedido(pedido);

	}

	@Override
	public List<Pedido> listarPedidosEstado(int id) {
		return pedidoDao.listarPedidosEstado(id);
	}

	@Override
	public void confirmarPedido(int pedido, int repartidor) {
		Pedido p = buscarPorId(pedido);
		Repartidor r = repartidorService.buscarPorId(repartidor);
		p.setRepartidor(r);
		p.setEstado(2);
		pedidoDao.actualizarPedido(p);
	}

	@Override
	public void enviarPedido(int pedido) {
		Pedido p = buscarPorId(pedido);
		p.setEstado(3);
		pedidoDao.actualizarPedido(p);

	}

	@Override
	public void entregaPedido(int pedido, int estado) {
		if (estado != 4 && estado != 5) {
			throw new ValueNotPermittedException("El estado solo puede ser entregado (4) o no entregado (5)");
		}
		Pedido p = buscarPorId(pedido);
		p.setEstado(estado);
		pedidoDao.actualizarPedido(p);
	}

}
