package pruebas.fracciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FraccionTest {

	@Test
	void testConstructor() {
		// Green path
		Fraccion f1 = new Fraccion(1, 2);
		assertEquals(1, f1.num);
		assertEquals(2, f1.den);
		// Red path
		try {
			Fraccion f2 = new Fraccion(1, 0);
			fail("Debería haber lanzado una ArithmeticException");
		} catch (ArithmeticException e) {
			// OK!
		}	
	}
	
	@Test
	void testCalcular() {
		Fraccion f1 = new Fraccion(1, 2);
		assertEquals(0.5, f1.calcular(), 0.001);
		Fraccion f2 = new Fraccion(1, 4);
		assertEquals(0.25, f2.calcular(), 0.001);
		Fraccion f3 = new Fraccion(2, 4);
		assertEquals(0.5, f3.calcular(), 0.001);
		Fraccion f4 = new Fraccion(1, 3);
		assertEquals(0.333333, f4.calcular(), 0.001);
		Fraccion f5 = new Fraccion(0, 3);
		assertEquals(0.0, f5.calcular(), 0.001);
	}
	
	@Test
	void testSimplifica() {
		Fraccion f1 = new Fraccion(2, 4);
		Fraccion f2 = new Fraccion(1, 2);
		assertEquals(f2, f1.simplifica());

		Fraccion f3 = new Fraccion(0, 4);
		assertEquals(f3, f3.simplifica());

		Fraccion f4 = new Fraccion(3, 7);
		assertEquals(f4, f4.simplifica());
	}

	@Test
	void testSuma() {
		Fraccion f1 = new Fraccion(1, 4);
		Fraccion f2 = new Fraccion(1, 2);
		Fraccion f3 = new Fraccion(3, 4);
		assertEquals(f3, Fraccion.suma(f1, f2).simplifica());
	}
	
}
