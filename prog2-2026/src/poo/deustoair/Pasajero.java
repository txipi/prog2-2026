package poo.deustoair;

public class Pasajero {
	protected String nombre;
	protected String apellido;
	protected String dni;
	
	public Pasajero(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	
	public Pasajero() {
		super();
		this.nombre = "Anónimo";
		this.apellido = "";
		this.dni = "12345678Z";
	}
	
	public Pasajero(Pasajero p) {
		super();
		this.nombre = p.nombre;
		this.apellido = p.apellido;
		this.dni = p.dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Pasajero [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
	}
	
}
