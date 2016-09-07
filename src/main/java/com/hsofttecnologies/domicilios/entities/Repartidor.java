/**
 * 
 */
package com.hsofttecnologies.domicilios.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

/**
 * Entidad que representa a un repartidor
 * 
 * @author han
 * @version 1.0
 */
@Entity
@Table(name = "repartidor")
@PrimaryKeyJoinColumn(name = "id")
@Polymorphism(type = PolymorphismType.EXPLICIT)
@Inheritance(strategy = InheritanceType.JOINED)
public class Repartidor extends Persona {

	@Column(name = "estado")
	private boolean estado;

	/**
	 * Fecha de ingreso del repartidor
	 */
	@Column(name = "fechaingreso")
	private Date fechaIngreso;

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	/**
	 * Retorna la fecha de ingreso del repartidor
	 * 
	 * @return La fecha de ingreso
	 */
	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * Establece la fecha de ingreso del repartidor
	 * 
	 * @param fechaIngreso
	 *            Fecha de ingreso a establecer
	 */
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

}