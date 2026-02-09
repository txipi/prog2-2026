package primerospasos;

public class Bucles {

	public static void main(String[] args) {
		// Bucle while
		
		int i = 0;
		while (i <= 10) {
			System.out.println(i);
			i++;
		}
		
		// Bucles for
		for (int j = 0; j <= 10; j++) {
			System.out.println(j);
		}

		// range(12, 500)
		for (int j = 12; j < 500; j++) {
			System.out.println(j);
		}
		
		// range(0, 25, 1) == range(25)
		for (int j = 0; j < 25; j++) {
			System.out.println(j);
		}
		
		// range(3, 77, 2)
		for (int j = 3; j < 77; j += 2) {
			System.out.println(j);
		}
		
	}

}
