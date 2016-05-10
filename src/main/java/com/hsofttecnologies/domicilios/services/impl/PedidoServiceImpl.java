package com.hsofttecnologies.domicilios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsofttecnologies.domicilios.dao.PedidoDao;
import com.hsofttecnologies.domicilios.entities.Pedido;
import com.hsofttecnologies.domicilios.exception.ObjectNotFoundException;
import com.hsofttecnologies.domicilios.services.PedidoService;
@Service("pedidoService")
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	PedidoDao pedidoDao;
	public List<Pedido> listarPedidos() {
		return pedidoDao.listarPedidos();
	}

	public Pedido buscarPorId(int id) {
		Pedido pedido=pedidoDao.buscarPorId(id);
		if(pedido==null){
			throw new ObjectNotFoundException("Pedido con id:"+id+" no encontrado ");
		}
		return pedido;
	}

	public void agregarPedido(Pedido pedido) {
		pedidoDao.agregarPedido(pedido);

	}

	public void actualizarPedido(Pedido pedido) {
		pedidoDao.actualizarPedido(pedido);

	}

}
