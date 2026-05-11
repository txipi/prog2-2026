package examenes.citybike;

public class Electrica extends Bicicleta implements Recargable {
	private double bateria;

	public Electrica(boolean operativa, double bateria) {
		super(operativa);
		this.bateria = bateria;
	}

	public Electrica() {
		super();
		this.bateria = 0;
	}
	
	public double getBateria() {
		return bateria;
	}

	public void setBateria(double bateria) {
		this.bateria = bateria;
	}

	@Override
	public String toString() {
		return "Electrica [" + this.getCodigo() + ", bateria=" + bateria + "]";
	}

	@Override
	public String getCodigo() {
		return "E" + this.getNumero();
	}

	@Override
	public boolean usable() {
		if (this.isOperativa() && this.getBateria() > 80) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void recargar() {
		this.bateria = 100;
	}
	
}
