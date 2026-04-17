package collections.canciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Principal {
	
	/*
	 * Método que cuenta la duración total de cada canción en la lista de canciones
	 */
	public static HashMap<Cancion, Double> duracionPorCancion (ArrayList<Cancion> canciones) {
		HashMap<Cancion, Double> mapa = new HashMap<Cancion, Double>();
		
		for (Cancion cancion : canciones) {
			double duracion = cancion.getDuracion();
			
			// Si el contador no existía, lo creamos
			if (!mapa.containsKey(cancion)) {
				mapa.put(cancion, 0.0);
			}
			
			// Actualizamos el valor asociado a esta clave sumando la duración de esta canción
			double valor = mapa.get(cancion);
			mapa.put(cancion, valor + duracion);
		}
		
		return mapa;
	}
	
	/*
	 * Método que cuenta cuántas veces sale cada canción en la lista de canciones
	 */
	public static HashMap<Cancion, Integer> contarCanciones (ArrayList<Cancion> canciones) {
		HashMap<Cancion, Integer> mapa = new HashMap<Cancion, Integer>();
		
		for (Cancion cancion : canciones) {
			if (!mapa.containsKey(cancion)) {
				mapa.put(cancion, 1);
			} else {
				int valor = mapa.get(cancion);
				mapa.put(cancion, valor + 1);
			}
		}
		
		return mapa;	
	}
	
	public static void main(String[] args) {
		ArrayList<Cancion> canciones = new ArrayList<Cancion>();
		HashSet<Cancion> conjunto = new HashSet<Cancion>();
		TreeSet<Cancion> conjuntoT = new TreeSet<Cancion>();
		
		for (int i = 0; i < 1000; i++) {
			Cancion cancion1 = new Cancion("Let it be", "Beatles", 341);
			Cancion cancion2 = new Cancion("Macarena", "Los del río", 501);
			Cancion cancion3 = new Cancion("Baby", "Justin Bieber", 171);
			Cancion cancion4 = new Cancion("Ave maría", "David Bisbal", 305);
			Cancion cancion5 = new Cancion("Manos rotas", "Morad", 189);
			canciones.add(cancion1);
			canciones.add(cancion2);
			canciones.add(cancion3);
			canciones.add(cancion4);
			canciones.add(cancion5);
			conjuntoT.add(cancion1);
			conjuntoT.add(cancion2);
			conjuntoT.add(cancion3);
			conjuntoT.add(cancion4);
			conjuntoT.add(cancion5);
		}
		
		// Eliminamos los duplicados de la lista canciones pasándolas a un conjunto
		conjunto = new HashSet<Cancion>(canciones);
		
		System.out.println(canciones.size());
		System.out.println(conjunto.size());
		
		System.out.println("Conjunto Hash:");
		for (Cancion cancion : conjunto) {
			System.out.println(cancion);
		}
		
		System.out.println("Conjunto Tree:");
		for (Cancion cancion : conjuntoT) {
			System.out.println(cancion);
		}
		
	}
}
