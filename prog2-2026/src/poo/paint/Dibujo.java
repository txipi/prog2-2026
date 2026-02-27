package poo.paint;

import java.util.ArrayList;

public class Dibujo {
	protected static int contador = 1;
	
	protected int codigo;
	protected String fichero;
	protected ArrayList<Texto> textos;
	protected ArrayList<Forma> formas;
	protected int altura;
	protected int anchura;

	public Dibujo(int codigo, String fichero, ArrayList<Texto> textos, ArrayList<Forma> formas, int altura,
			int anchura) {
		super();
		this.codigo = Dibujo.contador;
		Dibujo.contador++;
		this.fichero = fichero;
		this.textos = new ArrayList<Texto>(textos);
		this.formas = new ArrayList<Forma>(formas);
		this.altura = altura;
		this.anchura = anchura;
	}

	public Dibujo() {
		super();
		this.codigo = Dibujo.contador;
		Dibujo.contador++;
		this.fichero = "";
		this.textos = new ArrayList<Texto>();
		this.formas = new ArrayList<Forma>();
		this.altura = 480;
		this.anchura = 640;
	}
	
	public Dibujo(Dibujo d) {
		super();
		this.codigo = Dibujo.contador;
		Dibujo.contador++;
		this.fichero = d.fichero;
		this.textos = new ArrayList<Texto>(d.textos);
		this.formas = new ArrayList<Forma>(d.formas);
		this.altura = d.altura;
		this.anchura = d.anchura;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getFichero() {
		return fichero;
	}

	public void setFichero(String fichero) {
		this.fichero = fichero;
	}

	public ArrayList<Texto> getTextos() {
		return textos;
	}

	public void setTextos(ArrayList<Texto> textos) {
		this.textos = textos;
	}

	public ArrayList<Forma> getFormas() {
		return formas;
	}

	public void setFormas(ArrayList<Forma> formas) {
		this.formas = formas;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getAnchura() {
		return anchura;
	}

	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}

	@Override
	public String toString() {
		return "Dibujo [codigo=" + codigo + ", fichero=" + fichero + ", textos=" + textos + ", formas=" + formas
				+ ", altura=" + altura + ", anchura=" + anchura + "]";
	}

	public double getAreaFormas() {
		double area = 0.0;
		
		for (Forma forma : formas) {
			area += forma.getArea();
		}
		
		return area;
	}
	
}
