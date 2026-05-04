package collections.ong;

import java.io.Serializable;
import java.util.ArrayList;

class Proyecto implements Serializable {

    private String nombre;
    private String pais;
    private Area area;
    private ArrayList<Cooperante> cooperantes;

    public Proyecto(String nombre, String pais, Area area) {
        this.nombre = nombre;
        this.pais = pais;
        this.area = area;
        this.cooperantes = new ArrayList<Cooperante>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public Area getArea() {
        return area;
    }

    public ArrayList<Cooperante> getCooperantes() {
        return cooperantes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public void setCooperantes(ArrayList<Cooperante> cooperantes) {
        this.cooperantes = cooperantes;
    }

    @Override
    public String toString() {
        return nombre + " - " + pais + " - " + area +
               " | Cooperantes: " + cooperantes.size();
    }
}
