package collections.ong;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ONG {

    private ArrayList<Cooperante> cooperantes;
    private ArrayList<Proyecto> proyectos;
    private HashMap<String, ArrayList<Proyecto>> proyectosPorPais;

    public ONG() {
        cooperantes = new ArrayList<Cooperante>();
        proyectos = new ArrayList<Proyecto>();
        proyectosPorPais = new HashMap<String, ArrayList<Proyecto>>();
    }

    public ArrayList<Cooperante> getCooperantes() {
        return cooperantes;
    }

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public HashMap<String, ArrayList<Proyecto>> getProyectosPorPais() {
        return proyectosPorPais;
    }

    public void addCooperante(Cooperante v) {
        cooperantes.add(v);
    }

    public void addProyecto(Proyecto p) {
        proyectos.add(p);
    }

    @Override
    public String toString() {
        return "ONG -> Cooperantes: " + cooperantes.size()
                + " | Proyectos: " + proyectos.size()
                + " | Países: " + proyectosPorPais.size();
    }

	public void cargarCooperantes(String ruta) {
		try {
			File f = new File(ruta);
			Scanner sc = new Scanner(f);
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] campos = linea.split(";");
				String dni = campos[0];
				String nombre = campos[1];
				Area area = Area.valueOf(campos[2]);
				int anyo = Integer.parseInt(campos[3]);
				Cooperante cooperante = new Cooperante(dni, nombre, area, anyo);
				cooperantes.add(cooperante);
			}
			sc.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public HashMap<Area, Integer> contarCooperantesPorArea() {
		HashMap<Area, Integer> mapa = new HashMap<Area, Integer>();
		for (Cooperante cooperante : cooperantes) {
			Area a = cooperante.getEspecialidad();
			if (!mapa.containsKey(a)) {
				mapa.put(a, 1);
			} else {
				int valor = mapa.get(a);
				mapa.put(a, valor + 1);
			}
		}
		return mapa;
	}

	public void generarProyectos() {
		ArrayList<String> paises = new ArrayList<String>();
		paises.add("Nicaragua");
		paises.add("Guatemala");
		paises.add("Colombia");
		paises.add("Bolivia");
		paises.add("Honduras");
		
		for (int i = 0; i < 20; i++) {
			String nombre = "proyecto" + (i+1);
			int alea = (int) (Math.random() * paises.size());
			String pais = paises.get(alea);
			alea = (int) (Math.random() * Area.values().length);
			Area area = Area.values()[alea];
			Proyecto proyecto = new Proyecto(nombre, pais, area);
			// Añadir 5 cooperantes al proyecto
			ArrayList<Cooperante> lista = new ArrayList<Cooperante>();
			while (lista.size() < 5) {
				// Elegir un cooperante al azar
				alea = (int) (Math.random() * this.cooperantes.size());
				Cooperante cooperante = this.cooperantes.get(alea);
				
				// Añadir el cooperante a la lista siempre que no estuviera ya
				if (cooperante.getEspecialidad().equals(area) && !lista.contains(cooperante)) {
					lista.add(cooperante);
				}
			}
			proyecto.setCooperantes(lista);
			this.proyectos.add(proyecto);
		}
	}

	public HashMap<String, ArrayList<Proyecto>> agruparProyectosPorPais() {
		HashMap<String, ArrayList<Proyecto>> mapa = new HashMap<String, ArrayList<Proyecto>>();
		for (Proyecto proyecto : this.proyectos) {
			String pais = proyecto.getPais();
			if (!mapa.containsKey(pais)) {
				mapa.put(pais, new ArrayList<Proyecto>());
			}
			mapa.get(pais).add(proyecto);
		}
		// Aprovechamos para actualizar el mapa de proyectos por pais de esta clase:
		this.proyectosPorPais = mapa;
		return mapa;
	}

	public String paisMayorPresupuesto() {
		// Mapa con los totales por cada país
		HashMap<String, Double> mapa = new HashMap<String, Double>();
		for (Proyecto proyecto : this.proyectos) {
			String pais = proyecto.getPais();
			// Si el total no existe, lo creamos
			if (!mapa.containsKey(pais)) {
				mapa.put(pais, 0.0);
			}
			// Calculamos el coste de este proyecto
			double total = 0.0;
			for (Cooperante cooperante : proyecto.getCooperantes()) {
				Area a = cooperante.getEspecialidad();
				if (a.equals(Area.EDUCACION)) {
					total += 12000 * cooperante.getExperiencia();
				} else if (a.equals(Area.SALUD)) {
					total += 20000 * cooperante.getExperiencia();
				} else if (a.equals(Area.AGUA)) {
					total += 15000 * cooperante.getExperiencia();
				} else {
					total += 18000 * cooperante.getExperiencia();
				}
			}
			
			// Lo añadimos a este total
			double valor = mapa.get(pais);
			mapa.put(pais, valor + total);
		}
		// Encontramos el mayor en ese mapa
		String mayor_clave = "";
		double mayor_valor = 0.0;
		for (String clave : mapa.keySet()) {
			double valor = mapa.get(clave);
			if (valor > mayor_valor) {
				mayor_clave = clave;
				mayor_valor = valor;
			}
		}
		return mayor_clave;
	}

	public void guardarDatos() {
		// fos -> oos -> writeObject
		try {
			FileOutputStream fos = new FileOutputStream("ong.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(this.cooperantes);
			oos.writeObject(this.proyectos);
			oos.writeObject(this.proyectosPorPais);
			oos.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void cargarDatos() {
		// fis -> ois -> readObject
		try {
			FileInputStream fis = new FileInputStream("ong.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			this.cooperantes = (ArrayList<Cooperante>) ois.readObject();
			this.proyectos= (ArrayList<Proyecto>) ois.readObject();
			this.proyectosPorPais = (HashMap<String, ArrayList<Proyecto>>) ois.readObject();
			ois.close();			
		} catch (Exception e) {
			System.out.println(e);
		}		
	}

}

