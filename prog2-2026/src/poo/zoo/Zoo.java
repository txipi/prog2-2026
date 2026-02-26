package poo.zoo;

import java.util.ArrayList;

public class Zoo {
	protected String nombre;
	protected ArrayList<Animal> animales;
	
	public Zoo(String nombre, ArrayList<Animal> animales) {
		super();
		this.nombre = nombre;
		this.animales = new ArrayList<Animal>(animales);
	}
	
	public Zoo() {
		super();
		this.nombre = "";
		this.animales = new ArrayList<Animal>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(ArrayList<Animal> animales) {
		this.animales = animales;
	}

	@Override
	public String toString() {
		return "Zoo [nombre=" + nombre + ", animales=" + animales + "]";
	}
	
}
