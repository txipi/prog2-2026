package pruebas.agenda;

import java.time.LocalDate;

public class Contacto {
	private String nombre;
	private int telefono;
	private LocalDate fecha;
	private double saldo;
	
	public Contacto(String nombre, int telefono, LocalDate fecha, double saldo) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.fecha = fecha;
		this.saldo = saldo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", fecha=" + fecha + ", saldo=" + saldo + "]";
	}
	
	
}
