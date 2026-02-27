package poo.paint;

import java.awt.Color;

public class Texto {
	protected int x;
	protected int y;
	protected Color color;
	protected String texto;
	
	public Texto(int x, int y, Color color, String texto) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.texto = texto;
	}
	
	public Texto() {
		super();
		this.x = 0;
		this.y = 0;
		this.color = Color.BLACK;
		this.texto = "Introduce aquí tu texto";
	}
	
	public Texto(Texto t) {
		super();
		this.x = t.x;
		this.y = t.y;
		this.color = t.color;
		this.texto = t.texto;
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Texto [x=" + x + ", y=" + y + ", color=" + color + ", texto=" + texto + "]";
	}
	
	
}
