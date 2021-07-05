package es.unican.is2.ListaAcotadaTest;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.ListaOrdenadaAcotada.ListaOrdenadaAcotada;

public class ListaAcotadaTest {

	private ListaOrdenadaAcotada<Integer> sut;
	@Before
	public void setUp() {
		try {
			sut=new ListaOrdenadaAcotada<Integer>(5);
		}catch(Exception e) {
			fail("Error al generar la lista");
		}
	}

	@Test
	public void testAdd() {
		//caso 1
		try {
			sut.add(2);
		}catch(Exception e){
			fail("no se ha podido añadir");
		}
		assertTrue(sut.get(0)==2);
		//caso 2
		try {
			sut.add(1);
		}catch(Exception e){
			fail("no se ha podido añadir");
		}
		assertTrue(sut.get(0)==1);
		assertTrue(sut.get(1)==2);
		//caso 3
		try {
			sut.add(3);
		}catch(Exception e){
			fail("no se ha podido añadir");
		}
		assertTrue(sut.get(0)==1);
		assertTrue(sut.get(1)==2);
		assertTrue(sut.get(2)==3);
	}

}
