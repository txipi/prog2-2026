package poo.ski;

public class Pista {
	protected static int contador = 1;
	
	protected int identificativo;
	protected double cotaSuperior;
	protected double cotaInferior;
	protected double distancia;
	protected TipoPista tipo;
	
	public Pista(double cotaSuperior, double cotaInferior, double distancia, TipoPista tipo) {
		super();
		this.identificativo = Pista.contador;
		Pista.contador++;
		this.cotaSuperior = cotaSuperior;
		this.cotaInferior = cotaInferior;
		this.distancia = distancia;
		this.tipo = tipo;
	}

	public Pista() {
		super();
		this.identificativo = Pista.contador;
		Pista.contador++;
		this.cotaSuperior = 0;
		this.cotaInferior = 0;
		this.distancia = 0;
		this.tipo = TipoPista.VERDE;
	}

	public Pista(Pista p) {
		super();
		this.identificativo = Pista.contador;
		Pista.contador++;
		this.cotaSuperior = p.cotaSuperior;
		this.cotaInferior = p.cotaInferior;
		this.distancia = p.distancia;
		this.tipo = p.tipo;
	}	
	
	public int getIdentificativo() {
		return identificativo;
	}

	public void setIdentificativo(int identificativo) {
		this.identificativo = identificativo;
	}

	public double getCotaSuperior() {
		return cotaSuperior;
	}

	public void setCotaSuperior(double cotaSuperior) {
		this.cotaSuperior = cotaSuperior;
	}

	public double getCotaInferior() {
		return cotaInferior;
	}

	public void setCotaInferior(double cotaInferior) {
		this.cotaInferior = cotaInferior;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public TipoPista getTipo() {
		return tipo;
	}

	public void setTipo(TipoPista tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Pista [identificativo=" + identificativo + ", cotaSuperior=" + cotaSuperior + ", cotaInferior="
				+ cotaInferior + ", distancia=" + distancia + ", tipo=" + tipo + "]";
	}
}
