package poo.paint;

import java.awt.Color;

public abstract class Forma {
	protected int x;
	protected int y;
	protected Color color;
	
	public Forma(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}
	
	public Forma() {
		super();
		this.x = 0;
		this.y = 0;
		this.color = Color.BLACK;
	}
	
	public Forma(Forma f) {
		super();
		this.x = f.x;
		this.y = f.y;
		this.color = f.color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Forma [x=" + x + ", y=" + y + ", color=" + color + "]";
	}
	
	// Este método abstracto OBLIGA a las clases hijas a implementarlo
	public abstract double getArea();

	//	public double getArea() {
//		double area = 0.0;
//		
//		// MALA PRÁCTICA: estamos acoplando demasiado a Forma con sus hijas
//		
//		if (this instanceof Circulo) {
//			// Calculamos el area del circulo
//		} else if (this instanceof Rectangulo) {
//			// Calculamos el area del rectangulo
//		} else {
//			// Calculamos el area del triangulo
//		}
//		 
//		return area;
//	}
}
