package primerospasos;

public class PrimerosPares {
	public static void main(String[] args) {
		int inicio = 31;
		int fin = 400;
		int cuantos = 5;
		
		for (int i = inicio; i <= fin && cuantos > 0; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
				cuantos--;
			}
		}
	}
}
