package poo.zoo;

public class Animal {
	protected static int contador = 1;
	
	protected int codigo;
	protected String nombre;
	protected double edad;
	
	public Animal(String nombre, double edad) {
		super();
		this.codigo = Animal.contador;
		Animal.contador++;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Animal() {
		super();
		this.codigo = Animal.contador;
		Animal.contador++;
		this.nombre = "";
		this.edad = 0.0;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getEdad() {
		return edad;
	}

	public void setEdad(double edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return "Animal [codigo=" + codigo + ", nombre=" + nombre + ", edad=" + edad + "]";
	}
	
	
}
