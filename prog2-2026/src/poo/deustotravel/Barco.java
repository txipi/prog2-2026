package poo.deustotravel;

public class Barco extends Transporte {
	protected double calado;
	protected boolean diesel;
	
	public Barco(int capacidad, double calado, boolean diesel) {
		super(capacidad);
		this.calado = calado;
		this.diesel = diesel;
	}
	
	public Barco() {
		super();
		this.calado = 0;
		this.diesel = false;
	}

	public double getCalado() {
		return calado;
	}

	public void setCalado(double calado) {
		this.calado = calado;
	}

	public boolean isDiesel() {
		return diesel;
	}

	public void setDiesel(boolean diesel) {
		this.diesel = diesel;
	}

	@Override
	public String toString() {
		return "Barco [calado=" + calado + ", diesel=" + diesel + ", codigo=" + codigo + ", capacidad=" + capacidad
				+ "]";
	}

	@Override
	public double getPrecioPorKm() {
		if (this.diesel) {
			return 0.8 * this.calado;
		} else {
			return 1.5 * this.calado;
		}
	}
	
}
