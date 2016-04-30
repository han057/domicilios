/**
 * 
 */
package com.hsofttecnologies.domicilios.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entidad que representa a un producto en un pedido
 * 
 * @author han
 * @version 1.0
 */
@Entity
@Table(name = "itempedido")
public class ItemPedido {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private Pedido pedido;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;

	@Column(name = "cantidad")
	private short cantidad;

	@Column(name = "valor")
	private int valor;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the pedido
	 */
	public Pedido getPedido() {
		return pedido;
	}

	/**
	 * @param pedido
	 *            the pedido to set
	 */
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	/**
	 * @return the cantidad
	 */
	public short getCantidad() {
		return cantidad;
	}

	/**
	 * @param cantidad
	 *            the cantidad to set
	 */
	public void setCantidad(short cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * @param producto
	 *            the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

}
