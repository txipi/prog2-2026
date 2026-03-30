package collections.embarque;

import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		LinkedList<Pasajero> cola = new LinkedList<Pasajero>();
		
		// Creamos 200 pasajeros
		for (int i = 0; i < 200; i++) {
			Pasajero pasajero = new Pasajero("Pasajero" +i, "", Clase.ECONOMY);
			cola.addLast(pasajero);
		}
		
		// Vaciamos la cola
		// while (cola.size() > 0) {}
		while (!cola.isEmpty()) {
			Pasajero atendido = cola.removeFirst();
			System.out.println("Entra el pasajero: " + atendido);
		}

		// Creamos 200 pasajeros de diferentes clases
		for (int i = 0; i < 200; i++) {
			// Elegir aleatoriamente dentro de un enum:
			int alea = (int) (Math.random() * 3); // número aleatorio entre 0 y 2
			Clase[] todas = Clase.values(); // array con todos los valores del enum Clase
			Clase clase = todas[alea]; // usamos alea como índice en el array de todas las Clases
			// Crear el pasajero
			Pasajero pasajero = new Pasajero();
			pasajero.setNombre("Pasajero" +i);
			pasajero.setClase(clase);
			cola.addLast(pasajero);
		}
		
		System.out.println(cola);

		// Clasificamos a los pasajeros en sub-colas en función de su clase
		
		LinkedList<Pasajero> colaPrimera = new LinkedList<Pasajero>();
		LinkedList<Pasajero> colaBusiness = new LinkedList<Pasajero>();
		LinkedList<Pasajero> colaEconomy = new LinkedList<Pasajero>();
		
		while (!cola.isEmpty()) {
			Pasajero atendido = cola.removeFirst();
			if (atendido.getClase() == Clase.PRIMERA) {
				colaPrimera.addLast(atendido);
			} else if (atendido.getClase() == Clase.BUSINESS) {
				colaBusiness.addLast(atendido);
			} else {
				colaEconomy.addLast(atendido);
			}
		}
	
		// Primero, entran los de PRIMERA
		
		while (!colaPrimera.isEmpty()) {
			Pasajero atendido = colaPrimera.removeFirst();
			System.out.println("Entra el pasajero: " + atendido);
		}
	
		// Segundo, entran los de BUSINESS
		
		while (!colaBusiness.isEmpty()) {
			Pasajero atendido = colaBusiness.removeFirst();
			System.out.println("Entra el pasajero: " + atendido);
		}
	
		// Tercero, entran los de ECONOMY
		
		while (!colaEconomy.isEmpty()) {
			Pasajero atendido = colaEconomy.removeFirst();
			System.out.println("Entra el pasajero: " + atendido);
		}
	
	}

}
