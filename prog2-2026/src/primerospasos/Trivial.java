package primerospasos;

import javax.swing.JOptionPane;

public class Trivial {

	public static void main(String[] args) {
		// Crear una variable para guardar la puntuacion
		int puntuacion = 0;
		
		// Crear una variable para guardar el número de preguntas = 5
		int preguntas = 5;
		
		// Hacer un bucle que repita "numero de preguntas" veces:
		// 		Hacer una pregunta: ¿A qué temperatura se congela el agua? -> 0
		// 		Comprobar, si está bien, sumamos 1 a la puntuación
		
		// for i in range(preguntas):
		for (int i = 0; i < preguntas; i++) {
			int numero1 = (int) (Math.random() * 10) + 1;
			int numero2 = (int) (Math.random() * 10) + 1;
			String respuesta = JOptionPane.showInputDialog("¿" + numero1 + " + " + numero2 + "?");
			int numero = Integer.parseInt(respuesta);
			if (numero == numero1 + numero2) {
				JOptionPane.showMessageDialog(null, "Has acertado");
				puntuacion++;
			} else {
				JOptionPane.showMessageDialog(null, "Has fallado");
			}
		}
		
		// Finalmente, mostramos la puntuación
		JOptionPane.showMessageDialog(null, "Tu puntuación es " + puntuacion + " / " + preguntas);

	}

}
