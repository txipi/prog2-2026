package poo.paint;

import java.awt.Color;

public class Rectangulo extends Forma {
	protected int altura;
	protected int anchura;
	
	public Rectangulo(int x, int y, Color color, int altura, int anchura) {
		super(x, y, color);
		this.altura = altura;
		this.anchura = anchura;
	}
	
	public Rectangulo() {
		super();
		this.altura = 10;
		this.anchura = 20;
	}
	
	public Rectangulo(Rectangulo r) {
		super(r.x, r.y, r.color);
		this.altura = r.altura;
		this.anchura = r.anchura;
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
		return "Rectangulo [altura=" + altura + ", anchura=" + anchura + ", x=" + x + ", y=" + y + ", color=" + color
				+ "]";
	}

	public double getArea() {
		return altura * anchura;
	}
	
}
