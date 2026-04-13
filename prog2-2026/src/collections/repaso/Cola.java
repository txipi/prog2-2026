package collections.repaso;

import java.util.LinkedList;

public class Cola {

	public static void main(String[] args) {
		// Crear una cola
		LinkedList<String> palabras = new LinkedList<String>();
		
		// Añadir elementos a una cola
		palabras.add("Hola");
		palabras.addLast("mundo"); // add y addLast es lo mismo -> añadir al final
		
		// Acceder a un elemento de la cola
		System.out.println(palabras.get(1));

		// Borrar elementos de la cola
		palabras.remove(0);
		
		// Recorrer los elementos de la cola
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
		
		// Procesar y vacíar una cola
		while (!palabras.isEmpty()) { // mientras NO esté vacía la cola palabras...
			String turno = palabras.removeFirst();
			System.out.println(turno);
		}

	}

}
