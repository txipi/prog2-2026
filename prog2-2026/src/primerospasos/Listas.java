package primerospasos;

import java.util.ArrayList;

public class Listas {

	public static void main(String[] args) {
		// Un String es una colección de chars
		String frase = "Hola mundo"; // Crear
		String frase2 = new String("Hola mundo"); // String frase2 = "Hola mundo";
		char letra = frase.charAt(2); // Acceder
		// No podemos modificar un char individual así: frase[2] = 'x';
		frase = "Hol" + letra + " mundo";
		
		// Una lista es una colección de objetos
		
		// Crear:
		// En Python -> lista : list = [ 7, 7.3, True, [], "hola"]
		ArrayList lista = new ArrayList(); // podemos añadir cualquier cosa dentro
		// En Python -> lista : list[str] = [ "a", "abc", "abcdef" ]
		ArrayList<String> palabras = new ArrayList<String>();
		
		// Añadir:
		palabras.add("Hola");
		palabras.add("Mundo");
		palabras.add("cruel");
		palabras.add("pero");
		palabras.add("hermoso");
		
		// Acceder: 
		System.out.println(palabras);
		// En Python -> print(palabras[1])
		System.out.println(palabras.get(1));
		
		// Borrar:
		palabras.remove(1);
		palabras.remove("Hola");
		System.out.println(palabras);
		
		// arrays "antiguos" -> Se usa poco porque es más incómodo
		String[] campos = frase.split(" ");
		System.out.println(campos[0]);
		System.out.println(campos[1]);
		
		int[] numeros = new int[100];
		numeros[0] = 34;
		numeros[1] = 34;
		numeros[2] = 34;
		
		System.out.println(numeros[1]);
		System.out.println(numeros[8]);
		
		// Error porque tenemos desde 0 a 9 como índice: numeros[10] = 34;
	}

}
