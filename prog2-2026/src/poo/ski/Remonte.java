package poo.ski;

public class Remonte extends Movilidad {
	protected int perchas;
	protected double desnivel;
	
	public Remonte(int pistaInicio, int pistaFin, double distancia, int perchas, double desnivel) {
		super(pistaInicio, pistaFin, distancia);
		this.perchas = perchas;
		this.desnivel = desnivel;
	}
	
	public Remonte() {
		super();
		this.perchas = 0;
		this.desnivel = 0;
	}

	public int getPerchas() {
		return perchas;
	}

	public void setPerchas(int perchas) {
		this.perchas = perchas;
	}

	public double getDesnivel() {
		return desnivel;
	}

	public void setDesnivel(double desnivel) {
		this.desnivel = desnivel;
	}

	@Override
	public String toString() {
		return "Remonte [perchas=" + perchas + ", desnivel=" + desnivel + ", pistaInicio=" + pistaInicio + ", pistaFin="
				+ pistaFin + ", distancia=" + distancia + "]";
	}
	
	
}
