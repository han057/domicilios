/**
 * 
 */
package com.hsofttecnologies.domicilios.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsofttecnologies.domicilios.entities.Producto;
import com.hsofttecnologies.domicilios.services.ProductoService;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

/**
 * @author Javier cabrera
 *
 */
@RestController
@CrossOrigin
public class ProductoController {

	private static final String url = "/api/producto";

	@Autowired
	ProductoService productoService;

	
	@RequestMapping(value = url + "/categoria/{id}", method = RequestMethod.GET)
	public List<Producto> listarProductosPorCategoria(@PathVariable("id") int id) {
		return productoService.listarProductosPorCategoria(id);
	}
	
	@RequestMapping(value = url, method = RequestMethod.GET)
	public List<Producto> listarProductos() {
		return productoService.listarProductos();
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.GET)
	public Producto buscarProductoPorId(@PathVariable("id") int id) {
		return productoService.buscarPorId(id);
	}

	@RequestMapping(value = url, method = RequestMethod.POST)
	public Respuesta agregarProducto(@RequestBody Producto producto) {
		productoService.agregarProducto(producto);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El producto ha sido agregado correctamente");
		respuesta.setBody(producto);
		return respuesta;
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.PUT)
	public Respuesta actualizaProducto(@RequestBody Producto producto) {
		productoService.actualizarProducto(producto);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El producto ha sido actualizado correctamente");
		respuesta.setBody(producto);
		return respuesta;
	}
	
	@RequestMapping(value = url + "/estado/{id}", method = RequestMethod.POST)
	public Respuesta cambiarEstadoProducto(@PathVariable int id) {
		productoService.cambiarEstadoProducto(id);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El producto ha sido modificado correctamente");
		return respuesta;
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.DELETE)
	public Respuesta eliminarProducto(@PathVariable("id") int id) {
		productoService.eliminarProducto(id);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("El producto ha sido eliminado correctamente");
		return respuesta;
	}
	
	@RequestMapping(value = url + "/nombre", method = RequestMethod.POST)
	public List<Producto> ListarProductosPorNombre(@RequestParam("nombre") String nombre) {
		return productoService.listarProductosPorNombre(nombre);
	}

}
