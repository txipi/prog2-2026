package primerospasos;

import javax.swing.JOptionPane;

public class Adivino {

	public static void main(String[] args) {
		// Elegir un número aleatorio entre 1 y 100
		// secreto : int = random.randint(1, 100)
		int secreto = (int) (Math.random() * 100) + 1;
		
		// Fijar un número de intentos, por ejemplo 5
		// intentos : int = 5
		int intentos = 5;
		
		// numero : int = 0
		int numero = 0;
		
		// Mientras no hayamos acertado y queden intentos:
		// while (numero != secreto and intentos > 0): 
		while (numero != secreto && intentos > 0) {
			//   Pedir un número
			// respuesta : str = input("Introduce un número")
			String respuesta = JOptionPane.showInputDialog("Introduce un número");
			// numero = int(respuesta)
			numero = Integer.parseInt(respuesta);
			
			//   Comprobar el número y:
			//     Si no es correcto damos una pista (es mayor / es menor)
			//     Si es correcto, salimos del bucle
			// if (numero == secreto): 
			if (numero == secreto) {
				// print("Has acertado")
				System.out.println("Has acertado");
				JOptionPane.showMessageDialog(null, "¡Has acertado!");
			} else if (numero > secreto) {
				System.out.println("¡Has fallado! El número secreto es menor.");
				JOptionPane.showMessageDialog(null, "¡Has fallado! El número secreto es menor.");
			} else {
				System.out.println("¡Has fallado! El número secreto es mayor.");
				JOptionPane.showMessageDialog(null, "¡Has fallado! El número secreto es mayor.");
			}
			
			intentos--;
		}
	}
	
}
