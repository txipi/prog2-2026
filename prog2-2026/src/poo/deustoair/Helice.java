package poo.deustoair;

public class Helice extends Aeronave {
	protected int motores;
	protected double potencia;
	protected int rpm;
	
	public Helice(double velocidad, double autonomia, int capacidad, int motores, double potencia, int rpm) {
		super(velocidad, autonomia, capacidad);
		this.motores = motores;
		this.potencia = potencia;
		this.rpm = rpm;
	}
	
	public Helice() {
		super();
		this.motores = 0;
		this.potencia = 0;
		this.rpm = 0;
	}
	
	public Helice(Helice h) {
		super(h.velocidad, h.autonomia, h.capacidad);
		this.motores = h.motores;
		this.potencia = h.potencia;
		this.rpm = h.rpm;
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

	public int getRpm() {
		return rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}

	@Override
	public String toString() {
		return "Helice [motores=" + motores + ", potencia=" + potencia + ", rpm=" + rpm + ", codigo=" + codigo
				+ ", velocidad=" + velocidad + ", autonomia=" + autonomia + ", capacidad=" + capacidad + "]";
	}
	
}
