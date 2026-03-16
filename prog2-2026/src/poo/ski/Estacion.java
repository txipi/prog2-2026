package poo.ski;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/*
 * Métodos estáticos:
 * 
 * Calcular desnivel total esquiable de la estación
 * Calcular distancia total de remontes
 * Obtener la pista con mayor distancia esquiable
 * Obtener todas las pistas de un tipo
 * Coste total de los abonos
 * Porcentaje de abonos pagados
 * Ordenar pistas por desnivel
 * Ordenar abonos por fecha de fin
 * Obtener abonos activos hoy
 * Buscar movilidad que conecte dos pistas
 */

public class Estacion {
	
	public static Movilidad buscarMovilidad(ArrayList<Movilidad> movilidades, Pista a, Pista b) {
		Movilidad encontrado = null;
		
		for (Movilidad movilidad : movilidades) {
			if (movilidad.getPistaInicio() == a.getIdentificativo() && movilidad.getPistaFin() == b.getIdentificativo()) {
				encontrado = movilidad;
				break;
			}
		}
		
		return encontrado;
	}
	
	public static ArrayList<Abono> abonosActivosHoy(ArrayList<Abono> abonos) {
		ArrayList<Abono> lista = new ArrayList<Abono>();
		
		LocalDate hoy = LocalDate.now();
		
		for (Abono abono : abonos) {
			if (abono.getInicio().isBefore(hoy) && abono.getFin().isAfter(hoy)) {
				lista.add(abono);
			}
		}
		
		return lista;
	}
	
	public static double porcentajeAbonosPagados(ArrayList<Abono> abonos) {
		int contador = 0;
		
		for (Abono abono : abonos) {
			if (abono.isPagado()) {
				contador++;
			}
		}
		
		return 100 * contador / abonos.size();
	}
	
	public static double costeTotalAbonos(ArrayList<Abono> abonos) {
		// Abono normal -> 50
		// Infantil -> 0
		// Senior -> 30
		double total = 0;
		
		for (Abono abono : abonos) {
			if (abono instanceof Infantil) {
				total += 0;
			} else if (abono instanceof Senior) {
				total += 30;
			} else {
				total += 50;
			}
		}
		
		return total;
	}
	
	public static ArrayList<Pista> obtenerPistasTipo(ArrayList<Pista> pistas, TipoPista tipo) {
		ArrayList<Pista> lista = new ArrayList<Pista>();
		
		for (Pista pista : pistas) {
			if (pista.getTipo().equals(tipo)) {
				lista.add(pista);
			}
		}
		
		return lista;
	}
	
	public static Pista mayorDistanciaEsquiable(ArrayList<Pista> pistas) {
		Pista mayor = pistas.get(0);
		
		for (Pista pista : pistas) {
			if (pista.getDistancia() > mayor.getDistancia()) {
				mayor = pista;
			}
		}
		
		return mayor;
	}
	
	public static double distanciaTotalRemontes(ArrayList<Movilidad> movilidades) {
		double total = 0;
		
		for (Movilidad movilidad : movilidades) {
			if (movilidad instanceof Remonte) {
				total += movilidad.getDistancia();
			}
		}
		
		return total;
	}
	
	public static double desnivelTotal(ArrayList<Pista> pistas) {
		double total = 0;
		
		for (Pista pista : pistas) {
			double desnivel = pista.getCotaSuperior() - pista.getCotaInferior();
			total += desnivel;
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		// =========================
		// CREACIÓN DE PISTAS
		// =========================
		ArrayList<Pista> pistas = new ArrayList<Pista>();

		pistas.add(new Pista(2250, 2100, 1200, TipoPista.VERDE));
		pistas.add(new Pista(2200, 2000, 1800, TipoPista.AZUL));
		pistas.add(new Pista(2300, 1900, 2400, TipoPista.ROJA));
		pistas.add(new Pista(2350, 1850, 2600, TipoPista.NEGRA));
		pistas.add(new Pista(2100, 1950, 900, TipoPista.VERDE));
		pistas.add(new Pista(2150, 1850, 1700, TipoPista.AZUL));
		pistas.add(new Pista(2280, 2000, 2100, TipoPista.ROJA));
		pistas.add(new Pista(2400, 1900, 3000, TipoPista.NEGRA));

		System.out.println("=== PISTAS ===");
		for (Pista p : pistas)
			System.out.println(p);

		// =========================
		// SISTEMAS DE MOVILIDAD
		// =========================
		ArrayList<Movilidad> movilidades = new ArrayList<Movilidad>();

		movilidades.add(new Cinta(1, 2, 300, "Leitner", true));
		movilidades.add(new Cinta(5, 6, 250, "Doppelmayr", false));

		movilidades.add(new Remonte(2, 3, 900, 80, 25));
		movilidades.add(new Remonte(6, 7, 1100, 95, 32));

		movilidades.add(new Telesilla(3, 4, 1800, 120, 4, 18));
		movilidades.add(new Telesilla(7, 8, 2100, 140, 6, 22));

		System.out.println("\n=== MOVILIDAD ===");
		for (Movilidad m : movilidades)
			System.out.println(m);

		// =========================
		// ABONOS
		// =========================
		ArrayList<Abono> abonos = new ArrayList<Abono>();

		abonos.add(new Infantil(
				"Iker",
				"600111222",
				LocalDate.now(),
				LocalDate.now().plusDays(3),
				true,
				"Ane",
				"699888777"));

		abonos.add(new Infantil(
				"Lucía",
				"600333444",
				LocalDate.now(),
				LocalDate.now().plusDays(5),
				false,
				"Carlos",
				"688777666"));

		// Adulto → usamos Abono base
		abonos.add(new Abono(
				"Marcos",
				"611222333",
				LocalDate.now(),
				LocalDate.now().plusDays(2),
				true));

		abonos.add(new Abono(
				"Elena",
				"622333444",
				LocalDate.now(),
				LocalDate.now().plusDays(4),
				false));

		abonos.add(new Senior(
				"José",
				"633444555",
				LocalDate.now(),
				LocalDate.now().plusDays(6),
				true,
				"12345678A"));

		abonos.add(new Senior(
				"María",
				"644555666",
				LocalDate.now(),
				LocalDate.now().plusDays(7),
				false,
				"87654321B"));

		System.out.println("\n=== ABONOS ===");
		for (Abono a : abonos)
			System.out.println(a);

		Collections.sort(pistas);

		Collections.sort(abonos);
	}

}
