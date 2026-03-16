package poo.ski;

import java.time.LocalDate;

public class Abono implements Comparable<Abono> {
	protected String nombre;
	protected String telefono;
	protected LocalDate inicio;
	protected LocalDate fin;
	protected boolean pagado;
	
	public Abono(String nombre, String telefono, LocalDate inicio, LocalDate fin, boolean pagado) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.inicio = inicio;
		this.fin = fin;
		this.pagado = pagado;
	}
	
	public Abono() {
		super();
		this.nombre = "";
		this.telefono = "";
		this.inicio = LocalDate.now();
		this.fin = LocalDate.now().plusDays(1);
		this.pagado = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	@Override
	public String toString() {
		return "Abono [nombre=" + nombre + ", telefono=" + telefono + ", inicio=" + inicio + ", fin=" + fin
				+ ", pagado=" + pagado + "]";
	}

	@Override
	public int compareTo(Abono other) {
		return this.getFin().compareTo(other.getFin());
	}

}
