package poo;

import java.util.ArrayList;

public class Superheroe {
	// Propiedades
	private String nombre; // "Tony Stark"
	private boolean indentidadSecreta; // false
	private ArrayList<String> poderes; // "Dinero", "Inteligencia", "Volar", "*"
	private String universo; // "Marvel"
	private int anyo; // 2008
	private String genero; // "masculino"
	private double bondad; // 70
	private boolean humano; // true
	
	public Superheroe(String nombre, boolean indentidadSecreta, ArrayList<String> poderes, String universo, int anyo,
			String genero, double bondad, boolean humano) {
		super();
		this.nombre = nombre;
		this.indentidadSecreta = indentidadSecreta;
		this.poderes = poderes;
		this.universo = universo;
		this.anyo = anyo;
		this.genero = genero;
		this.bondad = bondad;
		this.humano = humano;
	}
	
	public Superheroe() {
		super();
		this.nombre = "Sin nombre";
		this.indentidadSecreta = false;
		this.poderes = new ArrayList<String>();
		this.universo = "Marvel";
		this.anyo = 2000;
		this.genero = "femenino";
		this.bondad = 0;
		this.humano = true;
	}
	
	public Superheroe(Superheroe s) {
		super();
		this.nombre = s.nombre;
		this.indentidadSecreta = s.indentidadSecreta;
		this.poderes = new ArrayList<String>(s.poderes);
		this.universo = s.universo;
		this.anyo = s.anyo;
		this.genero = s.genero;
		this.bondad = s.bondad;
		this.humano = s.humano;
	}

	public String getNombre() {
		if (this.isIndentidadSecreta()) {
			return "";
		} else {
			return nombre;
		}
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isIndentidadSecreta() {
		return indentidadSecreta;
	}

	public void setIndentidadSecreta(boolean indentidadSecreta) {
		this.indentidadSecreta = indentidadSecreta;
	}

	public ArrayList<String> getPoderes() {
		return poderes;
	}

	public void setPoderes(ArrayList<String> poderes) {
		this.poderes = poderes;
	}

	public String getUniverso() {
		return universo;
	}

	public void setUniverso(String universo) {
		this.universo = universo;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public double getBondad() {
		return bondad;
	}

	public void setBondad(double bondad) {
		this.bondad = bondad;
	}

	public boolean isHumano() {
		return humano;
	}

	public void setHumano(boolean humano) {
		this.humano = humano;
	}

	@Override
	public String toString() {
		return "Superheroe [nombre=" + nombre + ", indentidadSecreta=" + indentidadSecreta + ", poderes=" + poderes
				+ ", universo=" + universo + ", anyo=" + anyo + ", genero=" + genero + ", bondad=" + bondad
				+ ", humano=" + humano + "]";
	}
	
	
}
