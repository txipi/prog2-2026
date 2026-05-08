package pruebas.agenda;

import java.util.ArrayList;

public class Agenda {
	private String nombre;
	private ArrayList<Contacto> contactos;
	
	public Agenda(String nombre, ArrayList<Contacto> contactos) {
		super();
		this.nombre = nombre;
		this.contactos = contactos;
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
	
	public double getTotal() {
		double total = 0.0;
		
		for (Contacto contacto : contactos) {
			total += contacto.getSaldo();
		}
		
		return total;
	}
}
