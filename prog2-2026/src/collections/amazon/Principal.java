package collections.amazon;

import java.util.Iterator;
import java.util.LinkedList;

public class Principal {

	public static void main(String[] args) {
		LinkedList<Pedido> colaCobrar = new LinkedList<Pedido>();
		LinkedList<Pedido> colaPreparar = new LinkedList<Pedido>();
		LinkedList<Pedido> colaEnviar = new LinkedList<Pedido>();
		
		for (int i = 0; i < 20; i++) {
			Pedido pedido = new Pedido();
			pedido.setDescripcion("Pedido " + i);
			int alea = (int) (Math.random() * 3) + 1; // random entre 1 y 3
			pedido.setCobrar(alea);
			alea = (int) (Math.random() * 3) + 1; // random entre 1 y 3
			pedido.setPreparar(alea);
			alea = (int) (Math.random() * 3) + 1; // random entre 1 y 3
			pedido.setEnviar(alea);
			colaCobrar.addLast(pedido);
		}
		
		System.out.println(colaCobrar);
		
		// Simular que pasa el tiempo

		for (int t = 0; t < 100; t++) {
			System.out.println("Hora: " + t);
//			for (Pedido pedido : colaCobrar) {
//				int horas = pedido.getCobrar();
//				if (horas == 0) {
//					// Hay que sacarlo de esta cola y meterlo en colaPreparar
//					// PERO DARÍA ERROR PORQUE NO SE PUEDEN AÑADIR O ELIMINAR
//					// ELEMENTOS DE UNA COLECCION DE DATOS SI LA ESTAMOS RECORRIENDO CON for
//				}
//				pedido.setCobrar(horas - 1);
//			}
			while(!colaCobrar.isEmpty()) {
				Pedido atendido = colaCobrar.removeFirst();
				int horas = atendido.getCobrar();
				if (horas == 0) {
					// Hay que sacarlo de esta cola y meterlo en colaPreparar
					colaPreparar.addLast(atendido);
				} else {
					atendido.setCobrar(horas - 1);
					// ¿LO VOLVEMOS A AÑADIR A LA COLACOBRAR? NO, PORQUE NO TERMINA EL WHILE
				}
			}
		}
		
		
	}

}
