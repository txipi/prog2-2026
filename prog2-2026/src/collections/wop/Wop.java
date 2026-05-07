package collections.wop;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class Wop {
	private ArrayList<Participante> participantes;
	private ArrayList<Equipo> equipos;
		
	public Wop(ArrayList<Participante> participantes, ArrayList<Equipo> equipos) {
		super();
		this.participantes = participantes;
		this.equipos = equipos;
	}

	public Wop() {
		super();
		this.participantes = new ArrayList<Participante>();
		this.equipos = new ArrayList<Equipo>();
	}

	public ArrayList<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(ArrayList<Participante> participantes) {
		this.participantes = participantes;
	}

	public ArrayList<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(ArrayList<Equipo> equipos) {
		this.equipos = equipos;
	}
	
	@Override
	public String toString() {
		return "Wop [participantes=" + participantes + ", equipos=" + equipos + "]";
	}
	
	// EJERCICIO 1: 1.5 puntos
	/*
	 * Método que recibe la ruta a un fichero CSV que contiene los datos de varios participantes 
	 * y actualiza la lista de participantes de la clase contenedora Wop después de haber cargado
	 * los datos desde el fichero. Ten en cuenta que el formato del fichero CSV es el siguiente:
	 * 
	 * nombre;dorsal;ritmo
	 * 
	 * Por ejemplo:
	 * 
	 * June Martinez;98;6.17
	 * 
	 */
	public void cargarDatosParticipantes(String ruta) {
		try {
			File f = new File(ruta);
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				String nombre = campos[0];
				int dorsal = Integer.parseInt(campos[1]);
				double ritmo = Double.parseDouble(campos[2]);
				Participante participante = new Participante(nombre, dorsal, ritmo);
				participantes.add(participante);
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
		
	// EJERCICIO 2: 1 punto
	/*
	 * Método que elimina los participantes repetidos de la lista de participantes de la clase 
	 * contenedora Wop. 
	 * Se considera que un participante está repetido si tiene el mismo dorsal que otro. 
	 */
	public void eliminarDuplicados() {
		HashSet<Participante> conjunto = new HashSet<Participante>(this.participantes);
		this.participantes = new ArrayList<Participante>(conjunto);
	}	
	
	// EJERCICIO 3: 2 puntos
	/*
	 * Método que devuelve un mapa donde la clave es la Modalidad y el valor es el número de 
	 * participantes que corren en esa modalidad, teniendo en cuenta que quienes corren con 
	 * un ritmo inferior a 4.50 están en la modalidad TRAIL, quienes corren con un ritmo 
	 * entre 4.50 y 5.50 (ambos incluídos) están en la modalidad RUN y quienes corren con un 
	 * ritmo por encima de 5.50 están en la modalidad WALK. 
	 * Modifica la clase Participante para que tenga un método getModalidad() que devuelva 
	 * la modalidad del participante en función de su ritmo.
	 */

	public HashMap<Modalidad, Integer> contarModalidades() {
		HashMap<Modalidad, Integer> mapa = new HashMap<Modalidad, Integer>();
		
		for (Participante participante : participantes) {
			Modalidad modalidad = participante.getModalidad();
			
			if (!mapa.containsKey(modalidad)) {
				mapa.put(modalidad, 1);
			} else {
				int valor = mapa.get(modalidad);
				mapa.put(modalidad, valor + 1);
			}
			
		}
		
		return mapa;
	}
	
	// EJERCICIO 4: 2.5 puntos
	/*
	 * Método que actualiza la lista de equipos de la clase contenedora Wop de la siguiente manera:
	 * 1) Crea tres colas de participantes diferentes a partir de la lista de participantes 
	 *    recibida: colaTRAIL, colaRUN y colaWALK, cada una con los participantes de cada 
	 *    modalidad (ten en cuenta los ritmos del ejercicio anterior para saber en qué modalidad 
	 *    debería correr cada participante).
	 * Extra: puedes hacer esto mismo con un mapa en el que la clave sea la Modalidad y el valor sea 
	 * la cola de participantes de esa modalidad (+0.5 puntos).
	 * 2) Vacía cada cola para ir creando los equipos de esas modalidades, teniendo en cuenta que 
	 *    todos los equipos son de 6 personas y que los códigos de los equipos deberían ser 
	 *    MODALIDAD+número, es decir, el primer equipo de TRAIL se debería llamar: TRAIL1, 
	 *    el segundo: TRAIL2, etc. y lo mismo con: RUN1,  RUN2, etc. o WALK1, WALK2, etc. 
	 * Si hay participantes al final de las colas que no llegan a formar un equipo de 6 personas, 
	 * el equipo no se crea y esas personas no formarán parte de ningún equipo. 
	 * 3) Guarda los equipos que has ido creando en la lista de equipos de la clase contenedora Wop.
	 */
	
	public void generarEquipos() {
		HashMap<Modalidad, LinkedList<Participante>> mapa = new HashMap<>();
		
		for (Participante participante : this.participantes) {
			Modalidad modalidad = participante.getModalidad();
			if (!mapa.containsKey(modalidad)) {
				mapa.put(modalidad, new LinkedList());
			}
			mapa.get(modalidad).add(participante);
		}
		
		for (Modalidad modalidad : mapa.keySet()) {
			int contador = 1;
			ArrayList<Participante> lista = new ArrayList<Participante>();
			LinkedList<Participante> cola = mapa.get(modalidad);
			
			while (!cola.isEmpty()) {
				Participante turno = cola.removeFirst();
				lista.add(turno);
				if (lista.size() >= 6) {
					Equipo equipo = new Equipo(modalidad+""+contador, lista, Modalidad.TRAIL);
					contador++;
					lista = new ArrayList<Participante>();
				}
			}	
		}
	}
	
	public void generarEquiposBasico() {
		LinkedList<Participante> colaTRAIL = new LinkedList<Participante>();
		LinkedList<Participante> colaRUN = new LinkedList<Participante>();
		LinkedList<Participante> colaWALK = new LinkedList<Participante>();
		
		for (Participante participante : this.participantes) {
			Modalidad modalidad = participante.getModalidad();
			if (modalidad.equals(Modalidad.TRAIL)) {
				colaTRAIL.add(participante);
			} else if (modalidad.equals(Modalidad.RUN)) {
				colaRUN.add(participante);
			} else {
				colaWALK.add(participante);
			}
		}
		
		int contador = 1;
		ArrayList<Participante> lista = new ArrayList<Participante>();
		
		while (!colaTRAIL.isEmpty()) {
			Participante turno = colaTRAIL.removeFirst();
			lista.add(turno);
			if (lista.size() >= 6) {
				Equipo equipo = new Equipo("TRAIL"+contador, lista, Modalidad.TRAIL);
				contador++;
				lista = new ArrayList<Participante>();
			}
		}
		
		contador = 1;
		lista = new ArrayList<Participante>();
		
		while (!colaRUN.isEmpty()) {
			Participante turno = colaRUN.removeFirst();
			lista.add(turno);
			if (lista.size() >= 6) {
				Equipo equipo = new Equipo("RUN"+contador, lista, Modalidad.RUN);
				contador++;
				lista = new ArrayList<Participante>();
			}
		}

		contador = 1;
		lista = new ArrayList<Participante>();
		
		while (!colaWALK.isEmpty()) {
			Participante turno = colaWALK.removeFirst();
			lista.add(turno);
			if (lista.size() >= 6) {
				Equipo equipo = new Equipo("WALK"+contador, lista, Modalidad.WALK);
				contador++;
				lista = new ArrayList<Participante>();
			}
		}
	
	}
	
	
	// EJERCICIO 5: 2 puntos
	/*
	 * Depura y corrige el método ganadorModalidad() que recibe una modalidad y debería 
	 * devolver el equipo más rápido de esa modalidad, es decir, el equipo que tenga el 
	 * menor ritmo total medido en minutos por km (el ritmo total del equipo se calcula 
	 * simplemente sumando los ritmos de todos sus participantes). 
	 */
	public Equipo ganadorModalidad(Modalidad modalidad) {
		//Equipo mejor = new Equipo("", this.participantes, modalidad); 
		Equipo mejor = equipos.get(0);
		
		for (Equipo equipo : equipos) {
			if (equipo.getModalidad().equals(modalidad)) {
				mejor = equipo;
				break;
			}
		}
		
		for (Equipo equipo : equipos) {
			if (equipo.getModalidad().equals(modalidad)) {
				if (equipo.getRitmoTotal() < mejor.getRitmoTotal()) {
					mejor = equipo;	
				}
			}
		}
		return mejor;
	}
	
	// EJERCICIO 6: 1 punto
	/*
	 * Depura y corrige el método guardarDatosEquipos() que debería guardar la lista de 
	 * equipos de la clase contenedora Wop en un fichero binario "wop.dat".
	 * Recuerda usar “F5 - Refresh” para comprobar si se ha creado el fichero en la raíz 
	 * del proyecto (el fichero debería ocupar unos 4 KB aproximadamente).
	 */
	
	public void guardarDatosEquipos(String ruta) {
		try {
			FileOutputStream fos = new FileOutputStream(ruta);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.equipos);
			oos.close();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Ha habido un error al guardar los datos");
		}	
	}

	public void cargarDatosAMano() {
		participantes.add(new Participante("Iker Garcia", 1, 4.15));
		participantes.add(new Participante("Ane Fernandez", 2, 5.02));
		participantes.add(new Participante("Jon Lopez", 3, 4.45));
		participantes.add(new Participante("Maite Martinez", 4, 5.30));
		participantes.add(new Participante("Aitor Gonzalez", 5, 3.55));
		participantes.add(new Participante("Nerea Perez", 6, 5.40));
		participantes.add(new Participante("Unai Rodriguez", 7, 4.25));
		participantes.add(new Participante("Leire Sanchez", 8, 5.10));
		participantes.add(new Participante("Asier Diaz", 9, 4.05));
		participantes.add(new Participante("Unai Rodriguez", 9, 4.25));
		participantes.add(new Participante("Amaia Alvarez", 10, 5.55));

		participantes.add(new Participante("Gorka Etxebarria", 11, 4.35));
		participantes.add(new Participante("Miren Zubizarreta", 12, 6.10));
		participantes.add(new Participante("Ander Uribe", 13, 4.50));
		participantes.add(new Participante("Irati Agirre", 14, 5.20));
		participantes.add(new Participante("Xabier Elorza", 15, 3.50));
		participantes.add(new Participante("Garazi Aramburu", 16, 5.45));
		participantes.add(new Participante("Eneko Goikoetxea", 17, 4.10));
		participantes.add(new Participante("June Bengoetxea", 18, 6.05));
		participantes.add(new Participante("Garazi Aramburu", 17, 5.45));
		participantes.add(new Participante("Mikel Larrinaga", 19, 4.55));
		participantes.add(new Participante("Uxue Ibarretxe", 20, 5.35));

		participantes.add(new Participante("Iker Fernandez", 21, 4.20));
		participantes.add(new Participante("Ane Garcia", 22, 5.15));
		participantes.add(new Participante("Jon Martinez", 23, 4.40));
		participantes.add(new Participante("Maite Lopez", 24, 6.00));
		participantes.add(new Participante("Aitor Perez", 25, 3.58));
		participantes.add(new Participante("Nerea Gonzalez", 26, 5.25));
		participantes.add(new Participante("Unai Diaz", 27, 4.30));
		participantes.add(new Participante("Leire Rodriguez", 28, 5.05));
		participantes.add(new Participante("Maite Lopez", 28, 6.00));
		participantes.add(new Participante("Asier Sanchez", 29, 4.00));
		participantes.add(new Participante("Amaia Fernandez", 30, 5.50));

		participantes.add(new Participante("Gorka Garcia", 31, 4.28));
		participantes.add(new Participante("Miren Lopez", 32, 6.20));
		participantes.add(new Participante("Ander Martinez", 33, 4.48));
		participantes.add(new Participante("Irati Perez", 34, 5.18));
		participantes.add(new Participante("Xabier Gonzalez", 35, 3.52));
		participantes.add(new Participante("Garazi Diaz", 36, 5.48));
		participantes.add(new Participante("Eneko Rodriguez", 37, 4.12));
		participantes.add(new Participante("Ander Martinez", 37, 4.48));
		participantes.add(new Participante("June Sanchez", 38, 6.15));
		participantes.add(new Participante("Mikel Alvarez", 39, 4.52));
		participantes.add(new Participante("Uxue Fernandez", 40, 5.38));

		participantes.add(new Participante("Iker Martinez", 41, 4.18));
		participantes.add(new Participante("Ane Lopez", 42, 5.12));
		participantes.add(new Participante("Jon Perez", 43, 4.42));
		participantes.add(new Participante("Maite Gonzalez", 44, 6.05));
		participantes.add(new Participante("Aitor Diaz", 45, 3.57));
		participantes.add(new Participante("Nerea Rodriguez", 46, 5.28));
		participantes.add(new Participante("Unai Sanchez", 47, 4.32));
		participantes.add(new Participante("Nerea Rodriguez", 47, 5.28));
		participantes.add(new Participante("Leire Alvarez", 48, 5.08));
		participantes.add(new Participante("Asier Fernandez", 49, 4.02));
		participantes.add(new Participante("Amaia Garcia", 50, 5.52));

		participantes.add(new Participante("Gorka Martinez", 51, 4.33));
		participantes.add(new Participante("Miren Perez", 52, 6.25));
		participantes.add(new Participante("Ander Gonzalez", 53, 4.46));
		participantes.add(new Participante("Irati Diaz", 54, 5.22));
		participantes.add(new Participante("Xabier Rodriguez", 55, 3.54));
		participantes.add(new Participante("Garazi Sanchez", 56, 5.42));
		participantes.add(new Participante("Xabier Rodriguez", 56, 3.54));
		participantes.add(new Participante("Eneko Alvarez", 57, 4.14));
		participantes.add(new Participante("June Fernandez", 58, 6.18));
		participantes.add(new Participante("Mikel Garcia", 59, 4.50));
		participantes.add(new Participante("Uxue Martinez", 60, 5.33));

		participantes.add(new Participante("Iker Perez", 61, 4.16));
		participantes.add(new Participante("Ane Gonzalez", 62, 5.14));
		participantes.add(new Participante("Jon Diaz", 63, 4.38));
		participantes.add(new Participante("Maite Rodriguez", 64, 6.08));
		participantes.add(new Participante("Aitor Sanchez", 65, 3.53));
		participantes.add(new Participante("Nerea Alvarez", 66, 5.26));
		participantes.add(new Participante("Unai Fernandez", 67, 4.27));
		participantes.add(new Participante("Unai Fernandez", 67, 3.27));
		participantes.add(new Participante("Leire Garcia", 68, 5.06));
		participantes.add(new Participante("Asier Martinez", 69, 4.03));
		participantes.add(new Participante("Amaia Lopez", 70, 5.48));

		participantes.add(new Participante("Gorka Perez", 71, 4.31));
		participantes.add(new Participante("Miren Gonzalez", 72, 6.30));
		participantes.add(new Participante("Ander Diaz", 73, 4.44));
		participantes.add(new Participante("Irati Rodriguez", 74, 5.24));
		participantes.add(new Participante("Irati Rodriguez", 74, 6.24));
		participantes.add(new Participante("Xabier Sanchez", 75, 3.51));
		participantes.add(new Participante("Garazi Alvarez", 76, 5.46));
		participantes.add(new Participante("Eneko Fernandez", 77, 4.11));
		participantes.add(new Participante("June Garcia", 78, 6.12));
		participantes.add(new Participante("Mikel Martinez", 79, 4.49));
		participantes.add(new Participante("Uxue Lopez", 80, 5.36));

		participantes.add(new Participante("Iker Gonzalez", 81, 4.19));
		participantes.add(new Participante("Ane Diaz", 82, 5.11));
		participantes.add(new Participante("Jon Rodriguez", 83, 4.41));
		participantes.add(new Participante("Maite Sanchez", 84, 6.02));
		participantes.add(new Participante("Aitor Alvarez", 85, 3.56));
		participantes.add(new Participante("Nerea Fernandez", 86, 5.29));
		participantes.add(new Participante("Nerea Fernandez", 86, 5.29));
		participantes.add(new Participante("Unai Garcia", 87, 4.26));
		participantes.add(new Participante("Leire Martinez", 88, 5.09));
		participantes.add(new Participante("Asier Lopez", 89, 4.01));
		participantes.add(new Participante("Amaia Perez", 90, 5.47));

		participantes.add(new Participante("Gorka Gonzalez", 91, 4.34));
		participantes.add(new Participante("Gorka Gonzalez", 91, 5.34));
		participantes.add(new Participante("Miren Diaz", 92, 6.22));
		participantes.add(new Participante("Ander Rodriguez", 93, 4.47));
		participantes.add(new Participante("Irati Sanchez", 94, 5.23));
		participantes.add(new Participante("Xabier Alvarez", 95, 3.49));
		participantes.add(new Participante("Garazi Fernandez", 96, 5.44));
		participantes.add(new Participante("Eneko Garcia", 97, 4.13));
		participantes.add(new Participante("June Martinez", 98, 6.17));
		participantes.add(new Participante("Mikel Lopez", 99, 4.51));
		participantes.add(new Participante("Uxue Perez", 100, 5.37));
		
	}

	public void generarEquiposAMano() {
		equipos.add(new Equipo("WALK1", new ArrayList<Participante>(Arrays.asList(
			    participantes.get(10-1),
			    participantes.get(12-1),
			    participantes.get(18-1),
			    participantes.get(24-1),
			    participantes.get(32-1),
			    participantes.get(38-1)
			)), Modalidad.WALK));

		equipos.add(new Equipo("WALK2", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(44-1),
		    participantes.get(50-1),
		    participantes.get(52-1),
		    participantes.get(58-1),
		    participantes.get(64-1),
		    participantes.get(72-1)
		)), Modalidad.WALK));

		equipos.add(new Equipo("RUN1", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(2-1),
		    participantes.get(4-1),
		    participantes.get(6-1),
		    participantes.get(8-1),
		    participantes.get(13-1),
		    participantes.get(14-1)
		)), Modalidad.RUN));

		equipos.add(new Equipo("RUN2", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(16-1),
		    participantes.get(19-1),
		    participantes.get(20-1),
		    participantes.get(22-1),
		    participantes.get(26-1),
		    participantes.get(28-1)
		)), Modalidad.RUN));

		equipos.add(new Equipo("RUN3", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(30-1),
		    participantes.get(34-1),
		    participantes.get(36-1),
		    participantes.get(39-1),
		    participantes.get(40-1),
		    participantes.get(42-1)
		)), Modalidad.RUN));

		equipos.add(new Equipo("RUN4", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(46-1),
		    participantes.get(48-1),
		    participantes.get(54-1),
		    participantes.get(56-1),
		    participantes.get(59-1),
		    participantes.get(60-1)
		)), Modalidad.RUN));

		equipos.add(new Equipo("RUN5", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(62-1),
		    participantes.get(66-1),
		    participantes.get(68-1),
		    participantes.get(70-1),
		    participantes.get(74-1),
		    participantes.get(76-1)
		)), Modalidad.RUN));

		equipos.add(new Equipo("RUN6", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(80-1),
		    participantes.get(82-1),
		    participantes.get(86-1),
		    participantes.get(88-1),
		    participantes.get(90-1),
		    participantes.get(94-1)
		)), Modalidad.RUN));

		equipos.add(new Equipo("TRAIL1", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(1-1),
		    participantes.get(3-1),
		    participantes.get(5-1),
		    participantes.get(7-1),
		    participantes.get(9-1),
		    participantes.get(11-1)
		)), Modalidad.TRAIL));

		equipos.add(new Equipo("TRAIL2", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(15-1),
		    participantes.get(17-1),
		    participantes.get(21-1),
		    participantes.get(23-1),
		    participantes.get(25-1),
		    participantes.get(27-1)
		)), Modalidad.TRAIL));

		equipos.add(new Equipo("TRAIL3", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(29-1),
		    participantes.get(31-1),
		    participantes.get(33-1),
		    participantes.get(35-1),
		    participantes.get(37-1),
		    participantes.get(41-1)
		)), Modalidad.TRAIL));

		equipos.add(new Equipo("TRAIL4", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(43-1),
		    participantes.get(45-1),
		    participantes.get(47-1),
		    participantes.get(49-1),
		    participantes.get(51-1),
		    participantes.get(53-1)
		)), Modalidad.TRAIL));

		equipos.add(new Equipo("TRAIL5", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(55-1),
		    participantes.get(57-1),
		    participantes.get(61-1),
		    participantes.get(63-1),
		    participantes.get(65-1),
		    participantes.get(67-1)
		)), Modalidad.TRAIL));

		equipos.add(new Equipo("TRAIL6", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(69-1),
		    participantes.get(71-1),
		    participantes.get(73-1),
		    participantes.get(75-1),
		    participantes.get(77-1),
		    participantes.get(79-1)
		)), Modalidad.TRAIL));

		equipos.add(new Equipo("TRAIL7", new ArrayList<Participante>(Arrays.asList(
		    participantes.get(81-1),
		    participantes.get(83-1),
		    participantes.get(85-1),
		    participantes.get(87-1),
		    participantes.get(89-1),
		    participantes.get(91-1)
		)), Modalidad.TRAIL));
	}

}
