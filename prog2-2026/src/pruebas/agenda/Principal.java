package pruebas.agenda;

import java.time.LocalDate;

public class Principal {

	public static void main(String[] args) {
		Contacto c1 = new Contacto("Pablo", 123456, LocalDate.now(), 35.67);
		System.out.println(c1.getNombre());
		System.out.println(c1.getTelefono());
		System.out.println(c1.getFecha());
		System.out.println(c1.getSaldo());
	}

}
