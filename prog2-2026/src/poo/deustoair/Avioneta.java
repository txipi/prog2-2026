package poo.deustoair;

public class Avioneta extends Aeronave {
	protected double carga;

	public Avioneta(double velocidad, double autonomia, int capacidad, double carga) {
		super(velocidad, autonomia, capacidad);
		this.carga = carga;
	}
	
	public Avioneta() {
		super();
		this.carga = 0;
	}
	
	public Avioneta(Avioneta a) {
		super(a.velocidad, a.autonomia, a.capacidad);
		this.carga = a.carga;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	@Override
	public String toString() {
		return "Avioneta [carga=" + carga + ", codigo=" + codigo + ", velocidad=" + velocidad + ", autonomia="
				+ autonomia + ", capacidad=" + capacidad + "]";
	}
	
}
