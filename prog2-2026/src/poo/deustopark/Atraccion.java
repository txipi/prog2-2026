package poo.deustopark;

public abstract class Atraccion {
	protected String nombre;
	protected int capacidad;
	protected int intensidad;
	
	abstract public boolean esApta(int edad);
}
