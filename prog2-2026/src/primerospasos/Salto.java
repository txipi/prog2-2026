package primerospasos;

import javax.swing.JOptionPane;

public class Salto {

	public static void main(String[] args) {
		/* 
		 * Define la velocidad inicial y el ángulo de salto de una persona y la gravedad para devolver 
		 * la longitud que recorrería en ese planeta:
		 * longitud = (v^2 * sen(2*angulo)) / g
		 * 
		 * Una persona que salte con un ángulo de 45º a 4 m/s en un planeta 
		 * con g = 1.633 m/s2 recorrería 9.797 m.
		 */
		
		// Datos de entrada
		// Scanner / JOptionPane
		
		String respuestaVelocidad = JOptionPane.showInputDialog("Introduce la velocidad: ");
		String respuestaAngulo = JOptionPane.showInputDialog("Introduce el ángulo: ");
		String respuestaG = JOptionPane.showInputDialog("Introduce la gravedad: ");
				
		double velocidad = Double.parseDouble(respuestaVelocidad);
		double angulo = Double.parseDouble(respuestaAngulo);
		double g = Double.parseDouble(respuestaG);
				
		// Cálculo
		
		double longitud = velocidad * velocidad * Math.sin(2 * Math.toRadians(angulo)) / g;
		
		// Datos de salida

		System.out.println("Una persona que salte con un ángulo de "+angulo+"º a "+velocidad+" m/s en un planeta con g = "+g+" m/s2 recorrería "+longitud+" m.");
		JOptionPane.showMessageDialog(null, "Una persona que salte con un ángulo de "+angulo+"º a "+velocidad+" m/s en un planeta con g = "+g+" m/s2 recorrería "+longitud+" m.");
	}

}
