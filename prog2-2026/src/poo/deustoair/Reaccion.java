package poo.deustoair;

public class Reaccion extends Aeronave {
	protected int motores;
	protected double potencia;
	protected int altitud;
	
	public Reaccion(double velocidad, double autonomia, int capacidad, int motores, double potencia, int altitud) {
		super(velocidad, autonomia, capacidad);
		this.motores = motores;
		this.potencia = potencia;
		this.altitud = altitud;
	}
	
	public Reaccion() {
		super();
		this.motores = 0;
		this.potencia = 0;
		this.altitud = 0;
	}
	
	public Reaccion(Reaccion r) {
		super(r.velocidad, r.autonomia, r.capacidad);
		this.motores = r.motores;
		this.potencia = r.potencia;
		this.altitud = r.altitud;
	}

	public int getMotores() {
		return motores;
	}

	public void setMotores(int motores) {
		this.motores = motores;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public int getAltitud() {
		return altitud;
	}

	public void setAltitud(int altitud) {
		this.altitud = altitud;
	}

	@Override
	public String toString() {
		return "Reaccion [motores=" + motores + ", potencia=" + potencia + ", altitud=" + altitud + ", codigo=" + codigo
				+ ", velocidad=" + velocidad + ", autonomia=" + autonomia + ", capacidad=" + capacidad + "]";
	}
	
}
