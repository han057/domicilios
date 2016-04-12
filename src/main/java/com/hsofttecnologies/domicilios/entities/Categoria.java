package com.hsofttecnologies.domicilios.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entidad que representa una categoria de producto
 * 
 * @author han
 * @version 1.0
 */

@Entity
@Table(name = "categoria")
public class Categoria {

	/**
	 * Identificador único de la categoria
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/**
	 * Nombre de la categoria
	 */
	@Column(name = "nombre")
	private String nombre;

	/**
	 * Retorna el identificador de la categoria
	 * 
	 * @return El identificador de la categoria
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador de la categoria
	 * 
	 * @param id
	 *            El identificador a establecer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna el nombre de la categoria
	 * 
	 * @return El nombre de la categoria
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la categoria
	 * 
	 * @param nombre
	 *            El nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}