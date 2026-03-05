package poo.deustoair;

public class Aeropuerto {
	protected double latitud;
	protected double longitud;
	protected String codigo;
	protected int pistas;
	protected SalaVIP salavip;
	
	public Aeropuerto(double latitud, double longitud, String codigo, int pistas, SalaVIP salavip) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.codigo = codigo;
		this.pistas = pistas;
		this.salavip = salavip;
	}

	public Aeropuerto() {
		super();
		this.latitud = 0;
		this.longitud = 0;
		this.codigo = "";
		this.pistas = 0;
		this.salavip = null;
	}

	public Aeropuerto(Aeropuerto a) {
		super();
		this.latitud = a.latitud;
		this.longitud = a.longitud;
		this.codigo = a.codigo;
		this.pistas = a.pistas;
		this.salavip = a.salavip;
	}
	
	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getPistas() {
		return pistas;
	}

	public void setPistas(int pistas) {
		this.pistas = pistas;
	}

	public SalaVIP getSalavip() {
		return salavip;
	}

	public void setSalavip(SalaVIP salavip) {
		this.salavip = salavip;
	}

	@Override
	public String toString() {
		return "Aeropuerto [latitud=" + latitud + ", longitud=" + longitud + ", codigo=" + codigo + ", pistas=" + pistas
				+ ", salavip=" + salavip + "]";
	}
	
}
