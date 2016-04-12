package com.hsofttecnologies.domicilios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsofttecnologies.domicilios.dao.CategoriaDao;
import com.hsofttecnologies.domicilios.entities.Categoria;
import com.hsofttecnologies.domicilios.exception.ObjectNotFoundException;
import com.hsofttecnologies.domicilios.services.CategoriaService;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	CategoriaDao categoriaDao;

	public List<Categoria> listarCategorias() {
		return categoriaDao.listarCategorias();
	}

	public Categoria buscarPorId(int id) {
		Categoria categoria = categoriaDao.buscarPorId(id);
		if (categoria == null) {
			throw new ObjectNotFoundException("Categoría con id: " + id
					+ " no encontrado");
		}
		return categoria;
	}

	public void agregarCategoria(Categoria categoria) {
		categoriaDao.agregarCategoria(categoria);
	}

	public void actualizarCategoria(Categoria categoria) {
		categoriaDao.actualizarCategoria(categoria);
	}

}
