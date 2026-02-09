package primerospasos;

public class Palabras {

	public static void main(String[] args) {
		char letra = 'a';
		String palabra = "hola";
		String palabra2 = "hol";
		
		palabra2 = palabra2 + 'a';
		
		System.out.println(letra);
		System.out.println(palabra);
		System.out.println(palabra.length());
		System.out.println(palabra.toUpperCase());
		System.out.println(palabra2);
		
		// if (a == 1):
		if (palabra == palabra2) {
			System.out.println("Sí es exactamente el mismo String");
		} else {
			System.out.println("No es exactamente el mismo String");
		}
		
		if (palabra.equals(palabra2)) {
			System.out.println("Sí contiene los mismos chars");
		} else {
			System.out.println("No contiene los mismos chars");
		}
		
		
	}
}
