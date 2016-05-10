/**
 * 
 */
package com.hsofttecnologies.domicilios.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RestController(value="/api/pedido")
public class PedidoController {

@Autowired
PedidoService pedidoService;

@RequestMapping(method = RequestMethod.GET)
public List<Pedido> listarPedidos() {
	return pedidoService.listarPedidos();
}

@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Pedido buscarPedidoPorId(int id) {
	return pedidoService.buscarPorId(id);
}

@RequestMapping(method = RequestMethod.POST)
public Respuesta agregarPedido(@ModelAttribute("pedido") Pedido pedido) {
	pedidoService.agregarPedido(pedido);
	Respuesta respuesta = new Respuesta();
	respuesta.setTipo("Confirmacion");
	respuesta.setMensaje("El pedido ha sido agregado correctamente");
	respuesta.setBody(pedido);
	return respuesta;
}

@RequestMapping(method = RequestMethod.PUT)
public Respuesta actualizarPedido(@ModelAttribute("pedido") Pedido pedido) {
	pedidoService.actualizarPedido(pedido);
	Respuesta respuesta = new Respuesta();
	respuesta.setTipo("Confirmacion");
	respuesta.setMensaje("El pedido ha sido actualizado correctamente");
	respuesta.setBody(pedido);
	return respuesta;
}
}