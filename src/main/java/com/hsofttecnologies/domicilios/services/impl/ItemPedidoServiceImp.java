/**
 * 
 */
package com.hsofttecnologies.domicilios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsofttecnologies.domicilios.dao.ItemPedidoDao;
import com.hsofttecnologies.domicilios.entities.ItemPedido;
import com.hsofttecnologies.domicilios.exception.ObjectAlreadyExistException;
import com.hsofttecnologies.domicilios.exception.ObjectNotFoundException;
import com.hsofttecnologies.domicilios.services.ItemPedidoService;

/**
 * @author INTERNET_2
 *
 */
@Service("itemPedidoService")
public class ItemPedidoServiceImp implements ItemPedidoService {

	@Autowired
	ItemPedidoDao itemPedidoDao;
	
	public List<ItemPedido> listaritemsPedido() {
		return itemPedidoDao.listarItemsPedido();
	}

	public ItemPedido buscarPorId(int id) {
		ItemPedido itempedido=itemPedidoDao.buscarPorId(id);
		if(itempedido==null){
			throw new ObjectNotFoundException("El item de pedido con id:"+id+" no fue encontrado ");
		}
		return itempedido;
	}

	public void agregarItemPedido(ItemPedido itempedido) {
		ItemPedido item=itemPedidoDao.buscarPorId(itempedido.getProducto().getId());
		if(item==null){
			itemPedidoDao.agregarItemPedido(itempedido);	
		}else{
			throw new ObjectAlreadyExistException("El iem ya existe");
		}
		
		
	}

	public void actualizarItemPedido(ItemPedido itempedido) {
		ItemPedido item=itemPedidoDao.buscarPorId(itempedido.getProducto().getId());
		if(item!=null){
			itemPedidoDao.actualizarItemPedido(itempedido);	
		}else{
			throw new ObjectAlreadyExistException("El iem no existe");
		}
		
		
	}

}
