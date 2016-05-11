package com.hsofttecnologies.domicilios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsofttecnologies.domicilios.dao.ProductoDao;
import com.hsofttecnologies.domicilios.entities.Producto;
import com.hsofttecnologies.domicilios.exception.ObjectNotFoundException;
import com.hsofttecnologies.domicilios.services.ProductoService;
@Service("productoService")
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoDao productoDao;
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return productoDao.listarProductos();
	}

	public Producto buscarPorId(int id) {
		Producto producto = productoDao.buscarPorId(id);
		if(producto==null){
			throw new ObjectNotFoundException("Producto con id: "+id+" No encontrado");
		}
 		return producto;
	}

	public void agregarProducto(Producto producto) {
		productoDao.agregarProducto(producto);
		
	}

	public void actualizarProducto(Producto producto) {
		productoDao.actualizarProducto(producto);
		
	}

}
