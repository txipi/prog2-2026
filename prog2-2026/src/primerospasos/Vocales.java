package primerospasos;

public class Vocales {

	public static void main(String[] args) {
		String frase = "En un lugar de La Mancha";
		String vocales = "aeiouAEIOU";
		int contador = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);
			if (vocales.indexOf(letra) >= 0) {
				contador++;
			}
		}
		
		System.out.println("La frase tiene " + contador + " vocales.");

	}

}
