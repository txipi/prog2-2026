package poo.deustube;

public class Video {
	private String id;
	private String titulo;
	private double duracion;
	private int likes;
	private int dislikes;
	
	public Video(String id, String titulo, double duracion, int likes, int dislikes) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.duracion = duracion;
		this.likes = likes;
		this.dislikes = dislikes;
	}
	
	public Video() {
		super();
		this.id = "";
		this.titulo = "";
		this.duracion = 0.0;
		this.likes = 0;
		this.dislikes = 0;
	}
	
	public Video(Video v) {
		super();
		this.id = v.id;
		this.titulo = v.titulo;
		this.duracion = v.duracion;
		this.likes = v.likes;
		this.dislikes = v.dislikes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	@Override
	public String toString() {
		return "http://deustube.com" + id;
	}
	
}
