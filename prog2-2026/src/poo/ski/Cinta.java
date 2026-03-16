package poo.ski;

public class Cinta extends Movilidad {
	protected String fabricante;
	protected boolean cubierta;
	
	public Cinta(int pistaInicio, int pistaFin, double distancia, String fabricante, boolean cubierta) {
		super(pistaInicio, pistaFin, distancia);
		this.fabricante = fabricante;
		this.cubierta = cubierta;
	}
	
	public Cinta() {
		super();
		this.fabricante = "";
		this.cubierta = false;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public boolean isCubierta() {
		return cubierta;
	}

	public void setCubierta(boolean cubierta) {
		this.cubierta = cubierta;
	}

	@Override
	public String toString() {
		return "Cinta [fabricante=" + fabricante + ", cubierta=" + cubierta + ", pistaInicio=" + pistaInicio
				+ ", pistaFin=" + pistaFin + ", distancia=" + distancia + "]";
	}


}
