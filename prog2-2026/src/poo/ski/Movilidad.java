package poo.ski;

public abstract class Movilidad {
	protected int pistaInicio;
	protected int pistaFin;
	protected double distancia;
	
	public Movilidad(int pistaInicio, int pistaFin, double distancia) {
		super();
		this.pistaInicio = pistaInicio;
		this.pistaFin = pistaFin;
		this.distancia = distancia;
	}
	
	public Movilidad() {
		super();
		this.pistaInicio = 0;
		this.pistaFin = 0;
		this.distancia = 0;
	}

	public int getPistaInicio() {
		return pistaInicio;
	}

	public void setPistaInicio(int pistaInicio) {
		this.pistaInicio = pistaInicio;
	}

	public int getPistaFin() {
		return pistaFin;
	}

	public void setPistaFin(int pistaFin) {
		this.pistaFin = pistaFin;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "Movilidad [pistaInicio=" + pistaInicio + ", pistaFin=" + pistaFin + ", distancia=" + distancia + "]";
	}
	
	
}
