package com.hsofttecnologies.domicilios.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsofttecnologies.domicilios.dao.RepartidorDao;
import com.hsofttecnologies.domicilios.entities.Repartidor;
import com.hsofttecnologies.domicilios.exception.ObjectAlreadyExistException;
import com.hsofttecnologies.domicilios.exception.ObjectNotFoundException;
import com.hsofttecnologies.domicilios.services.RepartidorService;

@Service("repartidorService")
@Transactional
public class RepartidorServiceImpl implements RepartidorService {

	@Autowired
	RepartidorDao repartidorDao;

	public List<Repartidor> listarRepartidores() {
		return repartidorDao.listarRepartidor();
	}

	public Repartidor buscarPorId(int id) {
		Repartidor repartidor = repartidorDao.buscarPorId(id);
		if (repartidor == null) {
			throw new ObjectNotFoundException("Repartidor con id: " + id + " no encontrado. ");
		}
		return repartidor;
	}

	public void agregarRepartidor(Repartidor repartidor) {
		repartidorDao.agregarRepartidor(repartidor);
	}

	public void actualizarRepartidor(Repartidor repartidor) {
		repartidorDao.actualizarRepartidor(repartidor);
	}

	@Override
	public void cambiarEstadoRepartidor(int id) {
		Repartidor repartidor = buscarPorId(id);
		repartidor.setEstado(!repartidor.isEstado());
		repartidorDao.actualizarRepartidor(repartidor);
		
	}

}