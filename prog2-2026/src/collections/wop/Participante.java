package collections.wop;

import java.io.Serializable;
import java.util.Objects;

public class Participante implements Serializable {
	private String nombre;
	private int dorsal;
	private double ritmo;
	
	public Participante(String nombre, int dorsal, double ritmo) {
		super();
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.ritmo = ritmo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public double getRitmo() {
		return ritmo;
	}

	public void setRitmo(double ritmo) {
		this.ritmo = ritmo;
	}

	@Override
	public String toString() {
		return "Participante [nombre=" + nombre + ", dorsal=" + dorsal + ", ritmo=" + ritmo + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dorsal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Participante other = (Participante) obj;
		return dorsal == other.dorsal;
	}

	public Modalidad getModalidad() {
		Modalidad modalidad;
		
		if (this.ritmo < 4.50) {
			modalidad = Modalidad.TRAIL;
		} else if (this.ritmo <= 5.50) {
			modalidad = Modalidad.RUN;
		} else {
			modalidad = Modalidad.WALK;
		}
		
		return modalidad;
	}

	
	
}
