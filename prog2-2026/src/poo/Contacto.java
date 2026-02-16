package poo;

public class Contacto {
	// Propiedades
	private String nombre;
	private String apellidos;
	private String telefono;
	private String email;
	private String notas;

	// Métodos
	public Contacto(String nombre, String apellidos, String telefono, String email, String notas) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.notas = notas;
	}
	
	public Contacto() {
		super();
		this.nombre = "";
		this.apellidos = "";
		this.telefono = "+34 ";
		this.email = "";
		this.notas = "";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", email=" + email
				+ ", notas=" + notas + "]";
	}
	
	
}
