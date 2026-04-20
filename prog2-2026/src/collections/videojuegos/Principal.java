package collections.videojuegos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import collections.wnba.Jugadora;

public class Principal {

	public static void generarVideojuegos(ArrayList<Videojuego> videojuegos, int num) {
		for (int i = 0; i < num; i++) {
			String titulo = "Videojuego " + i;
			int alea = (int) (Math.random() * Genero.values().length);
			Genero genero = Genero.values()[alea];
			String des;
			alea = (int) (Math.random() * 3);
			if (alea == 0) {
				des = "Microsoft";
			} else if (alea == 1) {
				des = "Activision";
			} else {
				des = "Nintendo";
			}			
			int pegi = (int) (Math.random() * 19);
			int copias = (int) (Math.random() * 10000) + 5000;
			double precio = Math.floor(Math.random() * 2000)/100 + 20.0;
			Videojuego videojuego = new Videojuego(titulo, genero, des, pegi, copias, precio);
			videojuegos.add(videojuego);
		}
	}

	public static void generarDuplicados(ArrayList<Videojuego> videojuegos, int num) {
		for (int i = 0; i < num; i++) {
			// Elegir un videojuego aleatorio de la lista de videojuegos
			int alea = (int) (Math.random() * videojuegos.size()); // generamos índice aleatorio
			Videojuego videojuego = videojuegos.get(alea); // usamos el índice para acceder al videojuego
			// Añadir el videojuego aleatorio a la lista
			videojuegos.add(videojuego);
		}
	}


	public static ArrayList<Videojuego> eliminarDuplicados(ArrayList<Videojuego> videojuegos) {
		HashSet<Videojuego> conjunto = new HashSet<Videojuego>(videojuegos);
		ArrayList<Videojuego> lista = new ArrayList<Videojuego>(conjunto); 
		return lista;
	}
	
	public static HashMap<Videojuego, Integer> contarVideojuegos(ArrayList<Videojuego> videojuegos) {
		HashMap<Videojuego, Integer> mapa = new HashMap<Videojuego, Integer>();
		
		for (Videojuego videojuego : videojuegos) {
			if (!mapa.containsKey(videojuego)) {
				mapa.put(videojuego, 1);
			} else {
				int valor = mapa.get(videojuego);
				mapa.put(videojuego, valor + 1);
			}
		}
		
		return mapa;
	}
	
	public static HashMap<Videojuego, Double> contarGanancias(ArrayList<Videojuego> videojuegos) {
		HashMap<Videojuego, Double> mapa = new HashMap<Videojuego, Double>();
		
		for (Videojuego videojuego : videojuegos) {
			double dinero = videojuego.getPrecio() * videojuego.getCopias();
			if (!mapa.containsKey(videojuego)) {
				mapa.put(videojuego, dinero);
			} else {
				double valor = mapa.get(videojuego);
				mapa.put(videojuego, valor + dinero);
			}
		}
		
		return mapa;
	}
	
	public static HashMap<Genero, ArrayList<Videojuego>> agruparPorGenero(ArrayList<Videojuego> videojuegos) {
		HashMap<Genero, ArrayList<Videojuego>> mapa = new HashMap<Genero, ArrayList<Videojuego>>();
		
		for (Videojuego videojuego : videojuegos) {
			Genero genero = videojuego.getGenero();
			
			if (!mapa.containsKey(genero)) {
				mapa.put(genero, new ArrayList<Videojuego>());
			}
			
			mapa.get(genero).add(videojuego);
		}
		
		return mapa;
	}
	
	public static void guardarBinario(ArrayList<Videojuego> videojuegos) {
		// fos -> oos -> writeObject
		try {
			FileOutputStream fos = new FileOutputStream("videojuegos.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(videojuegos);
			oos.close();
		} catch (Exception e) {
			System.out.println("Error: no hemos podido guardar los datos.");
		}
	}

	public static void main(String[] args) {
		ArrayList<Videojuego> videojuegos = new ArrayList<Videojuego>();

		// Generar 25 videojuegos diferentes
		generarVideojuegos(videojuegos, 25);
		
		System.out.println(videojuegos);
		
		// Añadir múltiples copias de esos 25 videojuegos a la lista videojuegos
		generarDuplicados(videojuegos, 5000);

		System.out.println(videojuegos.size());
		
		// Eliminar duplicados (Set) de la lista de videojuegos
	
		ArrayList<Videojuego> sinDuplicados = eliminarDuplicados(videojuegos);
		
		System.out.println(sinDuplicados.size());
		
		// Contar cuántas veces sale cada videojuego en la lista (Map)
		
		HashMap<Videojuego, Integer> mapaVideojuegos = contarVideojuegos(videojuegos);
		
		// Contar el total de ganancias de cada videojuego (Map)

		HashMap<Videojuego, Double> mapaGanancias = contarGanancias(videojuegos);
		
		// Agrupar los videojuegos por Genero (Map)
		
		HashMap<Genero, ArrayList<Videojuego>> mapaGeneros = agruparPorGenero(videojuegos);
	}

}
