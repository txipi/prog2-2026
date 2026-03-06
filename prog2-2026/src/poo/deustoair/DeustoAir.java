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
	
	public static void main(String[] args) {
		ArrayList<Aeronave> flota = new ArrayList<Aeronave>();

		flota.add(new Avioneta(226, 1289, 4, 450));   // similar a Cessna 172
		flota.add(new Avioneta(315, 1800, 6, 700));   // similar a Piper PA-32
		flota.add(new Helicoptero(260, 640, 6, 1200, 9));   // helicóptero ligero de rescate
		flota.add(new Helicoptero(287, 857, 12, 4000, 7));  // helicóptero medio de transporte
		flota.add(new Helice(667, 1500, 72, 2, 2750, 1200));   // similar a ATR 72
		flota.add(new Helice(540, 2000, 50, 2, 2500, 1100));   // similar a Dash 8
		flota.add(new Reaccion(840, 6100, 180, 2, 120000, 12000));  // similar a Boeing 737
		flota.add(new Reaccion(828, 5700, 150, 2, 110000, 12000));  // similar a Airbus A320
		flota.add(new Reaccion(900, 15000, 300, 4, 280000, 13000)); // similar a Boeing 747
		flota.add(new Reaccion(905, 14000, 250, 2, 320000, 13000)); // similar a Boeing 787
		
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

		aeropuertos.add(new Aeropuerto(40.4722, -3.5608, "MAD", 4,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Madrid-Barajas
		aeropuertos.add(new Aeropuerto(41.2974, 2.0833, "BCN", 3,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Barcelona-El Prat
		aeropuertos.add(new Aeropuerto(43.3011, -2.9106, "BIO", 2,
		        new SalaVIP(true, 20, new ArrayList<Pasajero>()))); // Bilbao
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
		
		System.out.println(vuelos);
		
		
	}

}
