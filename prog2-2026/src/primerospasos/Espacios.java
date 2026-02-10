package primerospasos;

public class Espacios {

	public static void main(String[] args) {
		String frase = "En un lugar de La Mancha";
		int contador = 0;
		
		for (int i = 0; i < frase.length(); i++) {
			if (frase.charAt(i) == ' ') {
				contador++;
			}
		}
		
		System.out.println("La frase tiene " + contador + " espacios.");
	}

}
