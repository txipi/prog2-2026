package poo.ski;

import java.time.LocalDate;

public class Senior extends Abono {
	protected String dni;

	public Senior(String nombre, String telefono, LocalDate inicio, LocalDate fin, boolean pagado, String dni) {
		super(nombre, telefono, inicio, fin, pagado);
		this.dni = dni;
	}

	public Senior() {
		super();
		this.dni = "";
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Senior [dni=" + dni + ", nombre=" + nombre + ", telefono=" + telefono + ", inicio=" + inicio + ", fin="
				+ fin + ", pagado=" + pagado + "]";
	}

}
