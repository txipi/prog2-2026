package poo.ski;

import java.time.LocalDate;

public class Infantil extends Abono {
	protected String nombreResponsable;
	protected String telefonoResponsable;
	
	public Infantil(String nombre, String telefono, LocalDate inicio, LocalDate fin, boolean pagado,
			String nombreResponsable, String telefonoResponsable) {
		super(nombre, telefono, inicio, fin, pagado);
		this.nombreResponsable = nombreResponsable;
		this.telefonoResponsable = telefonoResponsable;
	}

	public Infantil() {
		super();
		this.nombreResponsable = "";
		this.telefonoResponsable = "";
	}

	public String getNombreResponsable() {
		return nombreResponsable;
	}

	public void setNombreResponsable(String nombreResponsable) {
		this.nombreResponsable = nombreResponsable;
	}

	public String getTelefonoResponsable() {
		return telefonoResponsable;
	}

	public void setTelefonoResponsable(String telefonoResponsable) {
		this.telefonoResponsable = telefonoResponsable;
	}

	@Override
	public String toString() {
		return "Infantil [nombreResponsable=" + nombreResponsable + ", telefonoResponsable=" + telefonoResponsable
				+ ", nombre=" + nombre + ", telefono=" + telefono + ", inicio=" + inicio + ", fin=" + fin + ", pagado="
				+ pagado + "]";
	}
	
}
