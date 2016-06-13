/**
 * 
 */
package com.hsofttecnologies.domicilios.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsofttecnologies.domicilios.entities.Greeting;
import com.hsofttecnologies.domicilios.entities.HelloModel;
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
	private SimpMessagingTemplate template;

	@Autowired
	PedidoService pedidoService;

	@RequestMapping(value = url, method = RequestMethod.GET)
	public List<Pedido> listarPedidos(@RequestParam("estado") Integer estado) {
		System.out.println(estado);
		List<Pedido> pedidos = estado == null ? pedidoService.listarPedidos()
				: pedidoService.listarPedidosEstado(estado);
		return pedidos;
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.GET)
	public Pedido buscarPedidoPorId(@PathVariable("id") int id) {
		return pedidoService.buscarPorId(id);
	}

	@RequestMapping(value = url, method = RequestMethod.POST)
	public Respuesta agregarPedido(@RequestBody Pedido pedido) {
		pedidoService.agregarPedido(pedido);
		template.convertAndSend("/topic/pedidos", pedido);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El pedido ha sido agregado correctamente");
		respuesta.setBody(pedido);
		return respuesta;
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.PUT)
	public Respuesta actualizarPedido(@RequestBody Pedido pedido) {
		pedidoService.actualizarPedido(pedido);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El pedido ha sido actualizado correctamente");
		respuesta.setBody(pedido);
		return respuesta;
	}

	@RequestMapping(value = url + "/confirmar/{id}", method = RequestMethod.PUT)
	public Respuesta confirmarPedido(@PathVariable("id") int pedido, @RequestParam("repartidor") int repartidor) {
		pedidoService.confirmarPedido(pedido, repartidor);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El pedido ha sido actualizado correctamente");
		respuesta.setBody(pedido);
		return respuesta;
	}
	
	@RequestMapping(value = url + "/enviar/{id}", method = RequestMethod.POST)
	public Respuesta enviarPedido(@PathVariable("id") int pedido) {
		pedidoService.enviarPedido(pedido);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El pedido ha sido actualizado correctamente");
		respuesta.setBody(pedido);
		return respuesta;
	}
	
	@RequestMapping(value = url + "/entrega/{id}", method = RequestMethod.POST)
	public Respuesta pedidoEntregado(@PathVariable("id") int pedido, @RequestParam("entregado") int entregado) {
		pedidoService.entregaPedido(pedido, entregado);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El pedido ha sido actualizado correctamente");
		respuesta.setBody(pedido);
		return respuesta;
	}

	@MessageMapping("/pedidos")
	@SendTo("/topic/pedidos")
	public Greeting greeting(HelloModel message) throws Exception {
		return new Greeting(message.getId(), message.getName());
	}
}