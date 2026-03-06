package poo.deustoair;

import java.time.LocalDate;
import java.util.ArrayList;

public class DeustoAir {

	/*
	 * Método estático que recibe una lista de aeronaves, pasajeros y aeropuertos y
	 * devuelve una lista de 20 vuelos, creados de la siguiente manera:
	 * - El código será DEUS0, DEUS1, DEUS2...
	 * - La hora será hoy (ahora).
	 * - La aeronave será una aleatoria de entre las que tiene la lista de aeronaves.
	 * - Los pasajeros serán 10 elegidos aleatoriamente de la lista de pasajeros.
	 * - El origen del vuelo será un aeropuerto aleatorio de la lista de aeropuertos.
	 * - El destino del vuelo será un aeropuerto aleatorio de la lista de aeropuertos (no puede ser el mismo que el origen).
	 */
	public static ArrayList<Vuelo> generarVuelos (ArrayList<Aeronave> flota, 
			ArrayList<Pasajero> pasajeros, ArrayList<Aeropuerto> aeropuertos) {
		ArrayList<Vuelo> vuelos = new ArrayList<Vuelo>();
		
		for (int i = 0; i < 20; i++) {
			Vuelo vuelo = new Vuelo();
			vuelo.setCodigo("DEUS"+i);
			vuelo.setHora(LocalDate.now());
			int aleatorio = (int) (Math.random() * flota.size());
			vuelo.setAeronave(flota.get(aleatorio));
			aleatorio = (int) (Math.random() * aeropuertos.size());
			vuelo.setOrigen(aeropuertos.get(aleatorio));
			aleatorio = (int) (Math.random() * aeropuertos.size());
			// En este caso valdría con aeropuertos.get(aleatorio) == vuelo.getOrigen() porque son los mismos aeropuertos
			// pero vamos a comparar con equals porque son objetos y es mejor comparar objetos con equals:
			// Aeropuerto origen = vuelo.getOrigen();
			// Aeropuerto destino = aeropuertos.get(aleatorio);
			// while ( origen.equals(destino) ) {...}
			while (aeropuertos.get(aleatorio).equals(vuelo.getOrigen())) {
				// Coinciden origen y destino, hay que buscar otro destino
				aleatorio = (int) (Math.random() * aeropuertos.size());
			}
			vuelo.setDestino(aeropuertos.get(aleatorio));
			
			for (int j = 0; j < 10; j++) {
				aleatorio = (int) (Math.random() * pasajeros.size());
				// Si la lista de pasajeros de este vuelo (vuelos.getPasajeros()) contiene
				// el pasajero de la posicion "aleatorio" de la lista de pasajeros, no nos vale porque ya estaba
				while (vuelo.getPasajeros().contains(pasajeros.get(aleatorio))) {
					aleatorio = (int) (Math.random() * pasajeros.size());
				}
				Pasajero pasajero = pasajeros.get(aleatorio);
				vuelo.getPasajeros().add(pasajero);
			}
			
			vuelos.add(vuelo);
		}
		
		return vuelos;
	}
	
	/*
	 * buscarVuelosOrigen: método estático que recibe una lista de vuelos y un aeropuerto y devuelve
	 * una lista vuelos con los vuelos que tengan como origen el aeropuerto que nos han pasado 
	 */
	public static ArrayList<Vuelo> buscarVuelosOrigen (ArrayList<Vuelo> vuelos, Aeropuerto aeropuerto) {
		ArrayList<Vuelo> resultado = new ArrayList<Vuelo>();

		for (Vuelo vuelo : vuelos) {
			if (vuelo.getOrigen().equals(aeropuerto)) {
				resultado.add(vuelo);
			}
		}
		
		return resultado;
	}
	
	/*
	 * buscarVuelosAeronave: método estático que recibe una lista de vuelos y una aeronave y devuelve
	 * una lista vuelos con los vuelos que tengan la aeronave que nos han pasado 
	 */
	public static ArrayList<Vuelo> buscarVuelosAeronave (ArrayList<Vuelo> vuelos, Aeronave aeronave) {
		ArrayList<Vuelo> resultado = new ArrayList<Vuelo>();

		for (Vuelo vuelo : vuelos) {
			if (vuelo.getAeronave().equals(aeronave)) {
				resultado.add(vuelo);
			}
		}
		
		return resultado;
	}
	
	
	/*
	 * mayorAeronave: método estático que recibe una lista de vuelos y devuelve
	 * la aeronave que más se ha utilizado en todos esos vuelos
	 */
	
