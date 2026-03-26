package poo.merchandeusto;

public class Taza extends Producto {
	protected double capacidad;
	protected boolean microondas;
	
	public Taza(String nombre, double precio, double capacidad, boolean microondas) {
		super(nombre, precio);
		this.capacidad = capacidad;
		this.microondas = microondas;
	}
	
	public Taza() {
		super();
		this.capacidad = 200;
		this.microondas = true;
	}
	
	public Taza(Taza t) {
		super(t.nombre, t.precio);
		this.capacidad = t.capacidad;
		this.microondas = t.microondas;
	}

	public double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}

	public boolean isMicroondas() {
		return microondas;
	}

	public void setMicroondas(boolean microondas) {
		this.microondas = microondas;
	}

	@Override
	public String toString() {
		return "Taza [capacidad=" + capacidad + ", microondas=" + microondas + ", nombre=" + nombre + ", precio="
				+ precio + "]";
	}

}
