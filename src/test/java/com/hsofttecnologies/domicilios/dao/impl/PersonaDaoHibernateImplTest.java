/**
 * 
 */
package com.hsofttecnologies.domicilios.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.hsofttecnologies.domicilios.JUnitSpringDaoServiceTestBase;
import com.hsofttecnologies.domicilios.dao.CategoriaDao;
import com.hsofttecnologies.domicilios.dao.PersonaDao;
import com.hsofttecnologies.domicilios.entities.Categoria;
import com.hsofttecnologies.domicilios.entities.Persona;

/**
 * @author INTERNET_2
 *
 */
@Transactional
public class PersonaDaoHibernateImplTest extends  JUnitSpringDaoServiceTestBase {
	@Autowired
	PersonaDao personaDao;

	@Before
	public void setUp() throws Exception {
		testAgregarPersona();
	}

	@Test
	public void testListarPersonas() {
		List<Persona> personas= personaDao.listarPersonas();
		assertTrue(personas.size() > 0);
	}

	@Test
	public void testBuscarPorId() {
		assertNotNull("Persona no encontrada", personaDao.buscarPorId(2));
		assertNull("Persona encontrada", personaDao.buscarPorId(1));
	}

	@Test
	public void testAgregarPersona() {
		Persona persona= new Persona();
		persona.setNombre("Javier ");
		persona.setApellido("");
		persona.setTelefono("");
		personaDao.agregarPersona(persona);
	}

	@Test 
	public void testActualizarPersona() {
		String nuevoNombre = "Nuevo nombre";

		Persona persona = personaDao.buscarPorId(1);
		persona.setNombre(nuevoNombre);

		personaDao.actualizarPersona(persona);
		Persona persona2 = personaDao.buscarPorId(1);
		assertEquals(nuevoNombre, persona.getNombre());
	}

	@Test
	public void testBuscarPorNombre() {
		assertNotNull(personaDao.buscarPorNombre("javier"));
	}
}
