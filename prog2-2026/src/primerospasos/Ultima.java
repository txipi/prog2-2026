package primerospasos;

public class Ultima {

	public static void main(String[] args) {
		String frase = "En un lugar de La Mancha";
		String palabra = "";
		
		for (int i = frase.length() - 1; i >= 0; i--) {
			char letra = frase.charAt(i);
			if (letra != ' ') {
				palabra = letra + palabra;
			} else {
				break;
			}
		}
		
		System.out.println("La última palabra era: " + palabra);
	}

}
