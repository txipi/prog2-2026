package collections.amazon;

import java.util.ArrayList;
import java.util.Collections;
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
		
		// Simular que pasa el tiempo (10 horas)

		for (int t = 0; t < 10; t++) {
			System.out.println("Hora: " + t);
			// Tenemos que recorrer colaCobrar y actualizar
			// las horas restantes de cada pedido.
			// Si alguno llega a 0, está cobrado y pasa a la 
			// siguiente cola...

//			for (Pedido pedido : colaCobrar) {
//				int horas = pedido.getCobrar();
//				if (horas == 0) {
//					// Hay que sacarlo de esta cola y meterlo en colaPreparar
//					// PERO DARÍA ERROR PORQUE NO SE PUEDEN AÑADIR O ELIMINAR
//					// ELEMENTOS DE UNA COLECCION DE DATOS SI LA ESTAMOS RECORRIENDO CON for
//				}
//				pedido.setCobrar(horas - 1);
//			}
//			while(!colaCobrar.isEmpty()) {
//				Pedido atendido = colaCobrar.removeFirst();
//				int horas = atendido.getCobrar();
//				if (horas == 0) {
//					// Hay que sacarlo de esta cola y meterlo en colaPreparar
//					colaPreparar.addLast(atendido);
//				} else {
//					atendido.setCobrar(horas - 1);
//					// ¿LO VOLVEMOS A AÑADIR A LA COLACOBRAR? NO, PORQUE NO TERMINA EL WHILE
//				}
//			}

			// Creamos una lista para guardar qué pedidos hay que borrar
			ArrayList<Pedido> borrar = new ArrayList<Pedido>();
			
			for (Pedido pedido : colaCobrar) {
				int horas = pedido.getCobrar();
				if (horas == 0) {
					// No podemos borrar este pedido de colaCobrar directamente
					// porque estamos recorriendo colabCobrar, así que lo marcamos
					// para borrarlo luego, metiéndolo en la lista borrar
					borrar.add(pedido);
					colaPreparar.add(pedido);
					System.out.println(pedido.getDescripcion() + " cobrado");
				} else {
					pedido.setCobrar(horas - 1);
				}
			}
			
			// Una vez que hemos terminado de recorrer colaCobrar, podemos
			// borrar todos los pedidos marcados para borrar con removeAll
			colaCobrar.removeAll(borrar);
			borrar = new ArrayList<Pedido>();

			// Hacemos lo mismo para la colaPreparar
			for (Pedido pedido : colaPreparar) {
				int horas = pedido.getPreparar();
				if (horas == 0) {
					borrar.add(pedido);
					colaEnviar.add(pedido);
					System.out.println(pedido.getDescripcion() + " preparado");
				} else {
					pedido.setPreparar(horas - 1);
				}
			}
			
			colaPreparar.removeAll(borrar);
			borrar = new ArrayList<Pedido>();
			
			// Hacemos lo mismo para la colaEnviar
			for (Pedido pedido : colaEnviar) {
				int horas = pedido.getEnviar();
				if (horas == 0) {
					borrar.add(pedido);
					System.out.println(pedido.getDescripcion() + " enviado");
				} else {
					pedido.setEnviar(horas - 1);
				}
			}
			
			colaEnviar.removeAll(borrar);
			borrar = new ArrayList<Pedido>();
			
			System.out.println("Cola cobrar:");
			for (Pedido pedido : colaCobrar) {
				System.out.println(pedido.getDescripcion());
			}
			System.out.println("Cola preparar:");
			for (Pedido pedido : colaPreparar) {
				System.out.println(pedido.getDescripcion());
			}
			System.out.println("Cola enviar:");
			for (Pedido pedido : colaEnviar) {
				System.out.println(pedido.getDescripcion());
			}
		}		
	}

}
