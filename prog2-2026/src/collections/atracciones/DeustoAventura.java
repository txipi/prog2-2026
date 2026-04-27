package collections.atracciones;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DeustoAventura {

	public static void main(String[] args) {
		// Lista de atracciones de DeustoAventura
		Atraccion[] ats = {
				new Atraccion("Carrusel", 0, 50),
				new Atraccion("Montaña rusa", 140, 25),
				new Atraccion("Autos locos", 100, 35),
				new Atraccion("Mansión embrujada", 120, 15),
				new Atraccion("Water splash", 90, 40)
		};
		ArrayList<Atraccion> atracciones = new ArrayList<Atraccion>(Arrays.asList(ats));

		// EJERCICIO 1: Cargar lista de visitantes de DeustoAventura
		ArrayList<Visitante> visitantes = cargaDatosVisitantes2();
		System.out.println(visitantes.size()); // debería mostrar 50
		Collections.sort(visitantes);
		System.out.println(visitantes); // debería mostrar la lista de visitantes ordenada por altura
		
		// EJERCICIO 2: Asignar atracciones a visitantes
		asignarAtracciones(atracciones, visitantes);
		System.out.println(visitantes.get(0)); // debería mostrar un visitante con 3 atracciones asignadas
		
		// EJERCICIO 3: Contar visitantes por tipo de entrada
		HashMap<Entrada, Integer> numeroPorEntrada = contarVisitantes(visitantes);
		System.out.println(numeroPorEntrada); // debería mostrar {VIP=8, EXPRESS=17, NORMAL=25}
		
		// EJERCICIO 4: Agrupar visitantes por atracción
		HashMap<Atraccion, LinkedList<Visitante>> visitantesPorAtraccion = agruparVisitantes(visitantes);
		System.out.println(visitantesPorAtraccion.get(atracciones.get(0)).size()); // debería mostrar un número aleatorio entre 0 y 50 
		
		// EJERCICIO 5: Simular el comportamiento de los visitantes
		//simularComportamiento(visitantesPorAtraccion);
		
		// EXTRA: Simular el comportamiento de los visitantes teniendo en cuenta la duración de las atracciones
		simularComportamientoExtra(visitantesPorAtraccion);
	}

	public static void simularComportamientoExtra(HashMap<Atraccion, LinkedList<Visitante>> mapa) {
		for (Atraccion clave : mapa.keySet()) {
			LinkedList<Visitante> valor = mapa.get(clave);
			int contador = 0;
			System.out.println("Atracción " + clave.getNombre());
			// Preparamos 3 sub-colas en función del tipo de entrada:
			LinkedList<Visitante> colaNormal = new LinkedList<Visitante>(); 
			LinkedList<Visitante> colaExpress = new LinkedList<Visitante>();
			LinkedList<Visitante> colaVip = new LinkedList<Visitante>();
			// Llenamos las sub-colas, vaciando la cola principal
			while (!valor.isEmpty()) {
				Visitante visitante = valor.removeFirst();
				if (visitante.getEntrada().equals(Entrada.VIP)) {
					colaVip.add(visitante);
				} else if (visitante.getEntrada().equals(Entrada.EXPRESS)) {
					colaExpress.add(visitante);
				} else {
					colaNormal.add(visitante);
				}
			}
			// Vaciamos la cola VIP
			while (!colaVip.isEmpty()) {
				Visitante visitante = colaVip.removeFirst();
				if (visitante.getAltura() >= clave.getAltura()) {
					System.out.println("Entra el visitante " + visitante.getCodigo());
					contador++;
					if (contador >= clave.getCapacidad()) {
						System.out.println("Siguiente turno");
						contador = 0;
					}
				} else {
					System.out.println(visitante.getCodigo() + " no puede entrar por falta de altura");
				}
			}
			// Vaciamos la cola Express
			while (!colaExpress.isEmpty()) {
				Visitante visitante = colaExpress.removeFirst();
				if (visitante.getAltura() >= clave.getAltura()) {
					System.out.println("Entra el visitante " + visitante.getCodigo());
					contador++;
					if (contador >= clave.getCapacidad()) {
						System.out.println("Siguiente turno");
						contador = 0;
					}
				} else {
					System.out.println(visitante.getCodigo() + " no puede entrar por falta de altura");
				}
			}
			// Vaciamos la cola Normal
			while (!colaNormal.isEmpty()) {
				Visitante visitante = colaNormal.removeFirst();
				if (visitante.getAltura() >= clave.getAltura()) {
					System.out.println("Entra el visitante " + visitante.getCodigo());
					contador++;
					if (contador >= clave.getCapacidad()) {
						System.out.println("Siguiente turno");
						contador = 0;
					}
				} else {
					System.out.println(visitante.getCodigo() + " no puede entrar por falta de altura");
				}
			}
		}
	}

	public static void simularComportamientoExtraMejor(HashMap<Atraccion, LinkedList<Visitante>> mapa) {
		for (Atraccion clave : mapa.keySet()) {
			LinkedList<Visitante> valor = mapa.get(clave);
			int contador = 0;
			System.out.println("Atracción " + clave.getNombre());
			// Preparamos 3 sub-colas en función del tipo de entrada:
			HashMap<Entrada, LinkedList<Visitante>> colasPorEntrada = new HashMap<Entrada, LinkedList<Visitante>>();
			for (Entrada entrada : Entrada.values()) {
				colasPorEntrada.put(entrada, new LinkedList<Visitante>()); 
			}
			// Llenamos las sub-colas, vaciando la cola principal
			while (!valor.isEmpty()) {
				Visitante visitante = valor.removeFirst();
				colasPorEntrada.get(visitante.getEntrada()).add(visitante);
			}
			for (Entrada entrada : Entrada.values()) {
				LinkedList<Visitante> cola = colasPorEntrada.get(entrada);
				// Vaciamos la cola
				while (!cola.isEmpty()) {
					Visitante visitante = cola.removeFirst();
					if (visitante.getAltura() >= clave.getAltura()) {
						System.out.println("Entra el visitante " + visitante.getCodigo());
						contador++;
						if (contador >= clave.getCapacidad()) {
							System.out.println("Siguiente turno");
							contador = 0;
						}
					} else {
						System.out.println(visitante.getCodigo() + " no puede entrar por falta de altura");
					}
				}
			}
		}
	}

	
	public static void simularComportamiento(HashMap<Atraccion, LinkedList<Visitante>> mapa) {
		/* En Python se hacía así para recorrer un diccionario:
		 * 
		 * for clave in diccionario:
		 *    valor = diccionario[clave]
		 */
		
		for (Atraccion clave : mapa.keySet()) {
			LinkedList<Visitante> valor = mapa.get(clave);
			int contador = 0;
			System.out.println("Atracción " + clave.getNombre());
			//for (Visitante visitante : valor) {
			while (!valor.isEmpty()) {
				Visitante visitante = valor.removeFirst();
				if (visitante.getAltura() >= clave.getAltura()) {
					System.out.println("Entra el visitante " + visitante.getCodigo());
					contador++;
					if (contador >= clave.getCapacidad()) {
						System.out.println("Siguiente turno");
						contador = 0;
					}
				} else {
					System.out.println(visitante.getCodigo() + " no puede entrar por falta de altura");
				}
			}
		}
		
		/* Recorrer mapas con for-map:
		 * 
		 * for (Map.Entry<Atraccion, LinkedList<Visitante>> entry : mapa.entrySet()) {
				Atraccion key = entry.getKey();
				LinkedList<Visitante> val = entry.getValue();
			}
		 */
		
	}

	public static HashMap<Atraccion, LinkedList<Visitante>> agruparVisitantes(ArrayList<Visitante> visitantes) {
		HashMap<Atraccion, LinkedList<Visitante>> mapa = new HashMap<Atraccion, LinkedList<Visitante>>();

		for (Visitante visitante : visitantes) {
			for (Atraccion atraccion : visitante.getAtracciones()) {
				if (!mapa.containsKey(atraccion)) {
					mapa.put(atraccion, new LinkedList<Visitante>());
				}	
				mapa.get(atraccion).add(visitante);
			}
		}		
		
		return mapa;
	}

	public static HashMap<Entrada, Integer> contarVisitantes(ArrayList<Visitante> visitantes) {
		HashMap<Entrada, Integer> mapa = new HashMap<Entrada, Integer>();

		for (Visitante visitante : visitantes) {
			Entrada entrada = visitante.getEntrada();
			
			if (!mapa.containsKey(entrada)) {
				mapa.put(entrada, 1);
			} else {
				int valor = mapa.get(entrada);
				mapa.put(entrada, valor + 1);
			}
		}

		return mapa;
	}

	public static void asignarAtracciones(ArrayList<Atraccion> atracciones, ArrayList<Visitante> visitantes) {
		// Recorrer la lista de visitantes
		for (Visitante visitante : visitantes) {
			// Mientras visitante.getAtracciones().size() < 3
			while (visitante.getAtracciones().size() < 3) {
				// Elegir una atracción aleatoriamente
				int alea = (int) (Math.random() * atracciones.size());
				Atraccion atraccion = atracciones.get(alea);
				// meterlo en visitante.getAtracciones()
				visitante.getAtracciones().add(atraccion);
			}
		}
	}

	public static ArrayList<Visitante> cargaDatosVisitantes() {
		// Formato de visitantes CSV:
		// altura;entrada

		ArrayList<Visitante> visitantes = new ArrayList<Visitante>();
		
		try {
			File f = new File("visitantes.csv");
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				int altura = Integer.parseInt(campos[0]);
				Entrada entrada = Entrada.valueOf(campos[1]);
				Visitante visitante = new Visitante(altura, entrada);
				visitantes.add(visitante);
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		return visitantes;
	}

	public static ArrayList<Visitante> cargaDatosVisitantes2() {
		ArrayList<Visitante> resultado = new ArrayList<Visitante>();
		for (int i = 0; i < 50; i++) {
			Entrada entrada = Entrada.NORMAL;
			if (i % 3 == 0) {
				entrada = Entrada.EXPRESS;
			} else if (i % 4 == 0) {
				entrada = Entrada.VIP;
			}  
			Visitante nuevo = new Visitante((int)(Math.random()*100)+100, entrada);
			resultado.add(nuevo);
		}
		return resultado;
	}
	
}
