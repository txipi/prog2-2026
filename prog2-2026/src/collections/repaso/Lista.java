package collections.repaso;

import java.util.ArrayList;

public class Lista {

	public static void main(String[] args) {
		// Crear una lista
		ArrayList<String> palabras = new ArrayList<String>();
		
		// Añadir elementos a una lista
		palabras.add("Hola");
		palabras.add("mundo");
		
		// Acceder a un elemento de la lista
		System.out.println(palabras.get(1));

		// Borrar elementos de la lista
		palabras.remove(0);
		
		// Recorrer los elementos de lista
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
	}

}
