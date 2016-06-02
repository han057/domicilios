/**
 * 
 */
package com.hsofttecnologies.domicilios.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsofttecnologies.domicilios.entities.Pedido;
import com.hsofttecnologies.domicilios.services.PedidoService;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

/**
 * @author Javier cabrera
 *
 */
@RestController
@CrossOrigin
public class PedidoController {

	private static final String url = "/api/pedido";

	@Autowired
	PedidoService pedidoService;

	@RequestMapping(value = url, method = RequestMethod.GET)
	public List<Pedido> listarPedidos() {
		return pedidoService.listarPedidos();
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.GET)
	public Pedido buscarPedidoPorId(@PathVariable("id") int id) {
		return pedidoService.buscarPorId(id);
	}

	@RequestMapping(value = url, method = RequestMethod.POST)
	public Respuesta agregarPedido(@ModelAttribute("pedido") Pedido pedido) {
		pedidoService.agregarPedido(pedido);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El pedido ha sido agregado correctamente");
		respuesta.setBody(pedido);
		return respuesta;
	}

	@RequestMapping(value = url, method = RequestMethod.PUT)
	public Respuesta actualizarPedido(@ModelAttribute("pedido") Pedido pedido) {
		pedidoService.actualizarPedido(pedido);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El pedido ha sido actualizado correctamente");
		respuesta.setBody(pedido);
		return respuesta;
	}
}