package com.hsofttecnologies.domicilios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsofttecnologies.domicilios.dao.RepartidorDao;
import com.hsofttecnologies.domicilios.entities.Repartidor;
import com.hsofttecnologies.domicilios.exception.ObjectAlreadyExistException;
import com.hsofttecnologies.domicilios.exception.ObjectNotFoundException;
import com.hsofttecnologies.domicilios.services.RepartidorService;
@Service("repartidorService")
public class RepartidorServiceImpl implements RepartidorService {

	@Autowired RepartidorDao repartidorDao;
	public List<Repartidor> listarRepartidores(){ 
		return repartidorDao.listarRepartidor();
	}

	public Repartidor buscarPorId(int id) {
		Repartidor repartidor=repartidorDao.buscarPorId(id);
		if(repartidor==null){
			throw new ObjectNotFoundException("Repartidor con id: "+id+" no encontrado. ");
		}
		return repartidor;
	}

	public void agregarRepartidor(Repartidor repartidor) {
		Repartidor repartidorTem =repartidorDao.buscarPorId(repartidor.getId());
		if(repartidorTem==null){
			repartidorDao.agregarRepartidor(repartidor);
		}else{
			throw new ObjectAlreadyExistException("el repartido con nombre "+repartidor.getNombre()+" ya exixte ");
		}
	}

	public void actualizarCategoria(Repartidor repartidor) {
		Repartidor repartidorTem =repartidorDao.buscarPorId(repartidor.getId());
		if(repartidorTem!=null){
			repartidorDao.actualizarRepartidor(repartidor);
		}else{
			throw new ObjectAlreadyExistException("el repartido con nombre "+repartidor.getNombre()+" no exixte ");
		}
	}

}
