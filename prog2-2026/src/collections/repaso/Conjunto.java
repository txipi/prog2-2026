package collections.repaso;

import java.util.HashSet;
import java.util.TreeSet;

public class Conjunto {
	public static void main(String[] args) {
		// Un conjunto se gestiona como una lista pero:
		// - NO PERMITE DUPLICADOS
		// - NO SE PUEDE ACCEDER POR INDICE (posicion 0, 1, 2)
		// Los usamos para ELIMINAR DUPLICADOS
		
		// Crear un conjunto
		HashSet<String> palabrasH = new HashSet<String>(); // se usa hashCode()
		TreeSet<String> palabrasT = new TreeSet<String>(); // String implements Comparable
		
		// Añadir elementos a un conjunto
		palabrasH.add("Hola");
		palabrasH.add("Hola");
		palabrasH.add("Hola"); // Solo se añade una vez "Hola" porque está repetida
		palabrasH.add("mundo");
		
		// Acceder a un elemento de un conjunto
		// System.out.println(palabrasH.get(1)); ¡¡NO SE PUEDE!!

		// Borrar elementos de un conjunto
		// palabrasH.remove(0); ¡NO SE PUEDE BORRAR POR POSICIÓN!
		palabrasH.remove("Hola"); // Sí se puede borrar un elemento que sepamos que existe
		
		// Recorrer los elementos un conjunto
		for (String palabra : palabrasH) {
			System.out.println(palabra);
		}
	}
}
