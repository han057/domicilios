package com.hsofttecnologies.domicilios.dao;

import java.util.List;

import com.hsofttecnologies.domicilios.entities.Repartidor;

public interface RepartidorDao {

	/**
	 * Lista las repartidor desde el repositorio de datos
	 * 
	 * @return Lista de repartidor
	 */
	public List<Repartidor> listarRepartidor();

	/**
	 * Buscar una repetidor por su identificador único
	 * 
	 * @param id - identificador a buscar
	 * @return el repartidor con id como identificador si lo encuentra, de lo
	 *         contrario null
	 */
	public Repartidor buscarPorId(int id);

	/**
	 * Buscar un repartidor por su nombre
	 * 
	 * @param nombre - nombre a buscar
	 * @return el repartidor cuyo nombre es igual al parametro dado, si no existe
	 *         null
	 */
	public Repartidor buscarPorNombre(String nombre);

	/**
	 * Agrega un nuevo Repartidor
	 * 
	 * @param prepartidor - repartidor a agregar
	 */
	public void agregarRepartidor(Repartidor repartidor);

	/**
	 * Modifica la información de la repartidor
	 * 
	 * @param repartidor - repartidor a actualizar
	 */
	public void actualizarRepartidor(Repartidor repartidor);
}
