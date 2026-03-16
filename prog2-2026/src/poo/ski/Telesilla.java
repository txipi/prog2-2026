package poo.ski;

public class Telesilla extends Movilidad {
	protected int sillas;
	protected int asientos;
	protected int pilares;
	
	public Telesilla(int pistaInicio, int pistaFin, double distancia, int sillas, int asientos, int pilares) {
		super(pistaInicio, pistaFin, distancia);
		this.sillas = sillas;
		this.asientos = asientos;
		this.pilares = pilares;
	}
	
	public Telesilla() {
		super();
		this.sillas = 0;
		this.asientos = 0;
		this.pilares = 0;
	}

	public int getSillas() {
		return sillas;
	}

	public void setSillas(int sillas) {
		this.sillas = sillas;
	}

	public int getAsientos() {
		return asientos;
	}

	public void setAsientos(int asientos) {
		this.asientos = asientos;
	}

	public int getPilares() {
		return pilares;
	}

	public void setPilares(int pilares) {
		this.pilares = pilares;
	}

	@Override
	public String toString() {
		return "Telesilla [sillas=" + sillas + ", asientos=" + asientos + ", pilares=" + pilares + ", pistaInicio="
				+ pistaInicio + ", pistaFin=" + pistaFin + ", distancia=" + distancia + "]";
	}
	
	
}
