package primerospasos;

import java.util.ArrayList;

public class Matematicas {

	// def sumar(a:int, b:int) -> int:
	//   return a + b
	
	public static int sumar (int a, int b) {
		return a + b;
	}
	
	public static int sumatorio (int a, int b) {
		int resultado = 0; // a + 0 = a
		
		for (int i = a; i <= b; i++) {
			resultado += i; // resultado = resultado + i
		}
		
		return resultado;
	}
	
	public static int sumatorio (ArrayList<Integer> lista) {
		int resultado = 0;
		
		// for i in range(0, len(lista)):
		//     resultado = resultado + lista[i]
		
		//for (int i = 0; i < lista.size(); i++) {
		//	resultado += lista.get(i); // resultado = resultado + lista.get(i);
		//}
		
		for (Integer numero : lista) {
			resultado += numero;
		}
		
		return resultado;
	}
	
	public static int producto (int a, int b) {
		int resultado = 1; // a * 1 = a
		
		for (int i = a; i <= b; i++) {
			resultado *= i; // resultado = resultado * i
		}
		
		return resultado;
	}
	
	public static int producto (ArrayList<Integer> lista) {
		int resultado = 1;
		
		for (Integer numero : lista) {
			resultado *= numero;
		}
		
		return resultado;
	}
	
	public static int factorial (int n) {
		return producto(1, n);
	}
	
	public static void main(String[] args) {
		System.out.println(sumar(1, 7));
		System.out.println(sumatorio(1, 100));
		System.out.println(producto(1, 100));
		// No cabe en un int: 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000

		ArrayList<Integer> numeros = new ArrayList<Integer>();
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		System.out.println(producto(numeros)); 

	}
	
}
