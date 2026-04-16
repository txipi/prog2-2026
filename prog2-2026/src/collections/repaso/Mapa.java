package collections.repaso;

import java.util.ArrayList;
import java.util.HashMap;

public class Mapa {

	public static void main(String[] args) {
		// Crear un mapa
		HashMap<String, Integer> mapa = new HashMap<String, Integer>();
		
		mapa.put("pan", 713);
		mapa.put("donuts", 22);
		mapa.put("palmeras", 65);
		mapa.put("leche", 265);
		
		// Usos típicos de mapas:
		
		// 1) Contar cosas 
		// - el valor es un número
		// - el mapa es un conjunto de contadores
		
		/*
		 * En Python se haría así:
		 * 
		 * diccionario : dict[str, int] = {}
		 * 
		 * for (letra in frase):
		 * 		if (letra not in diccionario):
		 * 			diccionario[letra] = 1
		 * 		else:
		 * 			diccionario[letra] = diccionario[letra] + 1
		 * 
		 */
		
		String frase = "esto es una frase cualquiera";
		
		HashMap<Character, Integer> mapaLetras = new HashMap<Character, Integer>();
		
		// Recorrer el String letra a letra
		for (int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);
			
			if (!mapaLetras.containsKey(letra)) {
				// Si el contador de esta letra no existía, lo añadimos al mapa
				mapaLetras.put(letra, 1);
			} else {
				// Si el contador de esta letra existía, sumamos 1 a su valor
				int valor = mapaLetras.get(letra);
				mapaLetras.put(letra, valor + 1);
			}
		}
		
		System.out.println(mapaLetras);
		
		// 2) Agrupar cosas
		// - el valor es una lista
		// - el mapa es un conjunto de listas
		
		/*
		 * diccionario : dict[str, list[str]] = {}
		 * 
		 * for (palabra in parrafo.split(" ")):
		 * 		inicial : str = palabra[0]
		 * 		if (inicial not in diccionario):
		 * 			diccionario[inicial] = []
		 *		diccionario[inicial].append(palabra)
		 * 
		 */
		
		HashMap<Character, ArrayList<String>> mapaPalabras = new HashMap<>();
		
		String parrafo = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis mattis tempor libero, vel viverra elit hendrerit vitae. Sed dignissim accumsan erat vel rhoncus. Vivamus elementum at augue pulvinar semper. Donec iaculis auctor risus eget porta. Etiam condimentum elementum augue, condimentum efficitur augue consectetur eu. Duis eleifend elementum massa at aliquet. In mollis ullamcorper sem rutrum commodo. Suspendisse sollicitudin maximus mi eu aliquam. Vivamus cursus mi leo, quis commodo sapien finibus sed. Nullam volutpat leo vitae auctor mattis. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc sagittis, ipsum nec sodales semper, neque enim aliquet massa, id mollis risus est nec felis. Sed a euismod purus. Maecenas enim justo, fermentum at mauris non, blandit facilisis ante. Ut et fringilla lacus, pulvinar rutrum massa.";

		// Recorrer el String palabra a palabra
		for (String palabra : parrafo.split(" ")) {
			char inicial = palabra.charAt(0);
			
			// Si no teníamos esa inicial en el mapa, la añadimos al mapa y
			// creamos una lista vacía para ir almacenando las palabras
			if (!mapaPalabras.containsKey(inicial)) {
				mapaPalabras.put(inicial, new ArrayList<String>());
			}
			
			mapaPalabras.get(inicial).add(palabra);
		}
		
		System.out.println(mapaPalabras);
	}

}
