package es.unican.is2.model;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;


import es.unican.is2.model.Empleado.DatoIncorrectoException;

public class EmpleadoTest {

	private Empleado sut;

	private LocalDate today = LocalDate.now();

	@Before
	public void setUp() {
		try {

		}catch(Exception e) {
			fail("Fallo en la creación de un Empleado");
		}
	}

	@Test
	public void constructorTest() {
		//TEST 1
		try {
			sut = new Empleado("Pepe",today,Categoria.DIRECTIVO);
		}catch (Exception e) {
			fail("Los datos del constructor son correctos");
		}
		// CASO ERROR 12
		try {
			sut = new Empleado("Pepe",today.plusDays(1),Categoria.OBRERO);
			fail("Debería lanzar excepción puesto a que la fecha introducida es erronea");
		}catch(DatoIncorrectoException e) {

		}

		// CASO ERROR  13
		try {
			sut = new Empleado("Pepe",null,Categoria.DIRECTIVO);
			fail("Debería lanzar excepción puesto a que la fecha introducida es nula");
		}catch(NullPointerException e) {

		}catch(DatoIncorrectoException e) {
			fail("No debe dar un dato incorrecto");
		}



		//CASO ERROR 14
		try {	
			sut = new Empleado("Pepe",today,Categoria.TECNICO);
			fail("Debería lanzar excepcion pues la categoria no es valida");
		}catch (Exception e) {

		}

		//CASO ERROR 15
		try {
			sut= new Empleado("Pepe",today,null);
			fail("Debería lanzar excepcion pues la categoria es nula");
		}catch (Exception e ) {

		}
	}

	@Test 
	public void darDeBaja() {
		// CASO 1
		try {
			sut = new Empleado("Pepe",today,Categoria.DIRECTIVO);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepción");
		}
		sut.darBaja();
		assertTrue(sut.getBaja()==true);
	}

	@Test 
	public void darDeAlta() {
		try {
			sut = new Empleado("Pepe",today,Categoria.DIRECTIVO);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");
		}
		sut.darBaja();
		sut.darAlta();
		assertFalse(sut.getBaja()==true);
	}

	@Test
	public void testSueldoBruto() {
		//CASO 1
		try {
			sut = new Empleado("Pepe",today,Categoria.DIRECTIVO);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");
		}

		assertTrue(sut.sueldoBruto()==1500);

		//CASO 2
		try {
			sut = new Empleado("Pepe",today.minusYears(3),Categoria.GESTOR);
		} catch (DatoIncorrectoException e) {	
			fail("No debería lanzar excepcion");

		}
		sut.darBaja();
		assertTrue(sut.sueldoBruto()==900);

		//CASO 3
		try {
			sut = new Empleado("Pepe",today.minusYears(5),Categoria.OBRERO);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");

		}
		assertTrue(sut.sueldoBruto()==100);

		//CASO 4
		try {
			sut = new Empleado("Pepe",today.minusYears(5).minusDays(1),Categoria.DIRECTIVO);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");

		}
		sut.darBaja();
		assertTrue(sut.sueldoBruto()==1162.5);

		//CASO 5
		try {
			sut = new Empleado("Pepe",today.minusYears(8),Categoria.GESTOR);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");

		}
		assertTrue(sut.sueldoBruto()==1250);

		//CASO 6
		try {
			sut = new Empleado("Pepe",today.minusYears(10),Categoria.OBRERO);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");

		}
		sut.darBaja();
		assertTrue(sut.sueldoBruto()==112.5);

		//CASO 7
		try {
			sut = new Empleado("Pepe",today.minusYears(10).minusDays(1),Categoria.DIRECTIVO);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");

		}
		assertTrue(sut.sueldoBruto()==1600);

		//CASO 8
		try {
			sut = new Empleado("Pepe",today.minusYears(15),Categoria.GESTOR);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");

		}
		sut.darBaja();
		assertTrue(sut.sueldoBruto()==975);

		//CASO 9
		try {
			sut = new Empleado("Pepe",today.minusYears(20),Categoria.OBRERO);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");

		}
		assertTrue(sut.sueldoBruto()==200);

		//CASO 10
		try {
			sut = new Empleado("Pepe",today.minusYears(20).minusDays(1),Categoria.DIRECTIVO);
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");

		}
		sut.darBaja();
		assertTrue(sut.sueldoBruto()==1275);

		//CASO 11
		try {
			sut = new Empleado("Pepe",today.minusYears(30),Categoria.GESTOR);		
		} catch (DatoIncorrectoException e) {
			fail("No debería lanzar excepcion");

		}
		assertTrue(sut.sueldoBruto()==1400);
	}
}