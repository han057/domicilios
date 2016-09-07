package com.hsofttecnologies.domicilios.services;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Repartidor;

public interface RepartidorService {
	/**
	 * Lista los Repartidores
	 * 
	 * @return Lista de repartidores
	 */
	public List<Repartidor> listarRepartidores();

	/**
	 * Buscar un Repartidor por su identificador único, si no lo encuentra lanza
	 * un ObjectNotFoundException
	 * 
	 * @param id - identificador a buscar
	 * @return el repartidor con id como identificador si lo encuentra, de lo
	 *         contrario lanza ObjectNotFoundException
	 */
	public Repartidor buscarPorId(int id);

	/**
	 * Agrega un nuevo repartidor, si ya existe una categoría con el mismo
	 * nombre lanza un ObjectAlreadyExistEception
	 * 
	 * @param repartidor - repartidor a agregar
	 */
	public void agregarRepartidor(Repartidor repartidor);

	/**
	 * Modifica la información del repartidor
	 * 
	 * @param repartidor - Repartidor a actualizar
	 */
	public void actualizarRepartidor(Repartidor repartidor);
	
	/**
	 * Modifica el estado del repartidor
	 * @param id - identificador del repartidor
	 */
	public void cambiarEstadoRepartidor(int id);

}
