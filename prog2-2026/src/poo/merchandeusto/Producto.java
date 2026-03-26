package poo.merchandeusto;

public class Producto implements Comparable<Producto> {
	protected String nombre;
	protected double precio;
	
	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public Producto() {
		super();
		this.nombre = "";
		this.precio = 0;
	}
	
	public Producto(Producto p) {
		super();
		this.nombre = p.nombre;
		this.precio = p.precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + "]";
	}

	@Override
	public int compareTo(Producto other) {
		return (int) (this.precio - other.precio);
	}
	
}
