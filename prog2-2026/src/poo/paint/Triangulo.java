package poo.paint;

import java.awt.Color;

public class Triangulo extends Forma {
	protected int altura;
	protected int anchura;
	
	public Triangulo(int x, int y, Color color, int altura, int anchura) {
		super(x, y, color);
		this.altura = altura;
		this.anchura = anchura;
	}
	
	public Triangulo() {
		super();
		this.altura = 10;
		this.anchura = 10;
	}
	
	public Triangulo(Triangulo t) {
		super(t.x, t.y, t.color);
		this.altura = t.altura;
		this.anchura = t.anchura;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAnchura() {
		return anchura;
	}

	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}

	@Override
	public String toString() {
		return "Triangulo [altura=" + altura + ", anchura=" + anchura + ", x=" + x + ", y=" + y + ", color=" + color
				+ "]";
	}
	
	public double getArea() {
		return altura * anchura / 2;
	}	
	
}
