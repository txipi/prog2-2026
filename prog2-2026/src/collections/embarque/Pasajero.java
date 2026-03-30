package collections.embarque;

public class Pasajero {
	protected String nombre;
	protected String dni;
	protected Clase clase;
	
	public Pasajero(String nombre, String dni, Clase clase) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.clase = clase;
	}

	public Pasajero() {
		super();
		this.nombre = "";
		this.dni = "";
		this.clase = Clase.ECONOMY;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	@Override
	public String toString() {
		return "Pasajero [nombre=" + nombre + ", dni=" + dni + ", clase=" + clase + "]";
	}
	
	
}
