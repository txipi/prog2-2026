package collections.canciones;

import java.util.Objects;

public class Cancion implements Comparable<Cancion> {
	protected String titulo;
	protected String artista;
	protected double duracion;
	
	public Cancion(String titulo, String artista, double duracion) {
		super();
		this.titulo = titulo;
		this.artista = artista;
		this.duracion = duracion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", artista=" + artista + ", duracion=" + duracion + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(artista, duracion, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		return Objects.equals(artista, other.artista)
				&& Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& Objects.equals(titulo, other.titulo);
	}

	@Override
	public int compareTo(Cancion other) {
		return this.titulo.compareTo(other.titulo);
	}
	
}
