package poo.merchandeusto;

import java.awt.Color;

public class Camiseta extends Producto implements Cambiable {
	protected Talla talla;
	protected Color color;
	
	public Camiseta(String nombre, double precio, Talla talla, Color color) {
		super(nombre, precio);
		this.talla = talla;
		this.color = color;
	}
	
	public Camiseta() {
		super();
		this.talla = Talla.M;
		this.color = Color.WHITE;
	}
	
	public Camiseta(Camiseta c) {
		super(c.nombre, c.precio);
		this.talla = c.talla;
		this.color = c.color;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Camiseta [talla=" + talla + ", color=" + color + ", nombre=" + nombre + ", precio=" + precio + "]";
	}

	@Override
	public boolean cambiar(Color color, Talla talla) {
		if (color.equals(Color.BLUE) || color.equals(Color.WHITE)) {
			this.color = color;
			this.talla = talla;
			return true;
		} else {
			return false;
		}
	}

}
