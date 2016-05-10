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

import com.hsofttecnologies.domicilios.entities.Repartidor;
import com.hsofttecnologies.domicilios.services.RepartidorService;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

/**
 * @author INTERNET_2
 *
 */
@RestController(value="/apo/repartidor")
public class RepartidorController {

@Autowired
RepartidorService repartidorService;

@RequestMapping(method = RequestMethod.GET)
public List<Repartidor> listarRepartidores() {
	return repartidorService.listarRepartidores();
}

@RequestMapping(value="/{id}", method = RequestMethod.GET)
public Repartidor buscarRepartidorPorId(int id) {
	return repartidorService.buscarPorId(id);
}

@RequestMapping(method = RequestMethod.POST)
public Respuesta agregarRepartidor(@ModelAttribute("repartidor") Repartidor repartidor) {
	repartidorService.agregarRepartidor(repartidor);
	Respuesta respuesta = new Respuesta();
	respuesta.setTipo("Confirmacion");
	respuesta.setMensaje("El repartidor ha sido agregado correctamente");
	respuesta.setBody(repartidor);
	return respuesta;
}

@RequestMapping(method = RequestMethod.PUT)
public Respuesta actualizarRepartidor(@ModelAttribute("repartidor") Repartidor repartidor) {
	repartidorService.actualizarCategoria(repartidor);
	Respuesta respuesta = new Respuesta();
	respuesta.setTipo("Confirmacion");
	respuesta.setMensaje("El repartidor ha sido Actualizado correctamente");
	respuesta.setBody(repartidor);
	return respuesta;
}
}