package collections.canciones;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class Principal {
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
