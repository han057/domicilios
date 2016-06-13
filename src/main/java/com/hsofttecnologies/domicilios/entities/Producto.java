package com.hsofttecnologies.domicilios.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad que representa un producto
 * 
 * @author han
 * @version 1.0
 *
 */

@Entity
@Table(name = "producto")
public class Producto {

	/**
	 * Identificador único del producto
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/**
	 * Nombre del producto
	 */
	@Column(name = "nombre")
	private String nombre;

	/**
	 * Descripción del producto
	 */
	@Column(name = "descripcion")
	private String descripcion;

	/**
	 * Valor del precio
	 */
	@Column(name = "valor")
	private int valor;

	/**
	 * Categoria del producto
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "categoria")
	private Categoria categoria;

	/**
	 * Define si el producto es una adición o no
	 */
	@Column(name = "adicion")
	private boolean adicion;

	@Column(name = "activo")
	private boolean activo;

	/**
	 * Retorna el identificador del producto
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador del producto
	 * 
	 * @param id
	 *            El identificador a establecer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna el nombre del producto
	 * 
	 * @return Nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del producto
	 * 
	 * @param nombre
	 *            El nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna la descripción del producto
	 * 
	 * @return Descripción del producto
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción del producto
	 * 
	 * @param descripcion
	 *            La descripción a establecer
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Retorna el valor del producto
	 * 
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Establece el valor del producto
	 * 
	 * @param valor
	 *            El valor a establecer
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * Retorna la categoria del producto
	 * 
	 * @return La categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Establece la categoria del producto
	 * 
	 * @param categoria
	 *            La categoria a establecer
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/**
	 * Indica si el producto es una adición o no
	 * 
	 * @return adicion
	 */
	public boolean isAdicion() {
		return adicion;
	}

	/**
	 * Establece si el producto es una adición o no
	 * 
	 * @param adicion
	 *            True en caso de que sea adición, en caso contrario False
	 */
	public void setAdicion(boolean adicion) {
		this.adicion = adicion;
	}

	/**
	 * Indica si el producto está activo
	 * 
	 * @return activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * Establece si el producto está activo o no
	 * 
	 * @param activo
	 *            True en caso de que esté activo, en caso contrario False
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}
