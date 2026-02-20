package poo.universidad;

import java.util.ArrayList;

public class Estudiante {
	private String nombre;
	private String dni;
	private int curso;
	private ArrayList<Asignatura> matricula;
	
	public Estudiante(String nombre, String dni, int curso, ArrayList<Asignatura> matricula) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.curso = curso;
		this.matricula = new ArrayList<Asignatura>(matricula);
	}
	
	public Estudiante() {
		super();
		this.nombre = "";
		this.dni = "";
		this.curso = 0;
		this.matricula = new ArrayList<Asignatura>();
	}
	
	public Estudiante(Estudiante e) {
		super();
		this.nombre = e.nombre;
		this.dni = e.dni;
		this.curso = e.curso;
		this.matricula = new ArrayList<Asignatura>(e.matricula);
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

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public ArrayList<Asignatura> getMatricula() {
		return matricula;
	}

	public void setMatricula(ArrayList<Asignatura> matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", dni=" + dni + ", curso=" + curso + ", matricula=" + matricula + "]";
	}
	
	
}
