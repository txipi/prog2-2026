package poo.deustotravel;

public class Avioneta extends Transporte {
	protected double peso;
	protected double planeo;
	
	public Avioneta(int capacidad, double peso, double planeo) {
		super(capacidad);
		this.peso = peso;
		this.planeo = planeo;
	}
	
	public Avioneta() {
		super();
		this.peso = 0;
		this.planeo = 0;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getPlaneo() {
		return planeo;
	}

	public void setPlaneo(double planeo) {
		this.planeo = planeo;
	}

	@Override
	public String toString() {
		return "Avioneta [peso=" + peso + ", planeo=" + planeo + ", codigo=" + codigo + ", capacidad=" + capacidad
				+ "]";
	}

	@Override
	public double getPrecioPorKm() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
