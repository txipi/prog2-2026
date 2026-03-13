package poo.deustotravel;

public class Guia implements Cobrable {
	protected String nombre;
	protected double precio;
	protected int personas;
	protected boolean pagada;
	
	public Guia(String nombre, double precio, int personas, boolean pagada) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.personas = personas;
		this.pagada = pagada;
	}
	
	public Guia() {
		super();
		this.nombre = "";
		this.precio = 0;
		this.personas = 0;
		this.pagada = false;
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

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public boolean isPagada() {
		return pagada;
	}

	public void setPagada(boolean pagada) {
		this.pagada = pagada;
	}

	@Override
	public String toString() {
		return "Guia [nombre=" + nombre + ", precio=" + precio + ", personas=" + personas + ", pagada=" + pagada + "]";
	}

	@Override
	public double calcularCoste() {
		return this.personas * this.precio;
	}

	@Override
	public boolean cobrar() {
		this.pagada = true;
		return true;
	}
	
}
