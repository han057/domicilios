/**
 * 
 */
package com.hsofttecnologies.domicilios.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Polymorphism;
import org.hibernate.annotations.PolymorphismType;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Entidad que representa a un usuario en el sistema
 * 
 * @author han
 * @version 1.0
 *
 */
@Entity
@Table(name = "usuario")
@PrimaryKeyJoinColumn(name = "id")
@Polymorphism(type = PolymorphismType.EXPLICIT)
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends Persona {

	/**
	 * Nombre de usuario para el inicio de sesión
	 */
	@Column(name = "usuario")
	private String usuario;

	/**
	 * Password del usuario
	 */
	@JsonIgnore
	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "app_user_user_rol", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "rol_id") })
	private Set<Rol> roles = new HashSet<Rol>(0);

	/**
	 * Retorna el nombre de usuario
	 * 
	 * @return Nombre de usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece el nombre de usuario
	 * 
	 * @param usuario
	 *            El nombre de usuario a establecer
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return El password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Establece el password, por seguridad el password debe ser pasado a una
	 * función hash antes de establecerlo (SHA-256)
	 * 
	 * @param password
	 *            El password a establecer
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Retorna el correo electrónico
	 * 
	 * @return El correo electrónico
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Establece el correo electrónico
	 * 
	 * @param email
	 *            Correo electrónico a establecer
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
}
