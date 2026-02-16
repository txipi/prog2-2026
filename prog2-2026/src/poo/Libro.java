package poo;

public class Libro {
	// Propiedades
	private String titulo;
	private String autoria;
	private int anyo;
	private String genero;
	private int paginas;
	private String isbn;
	
	// Métodos
	public Libro(String titulo, String autoria, int anyo, String genero, int paginas, String isbn) {
		super();
		this.titulo = titulo;
		this.autoria = autoria;
		this.anyo = anyo;
		this.genero = genero;
		this.paginas = paginas;
		this.isbn = isbn;
	}
	
	public Libro() {
		super();
		this.titulo = "";
		this.autoria = "";
		this.anyo = 0;
		this.genero = "";
		this.paginas = 0;
		this.isbn = "";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutoria() {
		return autoria;
	}

	public void setAutoria(String autoria) {
		this.autoria = autoria;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Libro [titulo=" + titulo + ", autoria=" + autoria + ", anyo=" + anyo + ", genero=" + genero
				+ ", paginas=" + paginas + ", isbn=" + isbn + "]";
	}
	
	
}
