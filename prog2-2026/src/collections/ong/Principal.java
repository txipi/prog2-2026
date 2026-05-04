package collections.ong;

import java.util.ArrayList;
import java.util.HashMap;

public class Principal {

	public static void main(String[] args) {
		// Instanciamos la clase contenedora
		ONG ong = new ONG();
		
		// Ejercicio 1:
		// cargarCooperantes(): método que recibe la ruta de un fichero CSV 
		// con datos de cooperantes y los carga en la lista de cooperantes 
		// de la clase contenedora.
		ong.cargarCooperantes("cooperantes.csv");
		System.out.println(ong.getCooperantes().size()); // Debería devolver 50
		
		// Ejercicio 2:
		// contarCooperantesPorArea(): método que devuelve un HashMap<Area,Integer> 
		// donde la clave es el área de especialidad y el valor es el número de 
		// cooperantes de esa área.
		HashMap<Area,Integer> cooperantesPorArea = ong.contarCooperantesPorArea();
		System.out.println(cooperantesPorArea);
		
		// Ejercicio 3:
		// generarProyectos(): método que genera 20 proyectos y los añade a la lista 
		// de proyectos de la clase contenedora. Cada proyecto tendrá: 
		// - un nombre como "proyecto1", "proyecto2", etc.
		// - un país aleatorio elegido entre estos: "Nicaragua", "Guatemala", "Colombia", "Bolivia", "Honduras".
		// - un área elegida aleatoriamente entre todos los valores del enum Area.
		// - 5 cooperantes elegidos al azar (tienen que ser especialistas en el área del proyecto y no pueden repetirse dentro de cada proyecto, aunque un cooperante sí que puede estar en varios proyectos diferentes).
		ong.generarProyectos();
		System.out.println(ong.getProyectos().size());
		System.out.println(ong.getProyectos());
		
		// Ejercicio 4:
		// agruparProyectosPorPais(): método que devuelve un 
		// HashMap<String,ArrayList<Proyecto>> donde la clave es cada país en el que la ONG 
		// tiene proyectos y el valor la lista de proyectos que se realizan en ese país.
		HashMap<String,ArrayList<Proyecto>> proyectosPorPais = ong.agruparProyectosPorPais();
		System.out.println(proyectosPorPais);
		
		// Ejercicio 5: 
		// paisMayorPresupuesto(): método que devuelve el país con mayor presupuesto total 
		// en la ONG, teniendo en cuenta que el presupuesto de cada proyecto se calcula 
		// sumando cuánto cuesta gestionar las acciones de cada cooperante, dato que se 
		// calcula multiplicando sus años de experiencia * 12000 en el caso del área de 
		// EDUCACION, sus años de experiencia * 20000 en el caso del área de SALUD, 
		// sus años de experiencia * 15000 en el caso del área de AGUA y sus años de 
		// experiencia * 18000 en el caso del área de TECNOLOGIA.
		String paisMayor = ong.paisMayorPresupuesto();
		System.out.println(paisMayor);
		
		// Ejercicio 6:
		// cargarDatos y guardarDatos(): métodos que cargan y guardan los datos de cooperantes, 
		// proyectos y el mapa de proyectosPorPaís desde y en el fichero binario "ong.dat".
		ong.guardarDatos();
		ong.cargarDatos();
	}

}
