package es.unican.is2.ListaAcotadaTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import es.unican.is2.ListaOrdenadaAcotada.IListaAcotada;
import es.unican.is2.ListaOrdenadaAcotada.ListaOrdenadaAcotada;

public class ListaAcotadaTest {

	IListaAcotada<Integer> sut;

	@Before
	public void setUp() {
		try {
			sut = new ListaOrdenadaAcotada<Integer>(5);
		}catch(Exception e) {
			fail("No se ha generado correctamente");
		}
	}

	@Test
	public void constructorTest() {
		//CASO 1
		try {
			sut = new ListaOrdenadaAcotada<Integer>(1);
		}catch(Exception e) {
			fail("Constructor erroneo. Error al generar lista de tamaño 1.");
		}
		//CASO 2
		try {
			sut = new ListaOrdenadaAcotada<Integer>(5);
		}catch(Exception e) {
			fail("Constructor erroneo. Error al generar lista de tamaño 5.");
		}

		//CASO 3
		try {
			sut = new ListaOrdenadaAcotada<Integer>();
		}catch(Exception e) {
			fail("Constructor erroneo. No se ha generado correctamente con omisión de parametro.");
		}

		//CASO ERROR 1
		try {
			sut = new ListaOrdenadaAcotada<Integer>(-3);
			fail("Error. No se puede generar una lista negativa.");
		}catch(Exception e) {

		}
	}


	@Test
	public void addTest() {
		//CASO 1
		try {
			sut.add(3);
		}catch(Exception e) {
			fail("Error. No se ha añadido elemento a lista vacia");
		}
		assertTrue(sut.get(0)==3);

		//CASO 2
		try {
			sut.add(-1);
		}catch(Exception e) {
			fail("Error. No se ha podido añadir elemento.");
		}
		System.out.println(sut);
		assertTrue(sut.get(0)==-1);
		assertTrue(sut.get(1)==3);

		//CASO 3
		try {
			sut.add(5);
		}catch(Exception e) {
			fail("Error. No se ha podido añadir elemento.");
		}
		assertTrue(sut.get(0)==-1);
		assertTrue(sut.get(1)==3);
		assertTrue(sut.get(2)==5);


		//CASO 4
		try {
			sut.add(2);
			sut.add(2);
		}catch(Exception e) {
			fail("Error. No se ha podido añadir elemento.");
		}
		assertTrue(sut.get(0)==-1);
		assertTrue(sut.get(1)==2);
		assertTrue(sut.get(2)==2);
		assertTrue(sut.get(3)==3);
		assertTrue(sut.get(4)==5);

		//CASO ERROR 1
		try {
			sut.add(1);
			fail("Error. No se debería poder añadir valores a lista llena.");
		}catch(Exception e) {
		}

		//CASO ERROR 2
		try {
			sut.add(null);
			fail("Error. No se debería poder añadir nulos.");
		}catch(Exception e) {
		}
	}

	@Test
	public void getTest() {
		sut.add(1);
		sut.add(2);
		sut.add(3);

		try {
			int x = sut.get(0);
			assertTrue(x==1);
		}catch(Exception e) {
			fail("No se pudo obtener el elemento inicial");
		}

		try {
			int x = sut.get(1);
			assertTrue(x==2);
		}catch(Exception e) {
			fail("No se pudo obtener el elemento intermedio");
		}

		try {
			int x = sut.get(2);
			assertTrue(x==3);
		}catch(Exception e) {
			fail("No se pudo obtener el elemento final");
		}

		sut.add(4);
		sut.add(5);

		try {
			int x = sut.get(4);
			assertTrue(x==5);
		}catch(Exception e) {
			fail("No se pudo obtener el elemento final con lista llena");
		}

		//CASO ERROR 1
		try {
			sut.get(-1);
			fail("No se ha recogido erro al recoger indice negativo");
		}catch(Exception e) {
		}

		//CASO ERROR 2
		try {
			sut.get(5);
			fail("No se ha recogido erro al recoger indice mayor que longitud");
		}catch(Exception e) {
		}

		sut = new ListaOrdenadaAcotada<Integer>(5);

		//CASO ERROR 3
		try {
			sut.get(0);
			fail("No se ha recogido error al intentar obtener elemento de lista vacia");
		}catch(Exception e) {
		}

	}

	@Test
	public void remove() {
		sut.add(1);
		sut.add(2);
		sut.add(3);
		sut.add(4);
		sut.add(5);
		//CASO 1
		try {
			int x = sut.remove(2);
			assertTrue(x==3);
			assertTrue(sut.get(1)==2);
			assertTrue(sut.get(2)==4);
			assertTrue(sut.size()==4);
		}catch(Exception e) {
			fail("No se pudo eliminar el elemento inicial");
		}

		//CASO 2
		try {
			int x = sut.remove(0);
			assertTrue(x==1);
			assertTrue(sut.get(0)==2);
			assertTrue(sut.size()==3);
		}catch(Exception e) {
			fail("No se pudo eliminar el elemento inicial");
		}

		//CASO 3
		try {
			int x = sut.remove(2);
			assertTrue(x==5);
			assertTrue(sut.get(0)==2);
			assertTrue(sut.size()==2);
		}catch(Exception e) {
			fail("No se pudo eliminar el elemento final");
		}

		//CASO 4
		try {
			sut.remove(1);
			int x = sut.remove(0);
			assertTrue(x==2);
			assertTrue(sut.size()==0);
		}catch(Exception e) {
			fail("No se pudo eliminar el elemento final");
		}



		sut.add(1);
		sut.add(2);
		sut.add(3);
		sut.add(4);
		sut.add(5);
		//CASO ERROR 1
		try {
			sut.remove(-1);
			fail("No se ha recogido erro al recoger indice negativo");
		}catch(Exception e) {
		}

		//CASO ERROR 2
		try {
			sut.remove(6);
			fail("No se ha recogido erro al recoger indice mayor que longitud");
		}catch(Exception e) {
		}
		sut = new ListaOrdenadaAcotada<Integer>(5);

		//CASO ERROR 3
		try {
			sut.remove(0);
			fail("No se ha recogido error al intentar obtener elemento de lista vacia");
		}catch(Exception e) {
		}

		sut.add(2);
		sut.add(4);
		//CASO ERROR 4
		try {
			sut.remove(3);
			fail("No se ha recogido error al intentar obtener elemento de indice superior");
		}catch(Exception e) {
		}
	}

	@Test
	public void sizeTest() {
		try {
			assertTrue(sut.size()==0);
		}catch(Exception e) {
			fail("Error con el size vacio");
		}
		sut.add(1);
		sut.add(2);
		try {
			assertTrue(sut.size()==2);
		}catch(Exception e) {
			fail("Error con el size intermedio");
		}
		sut.add(3);
		sut.add(4);
		sut.add(5);
		try {
			assertTrue(sut.size()==5);
		}catch(Exception e) {
			fail("Error con el size lleno");
		}
	}

	@Test
	public void clearTest() {
		try {
			sut.clear();
			assertTrue(sut.size()==0);
		}catch(Exception e) {
			fail("Error con el clear vacío");
		}
		sut.add(1);
		sut.add(2);
		try {
			sut.clear();
			assertTrue(sut.size()==0);
		}catch(Exception e) {
			fail("Error con el clear intermedio");
		}
		sut.add(3);
		sut.add(4);
		sut.add(5);
		try {
			sut.clear();
			assertTrue(sut.size()==0);
		}catch(Exception e) {
			fail("Error con el clear lleno");
		}
	}


}