package collections.repaso;

public class Array {

	public static void main(String[] args) {
		// Crear un array
		String[] palabras = new String[100];
		
		// Añadir elementos a un array
		palabras[0] = "Hola";
		palabras[1] = "Hola";
		
		// Acceder a un elemento de un array
		System.out.println(palabras[1]);

		// Borrar elementos de un array
		palabras[0] = null;
		
		// Recorrer los elementos de un array
		for (String palabra : palabras) {
			System.out.println(palabra);
		}
	}

}
