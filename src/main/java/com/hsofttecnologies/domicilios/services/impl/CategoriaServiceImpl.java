package com.hsofttecnologies.domicilios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsofttecnologies.domicilios.dao.CategoriaDao;
import com.hsofttecnologies.domicilios.entities.Categoria;
import com.hsofttecnologies.domicilios.entities.Persona;
import com.hsofttecnologies.domicilios.exception.ObjectAlreadyExistException;
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
		Categoria tem=categoriaDao.buscarPorNombre(categoria.getNombre());
		if(tem==null){
			categoriaDao.agregarCategoria(categoria);	
		}else{
			throw new ObjectAlreadyExistException("Categoria con Nombre: "+categoria.getNombre()+" ya existe");
		}


	}

	public void actualizarCategoria(Categoria categoria) {
		Categoria tem=categoriaDao.buscarPorId(categoria.getId());
		if(tem!=null){
			categoriaDao.actualizarCategoria(categoria);
		}else{
			throw new ObjectAlreadyExistException("Categoria con id: "+categoria.getId()+" no actualizada");
		}
		
	}

	public Categoria buscarPorNombre(String nombre) {
	
			Categoria categoria=categoriaDao.buscarPorNombre(nombre);
			if(categoria==null){
				throw new ObjectNotFoundException("categoria con nombre : "+nombre+" No encontrado");
			}
			return categoria;
		
	}

}
