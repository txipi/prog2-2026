package poo.deustube;

import java.util.ArrayList;

public class Canal {
	private String usuario;
	private String titulo;
	private ArrayList<String> seguidores;
	private ArrayList<Video> videos;
	
	public Canal(String usuario, String titulo, ArrayList<String> seguidores, ArrayList<Video> videos) {
		super();
		this.usuario = usuario;
		this.titulo = titulo;
		this.seguidores = new ArrayList<String>(seguidores);
		this.videos = new ArrayList<Video>(videos);
	}
	
	public Canal() {
		super();
		this.usuario = "";
		this.titulo = "";
		this.seguidores = new ArrayList<String>();
		this.videos = new ArrayList<Video>();
	}
	
	public Canal(Canal c) {
		super();
		this.usuario = c.usuario;
		this.titulo = c.titulo;
		this.seguidores = new ArrayList<String>(c.seguidores);
		this.videos = new ArrayList<Video>(c.videos);
	}
}
