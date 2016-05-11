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

import com.hsofttecnologies.domicilios.entities.ItemPedido;
import com.hsofttecnologies.domicilios.services.ItemPedidoService;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

/**
 * @author INTERNET_2
 *
 */
@RestController(value="/api/itenPedido")
public class ItemPedidoController {

@Autowired
ItemPedidoService itemPedidoService;

@RequestMapping(method = RequestMethod.GET)
public List<ItemPedido> listarItemsPedido() {
	return itemPedidoService.listaritemsPedido();
}

@RequestMapping(value="/{id}", method = RequestMethod.GET)
public ItemPedido buscarItemPedidoPorId(int id) {
	return itemPedidoService.buscarPorId(id);
}

@RequestMapping(method = RequestMethod.POST)
public Respuesta agregarItemPedido(@ModelAttribute("itemPedido") ItemPedido itemPedido) {
	itemPedidoService.agregarItemPedido(itemPedido);
	Respuesta respuesta = new Respuesta();
	respuesta.setTipo("Confirmacion");
	respuesta.setMensaje("El Item ha sido agregado correctamente");
	respuesta.setBody(itemPedido);
	return respuesta;
}


@RequestMapping(method = RequestMethod.PUT)
public Respuesta actualizarItemPedido(@ModelAttribute("itemPedido") ItemPedido itemPedido) {
	itemPedidoService.actualizarItemPedido(itemPedido);
	Respuesta respuesta = new Respuesta();
	respuesta.setTipo("Confirmacion");
	respuesta.setMensaje("El Item ha sido actualizado correctamente");
	respuesta.setBody(itemPedido);
	return respuesta;
}
}
