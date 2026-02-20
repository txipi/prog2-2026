package poo.universidad;

public class Asignatura {
	private String nombre;
	private String codigo;
	private int curso;
	private double creditos;
	
	public Asignatura(String nombre, String codigo, int curso, double creditos) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.curso = curso;
		this.creditos = creditos;
	}

	public Asignatura() {
		super();
		this.nombre = "";
		this.codigo = "";
		this.curso = 0;
		this.creditos = 0.0;
	}
	
	public Asignatura(Asignatura a) {
		super();
		this.nombre = a.nombre;
		this.codigo = a.codigo;
		this.curso = a.curso;
		this.creditos = a.creditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", codigo=" + codigo + ", curso=" + curso + ", creditos=" + creditos
				+ "]";
	}
	
	
}
