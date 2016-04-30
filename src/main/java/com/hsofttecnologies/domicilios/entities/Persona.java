/**
 * 
 */
package com.hsofttecnologies.domicilios.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Entidad que representa a una persona, base para usuarios, clientes y
 * repartidores
 * 
 * @author han
 * @version 1.0
 */
@Entity
@Table(name = "persona")
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona {

	/**
	 * Identificador único de la persona
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	/**
	 * Número de identificación de la persona
	 */
	@Column(name = "identificacion")
	private String identificacion;

	/**
	 * Nombre de la persona
	 */
	@Column(name = "nombre")
	private String nombre;

	/**
	 * Apellido de la persona
	 */
	@Column(name = "apellido")
	private String apellido;

	/**
	 * Teléfono de la persona
	 */
	@Column(name = "telefono")
	private String telefono;

	/**
	 * Retorna el identificador de la persona
	 * 
	 * @return El identificador de la persona
	 */
	public int getId() {
		return id;
	}

	/**
	 * Establece el identificador de la persona
	 * 
	 * @param id
	 *            El identificador a establecer
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Retorna el número de identificación de la persona
	 * 
	 * @return El número de identificación
	 */
	public String getIdentificacion() {
		return identificacion;
	}

	/**
	 * Establece el número de identificación de la persona
	 * 
	 * @param identificacion
	 *            El número de identificación a establecer
	 */
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	/**
	 * Retorna el nombre de la persona
	 * 
	 * @return El nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la persona
	 * 
	 * @param nombre
	 *            El nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Retorna el apellido de la persona
	 * 
	 * @return El apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * Establece el apellido de la persona
	 * 
	 * @param apellido
	 *            El apellido a establecer
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * Retorna el número telefónico de la persona
	 * 
	 * @return El número telefónico
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece el número telefónico de la persona
	 * 
	 * @param telefono
	 *            El número telefónico a establecer
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