	public static Aeronave mayorAeronave (ArrayList<Vuelo> vuelos) {
		Aeronave mayor = vuelos.get(0).getAeronave();
		
		for (Vuelo vuelo : vuelos) {
			// Busco los vuelos que se vuelan con la aeronave "mayor"
			ArrayList<Vuelo> vuelosMayor = buscarVuelosAeronave(vuelos, mayor);
			// Busco los vuelos que se vuelan con la aeronave "actual" (vuelo.getAeronave())
			ArrayList<Vuelo> vuelosActual = buscarVuelosAeronave(vuelos, vuelo.getAeronave());
			// Comparo el tamaño de las dos listas
			if (vuelosActual.size() > vuelosMayor.size()) { 
				mayor = vuelo.getAeronave();
			}
		}
		
		return mayor;
	}

	/*
	 * mostrarEstadisticas: método estático que recibe una lista de vuelos y muestra por pantalla
	 * (no devuelve nada) la siguiente información:
	 * - Aeronave X: 3 vuelos.
	 * - Aeronave Y: 2 vuelos.
	 * - Aeronave Z: 3 vuelos.
	 * - Aeronave W: 2 vuelos.
	 * ...
	 */
	public static void mostrarEstadisticas(ArrayList<Vuelo> vuelos) {
		// Creamos una lista con todas las aeronaves (no repetidas)
		ArrayList<Aeronave> aeronaves = new ArrayList<Aeronave>();
		
		for (Vuelo vuelo : vuelos) {
			// Si la aeronave de este vuelo no está contenida en la lista, la añadimos
			if (!aeronaves.contains(vuelo.getAeronave())) {
				aeronaves.add(vuelo.getAeronave());
			}
		}
		
		for (Aeronave aeronave : aeronaves) {
			// Preguntamos cuántos vuelos se vuelan con esta aeronave
			ArrayList<Vuelo> vuelosDeEstaAeronave = buscarVuelosAeronave(vuelos, aeronave);
			// Mostramos la información
			System.out.println(aeronave + ": " + vuelosDeEstaAeronave.size() + " vuelos.");
		}
	}
	
	
	public static void main(String[] args) {
		ArrayList<Aeronave> flota = new ArrayList<Aeronave>();

		Avioneta avioneta1 = new Avioneta(226, 1289, 4, 450);   // similar a Cessna 172
		Avioneta avioneta2 = new Avioneta(315, 1800, 6, 700);   // similar a Piper PA-32
		Helicoptero helicoptero1 = new Helicoptero(260, 640, 6, 1200, 9);   // helicóptero ligero de rescate
		Helicoptero helicoptero2 = new Helicoptero(287, 857, 12, 4000, 7);  // helicóptero medio de transporte
		Helice helice1 = new Helice(667, 1500, 72, 2, 2750, 1200);   // similar a ATR 72
		Helice helice2 = new Helice(540, 2000, 50, 2, 2500, 1100);   // similar a Dash 8
		Reaccion reaccion1 = new Reaccion(840, 6100, 180, 2, 120000, 12000);  // similar a Boeing 737
		Reaccion reaccion2 = new Reaccion(828, 5700, 150, 2, 110000, 12000);  // similar a Airbus A320
		Reaccion reaccion3 = new Reaccion(900, 15000, 300, 4, 280000, 13000); // similar a Boeing 747
		Reaccion reaccion4 = new Reaccion(905, 14000, 250, 2, 320000, 13000); // similar a Boeing 787
		
		flota.add(avioneta1);
		flota.add(avioneta2);
		flota.add(helicoptero1);
		flota.add(helicoptero2);
		flota.add(helice1);
		flota.add(helice2);
		flota.add(reaccion1);
		flota.add(reaccion2);
		flota.add(reaccion3);
		flota.add(reaccion4);
		
		ArrayList<Pasajero> pasajeros = new ArrayList<>();

		pasajeros.add(new Pasajero("Juan", "García", "12345678A"));
		pasajeros.add(new Pasajero("María", "López", "23456789B"));
		pasajeros.add(new Pasajero("Carlos", "Martínez", "34567890C"));
		pasajeros.add(new Pasajero("Lucía", "Fernández", "45678901D"));
		pasajeros.add(new Pasajero("Pedro", "Sánchez", "56789012E"));
		pasajeros.add(new Pasajero("Ana", "Gómez", "67890123F"));
		pasajeros.add(new Pasajero("David", "Pérez", "78901234G"));
		pasajeros.add(new Pasajero("Elena", "Ruiz", "89012345H"));
		pasajeros.add(new Pasajero("Miguel", "Díaz", "90123456J"));
		pasajeros.add(new Pasajero("Sara", "Moreno", "11223344K"));
		pasajeros.add(new Pasajero("John", "Smith", "AA123456"));
		pasajeros.add(new Pasajero("Emily", "Johnson", "BB234567"));
		pasajeros.add(new Pasajero("Michael", "Brown", "CC345678"));
		pasajeros.add(new Pasajero("Sarah", "Davis", "DD456789"));
		pasajeros.add(new Pasajero("William", "Wilson", "EE567890"));
		pasajeros.add(new Pasajero("Olivia", "Taylor", "FF678901"));
		pasajeros.add(new Pasajero("James", "Anderson", "GG789012"));
		pasajeros.add(new Pasajero("Isabella", "Thomas", "HH890123"));
		pasajeros.add(new Pasajero("Daniel", "Moore", "II901234"));
		pasajeros.add(new Pasajero("Charlotte", "Martin", "JJ012345"));
		
		ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();

		Aeropuerto bilbao = new Aeropuerto(43.3011, -2.9106, "BIO", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>())); // Bilbao
		aeropuertos.add(bilbao);
		aeropuertos.add(new Aeropuerto(40.4722, -3.5608, "MAD", 4,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Madrid-Barajas
		aeropuertos.add(new Aeropuerto(41.2974, 2.0833, "BCN", 3,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Barcelona-El Prat
		aeropuertos.add(new Aeropuerto(36.6749, -4.4991, "AGP", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Málaga
		aeropuertos.add(new Aeropuerto(39.4893, -0.4816, "VLC", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Valencia
		aeropuertos.add(new Aeropuerto(51.4700, -0.4543, "LHR", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Londres Heathrow
		aeropuertos.add(new Aeropuerto(48.3538, 11.7861, "MUC", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Múnich
		aeropuertos.add(new Aeropuerto(49.0097, 2.5479, "CDG", 4,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // París CDG
		aeropuertos.add(new Aeropuerto(52.3105, 4.7683, "AMS", 6,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Ámsterdam
		aeropuertos.add(new Aeropuerto(50.0379, 8.5622, "FRA", 4,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Frankfurt
		aeropuertos.add(new Aeropuerto(41.8003, 12.2389, "FCO", 3,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Roma Fiumicino
		aeropuertos.add(new Aeropuerto(40.6413, -73.7781, "JFK", 4,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Nueva York JFK
		aeropuertos.add(new Aeropuerto(33.9416, -118.4085, "LAX", 4,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Los Ángeles
		aeropuertos.add(new Aeropuerto(25.2532, 55.3657, "DXB", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Dubái
		aeropuertos.add(new Aeropuerto(35.5494, 139.7798, "HND", 4,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Tokio Haneda
		aeropuertos.add(new Aeropuerto(1.3644, 103.9915, "SIN", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Singapur Changi
		aeropuertos.add(new Aeropuerto(-33.9399, 151.1753, "SYD", 3,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Sídney
		aeropuertos.add(new Aeropuerto(-23.4356, -46.4731, "GRU", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // São Paulo
		aeropuertos.add(new Aeropuerto(19.4361, -99.0719, "MEX", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Ciudad de México
		aeropuertos.add(new Aeropuerto(37.4602, 126.4407, "ICN", 3,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Seúl Incheon
		
		ArrayList<Vuelo> vuelos = generarVuelos(flota, pasajeros, aeropuertos);
		
		System.out.println("Mostrando todos los vuelos...");
		System.out.println(vuelos);
		
		System.out.println("Mostrando todos los vuelos desde Bilbao...");
		System.out.println(buscarVuelosOrigen(vuelos, bilbao));
		
		System.out.println("Mostrando todos los vuelos con la avioneta1...");
		System.out.println(buscarVuelosAeronave(vuelos, avioneta1));
		
		System.out.println("Mostrando la aeronave más utilizada...");
		System.out.println(mayorAeronave(vuelos));
		
		System.out.println("Mostrando estadísticas...");
		mostrarEstadisticas(vuelos);
		
	}

}
