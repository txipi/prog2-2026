package poo.merchandeusto;

public class Cliente {
	protected String nombre;
	protected String email;
	protected boolean alumni;
	
	public Cliente(String nombre, String email, boolean alumni) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.alumni = alumni;
	}
	
	public Cliente() {
		super();
		this.nombre = "";
		this.email = "";
		this.alumni = false;
	}
	
	public Cliente(Cliente c) {
		super();
		this.nombre = c.nombre;
		this.email = c.email;
		this.alumni = c.alumni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAlumni() {
		return alumni;
	}

	public void setAlumni(boolean alumni) {
		this.alumni = alumni;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", email=" + email + ", alumni=" + alumni + "]";
	}
	
}
