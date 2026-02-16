package poo;

import java.util.ArrayList;

public class Agenda {
	// Propiedades
	private String nombre;
	private ArrayList<Contacto> contactos;
	
	// Métodos
	public Agenda(String nombre, ArrayList<Contacto> contactos) {
		super();
		this.nombre = nombre;
		this.contactos = contactos;
	}
	
	public Agenda() {
		super();
		this.nombre = "";
		this.contactos = new ArrayList();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Contacto> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Contacto> contactos) {
		this.contactos = contactos;
	}

	@Override
	public String toString() {
		return "Agenda [nombre=" + nombre + ", contactos=" + contactos + "]";
	}

	
}
