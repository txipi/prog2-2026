package poo.deustotravel;

public abstract class Transporte {
	protected static int contador = 1;
	
	protected int codigo;
	protected int capacidad;
	
	public Transporte(int capacidad) {
		super();
		this.codigo = Transporte.contador;
		Transporte.contador++;
		this.capacidad = capacidad;
	}
	
	public Transporte() {
		super();
		this.codigo = Transporte.contador;
		Transporte.contador++;
		this.capacidad = 0;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "Transporte [codigo=" + codigo + ", capacidad=" + capacidad + "]";
	}
	
	public abstract double getPrecioPorKm();
	
}
