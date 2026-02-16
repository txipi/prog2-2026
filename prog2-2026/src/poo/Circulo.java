package poo;

public class Circulo {
	// Propiedades 
	private double radio;
	private String color;
	
	// Métodos
	public Circulo(double radio, String color) {
		super();
		this.radio = radio;
		this.color = color;
	}
	
	public Circulo() {
		super();
		this.radio = 1.0;
		this.color = "red";
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
