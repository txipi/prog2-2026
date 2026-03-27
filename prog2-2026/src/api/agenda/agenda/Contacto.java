package api.agenda.agenda;

public class Contacto implements Comparable<Contacto> {
	protected String nombre;
	protected String telefono;
	protected String email;
	
	@Override
	public int compareTo(Contacto other) {
		return this.nombre.compareTo(other.nombre);
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + "]";
	}
	
	
}
