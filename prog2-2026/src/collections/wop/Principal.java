package collections.wop;

import java.util.HashMap;

public class Principal {

	public static void main(String[] args) {
		Wop wop = new Wop();
		
//		// EJERCICIO 1:
		wop.cargarDatosParticipantes("wop.csv");
//		// Si no sabes hacer el primer ejercicio, descomenta esta línea
//		// para tener los participantes cargados a mano:
//		// wop.cargarDatosAMano();
		System.out.println(wop.getParticipantes().size()); // Debería devolver: 110
//
//		// EJERCICIO 2:
		wop.eliminarDuplicados();
		System.out.println(wop.getParticipantes().size()); // Debería devolver: 100
//
//		// EJERCICIO 3:
		HashMap<Modalidad, Integer> mapaModalidades = wop.contarModalidades();
		System.out.println(mapaModalidades); // Debería devolver: {WALK=16, RUN=39, TRAIL=45}
//			
//		// EJERCICIO 4:
		wop.generarEquipos();
//		// Si no sabes hacer el cuarto ejercicio, descomenta esta línea
//		// para tener los equipos generadosa mano:
//		wop.generarEquiposAMano();
		System.out.println(wop.getEquipos().size()); // Debería devolver: 15
//
//		// EJERCICIO 5:
		Equipo ganadorTRAIL = wop.ganadorModalidad(Modalidad.TRAIL);
		System.out.println(ganadorTRAIL.getCodigo()); // Debería devolver: TRAIL5
		Equipo ganadorRUN = wop.ganadorModalidad(Modalidad.RUN);
		System.out.println(ganadorRUN.getCodigo()); // Debería devolver; RUN1
		Equipo ganadorWALK= wop.ganadorModalidad(Modalidad.WALK);
		System.out.println(ganadorWALK.getCodigo()); // Debería devolver: WALK1
//		
//		// EJERCICIO 6:
		wop.guardarDatosEquipos("wop.dat"); // Debería generar un fichero "wop.dat" en la raíz del proyecto
	}

}
