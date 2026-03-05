package poo.deustoair;

public class Aeronave {
	protected static int contador = 1;
	
	protected int codigo;
	protected double velocidad;
	protected double autonomia;
	protected int capacidad;
	
	public Aeronave(double velocidad, double autonomia, int capacidad) {
		super();
		this.codigo = Aeronave.contador;
		Aeronave.contador++;
		this.velocidad = velocidad;
		this.autonomia = autonomia;
		this.capacidad = capacidad;
	}
	
	public Aeronave() {
		super();
		this.codigo = Aeronave.contador;
		Aeronave.contador++;
		this.velocidad = 0;
		this.autonomia = 0;
		this.capacidad = 0;
	}
	
	public Aeronave(Aeronave a) {
		super();
		this.codigo = Aeronave.contador;
		Aeronave.contador++;
		this.velocidad = a.velocidad;
		this.autonomia = a.autonomia;
		this.capacidad = a.capacidad;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(double autonomia) {
		this.autonomia = autonomia;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return "Aeronave [codigo=" + codigo + ", velocidad=" + velocidad + ", autonomia=" + autonomia + ", capacidad="
				+ capacidad + "]";
	}
	
}
