package poo.zoo;

public class Pez extends Animal {
	protected boolean aguaSalada;
	protected double temperatura;
	
	public Pez(String nombre, double edad, boolean aguaSalada, double temperatura) {
		super(nombre, edad); // Llamamos al constructor Animal(nombre, edad) de la clase madre (superclase)
		this.aguaSalada = aguaSalada;
		this.temperatura = temperatura;
	}

	public Pez() {
		super(); // Llamamos al constructor Animal() de la clase madre (superclase)
		this.aguaSalada = false;
		this.temperatura = 0.0;
	}

	public boolean isAguaSalada() {
		return aguaSalada;
	}

	public void setAguaSalada(boolean aguaSalada) {
		this.aguaSalada = aguaSalada;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	@Override
	public String toString() {
		return "Pez [aguaSalada=" + aguaSalada + ", temperatura=" + temperatura + ", codigo=" + codigo + ", nombre="
				+ nombre + ", edad=" + edad + "]";
	}


}
