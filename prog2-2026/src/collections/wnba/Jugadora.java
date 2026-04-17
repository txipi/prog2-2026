package collections.wnba;

import java.util.Objects;

public class Jugadora {
	protected String nombre;
	protected double altura;
	protected Posicion posicion;
	protected int velocidad;
	protected int fuerza;
	protected int tiro;
	protected int defensa;
	
	public Jugadora(String nombre, double altura, Posicion posicion, int velocidad, int fuerza, int tiro, int defensa) {
		super();
		this.nombre = nombre;
		this.altura = altura;
		this.posicion = posicion;
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.tiro = tiro;
		this.defensa = defensa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getTiro() {
		return tiro;
	}

	public void setTiro(int tiro) {
		this.tiro = tiro;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	@Override
	public String toString() {
		return "Jugadora [nombre=" + nombre + ", altura=" + altura + ", posicion=" + posicion + ", velocidad="
				+ velocidad + ", fuerza=" + fuerza + ", tiro=" + tiro + ", defensa=" + defensa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(altura, nombre, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugadora other = (Jugadora) obj;
		return Double.doubleToLongBits(altura) == Double.doubleToLongBits(other.altura)
				&& Objects.equals(nombre, other.nombre) && posicion == other.posicion;
	}
	
}
