package pruebas.agenda;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ContactoTest {

	@Test
	void testConstructor() {
		Contacto c1 = new Contacto("Pablo", 123456, LocalDate.now(), 35.67);
		assertEquals("Pablo", c1.getNombre());
		assertEquals(123456, c1.getTelefono());
		assertEquals(35.67, c1.getNombre());
		
		// fail("Not yet implemented");
	}

}
