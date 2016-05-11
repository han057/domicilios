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

import com.hsofttecnologies.domicilios.entities.Producto;
import com.hsofttecnologies.domicilios.services.ProductoService;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

/**
 * @author Javier cabrera
 *
 */
@RestController(value="/api/producto")
public class ProductoController {
	

	@Autowired
	ProductoService productoService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Producto> listarProductos() {
		return productoService.listarProductos();
	}
	
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public Producto buscarProductoPorId(int id) {
		return productoService.buscarPorId(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Respuesta agregarProducto(@ModelAttribute("producto") Producto producto) {
		productoService.agregarProducto(producto);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El producto ha sido agregado correctamente");
		respuesta.setBody(producto);
		return respuesta;
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	public Respuesta actualizaProducto(@ModelAttribute("producto") Producto producto) {
		productoService.actualizarProducto(producto);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El producto ha sido Actualizado correctamente");
		respuesta.setBody(producto);
		return respuesta;
	}
	
}
