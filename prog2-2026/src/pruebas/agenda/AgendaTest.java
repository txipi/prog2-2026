package pruebas.agenda;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class AgendaTest {

	@Test
	void testGetNombre() {
		Agenda a = new Agenda("hola", null);
		assertEquals("hola", a.getNombre());
	}
	
	@Test
	void testGetContactos() {
		Contacto c1 = new Contacto("", 0, LocalDate.now(), 0.1);
		Contacto c2 = new Contacto("", 0, LocalDate.now(), 0.2);
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		lista.add(c1);
		lista.add(c2);
		Agenda a = new Agenda("", lista);
		assertEquals(lista, a.getContactos());
	}
	
	@Test
	void testGetTotal() {
		Contacto c1 = new Contacto("", 0, LocalDate.now(), 0.1);
		Contacto c2 = new Contacto("", 0, LocalDate.now(), 0.2);
		ArrayList<Contacto> lista = new ArrayList<Contacto>();
		lista.add(c1);
		lista.add(c2);
		Agenda a = new Agenda("", lista);
		assertEquals(0.3, a.getTotal(), 0.001);
	}

}
