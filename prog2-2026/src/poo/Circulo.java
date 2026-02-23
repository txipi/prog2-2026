package poo;

public class Circulo {
	// Propiedades globales (static) para TODOS los circulos en su conjunto
	private static int contador = 0;
	
	// Propiedades de cada circulo
	private double radio;
	private String color;
	
	// Métodos
	public Circulo(double radio, String color) {
		super();
		this.radio = radio;
		this.color = color;
		Circulo.contador++;
	}
	
	public Circulo() {
		super();
		this.radio = 1.0;
		this.color = "red";
		Circulo.contador++;
	}
	
	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Circulo.contador = contador;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		if (radio <= this.radio) {
			this.radio = radio;
		} 
	}

	public String getColor() {
		return color;
	}
	
	public double getArea() {
		return Math.PI * this.radio * this.radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", color=" + color + "]";
	}
	
	
	
}
