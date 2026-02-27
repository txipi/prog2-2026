package poo.paint;

import java.awt.Color;

public class Circulo extends Forma {
	protected int radio;

	public Circulo(int x, int y, Color color, int radio) {
		super(x, y, color); // llamamos Forma(x, y, radio)
		this.radio = radio;
	}
	
	public Circulo() {
		super(); // llamamos a Forma()
		this.radio = 10;
	}
	
	public Circulo(Circulo c) {
		super(c.x, c.y, c.color);
		this.radio = c.radio;
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

	@Override
	public String toString() {
		return "Circulo [radio=" + radio + ", x=" + x + ", y=" + y + ", color=" + color + "]";
	}	
	
}
