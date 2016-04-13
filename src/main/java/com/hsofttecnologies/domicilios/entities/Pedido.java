package com.hsofttecnologies.domicilios.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "clientenombre")
	private String clienteNombre;

	@Column(name = "clientetelefono")
	private String clienteTelefono;

	@Column(name = "clientedireccion")
	private String clienteDireccion;

	@ManyToOne
	@JoinColumn(name = "repartidor")
	private Repartidor repartidor;

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
	private List<ItemPedido> detalle;

	@Column(name = "estado")
	private EnumEstados estado;

	@Column(name = "fecha")
	private Date fecha;

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
	 * @return the clienteNombre
	 */
	public String getClienteNombre() {
		return clienteNombre;
	}

	/**
	 * @param clienteNombre
	 *            the clienteNombre to set
	 */
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	/**
	 * @return the clienteTelefono
	 */
	public String getClienteTelefono() {
		return clienteTelefono;
	}

	/**
	 * @param clienteTelefono
	 *            the clienteTelefono to set
	 */
	public void setClienteTelefono(String clienteTelefono) {
		this.clienteTelefono = clienteTelefono;
	}

	/**
	 * @return the clienteDireccion
	 */
	public String getClienteDireccion() {
		return clienteDireccion;
	}

	/**
	 * @param clienteDireccion
	 *            the clienteDireccion to set
	 */
	public void setClienteDireccion(String clienteDireccion) {
		this.clienteDireccion = clienteDireccion;
	}

	/**
	 * @return the repartidor
	 */
	public Repartidor getRepartidor() {
		return repartidor;
	}

	/**
	 * @param repartidor
	 *            the repartidor to set
	 */
	public void setRepartidor(Repartidor repartidor) {
		this.repartidor = repartidor;
	}

	/**
	 * @return the detalle
	 */
	public List<ItemPedido> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle
	 *            the detalle to set
	 */
	public void setDetalle(List<ItemPedido> detalle) {
		this.detalle = detalle;
	}

	/**
	 * @return the estado
	 */
	public EnumEstados getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(EnumEstados estado) {
		this.estado = estado;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha
	 *            the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
