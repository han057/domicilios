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

import com.hsofttecnologies.domicilios.entities.Categoria;
import com.hsofttecnologies.domicilios.services.CategoriaService;
import com.hsofttecnologies.domicilios.web.dto.Respuesta;

/**
 * @author Javier cabrera
 *
 */

@RestController
@CrossOrigin
public class CategoriaController {

	private static final String url = "/api/categoria";

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = url, method = RequestMethod.GET)
	public List<Categoria> listarCategoria() {
		return categoriaService.listarCategorias();
	}

	@RequestMapping(value = url + "/{id}", method = RequestMethod.GET)
	public Categoria buscarCategoriaPor_Id(@PathVariable("id") int id) {
		return categoriaService.buscarPorId(id);

	}

	@RequestMapping(value = url, method = RequestMethod.POST)
	public Respuesta agregarCategoria(@ModelAttribute("categoria") Categoria categoria) {
		categoriaService.agregarCategoria(categoria);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("la Categoria ha sido agregada correctamente");
		respuesta.setBody(categoria);
		return respuesta;
	}

	@RequestMapping(value = url, method = RequestMethod.PUT)
	public Respuesta actualizarCategoria(@ModelAttribute("categoria") Categoria categoria) {
		categoriaService.actualizarCategoria(categoria);
		Respuesta respuesta = new Respuesta();
		respuesta.setTipo("Confirmacion");
		respuesta.setMensaje("la Categoria ha sido Actualizada correctamente");
		respuesta.setBody(categoria);
		return respuesta;
	}

}
