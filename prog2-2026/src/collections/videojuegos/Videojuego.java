package collections.videojuegos;

import java.util.Objects;

public class Videojuego {
	protected String titulo;
	protected Genero genero;
	protected String desarrollador;
	protected int pegi;
	protected int copias;
	protected double precio;
	
	public Videojuego(String titulo, Genero genero, String desarrollador, int pegi, int copias, double precio) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.desarrollador = desarrollador;
		this.pegi = pegi;
		this.copias = copias;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getDesarrollador() {
		return desarrollador;
	}

	public void setDesarrollador(String desarrollador) {
		this.desarrollador = desarrollador;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public int getCopias() {
		return copias;
	}

	public void setCopias(int copias) {
		this.copias = copias;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Videojuego [titulo=" + titulo + ", genero=" + genero + ", desarrollador=" + desarrollador + ", pegi="
				+ pegi + ", copias=" + copias + ", precio=" + precio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(desarrollador, genero, pegi, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Videojuego other = (Videojuego) obj;
		return Objects.equals(desarrollador, other.desarrollador) && genero == other.genero && pegi == other.pegi
				&& Objects.equals(titulo, other.titulo);
	}
	
	
}
