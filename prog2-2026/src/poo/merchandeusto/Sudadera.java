package poo.merchandeusto;

import java.awt.Color;

public class Sudadera extends Producto implements Cambiable {
	protected Talla talla;
	protected boolean abierta;
	protected Color color;
	
	public Sudadera(String nombre, double precio, Talla talla, boolean abierta, Color color) {
		super(nombre, precio);
		this.talla = talla;
		this.abierta = abierta;
		this.color = color;
	}
	
	public Sudadera() {
		super();
		this.talla = Talla.M;
		this.abierta = false;
		this.color = Color.WHITE;
	}
	
	public Sudadera(Sudadera s) {
		super(s.nombre, s.precio);
		this.talla = s.talla;
		this.abierta = s.abierta;
		this.color = s.color;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

	public boolean isAbierta() {
		return abierta;
	}

	public void setAbierta(boolean abierta) {
		this.abierta = abierta;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Sudadera [talla=" + talla + ", abierta=" + abierta + ", color=" + color + ", nombre=" + nombre
				+ ", precio=" + precio + "]";
	}

	@Override
	public boolean cambiar(Color color, Talla talla) {
		if (color.equals(Color.WHITE)) {
			this.color = color;
			this.talla = talla;
			return true;
		} else {
			return false;
		}
	}
	
}
