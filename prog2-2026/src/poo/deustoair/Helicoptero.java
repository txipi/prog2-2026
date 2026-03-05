package poo.deustoair;

public class Helicoptero extends Aeronave {
	protected double carga;
	protected int maniobrabilidad;
	
	public Helicoptero(double velocidad, double autonomia, int capacidad, double carga, int maniobrabilidad) {
		super(velocidad, autonomia, capacidad);
		this.carga = carga;
		this.maniobrabilidad = maniobrabilidad;
	}
	
	public Helicoptero() {
		super();
		this.carga = 0;
		this.maniobrabilidad = 0;
	}
	
	public Helicoptero(Helicoptero h) {
		super(h.velocidad, h.autonomia, h.capacidad);
		this.carga = h.carga;
		this.maniobrabilidad = h.maniobrabilidad;
	}

	public double getCarga() {
		return carga;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	public int getManiobrabilidad() {
		return maniobrabilidad;
	}

	public void setManiobrabilidad(int maniobrabilidad) {
		this.maniobrabilidad = maniobrabilidad;
	}

	@Override
	public String toString() {
		return "Helicoptero [carga=" + carga + ", maniobrabilidad=" + maniobrabilidad + ", codigo=" + codigo
				+ ", velocidad=" + velocidad + ", autonomia=" + autonomia + ", capacidad=" + capacidad + "]";
	}
	
}
