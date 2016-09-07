/**
 * 
 */
package com.hsofttecnologies.domicilios.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
@RestController
@CrossOrigin
public class RepartidorController {

	private static final String url = "/api/repartidor";

	@Autowired
	RepartidorService repartidorService;

	@RequestMapping(value = url, method = RequestMethod.GET)
	public List<Repartidor> listarRepartidores() {
		return repartidorService.listarRepartidores();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Repartidor buscarRepartidorPorId(@PathVariable("id") int id) {
		return repartidorService.buscarPorId(id);
	}

	@RequestMapping(value = url, method = RequestMethod.POST)
	public Respuesta agregarRepartidor(@RequestBody Repartidor repartidor) {
		repartidorService.agregarRepartidor(repartidor);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El repartidor ha sido agregado correctamente");
		respuesta.setBody(repartidor);
		return respuesta;
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.PUT)
	public Respuesta actualizarRepartidor(@RequestBody Repartidor repartidor) {
		repartidorService.actualizarRepartidor(repartidor);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El repartidor ha sido Actualizado correctamente");
		respuesta.setBody(repartidor);
		return respuesta;
	}
	
	@RequestMapping(value = url + "/estado/{id}", method = RequestMethod.POST)
	public Respuesta cambiarEstadoRepartidor(@PathVariable int id) {
		repartidorService.cambiarEstadoRepartidor(id);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("La información del repartidor ha sido modificada correctamente");
		return respuesta;
	}
}