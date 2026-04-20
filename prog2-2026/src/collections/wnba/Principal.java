package collections.wnba;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Principal {

	public static void main(String[] args) {
		ArrayList<Jugadora> jugadoras = new ArrayList<Jugadora>(); 
		
		// Generar 100 jugadoras
		generarJugadoras(jugadoras);
		
		System.out.println(jugadoras);
		
		// Generar algún duplicado en la lista de jugadoras
		
		for (int i = 0; i < 5; i++) {
			jugadoras.addAll(jugadoras);
		}
		
		System.out.println(jugadoras.size());
		
		// Eliminar duplicados de la lista de jugadoras (Set)
		
		HashSet<Jugadora> conjunto = new HashSet<Jugadora>(jugadoras);
		
		System.out.println(conjunto.size());
		
		jugadoras = new ArrayList<Jugadora>(conjunto);
		
		// Contar cuántas jugadoras hay en cada Posicion
		HashMap<Posicion, Integer> mapaPosiciones = contarJugadorasPosicion(jugadoras);
		
		System.out.println(mapaPosiciones);
		
		// Contar el total de altura que hay por cada Posicion
		
		HashMap<Posicion, Double> mapaAlturas = totalAlturaJugadorasPosicion(jugadoras);

		System.out.println(mapaAlturas);
		
		// Agrupar las jugadoras por posicion
		
		HashMap<Posicion, ArrayList<Jugadora>> mapaAgrupacion = agruparJugadorasPosicion(jugadoras);
		
		System.out.println(mapaAgrupacion);
		
		// Guardar la lista de jugadoras en un fichero binario
		guardarBinario(jugadoras);
	}

	public static void guardarBinario(ArrayList<Jugadora> jugadoras) {
		// fos -> oos -> writeObject (IMPORTANTE: Serializable)
		try {
			FileOutputStream fos = new FileOutputStream("jugadoras.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(jugadoras);
			oos.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error: no hemos podido guardar los datos.");
		}
	}

	public static void cargarBinario(ArrayList<Jugadora> jugadoras) {
		// fis -> ois -> readObject (IMPORTANTE: Serializable)
		try {
			FileInputStream fis = new FileInputStream("jugadoras.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			jugadoras = (ArrayList<Jugadora>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error: no hemos podido cargar los datos.");
		}
	}
	
	public static HashMap<Posicion, ArrayList<Jugadora>> agruparJugadorasPosicion(ArrayList<Jugadora> jugadoras) {
		HashMap<Posicion, ArrayList<Jugadora>> mapa = new HashMap<Posicion, ArrayList<Jugadora>>();
		
		for (Jugadora jugadora : jugadoras) {
			Posicion posicion = jugadora.getPosicion();
			
			if (!mapa.containsKey(posicion)) {
				mapa.put(posicion, new ArrayList<Jugadora>());
			}
			
			mapa.get(posicion).add(jugadora);
		}
		
		return mapa;
	}

	public static HashMap<Posicion, Double> totalAlturaJugadorasPosicion(ArrayList<Jugadora> jugadoras) {
		HashMap<Posicion, Double> mapa = new HashMap<Posicion, Double>();
		
		for (Jugadora jugadora : jugadoras) {
			Posicion posicion = jugadora.getPosicion();
			double altura = jugadora.getAltura();
			
			if (!mapa.containsKey(posicion)) {
				mapa.put(posicion, altura);
			} else {
				double valor = mapa.get(posicion);
				mapa.put(posicion, valor + altura);
			}
		}
		
		return mapa;
	}

	public static HashMap<Posicion, Integer> contarJugadorasPosicion(ArrayList<Jugadora> jugadoras) {
		HashMap<Posicion, Integer> mapa = new HashMap<Posicion, Integer>();
		
		for (Jugadora jugadora : jugadoras) {
			Posicion posicion = jugadora.getPosicion();
			
			if (!mapa.containsKey(posicion)) {
				mapa.put(posicion, 1);
			} else {
				int valor = mapa.get(posicion);
				mapa.put(posicion, valor + 1);
			}
		}
		
		return mapa;
	}

	public static void generarJugadoras(ArrayList<Jugadora> jugadoras) {
		for (int i = 0; i < 100; i++) {
			String nombre = "Jugadora " + i;
			double altura = 1.70 + Math.random() * 0.30;
			//int alea = (int) (Math.random() * Posicion.values().length);
			//Posicion posicion = Posicion.values()[alea];
			Posicion posicion;
			if (altura < 1.75) {
				posicion = Posicion.BASE;
			} else if (altura < 1.80) {
				posicion = Posicion.ESCOLTA;
			} else if (altura < 1.85) {
				posicion = Posicion.ALERO;
			} else if (altura < 1.90) {
				posicion = Posicion.ALAPIVOT;
			} else {
				posicion = Posicion.PIVOT;
			}
			int vel = 50 + (int) (Math.random() * 50);
			int fue = 50 + (int) (Math.random() * 50);
			int tiro = 50 + (int) (Math.random() * 50);
			int def = 50 + (int) (Math.random() * 50);
			
			Jugadora jugadora = new Jugadora(nombre, altura, posicion, vel, fue, tiro, def);
			jugadoras.add(jugadora);
		}
	}

}
