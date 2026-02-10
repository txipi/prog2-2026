package primerospasos;

import java.util.Iterator;

public class Primera {
	public static void main(String[] args) {
		String frase = "En un lugar de La Mancha";
		String palabra = "";
		
		for (int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);
			if (letra != ' ') {
				palabra = palabra + letra;
			} else {
				break;
			}
		}
		
		System.out.println("La primera palabra era: " + palabra);
	}
}
