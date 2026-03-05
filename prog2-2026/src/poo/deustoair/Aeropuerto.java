package poo.deustoair;

public class Aeropuerto {
	protected double latitud;
	protected double longitud;
	protected String codigo;
	protected int pistas;
	
	public Aeropuerto(double latitud, double longitud, String codigo, int pistas) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.codigo = codigo;
		this.pistas = pistas;
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

	@Override
	public String toString() {
		return "Aeropuerto [latitud=" + latitud + ", longitud=" + longitud + ", codigo=" + codigo + ", pistas=" + pistas
				+ "]";
	}
	
	
	
}
