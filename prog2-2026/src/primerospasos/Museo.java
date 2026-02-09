package primerospasos;

import javax.swing.JOptionPane;

public class Museo {

	/*
	 * Pide la edad por teclado y muestra por pantalla el precio de la entrada al museo
	 * teniendo en cuenta que:
	 * - Hasta 7 años, entran gratis, precio : 0.0
	 * - Entre 8 y 17 años, el precio es joven: 5.0.
	 * - De 18 a 64 años, el precio es normal: 7.0.
	 * - De 65 años en adelante, el precio es senior: 6.0.
	 */
	
	public static void main(String[] args) {
		// Pedir la edad
		String respuesta = JOptionPane.showInputDialog("Introduce la edad: ");
		int edad = Integer.parseInt(respuesta);
		
		// Calcular el precio, con varios if
		double precio = 0.0;
		
		if (edad <= 7) {
			precio = 0.0;
		} else if (edad < 18) {
			precio = 5.0;
		} else if (edad < 65) {
			precio = 7.0;
		} else {
			precio = 6.0;
		}
		
		// Mostrar el precio
		System.out.println(precio);
		JOptionPane.showMessageDialog(null, precio);
	}

}
