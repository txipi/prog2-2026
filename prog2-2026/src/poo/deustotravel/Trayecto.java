package poo.deustotravel;

public class Trayecto {
	protected double latOrigen;
	protected double longOrigen;
	protected double latDestino;
	protected double longDestino;
	protected double distancia;
	protected Transporte transporte;
	
	public Trayecto(double latOrigen, double longOrigen, double latDestino, double longDestino, double distancia,
			Transporte transporte) {
		super();
		this.latOrigen = latOrigen;
		this.longOrigen = longOrigen;
		this.latDestino = latDestino;
		this.longDestino = longDestino;
		this.distancia = distancia;
		this.transporte = transporte;
	}
	
	public Trayecto() {
		super();
		this.latOrigen = 0;
		this.longOrigen = 0;
		this.latDestino = 0;
		this.longDestino = 0;
		this.distancia = 0;
		this.transporte = null;
	}

	public double getLatOrigen() {
		return latOrigen;
	}

	public void setLatOrigen(double latOrigen) {
		if (latOrigen >= -90.0 && latOrigen <= 90.0) {
			this.latOrigen = latOrigen;
		}
	}

	public double getLongOrigen() {
		return longOrigen;
	}

	public void setLongOrigen(double longOrigen) {
		this.longOrigen = longOrigen;
	}

	public double getLatDestino() {
		return latDestino;
	}

	public void setLatDestino(double latDestino) {
		this.latDestino = latDestino;
	}

	public double getLongDestino() {
		return longDestino;
	}

	public void setLongDestino(double longDestino) {
		this.longDestino = longDestino;
	}

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	@Override
	public String toString() {
		return "Trayecto [latOrigen=" + latOrigen + ", longOrigen=" + longOrigen + ", latDestino=" + latDestino
				+ ", longDestino=" + longDestino + ", distancia=" + distancia + ", transporte=" + transporte + "]";
	}

}
