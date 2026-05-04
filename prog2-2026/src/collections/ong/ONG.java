package collections.ong;

import java.util.ArrayList;
import java.util.HashMap;

public class ONG {

    private ArrayList<Cooperante> Cooperantes;
    private ArrayList<Proyecto> proyectos;
    private HashMap<String, ArrayList<Proyecto>> proyectosPorPais;

    public ONG() {
        Cooperantes = new ArrayList<Cooperante>();
        proyectos = new ArrayList<Proyecto>();
        proyectosPorPais = new HashMap<String, ArrayList<Proyecto>>();
    }

    public ArrayList<Cooperante> getCooperantes() {
        return Cooperantes;
    }

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public HashMap<String, ArrayList<Proyecto>> getProyectosPorPais() {
        return proyectosPorPais;
    }

    public void addCooperante(Cooperante v) {
        Cooperantes.add(v);
    }

    public void addProyecto(Proyecto p) {
        proyectos.add(p);
    }

    @Override
    public String toString() {
        return "ONG -> Cooperantes: " + Cooperantes.size()
                + " | Proyectos: " + proyectos.size()
                + " | Países: " + proyectosPorPais.size();
    }

}

