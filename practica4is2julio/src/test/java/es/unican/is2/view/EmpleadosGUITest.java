package es.unican.is2.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.unican.is2.vista.EmpleadosGUI;


public class EmpleadosGUITest {
	private FrameFixture demo;
	private LocalDate hoy;

	@Before 
	public void setUp() {
		EmpleadosGUI gui=new EmpleadosGUI();
		gui.setVisible(true);
		demo=new FrameFixture(gui);
		hoy= LocalDate.now();

	}
	@After 
	public void clear() {
		demo.cleanUp();
	}
	@Test
	public void test() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		// caso 1 
		demo.textBox("txtFechaContratacion").setText(hoy.format(formatter));
		demo.comboBox("comboCategoria").selectItem("DIRECTIVO");			
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("1500.0");

		// caso 2 
		demo.textBox("txtFechaContratacion").setText(hoy.minusYears(3).format(formatter));
		demo.comboBox("comboCategoria").selectItem("GESTOR");	
		demo.radioButton("btnVIP").check();
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("900.0");

		// caso error 1
		demo.textBox("txtFechaContratacion").setText(hoy.plusYears(3).format(formatter));
		demo.comboBox("comboCategoria").selectItem("DIRECTIVO");	
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("Datos incorrectos");

		// caso error 2
		demo.textBox("txtFechaContratacion").setText("04-03-2011");
		demo.comboBox("comboCategoria").selectItem("DIRECTIVO");	
		demo.button("btnCalcular").click();
		demo.textBox("txtSueldo").requireText("Fecha incorrecta");

	}



}
