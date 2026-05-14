package examenes.citybike;

import static org.junit.jupiter.api.Assertions.*;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class ReservaTest {

	@Test
	void testConstructor() {
		Electrica electrica = new Electrica(true, 100);
		Cliente adulto = new Cliente("", TipoCliente.ADULTO);
		LocalDate fecha = LocalDate.now();
		Estacion estacion = new Estacion("E1", 30);
		Reserva r1 = new Reserva(adulto, electrica, fecha, estacion);
		// Green path
		assertEquals(adulto, r1.getCliente());
		assertEquals(electrica, r1.getBicicleta());
		assertEquals(fecha, r1.getInicio());
		assertEquals(null, r1.getFin());	
		assertEquals(estacion, r1.getOrigen());
		assertEquals(null, r1.getDestino());
		// Red path
		try {
			Reserva r2 = new Reserva(adulto, electrica, LocalDate.of(1970,1970,1970), estacion);
			fail("Debería haber fallado y no ha fallado por fecha inválida");
		} catch (DateTimeException e) {
			// OK!
			System.out.println("Ha fallado cuando tenía que fallar = TODO BIEN");
		}
	}

	@Test
	void testCalcularCoste() {
		Electrica electrica = new Electrica(true, 100);
		Mecanica mecanica = new Mecanica(true);
		Cliente joven = new Cliente("", TipoCliente.JOVEN);
		Cliente adulto = new Cliente("", TipoCliente.ADULTO);
		Cliente senior = new Cliente("", TipoCliente.SENIOR);
		//Una Reserva de una bicicleta eléctrica hecha por un cliente adulto (tiene que dar 0.5).
		Reserva r1 = new Reserva(adulto, electrica, null, null);
		assertEquals(0.5, r1.calcularCoste(), 0.001);
		//Una Reserva de una bicicleta eléctrica hecha por un cliente joven (tiene que dar 0.25).
		Reserva r2 = new Reserva(joven, electrica, null, null);
		assertEquals(0.25, r2.calcularCoste(), 0.001);
		//Una Reserva de una bicicleta eléctrica hecha por un cliente senior (tiene que dar 0.35).
		Reserva r3 = new Reserva(senior, electrica, null, null);
		assertEquals(0.35, r3.calcularCoste(), 0.001);
		//Una Reserva de una bicicleta mecánica hecha por un cliente adulto (tiene que dar 0.0).
		Reserva r4 = new Reserva(adulto, mecanica, null, null);
		assertEquals(0.0, r4.calcularCoste(), 0.001);
	}

	
}
